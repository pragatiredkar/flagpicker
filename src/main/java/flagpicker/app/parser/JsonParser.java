package flagpicker.app.parser;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import flagpicker.app.models.Continent;

public class JsonParser {
	
	static final Logger LOGGER = LoggerFactory.getLogger(JsonParser.class);
	
	private Continent[] continents;
	
	public Continent[] getData(){
		
		ObjectMapper mapper = new ObjectMapper();		
		try {
			File file = new ClassPathResource("continents.json").getFile();			
			TypeReference<Continent[]> typeReference = new TypeReference<Continent[]>() {};
			continents = (mapper.readValue(file, typeReference));
			
		} catch (IOException e) {
			LOGGER.error("Error parsing JSON file", e);
		}
		return continents;
	}
}
