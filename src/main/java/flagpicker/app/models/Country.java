package flagpicker.app.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country implements Serializable{	

	private static final long serialVersionUID = -2091551775415464111L;

	private String name;

	private String flag;
	
	public Country() {
		super();
	}

	public Country(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}		
}
