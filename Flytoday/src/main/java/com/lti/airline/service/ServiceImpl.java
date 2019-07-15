package com.lti.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.lti.airline.model.Passenger;
import com.lti.airline.dao.*;

@Service
public interface ServiceImpl implements Service {

	@Autowired  
	private PassengerDAO passengerDao;
	
	@Transactional
	public Passenger checkPassenger(Passenger thepassenger) {
		return PassengerDAO.checkPassenger(thepassenger); 
	}

}
