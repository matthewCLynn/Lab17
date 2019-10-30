package co.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile
{
	
	
	public static void createCountries()
	{
		String fileName = "country_list.txt";
		Path path = Paths.get(fileName);
		if(Files.notExists(path))
		{
			try {
				Files.createFile(path);
				
			} catch (IOException e) {
				
				System.out.println("You messed it up. Not me.");
			}
		}
	}
	public static void writeCountries(ArrayList<Country> countries)
	{
		String fileName ="country_list.txt";
		Path path = Paths.get(fileName);
		File countryFile = path.toFile();		
			try {
				PrintWriter countryOutput = new PrintWriter(new FileOutputStream(countryFile));
				for(Country murica: countries)
				{
					countryOutput.println(murica);
				}
				
				countryOutput.close();
			} catch (FileNotFoundException e) {
		
				System.out.println("We broke it. Yay!");
			}
	}
	
	public static void writeCountries(Country country)
	{
		String fileName ="country_list.txt";
		Path path = Paths.get(fileName);
		File countryFile = path.toFile();		
			try {
				PrintWriter countryOutput = new PrintWriter(new FileOutputStream(countryFile, true));
				countryOutput.println(country);
				
				countryOutput.close();
			} catch (FileNotFoundException e) {
		
				System.out.println("We broke it. Yay!");
			}
	}
	
	public static ArrayList<Country> readCountries()
	{
		String fileName = "country_list.txt";
		Path path = Paths.get(fileName);
		
		File file = path.toFile();
		String [] countryAndPop = new String[2];
		ArrayList<Country> countryList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String line = br.readLine();
			while (line != null) {
				countryAndPop = line.split(" \\(pop ");
				countryAndPop[1]=countryAndPop[1].substring(0, countryAndPop[1].lastIndexOf(")"));
				countryList.add(new Country(countryAndPop[0],Integer.parseInt(countryAndPop[1])));
				line = br.readLine();
			}
			br.close();
			return countryList;
		} catch (FileNotFoundException e) {
			
//			e.printStackTrace();
			System.out.println("Something went so wrong, but so... well no just wrong.");
		} catch (IOException e) {
			
			//e.printStackTrace();
			System.out.println("Oh now you've done it!");
			
		}
		return null;
			
		
	}
	
	
	
	
	
	
}
