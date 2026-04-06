package behavioral_patterns.observerPattern.weatherstation.observable;

import behavioral_patterns.observerPattern.weatherstation.observer.WeatherObserver;

public interface WeatherObservable {
  void addObserver(WeatherObserver observer);

  void removeObserver(WeatherObserver observer);

  void notifyObservers();

  void setWeatherReadings(float temperature, float humidity, float pressure);
}
