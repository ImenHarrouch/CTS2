package controllers;

import views.html.*;
import models.*;
import play.mvc.*;
import play.data.Form;
import play.data.DynamicForm;
import play.*;
import static play.data.Form.form;

import java.util.List;

public class Users extends Controller {

    public Result welcome() {
        return ok(views.html.cts.welcome.render());
    }

    public Result index() {
        List<Tool> tools = Tool.find.all();
        return ok(views.html.cts.index.render(tools));
    }



    //post
    public Result register() {

        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");
        String firstname = userForm.data().get("firstname");
        String lastname = userForm.data().get("lastname");
        String email = userForm.data().get("email");
        String phone = userForm.data().get("phone");
        String address = userForm.data().get("address");


        User user = User.createUser(username, password, firstname, lastname, email, phone, address);
        if (user == null) {
            flash("error", "Invalid user");
            return redirect(routes.Users.welcome());
        }
            /*user.username = username;
            user.password_hash = password;*/
       /* user.firstname = firstname;
        user.lastname = lastname;
        user.email = email;
        user.phone = phone;
        user.address = address;*/

            user.save();
            flash("success", "Welcome new user " + user.username);
            session("user_id", user.id.toString());


            return redirect(routes.Users.index());
        }


    //get
    public Result registerUI()  {

        return ok(views.html.cts.register.render());
    }

    //get
    public Result loginUI() {

        return ok(views.html.cts.login.render());
    }


    //post
    public Result login(){


        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.find.where().eq("username", username).findUnique();

        if (user != null && user.authenticate(password)) {
            flash("success", "Welcome " + user.username);
        } else {
            flash("error", "Invalid login. Check your credentials information please.");
        }

        return redirect(routes.Users.index());
    }


    public Result logout() {
        session().remove("user_id");
        return redirect(routes.Users.welcome());
    }




}
