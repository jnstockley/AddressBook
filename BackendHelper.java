package com.github.jnstockley.addressbook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * A simple helper class that helps with checking if data exists on the database and what the newest address,
 * person or occupation is on the database.
 * @author jnstockley
 * @version 3.0.1
 *
 */
public class BackendHelper {

	private double version = 3.01;

	/**
	 * Checks a file stored on the github repository and gets the current version number and checks if the current version is less then the latest version
	 * @return Either true if the program is up to date or false if its not
	 */
	public boolean upToDate() {
		try {
			Document doc = Jsoup.connect("https://github.com/jnstockley/AddressBook/blob/master/version.txt").get(); //Gets the data from the version.txt on the github repository
			String latestVersion = doc.select("table").first().text(); //Gets the version number stored in the verion.txt file
			if(version<Double.parseDouble(latestVersion)) { //Checks if the program version is less then the latest version on the repository
				return true;
			}else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns a boolean determining if an address exists on the database
	 * @param conn The MySQL connection
	 * @param address The address that is being checked if it exits on the database
	 * @return True if address is on the database false otherwise
	 */
	public boolean exisits(Connection conn, Address address) {
		List<Address> addresses = address.getAllAddresses(conn); //Creates a list of all addresses on the database
		for(Address exisitingAddresses: addresses) { //Loops through all addresses
			if(exisitingAddresses.equals(address)) { //Checks address on database is equal to passed address
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a boolean determining if an occupation exists on the database
	 * @param conn The MySQL connection
	 * @param occupation The occupation that is being checked if it exists on the database
	 * @return True if occupation is on the database false otherwise
	 */
	public boolean exisits(Connection conn, Occupation occupation) {
		List<Occupation> occupations = occupation.getAllOccupations(conn); //Creates a list of all occupation on the database
		for(Occupation exisitingOccupations: occupations) { //Loops through all occupations
			if(exisitingOccupations.equals(occupation)) { //Checks occupation on database is equal to passed occupation
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns a boolean determining if a person exists on the database
	 * @param conn The MySQL connection
	 * @param person The person that is being check if it exists on the database
	 * @return True if person is on the database false otherwise
	 */
	public boolean exisits(Connection conn, Person person) {
		List<Person> people = person.getAllPeople(conn); //Creates a list of all people on the database
		for(Person exisitingPerson: people) { //Loops through all people
			if(exisitingPerson.equals(person)) { //Checks person on database is equal to passed person
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the id of the most recent address on the database based on highest id
	 * @param conn The MySQL connection
	 * @return The id of the newest address or -1 if no addresses
	 */
	public int mostRecentAddress(Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM address"); //A statement that will find the newest item in a table based on ID
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { //Checks if data was returned from database
				return rs.getInt(1);
			}else { //No addresses on the database
				return -1;
			}
		}catch(SQLException e) { //Error getting most recent address
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Returns the id of the most recent occupation on the database based on highest id
	 * @param conn The MySQL connection
	 * @return The id of the newest occupation or -1 if no occupations
	 */
	public int mostRecentOccupation(Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM occupation"); //A statement that will find the newest item in a table based on ID
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { //Checks if data was returned from database
				return rs.getInt(1);
			}else { //No occupations on the database
				return -1;
			}
		}catch(SQLException e) { //Error getting most recent occupation
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * Returns the id of the most recent person on the database based on highest id
	 * @param conn The MySQL connection
	 * @return The id of the newest person or -1 if no people
	 */
	public int mostRecentPerson(Connection conn) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM person"); //A statement that will find the newest item in a table based on ID
			ResultSet rs = ps.executeQuery();
			if(rs.next()) { //Checks if data was returned from database
				return rs.getInt(1);
			}else { //No people on the database
				return -1;
			}
		}catch(SQLException e) { //Error getting most recent person
			e.printStackTrace();
			return -1;
		}
	}
}