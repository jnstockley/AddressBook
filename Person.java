package com.github.jnstockley.addressbook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class holds all the necessary commands to create a person object,
 * and to perform full CRUD on the person table of a given database.
 * @author jnstockley
 * @version 3.2
 */
public class Person {

	@ApiModelProperty(
			value = "ID of the person",
			example = "1, 4, 99"
			)
	private int id;
	@ApiModelProperty(
			value = "First name of the person",
			example = "Jack, Katie"
			)
	private String firstName;
	@ApiModelProperty(
			value = "Middle name of the person",
			example = "Elizabeth, Rese"
			)
	private String middleName;
	@ApiModelProperty(
			value = "Last name of the person",
			example = "Smith, Glynn"
			)
	private String lastName;
	@ApiModelProperty(
			value = "Home phone number of the person",
			example = "1234567890"
			)
	private String homePhone;
	@ApiModelProperty(
			value = "Mobile phone number of the person",
			example = "1234567890"
			)
	private String mobilePhone;
	@ApiModelProperty(
			value = "Work phone number of the person",
			example = "1234567890"
			)
	private String workPhone;
	@ApiModelProperty(
			value = "Personal email of the person",
			example = "first-name@domain.com"
			)
	private String homeEmail;
	@ApiModelProperty(
			value = "Work email of the person",
			example = "first-name@domain.com"
			)
	private String workEmail;
	@ApiModelProperty(
			value = "Height of the person in cm",
			example = "170, 164.5"
			)
	private double height;
	@ApiModelProperty(
			value = "Weight of the person in pounds",
			example = "150, 135.78"
			)
	private double weight;
	@ApiModelProperty(
			value = "Gender of the person",
			example = "Male, Female"
			)
	private String gender;
	@ApiModelProperty(
			value = "Race of the person",
			example = "White, Hispanic"
			)
	private String race;
	@ApiModelProperty(
			value = "Address ID of the corresponding person",
			example = "1, 4, 99"
			)
	private int addressId;
	@ApiModelProperty(
			value = "Occupation ID of the corresponding occupation",
			example = "1, 4, 99"
			)
	private int occupationId;
	@ApiModelProperty(
			value = "Date the address was created or updated on",
			example = "2020-01-01"
			)
	private String date;
	@ApiModelProperty(
			value = "Time the address was created or updated on",
			example = "00:00:00"
			)
	private String time;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}

	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * @return the homeEmail
	 */
	public String getHomeEmail() {
		return homeEmail;
	}

	/**
	 * @param homeEmail the homeEmail to set
	 */
	public void setHomeEmail(String homeEmail) {
		this.homeEmail = homeEmail;
	}

	/**
	 * @return the workEmail
	 */
	public String getWorkEmail() {
		return workEmail;
	}

	/**
	 * @param workEmail the workEmail to set
	 */
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the occupationId
	 */
	public int getOccupationId() {
		return occupationId;
	}

	/**
	 * @param occupationId the occupationId to set
	 */
	public void setOccupationId(int occupationId) {
		this.occupationId = occupationId;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	/**
	 * Prints out the person object with formatting for better human readability
	 */
	public String toString() {
		return "ID: " + this.getId() + "\n" + this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName() 
		+ "\nHome Phone: " + this.getHomePhone() + " Mobile Phone: " + this.getMobilePhone() + " Work Phone: " + this.getWorkPhone()
		+ "\nHome Email: " + this.getHomeEmail() + " Work Email: " + this.getWorkEmail() 
		+ "\nHeight: " + this.getHeight() + " Weight: " + this.getWeight() + " Gender: " + this.getGender() + " Race: " + this.getRace()
		+ "\nAddress ID: " + this.getAddressId() +  " OccupationID: " + this.getOccupationId() + " Date Created: " + this.getDate() + " Time Created: " + this.getTime() + "\n"; 
	}

	/**
	 * Checks all the fields of both people and checks if they are equal ignoring case
	 * @param person The person that is being checked
	 * @return Either true if all the fields are equal or false if at least one field is different
	 */
	public boolean equals(Person person) {
		if(this.getFirstName().equalsIgnoreCase(person.getFirstName()) && this.getMiddleName().equalsIgnoreCase(person.getMiddleName()) && this.getLastName().equalsIgnoreCase(person.getLastName()) && this.getHomePhone().equalsIgnoreCase(person.getHomePhone()) && this.getMobilePhone().equalsIgnoreCase(person.getMobilePhone()) && this.getWorkPhone().equalsIgnoreCase(person.getWorkPhone()) && this.getHomeEmail().equalsIgnoreCase(person.getHomeEmail()) && this.getWorkEmail().equalsIgnoreCase(person.getWorkEmail()) && this.getHeight() == person.getHeight() && this.getWeight() == person.getWeight() && this.getGender().equalsIgnoreCase(person.getGender()) && this.getRace().equalsIgnoreCase(person.getRace()) && this.getAddressId() == person.getAddressId() && this.getOccupationId() == person.getOccupationId()) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Creates a person object with all the fields set to either 0, 0.0 or an empty string
	 */
	public Person() {
		this(0, "", "", "", "0", "0", "0", "", "", 0.0, 0.0, "", "", 0, 0, "", "");
	}

	/**
	 * Creates a person object with the id and date and time as empty values
	 * @param firstName The first name of the person
	 * @param middleName The middle name of the person
	 * @param lastName The last name of the person
	 * @param homePhone The home phone number with no dashes length of 10
	 * @param mobilePhone The mobile phone number with no dashed length of 10 
	 * @param workPhone The work phone number with no dashed length of 10
	 * @param homeEmail The home email of the person
	 * @param workEmail The work email of the person
	 * @param height The height of the person in centimeters
	 * @param weight The weight of the person in pounds
	 * @param gender The gender of the person
	 * @param race The race of the person
	 * @param addressID The address id which corresponds to an address on the database
	 * @param occupationID The occupation id which corresponds to an occupation on the database
	 */
	public Person(String firstName, String middleName, String lastName, String homePhone, String mobilePhone, String workPhone, String homeEmail, String workEmail, double height, double weight, String gender, String race, int addressID, int occupationID) {
		this(0, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, addressID, occupationID, "", "");
	}

	/**
	 * Creates a person object with the date and time as empty fields mainly used for updating a person
	 * @param id The id of the person
	 * @param firstName The first name of the person
	 * @param middleName The middle name of the person
	 * @param lastName The last name of the person
	 * @param homePhone The home phone number with no dashes length of 10
	 * @param mobilePhone The mobile phone number with no dashed length of 10 
	 * @param workPhone The work phone number with no dashed length of 10
	 * @param homeEmail The home email of the person
	 * @param workEmail The work email of the person
	 * @param height The height of the person in centimeters
	 * @param weight The weight of the person in pounds
	 * @param gender The gender of the person
	 * @param race The race of the person
	 * @param addressID The address id which corresponds to an address on the database
	 * @param occupationID The occupation id which corresponds to an occupation on the database
	 */
	public Person(int id, String firstName, String middleName, String lastName, String homePhone, String mobilePhone, String workPhone, String homeEmail, String workEmail, double height, double weight, String gender, String race, int addressID, int occupationID) {
		this(id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, addressID, occupationID, "", "");
	}

	/**
	 * Creates a person object with no empty fields mainly used for getting all people
	 * @param id The id of the person
	 * @param firstName The first name of the person
	 * @param middleName The middle name of the person
	 * @param lastName The last name of the person
	 * @param homePhone The home phone number with no dashes length of 10
	 * @param mobilePhone The mobile phone number with no dashed length of 10 
	 * @param workPhone The work phone number with no dashed length of 10
	 * @param homeEmail The home email of the person
	 * @param workEmail The work email of the person
	 * @param height The height of the person in centimeters
	 * @param weight The weight of the person in pounds
	 * @param gender The gender of the person
	 * @param race The race of the person
	 * @param addressID The address id which corresponds to an address on the database
	 * @param occupationID The occupation id which corresponds to an occupation on the database
	 * @param date The date the person was created
	 * @param time The time the person was created
	 */
	public Person(int id, String firstName, String middleName, String lastName, String homePhone, String mobilePhone, String workPhone, String homeEmail, String workEmail, double height, double weight, String gender, String race, int addressID, int occupationID, String date, String time) {
		this.setId(0);
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
		this.setHomePhone(homePhone);
		this.setMobilePhone(mobilePhone);
		this.setWorkPhone(workPhone);
		this.setHomeEmail(homeEmail);
		this.setWorkEmail(workEmail);
		this.setHeight(height);
		this.setWeight(weight);
		this.setGender(gender);
		this.setRace(race);
		this.setAddressId(addressID);
		this.setOccupationId(occupationID);
		this.setDate(date);
		this.setTime(time);
	}

	/**
	 * Creates a list of people stored on a database and returns the people list
	 * @param conn The MySQL connection
	 * @return Either returns a list of people or null if there was an error getting all the people
	 */
	public List<Person> get(Connection conn){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Person> people = new ArrayList<Person>(); //Creates an empty list of people to store all people on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, date, time, addressId, occupationId FROM person"); //SQL statement to get all people from the database
				ResultSet rs = ps.executeQuery(); //Retrieves all the people from the database
				while(rs.next()) { //Loops through all people, creates an empty person and set all the values for each person to their corresponding value stored on the database
					int col = 1;
					Person person = new Person();
					person.setId(rs.getInt(col++));
					person.setFirstName(Encryption.decrypt(rs.getString(col++)));
					person.setMiddleName(Encryption.decrypt(rs.getString(col++)));
					person.setLastName(Encryption.decrypt(rs.getString(col++)));
					person.setHomePhone(Encryption.decrypt(rs.getString(col++)));
					person.setMobilePhone(Encryption.decrypt(rs.getString(col++)));
					person.setWorkPhone(Encryption.decrypt(rs.getString(col++)));
					person.setHomeEmail(Encryption.decrypt(rs.getString(col++)));
					person.setWorkEmail(Encryption.decrypt(rs.getString(col++)));
					person.setHeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setWeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setGender(Encryption.decrypt(rs.getString(col++)));
					person.setRace(Encryption.decrypt(rs.getString(col++)));
					person.setDate(rs.getString(col++));
					person.setTime(rs.getString(col++));
					person.setAddressId(rs.getInt(col++));
					person.setOccupationId(rs.getInt(col++));
					people.add(person); //Adds the person to the people list
				}
				if(!people.isEmpty()) { //Checks if the people list is empty
					return people; //Returns the all people list
				}else { //No people in the database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch (SQLException e) { //Error getting all people
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar people stored on a database and returns the similar people list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if a person is similar
	 * @param data The value for the passed field to determine if a person is similar
	 * @return Either returns a list of similar people or null if there was error getting similar people
	 * @deprecated 
	 */
	@Deprecated
	public List<Person> getSimilarPeople(Connection conn, String field, String data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Person> similarPeople = new ArrayList<Person>(); //Creates an empty list of people to store similar people on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, date, time, addressId, occupationId FROM person WHERE " + field + "=?"); //SQL statement to get similar people from the database
				ps.setString(1, data); //Sets the first ? to the string data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar people from the database
				while(rs.next()) { //Loops through all the similar people, creates an empty person and set all the values for each person to their corresponding value stored on the databse
					int col = 1;
					Person person = new Person();
					person.setId(rs.getInt(col++));
					person.setFirstName(Encryption.decrypt(rs.getString(col++)));
					person.setMiddleName(Encryption.decrypt(rs.getString(col++)));
					person.setLastName(Encryption.decrypt(rs.getString(col++)));
					person.setHomePhone(Encryption.decrypt(rs.getString(col++)));
					person.setMobilePhone(Encryption.decrypt(rs.getString(col++)));
					person.setWorkPhone(Encryption.decrypt(rs.getString(col++)));
					person.setHomeEmail(Encryption.decrypt(rs.getString(col++)));
					person.setWorkEmail(Encryption.decrypt(rs.getString(col++)));
					person.setHeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setWeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setGender(Encryption.decrypt(rs.getString(col++)));
					person.setRace(Encryption.decrypt(rs.getString(col++)));
					person.setDate(rs.getString(col++));
					person.setTime(rs.getString(col++));
					person.setAddressId(rs.getInt(col++));
					person.setOccupationId(rs.getInt(col++));
					similarPeople.add(person); //Adds the person to the similar people list
				}
				if(!similarPeople.isEmpty()) { //Checks if the similar people list is empty
					return similarPeople; //Returns the similar people list
				}else { //No similar people based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch (SQLException e) { //Error getting similar people
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar people stored on a database and returns the similar people list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if a person is similar
	 * @param data The value for the passed field to determine if a person is similar
	 * @return Either returns a list of similar people or null if there was an error getting similar people
	 * @deprecated 
	 */
	@Deprecated
	public List<Person> getSimilarPeople(Connection conn, String field, int data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Person> similarPeople = new ArrayList<Person>(); //Creates an empty list of people to store similar people on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, date, time, addressId, occupationId FROM person WHERE " + field + "=?"); //SQL statement to get similar people from the database
				ps.setInt(1, data); //Sets the first ? to the integer data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar people from the database
				while(rs.next()) { //Loops through all the similar people, creates an empty person and set all the values for each person to their corresponding value stored on the database
					int col = 1;
					Person person = new Person();
					person.setId(rs.getInt(col++));
					person.setFirstName(Encryption.decrypt(rs.getString(col++)));
					person.setMiddleName(Encryption.decrypt(rs.getString(col++)));
					person.setLastName(Encryption.decrypt(rs.getString(col++)));
					person.setHomePhone(Encryption.decrypt(rs.getString(col++)));
					person.setMobilePhone(Encryption.decrypt(rs.getString(col++)));
					person.setWorkPhone(Encryption.decrypt(rs.getString(col++)));
					person.setHomeEmail(Encryption.decrypt(rs.getString(col++)));
					person.setWorkEmail(Encryption.decrypt(rs.getString(col++)));
					person.setHeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setWeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setGender(Encryption.decrypt(rs.getString(col++)));
					person.setRace(Encryption.decrypt(rs.getString(col++)));
					person.setDate(rs.getString(col++));
					person.setTime(rs.getString(col++));
					person.setAddressId(rs.getInt(col++));
					person.setOccupationId(rs.getInt(col++));
					similarPeople.add(person); //Adds the person to the similar people list
				}
				if(!similarPeople.isEmpty()) { //Checks if the similar people list is empty
					return similarPeople; //Returns the similar people list
				}else { //No matching people based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch (SQLException e) { //Error getting similar people
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar people stored on a database and returns the similar people list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if a person is similar
	 * @param data The value for the passed field to determine if a person is similar
	 * @return Either returns a list of similar people or null if there was an error getting similar people
	 * @deprecated
	 */
	@Deprecated
	public List<Person> getSimilarPeople(Connection conn, String field, double data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Person> similarPeople = new ArrayList<Person>(); //Creates an empty list of people to store similar people on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, date, time, addressId, occupationId FROM person WHERE " + field + "=?"); //SQL statement to get similar people from the database
				ps.setDouble(1, data); //Sets the first ? to the double data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar people from the database
				while(rs.next()) { //Loops through all the similar people, creates an empty person and set all the values for each person to their corresponding value stored on the database
					int col = 1;
					Person person = new Person();
					person.setId(rs.getInt(col++));
					person.setFirstName(Encryption.decrypt(rs.getString(col++)));
					person.setMiddleName(Encryption.decrypt(rs.getString(col++)));
					person.setLastName(Encryption.decrypt(rs.getString(col++)));
					person.setHomePhone(Encryption.decrypt(rs.getString(col++)));
					person.setMobilePhone(Encryption.decrypt(rs.getString(col++)));
					person.setWorkPhone(Encryption.decrypt(rs.getString(col++)));
					person.setHomeEmail(Encryption.decrypt(rs.getString(col++)));
					person.setWorkEmail(Encryption.decrypt(rs.getString(col++)));
					person.setHeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setWeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setGender(Encryption.decrypt(rs.getString(col++)));
					person.setRace(Encryption.decrypt(rs.getString(col++)));
					person.setDate(rs.getString(col++));
					person.setTime(rs.getString(col++));
					person.setAddressId(rs.getInt(col++));
					person.setOccupationId(rs.getInt(col++));
					similarPeople.add(person); //Adds the person to the similar people list
				}
				if(!similarPeople.isEmpty()) { //Checks if the similar people list is empty
					return similarPeople; //Returns the similar people list
				}else { //No matching people based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch (SQLException e) { //Error getting similar people
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * Retrieves a singular person based on the passed ID and returns it
	 * @param conn The MySQL connection
	 * @param id The ID of the person to be returned
	 * @return Either the requested person from the database or null if there was an error getting the person
	 */
	public Person get(Connection conn, int id) {
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				Person person = new Person(); //Creates an empty person to store the person on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, date, time, addressId, occupationId FROM person WHERE id = ?"); //SQL statement to get a singular person based on the passed ID
				ps.setInt(1, id); //Sets the first ? to the integer id of the person to be returned
				ResultSet rs = ps.executeQuery(); //Retrieves the person from the database
				if(rs.next()) { //Checks if the person was returned from the database. If true it will set all the values for the person to their corresponding values from the database. If false it will return null
					int col = 1;
					person.setId(rs.getInt(col++));
					person.setFirstName(Encryption.decrypt(rs.getString(col++)));
					person.setMiddleName(Encryption.decrypt(rs.getString(col++)));
					person.setLastName(Encryption.decrypt(rs.getString(col++)));
					person.setHomePhone(Encryption.decrypt(rs.getString(col++)));
					person.setMobilePhone(Encryption.decrypt(rs.getString(col++)));
					person.setWorkPhone(Encryption.decrypt(rs.getString(col++)));
					person.setHomeEmail(Encryption.decrypt(rs.getString(col++)));
					person.setWorkEmail(Encryption.decrypt(rs.getString(col++)));
					person.setHeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setWeight(Double.parseDouble(Encryption.decrypt(rs.getString(col++))));
					person.setGender(Encryption.decrypt(rs.getString(col++)));
					person.setRace(Encryption.decrypt(rs.getString(col++)));
					person.setDate(rs.getString(col++));
					person.setTime(rs.getString(col++));
					person.setAddressId(rs.getInt(col++));
					person.setOccupationId(rs.getInt(col++));
					return person;
				}else { //No person with passed id
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch (SQLException e) { //Error getting singular person
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Updates a singular person on the database and returns the new person
	 * To keep existing data from the current person set height and weight to 0.0, set addressId and occupationId to 0
	 * or other fields to empty strings, excluding id, date, and time
	 * @param conn The MySQL connection
	 * @param id The id of the person to be updated
	 * @param updatedPerson The new person that is going to be updated
	 * @return Either returns the person passed, confirming the update or null if the person was not updated
	 */
	public Person update(Connection conn, int id, Person updatedPerson) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				BackendHelper helper = new BackendHelper(); //Creates a backend helper to help check for existing people in the database
				updatedPerson.setId(id); //Sets the id of the person
				updatedPerson.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the person
				updatedPerson.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the person
				Person oldPerson = get(conn, id); //Creates a person object and sets it to the current person stored on the database at the given id
				//Checks if any field in the updated person is empty and replaces it with data from the current person on the database
				if(updatedPerson.getFirstName().equalsIgnoreCase("")) {
					updatedPerson.setFirstName(oldPerson.getFirstName());
				}
				if(updatedPerson.getMiddleName().equalsIgnoreCase("")) {
					updatedPerson.setMiddleName(oldPerson.getMiddleName());
				}
				if(updatedPerson.getLastName().equalsIgnoreCase("")) {
					updatedPerson.setLastName(oldPerson.getLastName());
				}
				if(updatedPerson.getHomePhone()=="") {
					updatedPerson.setHomePhone(oldPerson.getHomePhone());
				}
				if(updatedPerson.getMobilePhone()=="") {
					updatedPerson.setMobilePhone(oldPerson.getMobilePhone());
				}
				if(updatedPerson.getWorkPhone()=="") {
					updatedPerson.setWorkPhone(oldPerson.getWorkPhone());
				}
				if(updatedPerson.getHomeEmail().equalsIgnoreCase("")) {
					updatedPerson.setHomeEmail(oldPerson.getHomeEmail());
				}
				if(updatedPerson.getWorkEmail().equalsIgnoreCase("")) {
					updatedPerson.setWorkEmail(oldPerson.getWorkEmail());
				}
				if(updatedPerson.getHeight()==0.0) {
					updatedPerson.setHeight(oldPerson.getHeight());
				}
				if(updatedPerson.getWeight()==0.0) {
					updatedPerson.setWeight(oldPerson.getWeight());
				}
				if(updatedPerson.getGender().equalsIgnoreCase("")) {
					updatedPerson.setGender(oldPerson.getGender());
				}
				if(updatedPerson.getRace().equalsIgnoreCase("")) {
					updatedPerson.setRace(oldPerson.getRace());
				}
				if(updatedPerson.getAddressId()==0) {
					updatedPerson.setAddressId(oldPerson.getAddressId());
				}
				if(updatedPerson.getOccupationId()==0) {
					updatedPerson.setOccupationId(oldPerson.getOccupationId());
				}
				if(!helper.exisits(conn, updatedPerson)) { //Makes sure the updated person doesn't exist on the database
					PreparedStatement ps = conn.prepareStatement("UPDATE person SET firstName=?, middleName=?, lastName=?, homePhone=?, mobilePhone=?, workPhone=?, homeEmail=?, workEmail=?, height=?, weight=?, gender=?, race=?, addressId=?, occupationId=?, date=?, time=? WHERE id =?"); //SQL statement that updates existing data with the new data at the given id
					//Sets all the ? to the given data from the updated person object
					ps.setString(1, Encryption.encrypt(updatedPerson.getFirstName()));
					ps.setString(2, Encryption.encrypt(updatedPerson.getMiddleName()));
					ps.setString(3, Encryption.encrypt(updatedPerson.getLastName()));
					ps.setString(4, Encryption.encrypt(updatedPerson.getHomePhone()));
					ps.setString(5, Encryption.encrypt(updatedPerson.getMobilePhone()));
					ps.setString(6, Encryption.encrypt(updatedPerson.getWorkPhone()));
					ps.setString(7, Encryption.encrypt(updatedPerson.getHomeEmail()));
					ps.setString(8, Encryption.encrypt(updatedPerson.getWorkEmail()));
					ps.setString(9, Encryption.encrypt(Double.toString(updatedPerson.getHeight())));
					ps.setString(10, Encryption.encrypt(Double.toString(updatedPerson.getWeight())));
					ps.setString(11, Encryption.encrypt(updatedPerson.getGender()));
					ps.setString(12, Encryption.encrypt(updatedPerson.getRace()));
					ps.setInt(13, updatedPerson.getAddressId());
					ps.setInt(14, updatedPerson.getOccupationId());
					ps.setString(15, updatedPerson.getDate());
					ps.setString(16, updatedPerson.getTime());
					ps.setInt(17, id);
					ps.executeUpdate(); //Sends the update request to the database
					if(get(conn, id).equals(updatedPerson)) { //Makes sure the requested person was successfully updated
						return updatedPerson;
					}else { //Person not updated
						return null;
					}
				}else { //Person already exists on the database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error updating person
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserts a new person into the database
	 * @param conn The MySQL connection
	 * @param newPerson The new person this is going to be inserted into the database
	 * @return Either returns the passed person, confirming the insert or null if the person wasn't updated
	 */
	public Person insert(Connection conn, Person newPerson) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid!
				if(!newPerson.getFirstName().equals("") && !newPerson.getMiddleName().equals("") && !newPerson.getLastName().equals("") && !newPerson.getHomePhone().equals("0") && !newPerson.getMobilePhone().equals("0") && !newPerson.getWorkPhone().equals("0") && !newPerson.getHomeEmail().equals("") && !newPerson.getWorkEmail().equals("") && newPerson.getHeight() != 0.0 && newPerson.getWeight() != 0.0 && !newPerson.getGender().equals("") && !newPerson.getRace().equals("") && newPerson.getAddressId() != 0 && newPerson.getOccupationId() != 0) { //Makes sure all the values of the new person aren't empty or 0
					newPerson.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the new person
					newPerson.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the new person
					BackendHelper helper = new BackendHelper(); //Creates a backend helper to check for exists person in the database and to get the new id of the person
					if(!helper.exisits(conn, newPerson)) { //Determines if the newPerson is not in the database
						PreparedStatement ps = conn.prepareStatement("INSERT INTO person (firstName, middleName, lastName, homePhone, mobilePhone, workPhone, homeEmail, workEmail, height, weight, gender, race, addressId, occupationId, date, time) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //SQL statement to insert a new person in the database
						//Sets all the ? to the given data from the new person object
						ps.setString(1, Encryption.encrypt(newPerson.getFirstName()));
						ps.setString(2, Encryption.encrypt(newPerson.getMiddleName()));
						ps.setString(3, Encryption.encrypt(newPerson.getLastName()));
						ps.setString(4, Encryption.encrypt(newPerson.getHomePhone()));
						ps.setString(5, Encryption.encrypt(newPerson.getMobilePhone()));
						ps.setString(6, Encryption.encrypt(newPerson.getWorkPhone()));
						ps.setString(7, Encryption.encrypt(newPerson.getHomeEmail()));
						ps.setString(8, Encryption.encrypt(newPerson.getWorkEmail()));
						ps.setString(9, Encryption.encrypt(Double.toString(newPerson.getHeight())));
						ps.setString(10, Encryption.encrypt(Double.toString(newPerson.getWeight())));
						ps.setString(11, Encryption.encrypt(newPerson.getGender()));
						ps.setString(12, Encryption.encrypt(newPerson.getRace()));
						ps.setInt(13, newPerson.getAddressId());
						ps.setInt(14, newPerson.getOccupationId());
						ps.setString(15, newPerson.getDate());
						ps.setString(16, newPerson.getTime());
						ps.execute(); //Sends the insert request to the database
						int id = helper.mostRecentPerson(conn); //Gets the most recent id from the person table
						if(id!=-1) { //Checks to make sure the id is valid
							newPerson.setId(id); //Sets the id of the new person
							if(get(conn, id).equals(newPerson)) { //Makes sure the requested person was successfully inserted
								return newPerson;
							}else { //New person not inserted
								return null;
							}
						}else { //Error getting new person from database
							return null;
						}
					}else { //Person already exists on the database
						return null;
					}
				}else { //One or more of the person fields are blank or 0
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error inserting new person
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Removes the person at the passed id from the database
	 * @param conn The MySQL connection
	 * @param id The ID of the person to be removed
	 * @return Either true if the person was removed or false if it wasn't
	 */
	public boolean delete(Connection conn, int id) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				Person person = get(conn, id); //Gets the current person from the database
				if(person!=null) { //Checks if the person is on the database
					PreparedStatement ps = conn.prepareStatement("DELETE FROM person WHERE id = ?"); //SQL statement to remove a given person
					ps.setInt(1, id); //Sets the first ? to the id of the person to remove
					ps.execute(); //Sends the delete request to the database
					if(get(conn, id) == null) { //Checks that the person was removed from the database
						return true;
					}else { //Person not removed
						return false;
					}
				}else { //Person not in database
					return false;
				}
			}else { //MySQL connection is not valid
				return false;
			}
		}catch (SQLException e) { //Error removing person
			e.printStackTrace();
			return false;
		}
	}
}