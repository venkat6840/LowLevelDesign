package behavioral_patterns.observerPattern.weatherstation;

import behavioral_patterns.observerPattern.weatherstation.observable.WeatherObservable;
import behavioral_patterns.observerPattern.weatherstation.observable.WeatherStation;
import behavioral_patterns.observerPattern.weatherstation.observer.CurrentConditionsDisplay;
import behavioral_patterns.observerPattern.weatherstation.observer.ForecastDisplay;

public class WeatherStationApp {
  public static void main(String args[]) {
    WeatherObservable weatherStation = new WeatherStation();
    // Create displays (observers)
    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
    ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStation);

    System.out.println("===>>> Initial Weather Update");
    weatherStation.setWeatherReadings(80, 65, 30.4f);

    System.out.println("===>>> Second Weather Update");
    weatherStation.setWeatherReadings(82, 70, 29.2f);

    // Remove forecast display
    weatherStation.removeObserver(forecastDisplay);

    System.out.println("===>>> Third Weather Update");
    weatherStation.setWeatherReadings(70, 21, 29.2f);
    // Forecast display will not be notified

  }
}
