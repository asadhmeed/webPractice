package com.asad.web.Rest;

import javax.ejb.EJB;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


import com.asad.service.ejb.SubscriberService;
import com.asad.web.Subscriber;

@Path("/subscribe")
public class SubscribeRest {
	@EJB(mappedName="subscriber1")
	private SubscriberService subsciberService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int addSubscrber(Subscriber subscriber) {
		//TODO:TryCatch
		if(subsciberService.findSubscriberByEmail(subscriber.getEmail())) {
			return -1;
		}
		return subsciberService.addSubsecriber(subscriber.getEmail()).getId();	
		
		 
		
	}
}
