package com.demos;
import java.net.*;
import java.util.*;
 
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/products")
public class ProductResource 
{
	 private ProductDAO dao = ProductDAO.getInstance();
	 
	 
	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Product> list() {
		 List<Product> p=dao.listAll();
		 System.out.println(p);
	     return p;
	 }
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response add(Product product) throws URISyntaxException {
	     int newProductId = dao.add(product);
	     System.out.println(newProductId);
	     URI uri = new URI("/products/");
	     return Response.created(uri).build();
	 }
}
