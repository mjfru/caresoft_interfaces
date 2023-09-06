package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
	public Physician(int idCopy) {
		super();
		this.id = idCopy;
	}
	
    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		String pinTest = String.valueOf(pin);
		if (pinTest.length() != 4) {
			return false;
		} else {
			this.pin = pin;
			return true;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id == confirmedAuthID) {
			return true;
		} else {
			return false;
		}
	}

	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	
    // TO DO: Setters & Getters
}
