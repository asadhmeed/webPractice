package com.asad.web.Rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.asad.service.ejb.SubscriberService;
import com.asad.web.Subscriber;

import validEmail.EmailValidator;

@Path("/subscribe")
public class SubscribeRest {
	@EJB(mappedName = "subscriber1")
	private SubscriberService subsciberService;

	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int addSubscrber(Subscriber subscriber) {
		// TODO:TryCatch
		if (new EmailValidator().validateEmail(subscriber.getEmail())) {

			if (subsciberService.findSubscriberByEmail(subscriber.getEmail())) {
				return -1;
			}
			return subsciberService.addSubsecriber(subscriber.getEmail()).getId();
		}
		return -1;

	}
	@GET
	@Path("/")
	public String test() {
		return "TEST !!!";
	}
}
