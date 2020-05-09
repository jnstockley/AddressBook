package jackstockley.addressbook;

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

/**
 * This class holds all the necessary commands to create an address object, 
 * and to perform full CRUD on the address table of a given database.
 * @author jnstockley
 * @version 2.5
 */
public class Address {

	private int id;
	private int number;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String date;
	private String time;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	 * Prints out the address object with formatting for better human readability
	 */
	public String toString() {
		return "ID: " + this.getId() + "\n" + this.getNumber() + " " + this.getStreet() + "\n" + this.getCity() + ", " + this.getState() + " " + this.getZip() +"\n"
				+ "Date Created: " + this.getDate() + " Time Created: " + this.getTime();
	}

	/**
	 * Checks all the fields of both addresses if they are equal ignoring case
	 * @param address The address that is being checked
	 * @return Either true if all the fields are equal or false if at least one field is different
	 */
	public boolean equals(Address address) {
		if(this.getNumber() == address.getNumber() && this.getStreet().equalsIgnoreCase(address.getStreet()) && this.getCity().equalsIgnoreCase(address.getCity()) && this.getState().equalsIgnoreCase(address.getState()) && this.getZip().equals(address.getZip())) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Creates an address object with all the field set to either 0 or an empty string
	 */
	public Address() {
		this.setId(0);
		this.setNumber(0);
		this.setStreet("");
		this.setCity("");
		this.setState("");
		this.setZip("");
		this.setDate("");
		this.setTime("");
	}

	/**
	 * Creates an address object with the id and date and time as empty values
	 * @param number The house number of the address
	 * @param street The street name of the address
	 * @param city The city the address resides in
	 * @param state The state the address resides in
	 * @param zip The zip code of the address
	 */
	public Address(int number, String street, String city, String state, String zip) {
		this.setId(0);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setDate("");
		this.setTime("");
	}

	/**
	 * Creates an address object with the date and time as empty fields mainly used for updating an address
	 * @param id The id of the address
	 * @param number The house number of the address
	 * @param street The street name of the address
	 * @param city The city the address resides in
	 * @param state The state the address resides in
	 * @param zip The zip code of the address
	 */
	public Address(int id, int number, String street, String city, String state, String zip) {
		this.setId(id);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setDate("");
		this.setTime("");
	}

	/**
	 * Creates an address object with no empty fields mainly used for getting all addresses
	 * @param id The id of the address
	 * @param number The house number of the address
	 * @param street The street name of the address
	 * @param city The city the address resides in
	 * @param state The state the address resides in
	 * @param zip The zip code of the address
	 * @param date The date the address was created
	 * @param time The time the address was created
	 */
	public Address(int id, int number, String street, String city, String state, String zip, String date, String time) {
		this.setId(id);
		this.setNumber(number);
		this.setStreet(street);
		this.setCity(city);
		this.setState(state);
		this.setZip(zip);
		this.setDate(date);
		this.setTime(time);
	}

	/**
	 * Creates a list of addresses stored on a database and returns the address list
	 * @param conn The MySQL connection
	 * @return Either returns a list of addresses or null if there was an error getting all addresses
	 */
	public List<Address> getAllAddresses(Connection conn){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Address> addresses = new ArrayList<Address>(); //Creates an empty list of addresses to store all addresses on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, number, street, city, state, zip, date, time FROM address"); //SQL statement to get all the addresses from the database
				ResultSet rs = ps.executeQuery(); //Retrieves all the addresses from the database
				while(rs.next()) { //Loops through all the addresses, creates an empty address and set all the values for each address to their corresponding value stored on the database
					int col = 1;
					Address address = new Address();
					address.setId(rs.getInt(col++));
					address.setNumber(rs.getInt(col++));
					address.setStreet(rs.getString(col++));
					address.setCity(rs.getString(col++));
					address.setState(rs.getString(col++));
					address.setZip(rs.getString(col++));
					address.setDate(rs.getString(col++));
					address.setTime(rs.getString(col++));
					addresses.add(address); //Adds the address to the addresses list
				}
				if(!addresses.isEmpty()) { //Checks if the addresses list is empty
					return addresses; //Returns the all addresses list
				}else { //No addresses in database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting all addresses
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar addresses stored on a database and returns the similar addresses list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if an address is similar
	 * @param data The value for the passed field to determine if an address is similar
	 * @return Either returns a list of similar addresses or null if there was an error getting similar addresses
	 */
	public List<Address> getSimilarAddress(Connection conn, String field, String data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Address> similarAddresses = new ArrayList<Address>(); //Create an empty list of addresses to store similar addresses on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, number, street, city, state, zip, date, time FROM address WHERE " + field + "=?"); //SQL statement to get all the similar addresses from the database
				ps.setString(1, data); //Sets the first ?  to the string data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar addresses from the database
				while(rs.next()) { //Loops through all the similar addresses, creates an empty address, and sets all the values for each address to their corresponding value stored on the database
					int col = 1;
					Address address = new Address();
					address.setId(rs.getInt(col++));
					address.setNumber(rs.getInt(col++));
					address.setStreet(rs.getString(col++));
					address.setCity(rs.getString(col++));
					address.setState(rs.getString(col++));
					address.setZip(rs.getString(col++));
					address.setDate(rs.getString(col++));
					address.setTime(rs.getString(col++));
					similarAddresses.add(address); //Adds the address to the similar addresses list
				}
				if(!similarAddresses.isEmpty()) { //Checks if the similar addresses list is empty
					return similarAddresses; //Returns the similar addresses list
				}else { //No similar addresses based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting similar addresses
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Creates a list of similar addresses stored on a database and returns the similar address list
	 * @param conn The MySQL connection
	 * @param field The field used to determine if an address is similar
	 * @param data The values for the passed field to determine if an address is similar
	 * @return Either returns a list of similar addresses or null if there was an error getting similar addresses
	 */
	public List<Address> getSimilarAddress(Connection conn, String field, int data){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				List<Address> similarAddresses = new ArrayList<Address>(); //Creates an empty list of addresses to store similar addresses on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, number, street, city, state, zip, date, time FROM address WHERE " + field + "=?"); //SQL statement to get all the similar addresses from the database
				ps.setInt(1, data); //Sets the first ? to the integer data passed into the function
				ResultSet rs = ps.executeQuery(); //Retrieves all the similar addresses from the database
				while(rs.next()) { //Loops through all the similar addresses, creates an empty address and set all the values for each address to their corresponding value stored on the database
					int col = 1;
					Address address = new Address();
					address.setId(rs.getInt(col++));
					address.setNumber(rs.getInt(col++));
					address.setStreet(rs.getString(col++));
					address.setCity(rs.getString(col++));
					address.setState(rs.getString(col++));
					address.setZip(rs.getString(col++));
					address.setDate(rs.getString(col++));
					address.setTime(rs.getString(col++));
					similarAddresses.add(address); //Adds the address to the similar addresses list
				}
				if(!similarAddresses.isEmpty()) { //Checks if the similar addresses list is empty
					return similarAddresses; //Returns the similar addresses list
				}else { //No similar address based on passed field and data
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting similar addresses
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves a singular address based on the passed ID and returns it
	 * @param conn The MySQL connection
	 * @param id The ID of the address to be returned
	 * @return Either the requested address from the database or null if there was an error getting the address
	 */
	public Address getSingularAddress(Connection conn, int id){
		try {
			if(conn.isValid(30)) { //Checks if the SQL connection is valid
				Address address = new Address(); //Creates an empty address to store the address on the database
				PreparedStatement ps = conn.prepareStatement("SELECT id, number, street, city, state, zip, date, time FROM address WHERE id = ?"); //SQL statement to get a singular address based on the passed ID
				ps.setInt(1, id); //Sets the first ? to the integer id of the address to be returned
				ResultSet rs = ps.executeQuery(); //Retrieves the address from the database
				if(rs.next()) { //Checks if the address was returned from the database. If true it will set all the values for the address to their corresponding values from the database. If false will return null
					int col = 1;
					address.setId(rs.getInt(col++));
					address.setNumber(rs.getInt(col++));
					address.setStreet(rs.getString(col++));
					address.setCity(rs.getString(col++));
					address.setState(rs.getString(col++));
					address.setZip(rs.getString(col++));
					address.setDate(rs.getString(col++));
					address.setTime(rs.getString(col++));
					return address;
				}else { //No address with passed id
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error getting singular address
			return null;
		}
	}

	/**
	 * Updates a singular address on the database and returns the new address
	 * To keep existing data from current address set number to 0 or other fields to empty strings, excluding id, date, and time
	 * @param conn The MySQL connection
	 * @param id The id of the address to be updated
	 * @param updatedAddress The new address that is going to be updated
	 * @return Either returns the address passed, confirming the update or null if the address was not updated
	 */
	public Address updateAddress(Connection conn, int id, Address updatedAddress) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				BackendHelper helper = new BackendHelper(); //Creates a backend helper to help check for existing addresses in the database
				updatedAddress.setId(id); //Sets the id to the address
				updatedAddress.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the address
				updatedAddress.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the address
				Address oldAddress = getSingularAddress(conn, id); //Creates an address object and sets it to the current address stored on the database at the given id
				//Checks if any field in the updated address is empty and replaces it with the data from the current address on the database
				if(updatedAddress.getNumber() == 0) {
					updatedAddress.setNumber(oldAddress.getNumber());
				}
				if(updatedAddress.getStreet().equalsIgnoreCase("")) {
					updatedAddress.setStreet(oldAddress.getStreet());
				}
				if(updatedAddress.getCity().equalsIgnoreCase("")) {
					updatedAddress.setCity(oldAddress.getCity());
				}
				if(updatedAddress.getState().equalsIgnoreCase("")) {
					updatedAddress.setState(oldAddress.getState());
				}
				if(updatedAddress.getZip().equalsIgnoreCase("")) {
					updatedAddress.setZip(oldAddress.getZip());
				}
				if(!helper.exisits(conn, updatedAddress)) { //Makes sure the updated address doesn't exist on the database
					PreparedStatement ps = conn.prepareStatement("UPDATE address SET number=?, street=?, city=?, state=?, zip=?, date=?, time=? WHERE id =?"); //SQL statement that updates existing data with the new data at the given id
					//Sets all the ? to the given data from the updated address object
					ps.setInt(1, updatedAddress.getNumber());
					ps.setString(2, updatedAddress.getStreet());
					ps.setString(3, updatedAddress.getCity());
					ps.setString(4, updatedAddress.getState());
					ps.setString(5, updatedAddress.getZip());
					ps.setString(6, updatedAddress.getDate());
					ps.setString(7, updatedAddress.getTime());
					ps.setInt(8, id);
					ps.executeUpdate(); //Sends the update request to the database
					if(getSingularAddress(conn, id).equals(updatedAddress)) { //Makes sure the requested address was successfully updated
						return updatedAddress;
					}else { //Address not updated
						return null;
					}
				}else { //Address already exists on the database
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error updating address
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Inserts a new address into the database
	 * @param conn The MySQL connection
	 * @param newAddress The new address that is going to be inserted into the database
	 * @return Either returns the passed address, confirming the insert or null if the address wasn't inserted
	 */
	public Address insertAddress(Connection conn, Address newAddress) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid!
				if(newAddress.getNumber() != 0 && !newAddress.getStreet().equals("") && !newAddress.getCity().equals("") && !newAddress.getState().equals("") && !newAddress.getZip().equals("")) { //Makes sure all the values of the new address aren't empty or 0
					newAddress.setDate(Date.valueOf(LocalDate.now()).toString()); //Sets the current date to the new address
					newAddress.setTime(Time.valueOf(LocalTime.now()).toString()); //Sets the current time to the new address
					BackendHelper helper = new BackendHelper(); //Creates a backend helper to check for existing address in the database and to get the new id of the address
					if(!helper.exisits(conn, newAddress)) { //Makes sure the new address doesn't exist on the database
						PreparedStatement ps = conn.prepareStatement("INSERT INTO address (number, street, city, state, zip, date, time) values (?,?,?,?,?,?,?)"); //SQL statement to insert a new address in the database
						//Sets all the ? to the given data from the new address object
						ps.setInt(1, newAddress.getNumber());
						ps.setString(2, newAddress.getStreet());
						ps.setString(3, newAddress.getCity());
						ps.setString(4, newAddress.getState());
						ps.setString(5, newAddress.getZip());
						ps.setString(6, newAddress.getDate());
						ps.setString(7, newAddress.getTime());
						ps.execute(); //Sends the insert request to the database
						int id = helper.mostRecentAddress(conn); //Gets the most recent id from the address table
						if(id!=-1) { //Checks to make sure the id is valid
							newAddress.setId(id); //Sets the id of the new address
							if(getSingularAddress(conn, id).equals(newAddress)) { //Makes sure the requested address was successfully inserted
								return newAddress;
							}else { //New address not inserted
								return null;
							}
						}else { //Error getting new address from database
							return null;
						}
					}else { //Address already exists on the database
						return null;
					}
				}else { //One or more of the address fields is blank or 0
					return null;
				}
			}else { //MySQL connection is not valid
				return null;
			}
		}catch(SQLException e) { //Error inserting new address
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Removes the address at the passed id from the database
	 * @param conn The MySQL connection
	 * @param id The ID of the address to be removed
	 * @return Either true if the address was removed or false if it wasn't
	 */
	public boolean removeAddress(Connection conn, int id) {
		try {
			if(conn.isValid(30)) { //Checks if the MySQL connection is valid
				Address address = getSingularAddress(conn, id); //Gets current address from database
				if(address!=null) { //Confirms the returned address isn't null
					PreparedStatement ps = conn.prepareStatement("DELETE FROM address WHERE id = ?"); //SQL statement to remove an address with the given id
					ps.setInt(1, id); //Sets the first ? to the id of the address to remove
					ps.executeUpdate(); //Sends the delete request to the database
					if(getSingularAddress(conn, id) == null) { //Checks that the address was removed from the database
						return true;
					}else { //Address not removed
						return false;
					}
				}else { //Address not in database
					return false;
				}
			}else { //MySQL connection is not valid
				return false;
			}
		}catch(SQLException e) { //Error removing address
			e.printStackTrace();
			return false;
		}
	}
}