package controllers;

import core.java.Constants;
import core.pl.LogPerformanceInterceptor;
import core.pl.bindings.LoginData;
import core.pl.bindings.RegistrationData;
import core.java.services.DataService;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.i18n.Messages;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.With;
import play.mvc.*;

import java.util.Set;

import static play.data.Form.form;

/**
 * Created by nue on 2.9.2015.
 */
@With(LogPerformanceInterceptor.class)
public class LogInAndRegistrationController extends Controller {

    private static final Form<RegistrationData> registrationForm =
            Form.form(RegistrationData.class);


    public Result doLogin() {
        DataService dataService = new DataService(); //TODO viackrat
        Form<LoginData> form = form(LoginData.class).bindFromRequest();
        LoginData data = form.get();

        final String email = data.getEmail();
        final String password = data.getPassword();

        if (!dataService.userAuthentication(email, password)) {
            return ok(views.html.index.render(Messages.get("index.loggedin_no"), data));
        } else {
            Logger.info("Log in with = [ email = " + email + " , password = " + password + " ]");
            session().clear();
            session(Constants.LOGGED_IN, email);
            Logger.info("after login, current session = " + session()); // lognuty, session vytvorena.
            return redirect(routes.HomePageController.index());
        }
    }



    public Result registration() {
        RegistrationData registrationData = new RegistrationData();
        registrationData.setEmail("peter.email");
        registrationData.setUserName("name");
        Form<RegistrationData> preFilledForm = registrationForm.fill(registrationData);
        return ok(views.html.registration.render(preFilledForm));
    }


    //TODO
    public Result doRegistration() {

        flash("ha1", "ha1");
        flash("ha2", "ha2");

        Form<RegistrationData> regForm = form(RegistrationData.class).bindFromRequest();

        if (regForm.hasErrors()) {
            Set<String> keys = regForm.errors().keySet();
            Logger.error("keys = " + keys);
            Logger.error("keys = " + regForm.errors().get("email"));
            return redirect(routes.LogInAndRegistrationController.registration());

        } else {
            return ok(views.html.registration.render(registrationForm));

        }
    }

    public Result passwordForgotten() {
        return ok(views.html.passwordforgotten.render());
    }

    public Result doPasswordForgotten() {
        return TODO;
    }

    public Result logout() {
        //TODO save unsaved work, better ask user for saving, NOT important now
        // reset session
        session().clear();
        // redirect to index page
        return redirect(routes.Application.index());
    }

    // is user logged in already ?
    private boolean loggedin() {
        String loggedin = session().get(Constants.LOGGED_IN);
        return !StringUtils.isEmpty(loggedin);

    }


}
