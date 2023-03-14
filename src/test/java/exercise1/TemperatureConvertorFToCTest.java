package exercise1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureConvertorFToCTest {

    @Test
    public void instantiateClass() {
        Class<TemperatureConvertor> temperatureConvertorClass = TemperatureConvertor.class;
    }

    @Test
    public void callFahrenheitToCelsiusWithParam() {
        double fahrenheitTemperature = 0;
        TemperatureConvertor.fahrenheitToCelsius(fahrenheitTemperature);
    }

    @Test
    public void returnDoubleFromFahrenheitToCelsius() {
        double fahrenheitTemperature = 0;
        double celsiusTemperature = TemperatureConvertor.fahrenheitToCelsius(fahrenheitTemperature);
    }

    @Test
    public void returnCelsiusTemperatureFromFahrenheit() {
        //GIVEN
        double fahrenheitTemperature = 50;
        //WHEN
        double celsiusTemperature = TemperatureConvertor.fahrenheitToCelsius(fahrenheitTemperature);
        //THEN
        Assertions.assertThat(celsiusTemperature).isEqualTo(10);
    }
}
