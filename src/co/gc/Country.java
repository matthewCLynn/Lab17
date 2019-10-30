package co.gc;


public class Country
{
private String name;
private int population;
public String getName() {
	return name;
}
public int getPopulation() {
	return population;
}
public void setName(String name) {
	this.name = name;
}
public void setPopulation(int population) {
	this.population = population;
}
public Country(String name, int population) {
	super();
	this.name = name;
	this.population = population;
}
@Override
public String toString() {
	return name + " (pop " + population + ")";
}

	
	
}