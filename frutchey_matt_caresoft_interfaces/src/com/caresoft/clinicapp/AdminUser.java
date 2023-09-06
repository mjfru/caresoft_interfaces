package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(int id, String role) {
    	this.id = id;
    	this.role = role;
    	this.securityIncidents = new ArrayList<String>(); 
    }
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	return this.securityIncidents;
    }
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public boolean assignPin(int pin) {
    	String pinTest = String.valueOf(pin);
    	if (pinTest.length() < 6) {
    		return false;
    	} else {
    		this.pin = pin;
    		return true;		
    	}
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if (this.id != confirmedAuthID) {
    		this.authIncident();
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }


    
    // TO DO: Setters & Getters
}
