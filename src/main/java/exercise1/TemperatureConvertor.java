package exercise1;

public class TemperatureConvertor {

    public static double fahrenheitToCelsius(double fahrenheitTemperature) {
        return ((fahrenheitTemperature - 32) * 5 / 9);
    }

    public static double celsiusToFahrenheit(double celsiusTemperature) {
        return ((celsiusTemperature * 9 / 5) + 32);
    }
}
