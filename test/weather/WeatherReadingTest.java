package weather;

import static org.junit.Assert.*;

public class WeatherReadingTest {

    WeatherReading testInit;

    @org.junit.Before
    public void testConstruct() {
        testInit = new WeatherReading(13,10,7,69);
    }

    @org.junit.Test
    public void getTemperature() {
        assertEquals(13, testInit.getTemperature());
    }

    @org.junit.Test
    public void getDewPoint() {
        assertEquals(10, testInit.getDewPoint());
    }

    @org.junit.Test
    public void getWindSpeed() {
        assertEquals(7, testInit.getWindSpeed());
    }

    @org.junit.Test
    public void getTotalRain() {
        assertEquals(69, testInit.getTotalRain());
    }

    @org.junit.Test
    public void getRelativeHumidity() {
        assertEquals(85, testInit.getRelativeHumidity());
    }

    @org.junit.Test
    public void getHeatIndex() {
        assertEquals(24.269045279484967, testInit.getHeatIndex(), 0.000001);
    }

    @org.junit.Test
    public void getWindChill() {
        assertEquals(2.598857063812889, testInit.getWindChill(), 0.000001);
    }

    @org.junit.Test
    public void testToString() {
        assertEquals("WeatherReading{airTemp=13, dpTemp=10, windSpeed=7, rainRec=69}", testInit.toString());
    }
}