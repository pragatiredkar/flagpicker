package flagpicker.app;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import flagpicker.app.cache.CacheProvider;
import flagpicker.app.models.Country;

@Service
public class FlagPickerService {

	public List<Country> getAllCountries(String continentName) {		
		return CacheProvider.getInstance().getCountriesForContinent(continentName);				
	}

	public Country getCountry(String continentName, String countryName) {
		Country country = CacheProvider.getInstance().getCountryForContinent(continentName, countryName);
		return country;
	}

	public Set<String> getAllContinents() {
		Set<String> continents = CacheProvider.getInstance().getAllContinents();
		return continents;
	}
}
