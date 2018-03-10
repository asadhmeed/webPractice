package com.asad.service.ejb;

import javax.ejb.Local;

import com.asad.service.SubscriberEntity;
@Local
public interface SubscriberService {

	SubscriberEntity addSubsecriber(String email);
	SubscriberEntity removeSubscriberByEmail(String email);

	public boolean findSubscriberByEmail(String email);
}