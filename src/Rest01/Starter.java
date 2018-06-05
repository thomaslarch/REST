package Rest01;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


public class Starter {
		private final static int port = 80;
		private final static String host="http://localhost/";
		
		static ArrayList<Benutzer> dbenutzer = new ArrayList();				
		public static void main(String[] args) {
			URI baseUri = UriBuilder.fromUri(host).port(port).build();
			ResourceConfig config = new ResourceConfig(MyNetwork.class);
			HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		}

}
