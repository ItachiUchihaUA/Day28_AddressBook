package day28_AddressBook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AddressBook {

	static List<Contact> addressBook = new ArrayList<>();
	static Map<Contact, String> cityBook = new HashMap<>();
	static Map<Contact, String> stateBook = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!");
		addContact();
		editContact();
		deleteContact();
		cityBook = addressBook.stream().collect(Collectors.toMap( n -> n , n -> n.getCity()));
		stateBook = addressBook.stream().collect(Collectors.toMap( n -> n , n -> n.getState()));
		writeInFile();
		searchInCityOrState();
		countForCity();
		countForState();
		sortByCityStateOrZip();
	}
	

	static public void addContact() {
		int flag = 0;
		while (flag == 0) {
			Contact c = new Contact();
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---New Contact---");
			System.out.println("Enter First Name: ");
			String firstName = sc.next();

			if (!addressBook.isEmpty()) {
				//Using Stream to Check any same Contact exists or not!
				if (addressBook.stream().anyMatch(n -> n.getFirstName().equals(firstName))) {
					System.err.println("\nContact Exists!");
					return;
				}
			}
			c.setFirstName(firstName);
			System.out.println("Enter Last Name: ");
			c.setLastName(sc.next());
			System.out.println("Enter Address: ");
			c.setAddress(sc.next());
			System.out.println("Enter City: ");
			c.setCity(sc.next());
			System.out.println("Enter State: ");
			c.setState(sc.next());
			System.out.println("Enter Zip code: ");
			c.setZip(sc.next());
			System.out.println("Enter Phone: ");
			c.setPhone(sc.next());
			System.out.println("Enter email: ");
			c.setEmail(sc.next());
			addressBook.add(c);
			addressBook = addressBook.stream().sorted(Comparator.comparing(Contact :: getFirstName)).collect(Collectors.toList());
			
			System.out.println("Want to Add more? \n Enter 0 for Yes or 1 for No :\n");
			flag = sc.nextInt();

		}
	}
	

	static public void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name to Edit : ");
		String name = sc.next();
		int flag2 = 0;
		for (int i = 0; i < addressBook.size(); i++) {
			if (addressBook.get(i).getFirstName() == name) {
				flag2 = 1;
				System.out.println("---Edit Contact---");
				System.out.println("Enter First Name: ");
				addressBook.get(i).setFirstName(sc.next());
				System.out.println("Enter Last Name: ");
				addressBook.get(i).setLastName(sc.next());
				System.out.println("Enter Address: ");
				addressBook.get(i).setAddress(sc.next());
				System.out.println("Enter City: ");
				addressBook.get(i).setCity(sc.next());
				System.out.println("Enter State: ");
				addressBook.get(i).setState(sc.next());
				System.out.println("Enter Zip code: ");
				addressBook.get(i).setZip(sc.next());
				System.out.println("Enter Phone: ");
				addressBook.get(i).setPhone(sc.next());

			}
		}
		if (flag2 == 0) {
			System.out.println("No Such Contact Found!");
		}
	}

	static public void deleteContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name to delete : ");
		String name = sc.next();
		int flag2 = 0;
		for (int i = 0; i < addressBook.size(); i++) {
			if (addressBook.get(i).getFirstName() == name) {
				flag2 = 1;
				addressBook.remove(i);
				System.out.println("Deleted!");
			}
		}
		if (flag2 == 0) {
			System.out.println("No Such Contact Found!");
		}
	}
	
	static public void searchInCityOrState() {
		if(addressBook.isEmpty()) {
			System.err.println("Empty Book!");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to search in City or 2 to search in State");
		int temp= sc.nextInt();
		if(temp==1) {
			System.out.println("Enter City Name: ");
			String city=sc.next();
			addressBook.stream().filter(n -> n.getCity().equals(city)).forEach(n -> System.out.println("  "+n.getFirstName()));
		}
		
		else if(temp==2) {
			System.out.println("Enter State Name: ");
			String state=sc.next();
			addressBook.stream().filter(n -> n.getState().equals(state)).forEach(n -> System.out.println("  "+n.getFirstName()));
		}
		else {
			System.out.println("\nEnter 1 or 2 only!");
			searchInCityOrState();
		}
	}
	
	public static void countForCity() {
		if(cityBook.isEmpty()) {
			System.out.println("Empty Book");
			return;
		}
		System.out.println("\nEnter City Nmae: ");
		Scanner sc = new Scanner(System.in);
		String city = sc.next();
		System.out.println("Count: "+cityBook.entrySet().stream().filter(n -> n.getValue().equals(city)).count());
		
	}
	public static void countForState() {
		if(stateBook.isEmpty()) {
			System.err.println("Empty Book");
			return;
		}
		System.out.println("\nEnter State Nmae: ");
		Scanner sc = new Scanner(System.in);
		String State = sc.next();
		System.out.println("Count: "+stateBook.entrySet().stream().filter(n -> n.getValue().equals(State)).count());
		
	}
	public static void sortByCityStateOrZip() {
		System.out.println("Enter 1 to sort by City \n\t 2 to sort by State \n\t 2 to sort by Zip");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		if(select ==1) {
			addressBook = addressBook.stream().sorted(Comparator.comparing(Contact :: getCity)).collect(Collectors.toList());
			addressBook.stream().forEach(n -> {n.getFirstName(); n.getLastName(); n.getCity(); n.getState(); n.getZip();});
		}
		else if(select ==2) {
			addressBook = addressBook.stream().sorted(Comparator.comparing(Contact :: getState)).collect(Collectors.toList());
			addressBook.stream().forEach(n -> {n.getFirstName(); n.getLastName(); n.getCity(); n.getState(); n.getZip();});
		}
		else if(select==3) {
			addressBook = addressBook.stream().sorted(Comparator.comparing(Contact :: getZip)).collect(Collectors.toList());
			addressBook.stream().forEach(n -> {n.getFirstName(); n.getLastName(); n.getCity(); n.getState(); n.getZip();});
		}
		else {
			System.out.println("Wrong Entry!");
		}
	}
	
	public static void writeInFile() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\TheUA\\eclipse-workspace\\com.bridge.week3\\src\\day27_IOhandling\\addressBook.txt"));){
			for(int i =0; i< addressBook.size() ; i++) {
				bw.write(addressBook.get(i).toString());
			}
			bw.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

