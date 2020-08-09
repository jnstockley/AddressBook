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
 * This class holds all the necessary commands to create an occupation object,
 * and to perform full CRUD on the occupation table of a given database.
 * @author jnstockley
 * @version 3.1
 */
public class Occupation {

	@ApiModelProperty(
			value = "ID of the occupation",
			example = "1, 4, 99"
			)
	private int id;
	@ApiModelProperty(
			value = "Compnay name of the occupation",
			example = "Apple Inc."
			)
	private String companyName;
	@ApiModelProperty(
			value = "Job Title of the occupation",
			example = "Teacher, Chef"
			)
	private String jobTitle;
	@ApiModelProperty(
			value = "Employment type of the occupation",
			example = "Full-Time, Part-Time"
			)
	private String employmentType;
	@ApiModelProperty(
			value = "Monthly Salary of the occupation",
			example = "1200, 3200, 9900"
			)
	private String monthlySalary;
	@ApiModelProperty(
			value = "Industry of the occupation",
			example = "Education, Technology"
			)
	private String industry;
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(String monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	/**
	 * Prints out the occupation with formatting for better human readability
	 */
	public String toString() {
		return "ID: " + this.getId() + "\nCompany Name: " + this.getCompanyName() + " Job Title: " + this.getJobTitle() + "\nEmployment Type: "
				+ this.getEmploymentType() + " Monthly Salary: $" + this.getMonthlySalary() + " Industry: " + this.getIndustry() + "\nDate Created: "
				+ this.getDate() + " Time Created: " + this.getTime() + "\n";
	}

	/**
	 * Checks all the fields of both occupations and checks if they are equal ignoring case
	 * @param occupation The occupation that is being checked
	 * @return Either true if all the fields are equal or false if at least one field is different
	 */
	public boolean equals(Occupation occupation) {
		if(this.getCompanyName().equalsIgnoreCase(occupation.getCompanyName()) && this.getJobTitle().equalsIgnoreCase(occupation.getJobTitle()) && this.getEmploymentType().equalsIgnoreCase(occupation.getEmploymentType()) && this.getMonthlySalary().equalsIgnoreCase(occupation.getMonthlySalary()) && this.getIndustry().equalsIgnoreCase(occupation.getIndustry())) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Creates an occupation object with all the fields set to either 0 or an empty string
	 */
	public Occupation() {
		this(0, "", "", "", "", "", "", "");
	}

	/**
	 * Creates an occupation object with the id and date and time as empty values
	 * @param companyName The company name for the occupation
	 * @param jobTitle The job title for the occupation
	 * @param employmentType The employment type of the occupation
	 * @param monthlySalary The monthly salary of the occupation without the $ or , and no decimal points
	 * @param industry The industry of the occupation
	 */
	public Occupation(String companyName, String jobTitle, String employmentType, String monthlySalary, String industry) {
		this(0, companyName, jobTitle, employmentType, monthlySalary, industry, "", "");
	}

	/**
	 * Creates an occupation object with the date and time as empty fields mainly used for updating an occupation
	 * @param id The id of the occupation
	 * @param companyName The company name for the occupation
	 * @param jobTitle The job title for the occupation
	 * @param employmentType The employment type of the occupation
	 * @param monthlySalary The monthly salary of the occupation without the $ or , and no decimal points
	 * @param industry The industry of the occupation
	 */
	public Occupation(int id, String companyName, String jobTitle, String employmentType, String monthlySalary, String industry) {
		this(id, companyName, jobTitle, employmentType, monthlySalary, industry, "", "");
	}

	/**
	 * Creates an occupation object with no empty fields mainly used for getting all occupations
	 * @param id The id of the occupation
	 * @param companyName The company name for the occupation
	 * @param jobTitle The job title for the occupation
	 * @param employmentType The employment type of the occupation
	 * @param monthlySalary The monthly salary of the occupation without the $ or , and no decimal points
	 * @param industry The industry of the occupation
	 * @param date The date the occupation was created
	 * @param time The time the occupation was created
	 */
	public Occupation(int id, String companyName, String jobTitle, String employmentType, String monthlySalary, String industry, String date, String time) {
		this.setId(id);
		this.setCompanyName(companyName);
		this.setJobTitle(jobTitle);
		this.setEmploymentType(employmentType);
		this.setMonthlySalary(monthlySalary);
		this.setIndustry(industry);
		this.setDate(date);
		this.setTime(time);
	}

	/**
	 * Creates a list of occupations stored on a database and returns the occupation list
	 * @param conn The MySQL connection
	 * @return Either returns a list of occupations or null if there was an error getting all occupations
	 */
	public List<Occupation> get(Connection conn){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Occupation> occupations = new ArrayList<Occupation>(); //Creates an empty list of occupations to store all occupations on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, companyName, jobTitle, employmentType, monthlySalary, industry, date, time FROM occupation"); //SQL statement to get all occupations from the database
				ResultSet rs = ps.executeQuery(); //Retrieves all occupations from the database
				while(rs.next()) { //Loops through all occupations, creates an empty occupation and set all the values for each occupation to their corresponding value stored on the database
					int col = 1;
					Occupation occupation = new Occupation();
					occupation.setId(rs.getInt(col++));
					occupation.setCompanyName(Encryption.decrypt(rs.getString(col++)));
					occupation.setJobTitle(Encryption.decrypt(rs.getString(col++)));
					occupation.setEmploymentType(Encryption.decrypt(rs.getString(col++)));
					occupation.setMonthlySalary(Encryption.decrypt(rs.getString(col++)));
					occupation.setIndustry(Encryption.decrypt(rs.getString(col++)));
					occupation.setDate(rs.getString(col++));
					occupation.setTime(rs.getString(col++));
					occupations.add(occupation); //Adds the occupation to the occupations list
				}
				if(!occupations.isEmpty()) { //Checks if occupations list is empty
					return occupations; //Returns the all occupations list
				}else { //No occupations in the database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting all occupations
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar occupations stored on a database and returns the similar occupation list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if an occupation is similar
	 * @param data The value for the passed field to determine if an occupation is similar
	 * @return Either returns a list of similar occupations or null if there was an error getting similar occupations
	 * @deprecated 
	 */
	@Deprecated
	public List<Occupation> getSimilarOccupation(Connection conn, String field, String data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Occupation> similarOccupations = new ArrayList<Occupation>(); //Create an empty list of occupations to store similar occupations on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, companyName, jobTitle, employmentType, monthlySalary, industry, date, time FROM occupation WHERE " + field + "=?"); //SQL statement to get all the similar occupations from the database
				ps.setString(1, data); //Sets the first ? to the string data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar occupations from the database
				while(rs.next()) { //Loops through all the similar occupations, creates an empty occupation and sets all the values for each occupation to their corresponding value stored on the database
					int col = 1;
					Occupation occupation = new Occupation();
					occupation.setId(rs.getInt(col++));
					occupation.setCompanyName(Encryption.decrypt(rs.getString(col++)));
					occupation.setJobTitle(Encryption.decrypt(rs.getString(col++)));
					occupation.setEmploymentType(Encryption.decrypt(rs.getString(col++)));
					occupation.setMonthlySalary(Encryption.decrypt(rs.getString(col++)));
					occupation.setIndustry(Encryption.decrypt(rs.getString(col++)));
					occupation.setDate(rs.getString(col++));
					occupation.setTime(rs.getString(col++));
					similarOccupations.add(occupation); //Adds the occupation to the similar occupations list
				}
				if(!similarOccupations.isEmpty()) { //Checks if the similar occupations list is empty
					return similarOccupations; //Returns the similar occupations list
				}else { //No similar occupations based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting similar occupations
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar occupations stored on a database and returns the similar occupations list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if an occupation is similar
	 * @param data The values for the passed field to determine if an occupation is similar
	 * @return Either returns a list of similar occupations or null if there was an error getting similar occupations
	 * @deprecated 
	 */
	@Deprecated
	public List<Occupation> getSimilarOccupation(Connection conn, String field, int data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Occupation> similarOccupations = new ArrayList<Occupation>(); //Creates an empty list of occupations to store similar occupation on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, companyName, jobTitle, employmentType, monthlySalary, industry, date, time FROM occupation WHERE " + field + "=?"); //SQL statement to get all the similar occupation from the database
				ps.setInt(1, data); //Sets the first ? to the integer data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar occupations from the database
				while(rs.next()) { //Loops through all the similar occupations, creates an empty occupation and set all the values for each occupation to their corresponding value stored on the database
					int col = 1;
					Occupation occupation = new Occupation();
					occupation.setId(rs.getInt(col++));
					occupation.setCompanyName(Encryption.decrypt(rs.getString(col++)));
					occupation.setJobTitle(Encryption.decrypt(rs.getString(col++)));
					occupation.setEmploymentType(Encryption.decrypt(rs.getString(col++)));
					occupation.setMonthlySalary(Encryption.decrypt(rs.getString(col++)));
					occupation.setIndustry(Encryption.decrypt(rs.getString(col++)));
					occupation.setDate(rs.getString(col++));
					occupation.setTime(rs.getString(col++));
					similarOccupations.add(occupation); //Adds the occupation to the similar occupations list
				}
				if(!similarOccupations.isEmpty()) { //Checks if the similar occupations list is empty
					return similarOccupations; //Returns the similar occupations list
				}else { //No similar occupations based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting similar occupations
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves a singular occupation based on the passed ID and returns it
	 * @param conn The MySQL connection
	 * @param id The ID of the occupation to be returned
	 * @return A singular occupation based on the ID passed
	 */
	public Occupation get(Connection conn, int id){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				Occupation occupation = new Occupation(); //Creates an empty occupation to store the occupation on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, companyName, jobTitle, employmentType, monthlySalary, industry, date, time FROM occupation WHERE id = ?"); //SQL statement to get a singular occupation based on the passed ID
				ps.setInt(1, id); //Sets the first ? to the integer id of the occupation to be returned
				ResultSet rs = ps.executeQuery(); //Retrieves the occupation from the database
				if(rs.next()) { //Checks if the occupation was returned from the database. If true it will set all the values for the occupation to their corresponding values from the database. If false will return null
					int col = 1;
					occupation.setId(rs.getInt(col++));
					occupation.setCompanyName(Encryption.decrypt(rs.getString(col++)));
					occupation.setJobTitle(Encryption.decrypt(rs.getString(col++)));
					occupation.setEmploymentType(Encryption.decrypt(rs.getString(col++)));
					occupation.setMonthlySalary(Encryption.decrypt(rs.getString(col++)));
					occupation.setIndustry(Encryption.decrypt(rs.getString(col++)));
					occupation.setDate(rs.getString(col++));
					occupation.setTime(rs.getString(col++));
					return occupation;
				}else { //No matching occupation based on passed id
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting singular occupation
			return null;
		}
	}
	/**
	 * Updates a singular occupation on the database and returns the new occupation
	 * To keep existing data from current occupation set any of the field to empty strings, excluding id, date, and time
	 * @param conn The MySQL connection
	 * @param id The id of the occupation to be updated
	 * @param updatedOccupation The new occupation that is going to be updated
	 * @return Either returns the occupation passed, confirming the update or null if the occupation was not updated
	 */
	public Occupation update(Connection conn, int id, Occupation updatedOccupation) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				BackendHelper helper = new BackendHelper(); //Creates a backend helper to help check for existing occupations in the database
				updatedOccupation.setId(id); //Sets the id of the occupation
				updatedOccupation.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the occupation
				updatedOccupation.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the occupation
				Occupation oldOccupation = get(conn, id); //Creates an occupation object and sets it to the current occupation at the given id
				//Checks if any field in the updated occupation is empty and replaces it with the data from the current occupation on the database
				if(updatedOccupation.getCompanyName().equalsIgnoreCase("")) {
					updatedOccupation.setCompanyName(oldOccupation.getCompanyName());
				}
				if(updatedOccupation.getJobTitle().equalsIgnoreCase("")) {
					updatedOccupation.setJobTitle(oldOccupation.getJobTitle());
				}
				if(updatedOccupation.getEmploymentType().equalsIgnoreCase("")) {
					updatedOccupation.setEmploymentType(oldOccupation.getEmploymentType());
				}
				if(updatedOccupation.getMonthlySalary().equalsIgnoreCase("")) {
					updatedOccupation.setMonthlySalary(oldOccupation.getMonthlySalary());
				}
				if(updatedOccupation.getIndustry().equalsIgnoreCase("")) {
					updatedOccupation.setIndustry(oldOccupation.getIndustry());
				}
				if(!helper.exisits(conn, updatedOccupation)) { //Makes sure the updated occupation doesn't exist on the database
					PreparedStatement ps = conn.prepareStatement("UPDATE occupation SET companyName=?, jobTitle=?, employmentType=?, monthlySalary=?, industry=?, date=?, time=? WHERE id =?"); //SQL statement that updates existing data with the new data at the given id
					//Sets all the ? to the given data from the updated occupation object
					ps.setString(1, Encryption.encrypt(updatedOccupation.getCompanyName()));
					ps.setString(2, Encryption.encrypt(updatedOccupation.getJobTitle()));
					ps.setString(3, Encryption.encrypt(updatedOccupation.getEmploymentType()));
					ps.setString(4, Encryption.encrypt(updatedOccupation.getMonthlySalary()));
					ps.setString(5, Encryption.encrypt(updatedOccupation.getIndustry()));
					ps.setString(6, updatedOccupation.getDate());
					ps.setString(7, updatedOccupation.getTime());
					ps.setInt(8, id);
					ps.executeUpdate(); //Sends the update request to the database
					if(get(conn, id).equals(updatedOccupation)) { //Makes sure the requested occupation was successfully updated
						return updatedOccupation;
					}else { //Occupation not updated
						return null;
					}
				}else { //Occupation already exists on the database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error updating occupation
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserts a new occupation into the database
	 * @param conn The MySQL connection
	 * @param newOccupation The new occupation that is going to be inserted into the database
	 * @return Either returns the passed occupation, confirming the insert or null if the occupation wasn't inserted
	 */
	public Occupation insert(Connection conn, Occupation newOccupation) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid!
				if(!newOccupation.getCompanyName().equals("") && !newOccupation.getJobTitle().equals("") && !newOccupation.getEmploymentType().equals("") && !newOccupation.getMonthlySalary().equals("") && !newOccupation.getIndustry().equals("")) { //Makes sure all the values of the new occupation aren't empty
					newOccupation.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the new occupation
					newOccupation.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the new occupation
					BackendHelper helper = new BackendHelper(); //Creates a backend helper to check for existing occupation in the database and to get the new id of the occupation
					if(!helper.exisits(conn, newOccupation)) { //Makes sure the new occupation doesn't exist on the database
						PreparedStatement ps = conn.prepareStatement("INSERT INTO occupation (companyName, jobTitle, employmentType, monthlySalary, industry, date, time) values (?,?,?,?,?,?,?)"); //SQL statement to insert a new occupation in the database
						//Sets all the ? to the given data from the new occupation object
						ps.setString(1, Encryption.encrypt(newOccupation.getCompanyName()));
						ps.setString(2, Encryption.encrypt(newOccupation.getJobTitle()));
						ps.setString(3, Encryption.encrypt(newOccupation.getEmploymentType()));
						ps.setString(4, Encryption.encrypt(newOccupation.getMonthlySalary()));
						ps.setString(5, Encryption.encrypt(newOccupation.getIndustry()));
						ps.setString(6, newOccupation.getDate());
						ps.setString(7, newOccupation.getTime());
						ps.execute(); //Sends the insert request to the database
						int id = helper.mostRecentOccupation(conn); //Gets the most recent id from the occupation table
						if(id!=-1) { //Checks to make sure the id is valid
							newOccupation.setId(id); //Sets the id of the new occupation
							if(get(conn, id).equals(newOccupation)) { //Makes sure the requested occupation was successfully inserted
								return newOccupation;
							}else { //New occupation not inserted
								return null;
							}
						}else { //Error getting new occupation from database
							return null;
						}
					}else { //Occupation already exists on the database
						return null;
					}
				}else { //One or more of the occupation fields are blank
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error inserting new occupation
			return null;
		}
	}

	/**
	 * Removes the occupation at the passed id from the database
	 * @param conn The MySQL connection
	 * @param id The ID of the occupation to be removed
	 * @return Either true if the occupation was removed or false if it wasn't
	 */
	public boolean delete(Connection conn, int id) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				Occupation occupation = get(conn, id); //Gets the current occupation from database
				if(occupation!=null) { //Confirms the returned occupations isn't null
					PreparedStatement ps = conn.prepareStatement("DELETE FROM occupation WHERE id = ?"); //SQL statement to remove an occupation with the given id
					ps.setInt(1, id); //Sets the first ? to the id of the occupation to remove
					ps.executeUpdate(); //Sends the delete request to the database
					if(get(conn, id) == null) { //Checks that the occupation was removed from the database
						return true;
					}else { //Occupation not removed
						return false;
					}
				}else { //Occupation not in database
					return false;
				}
			}else { //MySQL connection is not valid
				return false;
			}
		}catch(SQLException e) { //Error removing occupation
			e.printStackTrace();
			return false;
		}
	}
}