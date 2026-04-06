package behavioral_patterns.observerPattern.weatherstation.observer;

import behavioral_patterns.observerPattern.weatherstation.observable.WeatherObservable;

public class CurrentConditionsDisplay implements WeatherObserver {
  private final WeatherObservable weatherObservable;

  public CurrentConditionsDisplay(WeatherObservable weatherObservable) {
    this.weatherObservable = weatherObservable;
    weatherObservable.addObserver(this);
  }

  @Override
  public void update() {
    System.out.println("Saving weather data... ");
    display();
  }

  // Display the current weather conditions
  public void display() {
    System.out.println("Current Weather Conditions: " + weatherObservable.toString());
  }
}
