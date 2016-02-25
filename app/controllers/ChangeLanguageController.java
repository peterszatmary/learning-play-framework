package controllers;

import core.pl.LogPerformanceInterceptor;
import play.Logger;
import play.data.DynamicForm;
import play.filters.csrf.AddCSRFToken;
import play.i18n.Messages;
import play.mvc.Result;
import play.mvc.*;

import static play.data.Form.form;

/**
 * Created by nue on 1.9.2015.
 */
@With(LogPerformanceInterceptor.class)

public class ChangeLanguageController extends Controller {

    //TODO
    // example of redirection : please try it !
    // redirect(routes.Application.index());
    // routes object is created by play for moving accross all app controllers
    // routes je teda tiez compilovane


    public Result changeLangSk() {
        Application.changeLang("sk");
        return redirect(request().getHeader("referer")); // redirection to the same page where are you from, request() method access the current request
    }


    public Result changeLangEn() {
        Application.changeLang("en");
        return redirect(request().getHeader("referer"));
    }


    public Result changeLangDe() {
        Application.changeLang("de");
        return redirect(request().getHeader("referer"));
    }


    public Result changeLanguage() {
        DynamicForm data = form().bindFromRequest();
        String changeLang = data.get("changeLanguage");

        if (Messages.get("app.lang.en").equals(changeLang)) {
            return changeLangEn();
        } else if (Messages.get("app.lang.sk").equals(changeLang)) {
            return changeLangSk();
        } else if (Messages.get("app.lang.de").equals(changeLang)) {
            return changeLangDe();
        } else {
            Logger.info("changeLang = " + changeLang);
            return null;
        }
    }

}
