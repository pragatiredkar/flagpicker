package flagpicker.app.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import flagpicker.app.models.Continent;
import flagpicker.app.models.Country;
import flagpicker.app.parser.JsonParser;

public class CacheProvider implements Serializable{

	private static final long serialVersionUID = -3253279031329575441L;
	private static CacheProvider cacheProvider = null;
	
	private Map<String, Map<String, Country>> cache;
	
	private CacheProvider() {
		super();
	}
	
	public static CacheProvider getInstance() {
		if(cacheProvider == null) {
			cacheProvider = new CacheProvider();
		}
		return cacheProvider;
	}
	
	public void setData(Continent[] continents) {
		
		cache = new HashMap<String, Map<String, Country>>();
		Map<String, Country> countryLookup = null;
		
		for(Continent continent: continents) {
			Country[] countries = continent.getCountries();		
			
			if(null != countries && countries.length > 0) {
				countryLookup = new HashMap<String, Country>();
				cache.put(continent.getContinent(), countryLookup);
			}
			for(Country country: countries) {
				countryLookup.put(country.getName(), country);				
			}
		}		
	}

	private void initalizeCache() {
		if(cache != null) {
			return;
		}
		JsonParser dataParser = new JsonParser();
		Continent[] continents = dataParser.getData();
		setData(continents);
	}	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone not supported.");
	}
	
	protected Object readResolve() {
		return getInstance();
	}

	public List<Country> getCountriesForContinent(String continentName) {
		initalizeCache();
		Map<String, Country> countries = cache.get(continentName);
		List<Country> ret = new ArrayList<Country>();
		ret.addAll(countries.values());
		return ret;
	}
	
	public Country getCountryForContinent(String continentName, String countryName) {
		initalizeCache();
		Map<String, Country> countries = cache.get(continentName);
		Country country = countries.get(countryName);
		return country;
	}	
	
	public Set<String> getAllContinents() {
		initalizeCache();
		Set<String> continents = cache.keySet();
		return continents;
	}
}
