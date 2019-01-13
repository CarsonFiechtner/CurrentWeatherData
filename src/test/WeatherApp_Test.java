package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import main.WeatherApp;

/**
 * @author Carson Fiechtner
 * JUnit Tests to confirm proper functionality of WeatherApp
 */
public class WeatherApp_Test {

	@Test
	public void test_getWeatherData_Pass1() {
		int result = WeatherApp.getWeatherData("Chicago");
		assertEquals(0, result);
	}
	
	@Test
	public void test_getWeatherData_Pass2() {
		int result = WeatherApp.getWeatherData("Butte,US");
		assertEquals(0, result);
	}
	
	@Test
	public void test_getWeatherData_Pass3() {
		int result = WeatherApp.getWeatherData("Des Moines,IA,US");
		assertEquals(0, result);
	}
	
	@Test
	public void test_getWeatherData_Fail() {
		int result = WeatherApp.getWeatherData("Chicago,IL");
		assertEquals(1, result);
	}

}
