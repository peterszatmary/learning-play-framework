package controllers;

import core.pl.LogPerformanceInterceptor;
import core.scala.ScalaExample;
import core.java.services.DataService;
import models.User;
import models.UserContact;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;
import play.mvc.*;

import java.util.Date;
import java.util.List;

@With(LogPerformanceInterceptor.class)
public class Application extends Controller {

    public Result index() { //
        return ok(views.html.index.render("", null));
    }

    @AddCSRFToken
    public Result docs() {
        return ok(views.html.docs.render());
    }

    @RequireCSRFCheck
    public Result sendFeedback() {
        return ok("feedback sended");
    }


    public Result todo() {
        return TODO;
    }

    public Result id(String id) {
        return ok("Product of id = " + id);
    }

    public Result scala() {
        ScalaExample sc = new ScalaExample();
        String helloFromScalaInJava = sc.helloWorld("Senacor");
        return ok(helloFromScalaInJava);
    }

    public Result users() {
        DataService dataService = new DataService();
        List<User> users = dataService.usersFindAll();

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            str.append(users.get(i));
            str.append("\n\n");
        }

        return ok(
                "MONGO DB WITH KUNDERA ON PLAY FRAMEWORK !\n\n" +
                "We find in our Mongo DB through Kundera " + users.size() + " users.\n\n\n" +
                str.toString());
    }

    public Result createUser() {
        DataService dataService = new DataService(); //TODO one call

        User user = new User();
        user.setBan(false);
        user.setAge(20);
        user.setPassword("pass");
        user.setName("Peter");
        user.setSurname("Szatmary");
        user.setBirth(new Date());
        user.setAccountName("pszatmary");
        user.setEmail("peter.szatmary@gmail.com");
        user.setActive(true);

        UserContact contact = new UserContact();
        contact.setAddress("Hemerkova 34");
        contact.setPhone("000111122222");

        user.setContact(contact);

        dataService.userCreate(user);
        return ok("User " + user + " sucesfully created.");
    }






}
