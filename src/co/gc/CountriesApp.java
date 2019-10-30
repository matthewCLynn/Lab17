package co.gc;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String cont = "y";
		ArrayList<Country> countryList = new ArrayList<>();
		CountriesTextFile.createCountries();
		System.out.println("Welcome to the Countries Maintenence Application!");
		
		do {
			System.out.println();
			System.out.println( "1 - See the list of countries\n2 - Add a country\n3 - Eliminate a country\n4 - Exit");
			int choice = Validator.getInt(scan,"Please enter a number: ", 1, 4);
			switch (choice) {
			case 1:
				countryList = CountriesTextFile.readCountries();
				for (Country nPole : countryList)
					System.out.println(nPole);
				break;

			case 2:
				String countryName = Validator.getStringAvoidingRegex(scan, "Please enter the country's name: ", " \\(pop ");
				int countryPop = Validator.getInt(scan, "Please enter " + countryName + "'s population: ", 0,
						Integer.MAX_VALUE);
				CountriesTextFile.writeCountries(new Country(countryName, countryPop));
				break;

			case 3:
				countryList = CountriesTextFile.readCountries();
				int counter =1;
				int deleteChoice;
				for (Country nPole : countryList)
					System.out.println(counter++ + ". " + nPole);
				deleteChoice =(Validator.getInt(scan, "Enter the number of the country that will no longer exist: ", 1, countryList.size()))-1;
				countryList.remove(deleteChoice);
				CountriesTextFile.writeCountries(countryList);
				break;
				
				
			case 4:	
				System.out.println("Goodbye!");
				cont = "n";
				break;
			}
		} while (cont.equalsIgnoreCase("y"));
		scan.close();
	}

}
