package API;

import API.Router;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server{
	
public static void main (String[] args) {
		
		
		Spark.port(8080);		
		Router.init();		
		DebugScreen.enableDebugScreen();
	}
}
