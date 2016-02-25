package controllers;

import core.pl.LogPerformanceInterceptor;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

/**
 * Created by nue on 4.9.2015.
 */
@With(LogPerformanceInterceptor.class)
public class HomePageController extends Controller {


    //TODO tu by bodlo mozno ten promise alebo reactivne nacitat page pri logine !
    public Result index() {
        return ok(views.html.homepage.render(""));
    }


}
