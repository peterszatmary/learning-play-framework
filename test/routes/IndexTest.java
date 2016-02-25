package routes;

import controllers.routes;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import testutils.PlayTestCredencials;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

/**
 * Created by nue on 4.9.2015.
 */
public class IndexTest extends PlayTestCredencials {

    //TODO java.lang.RuntimeException: java.lang.ClassNotFoundException: Routes
    @Test
    public void testIt() {
        running(fakeApplication(), () -> { // runnable
            Result result = routeAndCall(fakeRequest(GET, "/"), 1); // test by running path and method
            assertEquals(OK, result.status());
            assertEquals("text/html", result.contentType());
            assertNull(result.redirectLocation()); // not redirected
        });
    }

}
