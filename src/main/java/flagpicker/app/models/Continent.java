package flagpicker.app.models;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Continent implements Serializable {
	
	private static final long serialVersionUID = -7371228330316990571L;

	private String continent;

	private Country[] countries;	
	
	
	public Continent() {
		super();

	}
	public Continent(String continent, Country[]countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Country[] getCountries() {
		return countries;
	}
	public void setCountries(Country[] countries) {
		this.countries = countries;
	}	
}
