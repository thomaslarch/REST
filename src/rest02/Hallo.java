package rest02;

import javax.ws.rs.*;


	@Path("test1")
	public class Hallo {
		
		@GET
		@Produces("text/plain")
		public String sayHello3()
		{
			return "Hello World Standard";
		}
		
		
		@Path("get")
		@GET
		@Produces("text/plain")
		public String sayHello()
		{
			return "Hello World";
		}
		
		@Path("json")
		@PUT
		@Produces("application/json")
		public String sayHello2()
		{
			return "{Hello World JSON}";
		}
	}
