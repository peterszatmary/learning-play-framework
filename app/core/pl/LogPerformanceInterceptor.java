package core.pl;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http;
import play.libs.F;
import play.mvc.*;

/**
 * Created by nue on 2.9.2015.
 */
public class LogPerformanceInterceptor extends Action.Simple {

    @Override
    public F.Promise<Result> call(Http.Context context) throws Throwable {
        // finding out which method in which controller is performed
        final String METHOD = context.args.get("ROUTE_CONTROLLER") + "." + context.args.get("ROUTE_ACTION_METHOD");
        Logger.info("Method " + METHOD + " started");
        long start = System.currentTimeMillis();
        F.Promise<Result> result = delegate.call(context);

        long end = System.currentTimeMillis();
        Logger.info("Method " + METHOD + " end in " + (end - start) + " milliseconds.");
        return result;
    }
}
