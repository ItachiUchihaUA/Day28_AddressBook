package day28_AddressBook;

import com.opencsv.bean.CsvBindByName;

public class Contact {
	@CsvBindByName
	private String firstName;
	@CsvBindByName
	private String lastName;
	@CsvBindByName
	private String Address;
	@CsvBindByName
	private String city;
	@CsvBindByName
	private String state;
	@CsvBindByName
	private String email;
	@CsvBindByName
	private String Phone;
	@CsvBindByName
	private String zip;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 
	
	public boolean firstEquals(String c) {
		return this.getFirstName().equals(c);
	}
	
	public boolean cityEquals(String c) {
		return this.getCity().equals(c);
	}
	
	@Override
	public String toString() {
		return " Contact [firstName=" + firstName + ", lastName=" + lastName + ", Address=" + Address + ", city=" + city
				+ ", state=" + state + ", email=" + email + ", Phone=" + Phone + ", zip=" + zip + "] \n";
	}
}
