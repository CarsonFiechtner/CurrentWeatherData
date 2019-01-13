/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.WeatherApp;

/**
 * @author Carson Fiechtner
 * JUnit Tests to confirm proper functionality of WeatherApp
 */
class WeatherApp_Test {

	@Test
	void chk_getWeatherData_Pass1() {
		int result = WeatherApp.getWeatherData("Chicago");
		assertEquals(0, result);
	}
	
	@Test
	void chk_getWeatherData_Pass2() {
		int result = WeatherApp.getWeatherData("Butte,US");
		assertEquals(0, result);
	}
	
	@Test
	void chk_getWeatherData_Pass3() {
		int result = WeatherApp.getWeatherData("Des Moines,IA,US");
		assertEquals(0, result);
	}
	
	@Test
	void chk_getWeatherData_Fail() {
		int result = WeatherApp.getWeatherData("Chicago,IL");
		assertEquals(1, result);
	}

}
