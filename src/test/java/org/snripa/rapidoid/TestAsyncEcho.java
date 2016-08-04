package org.snripa.rapidoid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.rapidoid.http.HTTP;

import static org.rapidoid.u.U.eq;

public class TestAsyncEcho {

	public static final int PORT = 1234;
	private AsyncEchoServer asyncEchoServer;

	@Before
	public void setUp() throws Exception {
		asyncEchoServer = new AsyncEchoServer(PORT);
		asyncEchoServer.start();
	}

	@After
	public void tearDown() throws Exception {
		asyncEchoServer.stop();
	}

    @Test
    public void testEcho() throws Exception {
        String echoReq = "hello";
		String request = "http://localhost:" + 8888 + "/" + echoReq;
		String response = HTTP.get(request).fetch();
		eq(response, echoReq);
    }
}
