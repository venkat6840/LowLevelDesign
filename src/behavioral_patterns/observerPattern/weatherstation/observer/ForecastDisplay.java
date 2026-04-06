package behavioral_patterns.observerPattern.weatherstation.observer;

import behavioral_patterns.observerPattern.weatherstation.observable.WeatherObservable;

public class ForecastDisplay implements WeatherObserver {

  private final WeatherObservable weatherObservable;

  public ForecastDisplay(WeatherObservable weatherObservable) {
    this.weatherObservable = weatherObservable;
    weatherObservable.addObserver(this);
  }

  // ForecastDisplay implements the update method in its own way
  @Override
  public void update() {
    System.out.println(
        "Updating weather data to do some analytics: " + weatherObservable.toString());
    display();
  }

  // Display the forecast based on the current pressure
  public void display() {
    System.out.println(
        "Forecast Details: Displaying information about Rain, "
            + "Temperature Trends, Significant Weather Events and other phenomenon...");
  }
}
