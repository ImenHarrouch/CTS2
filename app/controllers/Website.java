package controllers;

import views.html.*;
import models.*;
import play.mvc.*;
import play.data.Form;
import play.data.DynamicForm;
import play.*;
import static play.data.Form.form;

import java.util.List;

public class Website extends Controller {

    public Result index() {
        List<Tool> tools = Tool.find.all();
        return ok(views.html.cts.index.render(tools));
    }



   /* public Result show(Long id) {
         //Query the database for a Tool with this id
        Tool tool = Tool.find.byId(id);

         //If the tool doesn't exist, then respond with a 404.
        if (tool == null)
            return notFound("Not Found\n");
        else
            return ok(views.html.cts.show.render(tool));

    }*/

    //post
    public Result register(){
        return null;
    }

    //get
    public Result registerUI()  {

        /*DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = new User();
        user.name = username;
        user.username = username;

        userForm.save();
        flash ("success", "Your account has been created successfully" + username);*/

        return ok(views.html.cts.register.render());
    }


    public Result login() {
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.find.where().eq("username", username).findUnique();

        if (user != null && user.authenticate(password)) {
            session("user_id", user.id.toString());
            flash("success", "Welcome " + user.username);
        } else {
            flash("error", "Invalid login. Check your credentials information please.");
        }

        return ok(views.html.cts.login.render());
    }



    public Result tools(){

        return ok(views.html.cts.tools.render());
    }

    public Result buy(){

        return ok(views.html.cts.buy.render());
        //   return ok("buy page");
    }

    public Result payeeinfo(){

        return ok(views.html.cts.payee_info.render());
    }

    public Result confirmation() {

        return ok(views.html.cts.confirmation.render());
    }


}