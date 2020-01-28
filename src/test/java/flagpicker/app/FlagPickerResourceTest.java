package flagpicker.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import flagpicker.app.models.Country;

@SpringBootTest
public class FlagPickerResourceTest {
	
	@Mock
	FlagPickerService flagPickerService;
	
	@Autowired
	FlagPickerResource flagPickerResource;

	private List<Country> getCountries() {
		List<Country> countries = new ArrayList<Country>();
		Country c1 = new Country("Mexico", "MexicoFlag");
		countries.add(c1);
		Country c2 = new Country("Brazil", "BrazilFlag");
		countries.add(c2);
		Country c3 = new Country("Argentina", "ArgentinaFlag");
		countries.add(c3);
		Country c4 = new Country("USA", "USAFlag");
		countries.add(c4);
		Country c5 = new Country("Colombia", "ColombiaFlag");
		countries.add(c5);
		return countries;
	}

	@Test
	public void getAllCountriesForContinentTest(){
		String continentName = "America";
		List<Country> expectedCountries = getCountries();
		Mockito.when(flagPickerService.getAllCountries(continentName)).thenReturn(getCountries());
		List<Country> actualCountries = flagPickerResource.getAllCountriesForContinent(continentName);
		assertThat(actualCountries.size() == expectedCountries.size());
	}

	@Test
	public void getCountryTest(){
		String continentName = "America";
		String countryName = "Mexico";
		String countryFlag = "MexicoFlag";
		Country expectedCountry = new Country(countryName, countryFlag);
		Mockito.when(flagPickerService.getCountry(continentName, countryName)).thenReturn(expectedCountry);
		
		Country actualCountry = flagPickerResource.getCountry(continentName, countryName);
		assertThat(expectedCountry.getName().equals(actualCountry.getName()));
	}

}
