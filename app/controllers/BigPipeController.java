package controllers;

import core.pl.LogPerformanceInterceptor;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

/**
 * Created by nue on 15.9.2015.
 */
@With(LogPerformanceInterceptor.class)
public class BigPipeController extends Controller {

    public Result withbp() {

        return ok(views.html.withbigpipe.render());
    }

    public Result withoutbp() {
        return ok(views.html.withoutbigpipe.render());
    }


}
