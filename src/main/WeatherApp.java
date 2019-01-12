package main;
import java.net.URL;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 * @author Carson Fiechtner
 * WeatherApp provides real time weather data on any city in OpenWeatherMap's database
 */
public class WeatherApp {
	//API Key for accessing OpenWeatherMap data
	private static String KEY = "f985044c4d7e3796db5248cfe2a8acd8";
	
	/**
	 * Retrieves the current temperature for the city that the user requested
	 * @param location The city for which to find weather data
	 * @return 0 on a successful exit, 1 otherwise
	 */
	public static int getWeatherData(String location) {
		
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + KEY + "&units=imperial";
		
		JSONObject json;
		try {
			json = new JSONObject(IOUtils.toString(new URL(urlString), "UTF-8"));
		} catch (Exception e) {
			System.out.println("City could not be found.");
			return 1;
		}
		
		System.out.println("Current temperature in " + location + ": " + ((JSONObject) json.get("main")).get("temp") + "°F");
		return 0;
	}
	
	public static void main(String [] args) {
		boolean running = true;
		
		System.out.println("Welcome to the Weather App!\n"+
			    "When entering a city, please use one of the following formats:\n"+ 
				"   1. <City>\n" + 
				"   2. <City>,<Country>\n" + 
				"   3. <City>,<State>,<Country>");
		
		while(running) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the name of a city or type \"Exit\" to quit:");
			String location = input.nextLine();
			
			if(location.toLowerCase().equals("exit")) {
				System.out.println("Goodbye!");
				input.close();
				break;
			}
			int result = getWeatherData(location);
			if(result > 0) {
				continue;
			}
			
			System.out.println("Would you like to check another city? (Y/N)");
		    String response = input.nextLine();
			if(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes")) {
				running = false;
				System.out.println("Goodbye!");
				input.close();
			}
		}
	}
}
