package weather;

import static java.lang.Math.*;


public class WeatherReading {
    private final int airTemp, dpTemp, windSpeed, rainRec, relativeHum;

    /*
    * Those parameters are used for calculate Heat Index
    * */
    private static final double
            c1 = -8.78469475556,
            c2 = 1.61139411,
            c3 = 2.33854883889,
            c4 = -0.14611605,
            c5 = -0.012308094,
            c6 = -0.0164248277778,
            c7 = 0.002211732,
            c8 = 0.00072546,
            c9 = -0.000003582;

    private final double heatIdx, windChill;

    public WeatherReading(int airTemp, int dpTemp, int windSpeed, int rainRec) {
        notValidInput(airTemp, dpTemp, windSpeed, rainRec);
        this.airTemp = airTemp;
        this.dpTemp = dpTemp;
        this.windSpeed = windSpeed;
        this.rainRec = rainRec;
        // Really a bad practice, too many magic numbers
        /* But it is for academia purpose*/
        this.relativeHum = (this.dpTemp - this.airTemp + 20) * 5;
        this.heatIdx = c1 + c2 * this.airTemp + c3 * this.relativeHum + c4 * this.airTemp * this.relativeHum +
                c5 * pow(this.airTemp, 2) + c6 * pow(this.relativeHum, 2) +
                c7 * pow(this.airTemp, 2) * this.relativeHum + c8 * this.airTemp * pow(this.relativeHum, 2) +
                c9 * pow(this.airTemp, 2) * pow(this.relativeHum, 2);
        double airTempF = ((double) this.airTemp * 9 / 5) + 32;
        this.windChill = 35.74 + .6215 * airTempF - 35.75 * pow(this.windSpeed, .16) + .4275 * airTempF * pow(this.windSpeed, .16);
    }

    private static void notValidInput(int aT, int dT, int wS, int rR) {
        if (aT < dT) throw new IllegalArgumentException("The dew point temperature cannot be greater than the air temperature");
        if (wS < 0) throw new IllegalArgumentException("The wind speed should be non-negative");
        if (rR < 0) throw new IllegalArgumentException("The rain received cannot be negative");
    }

    public int getTemperature() {
        return this.airTemp;
    }

    public int getDewPoint() {
        return this.dpTemp;
    }


    public int getWindSpeed() {
        return this.windSpeed;
    }


    public int getTotalRain() {
        return this.rainRec;
    }

    public int getRelativeHumidity() {
        return this.relativeHum;
    }

    public double getHeatIndex() {
        return this.heatIdx;
    }


    public double getWindChill() {
        return this.windChill;
    }

    @Override
    public String toString() {
        return "Reading: " +
                "T = " + airTemp +
                ", D = " + dpTemp +
                ", v = " + windSpeed +
                ", rain = " + rainRec;
    }

    public static void main(String[] args) {
        WeatherReading wr1 = new WeatherReading(10,9,12,90);
        System.out.println(wr1);

    }
}
