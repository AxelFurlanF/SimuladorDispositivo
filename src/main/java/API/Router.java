package API;


import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import spark.Spark;

public class Router {

	
	public static void init() {
		Spark.staticFileLocation("/public");
		Router.configure();
	}
	
	private static void configure(){
		
	
		Spark.get("/dispositivo/:id", (request, response) -> {
			String id = request.params(":id");
			
			List<NameValuePair> pairs = URLEncodedUtils.parse(request.body(), Charset.defaultCharset());

	        Map<String, String> params = toMap(pairs);
	        
	        System.out.println("Request recibida para dispositivo " + id + ":");
	        System.out.println(request.body());
			
		    return "Status OK ";
		});

	}
	
	
	private static Map<String, String> toMap(List<NameValuePair> pairs){
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<pairs.size(); i++){
			NameValuePair pair = pairs.get(i);
			map.put(pair.getName(), pair.getValue());
			
			}
		
		return map;
		
		}
	
}