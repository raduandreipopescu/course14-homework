package exercise1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureConvertorCToFTest {

    @Test
    public void instantiateClass() {
        Class<TemperatureConvertor> temperatureConvertorClass = TemperatureConvertor.class;
    }

    @Test
    public void callCelsiusToFahrenheitWithParam() {
        double celsiusTemperature = 0;
        TemperatureConvertor.celsiusToFahrenheit(celsiusTemperature);
    }

    @Test
    public void returnDoubleFromCelsiusToFahrenheit() {
        double celsiusTemperature = 0;
        double fahrenheitTemperature = TemperatureConvertor.celsiusToFahrenheit(celsiusTemperature);
    }

    @Test
    public void returnFahrenheitTemperatureFromCelsius() {
        //GIVEN
        double celsiusTemperature = 100;
        //WHEN
        double fahrenheitTemperature = TemperatureConvertor.celsiusToFahrenheit(celsiusTemperature);
        //THEN
        Assertions.assertThat(fahrenheitTemperature).isEqualTo(212);
    }
}
