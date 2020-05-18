package com.brain.software.resource;

import java.math.BigDecimal;
import java.util.Base64;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.brain.software.model.Order;



@Path("/order-service")
public class OrderResource {
	
	@GET
	@Path("/order/{orderId}")
	@Produces("application/json")
    public Object getUserById(@PathParam("orderId") Integer orderId, 
                            @HeaderParam("authorization") String authString){
         
        if(!isUserAuthenticated(authString)){
            return "{\"error\":\"User not authenticated\"}";
        }
        Order ord = new Order();
        ord.setId(orderId);
        ord.setCustomerName("xxxx");
        ord.setAddress("chennai");
        ord.setAmount(BigDecimal.valueOf(5000.25));
        return ord;
    }
     
    private boolean isUserAuthenticated(String authString){
         
    	boolean login=false;
      
        try {
        	Base64.Decoder decoder = Base64.getDecoder();
    		String decoded = new String(decoder.decode(authString));
    		String[] decode=decoded.split("#");
    		if("username".equals(decode[1])) 
    			login= true;
    		else
    			login= false;
    		
    		
        } catch (Exception e) {
            e.printStackTrace();
        }
		return login;
  
       
    }

}
