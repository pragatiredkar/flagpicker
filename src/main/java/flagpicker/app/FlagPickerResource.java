package flagpicker.app;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flagpicker.app.models.Country;


@RestController
public class FlagPickerResource {	
	
	@Autowired 
	FlagPickerService flagPickerService;

	@RequestMapping("/continents/{continentName}")
	public List<Country> getAllCountriesForContinent(@PathVariable String continentName){
		return flagPickerService.getAllCountries(continentName);
	}
	
	@RequestMapping("/continents/{continentName}/countries/{countryName}")
	public Country getCountry(@PathVariable String continentName, @PathVariable String countryName) {
		return flagPickerService.getCountry(continentName, countryName);
	}
	
	@RequestMapping("/continents")
	public Set<String> getAllContinents() {
		return flagPickerService.getAllContinents();
	}
}

