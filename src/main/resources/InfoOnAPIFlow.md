#Weather API

Welcome to my Weather API, providing weather information for various cities. Explore the weather conditions in your favourite locations, add new cities to the list, and remove those you no longer need.

## Endpoints:

localhost:8080/weather{insert endpoint here}

1.	Get Weather List of all cities
	Endpoint: '/get/all'
	Description: Retrieve a list of all cities along with 	their current weather conditions.
	

1.	Get Weather by City ID:
	Endpoint: '/get/city'
	Parameters: cityId (integer)
	Description: Obtain the weather details for a specific 	city using its unique City ID.
	
1.	Add New City and Weather details:
	Endpoint: '/add'
	Description: Add a new city to the list along with its corresponding weather information.

1.	Remove City from List by City ID:
	Endpoint: '/remove'
	Parameters: cityId (integer)
	Description: Remove a specified city, identified by its City ID, from the list.
	
	##Cities in the Current List:
	| City | City ID |
	|---|---| 
| London, | 1 |
| Paris, | City ID: 2
| Hamburg, | City ID: 3
| Moscow, | City ID: 4
| Vienna, | City ID: 5
| Barcelona, | City ID: 6
| Istanbul, | City ID: 7
| Abu Dhabi, | City ID: 8
| Lagos, | City ID: 9
| Accra, | City ID: 10