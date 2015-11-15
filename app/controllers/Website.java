package controllers;

import views.html.*;
import models.*;
import play.mvc.*;
import play.data.Form;

import java.util.List;

public class Website extends Controller {

    public Result index() {
        List<Tool> tools = Tool.find.all();
        return ok(views.html.cts.index.render(tools));
    }



    //public Result create(){
        //Tool tool = Form.form(Tool.class).bindFromRequest().get();
        //tool.save();
        //flash ("success", "Saved new tool" + tool.title);
        //return redirect(routes.Website.show(tool.id));
    //}

    public Result show(Long id) {
         //Query the database for a Tool with this id
        Tool tool = Tool.find.byId(id);

         //If the tool doesn't exist, then respond with a 404.
        if (tool == null)
            return notFound("Not Found\n");
        else
            return ok(views.html.cts.show.render(tool));

    }


    public Result register()  {

        User user = Form.form(User.class).bindFromRequest().get();

        user.save();
        flash ("success", "Your account has been created successfully" + user.name);

        return ok(views.html.cts.register.render());
    }


    //public Result login(Long id) {
      //  User user = User.find.byId(id);

        //if (user == null)
          //  return notFound("Not Found\n");
       // else
            //return ok(views.html.cts.index());
    //}


}