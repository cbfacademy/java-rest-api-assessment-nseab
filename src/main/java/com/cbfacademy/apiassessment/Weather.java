package com.cbfacademy.apiassessment;


public class Weather {
	
	private int cityId;
	private String city;
	private String country;
	private int temperature;
	private String condition;
		
	public Weather() {
		super();
	}
	
	public Weather(int cityId, String city, String country, int temperature, String condition) {
		super();
		this.cityId = cityId;
		this.city = city;
		this.country = country;
		this.temperature = temperature;
		this.condition = condition;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}

}
