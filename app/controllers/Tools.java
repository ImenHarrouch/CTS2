package controllers;

/**
 * Created by Imen on 2/6/2016.
 */

import views.html.*;
import models.*;
import play.mvc.*;
import play.data.Form;
import play.data.DynamicForm;
import play.*;
import static play.data.Form.form;

import java.util.List;


public class Tools extends Controller {

    //@Security.Authenticated(UserAuth.class)
    public Result create()
    {
        //Tool tool = Form.form(Tool.class).bindFromRequest().get();
        flash ("success", "Saved new tool" );
        DynamicForm userForm = form().bindFromRequest();
        String name = userForm.data().get("name");
        String owner = userForm.data().get("owner");
        String description = userForm.data().get("description");
        String category = userForm.data().get("category");
        String comment = userForm.data().get("comment");
        Tool tool = new Tool();


        tool.name = name;
        tool.owner = owner;
        tool.description = description;
        tool.category = category;
        tool.comment = comment;
        tool.save();
        flash ("success", "Saved new tool" + tool.name);
        //   return ok(views.html.cts.tools.render(tool));
        return redirect(routes.Tools.tools());
        //  return ok();
    }


    public Result gtools(){

        List<Tool> tool = Tool.find.all();
        //    Tool tool1 = Tool.find.byId(id);
        flash("hello");
        return ok(views.html.cts.tools.render(tool));
        //  return ok(views.html.cts.buy.render(tool));
        //   return ok("buy page");
    }

    public Result tools(){

        List<Tool> tool = Tool.find.all();
        //return redirect(routes.Users.tools());
        return ok(views.html.cts.tools.render(tool));
        //   return ok("buy page");
    }


    public Result buy(Long id){

        Tool tool = Tool.find.byId(id);
        return ok(views.html.cts.buy.render(tool));
        //   return ok("buy page");
    }

    public Result payeeinfo(){

        return ok(views.html.cts.payee_info.render());
    }

    public Result confirmation()
    {
        return ok(views.html.cts.confirmation.render());
    }

    public Result borrower(){
        DynamicForm bform = form().bindFromRequest();
        String fname = bform.data().get("firstname");
        String lname =  bform.data().get("lastname");
        String add = bform.data().get("address");
        String city =  bform.data().get("city");
        //String state = bform.data().get("state");
        String zip =  bform.data().get("zip");
        String email = bform.data().get("email");
        String phone =  bform.data().get("phone");

        Borrower bor = new Borrower();
        bor.firstname=fname;
        bor.lastname=lname;
        bor.address=add;
        bor.city=city;
        //bor.state=state;
        bor.zip=zip;
        bor.email=email;
        bor.phone=phone;

        bor.save();

        return ok(views.html.cts.confirmation.render());
        //    return redirect(routes.Users.confirmation());

    }




    public Result show(Long id) {
        //Query the database for a Tool with this id
        Tool tool = Tool.find.byId(id);

        //If the tool doesn't exist, then respond with a 404.
        if (tool == null)
            return notFound("Not Found\n");
        else
            return ok(views.html.cts.buy.render(tool));
        //return ok("show page");
    }

}
