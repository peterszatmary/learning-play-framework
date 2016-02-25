package controllers;

import org.apache.http.client.methods.RequestBuilder;
import org.junit.Test;
import play.api.test.Helpers;
import play.i18n.Messages;
import play.mvc.Result;
import play.twirl.api.Content;
import testutils.PlayTestCredencials;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import static play.test.Helpers.*;

/**
 * Created by nue on 4.9.2015.
 */
public class IndexTest extends PlayTestCredencials {

    @Test
    public void testIt() {
        running(fakeApplication(), () -> { // runnable
            Result result = route(routes.Application.index()); // test by running actions
            assertEquals(OK, result.status());
            assertNull(result.redirectLocation()); // not redirected
        });
    }

}
