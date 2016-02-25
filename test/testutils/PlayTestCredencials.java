package testutils;

import org.junit.Before;
import play.mvc.Http;

import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static play.test.Helpers.fakeRequest;

/**
 * Created by nue on 4.9.2015.
 */
public class PlayTestCredencials {

    // without it the test cry -> java.lang.RuntimeException: There is no HTTP Context available from here.
    // from http://stackoverflow.com/questions/20206270/play-framework-2-2-1-create-http-context-for-tests
    @Before
    public void setUp() {
        Map<String, String> flashData = Collections.emptyMap();
        Map<String, Object> argData = Collections.emptyMap();
        Long id = 2L;
        play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
        Http.Context context = new Http.Context(id, header, fakeRequest().build(), flashData, flashData, argData);
        Http.Context.current.set(context);
    }

}
