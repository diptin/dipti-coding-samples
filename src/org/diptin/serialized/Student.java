package org.diptin.serialized;

import java.io.Serializable;

/**
 * This class represents student and can be serialized.
 * @author Dipti Nirmale
 *
 */
class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String stud_id;
	private String fName;
	private String lName;
	private transient String dateOfBirth;
	
	
	Student(String id){
		this.stud_id = id;
	}

	public String studentId(){
		return this.stud_id;
	}
	public String firstName(){
		return this.fName;
	}
	
	public String lastName(){
		return this.lName;
	}
	
	public void setFirstName(String firstName){
		this.fName = firstName;
	}
	
	public void setLastName(String lastName){
		this.lName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDob(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
