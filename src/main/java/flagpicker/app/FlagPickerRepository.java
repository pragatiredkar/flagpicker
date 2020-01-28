package flagpicker.app;

import org.springframework.data.repository.CrudRepository;

import flagpicker.app.models.Country;

public interface FlagPickerRepository extends CrudRepository<Country, String>{

}
 