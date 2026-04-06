package behavioral_patterns.observerPattern.weatherstation.observable;

import behavioral_patterns.observerPattern.weatherstation.observer.WeatherObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservable {
  private List<WeatherObserver> observerList = new ArrayList<>();
  // Observable Data
  private float temperature;
  private float humidity;
  private float pressure;

  @Override
  public void addObserver(WeatherObserver observer) {
    observerList.add(observer);
    System.out.println("[+] Observer registered: " + observer.getClass().getSimpleName());
  }

  @Override
  public void removeObserver(WeatherObserver observer) {
    observerList.remove(observer);
    System.out.println("[-] Observer removed: " + observer.getClass().getSimpleName());
  }

  @Override
  public void notifyObservers() {
    for (WeatherObserver observer : observerList) {
      // Notify each observer about the change in weather data(state)
      observer
          .update(); // Observer will update its state based on the new data and respond accordingly
    }
  }

  @Override
  public void setWeatherReadings(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    notifyObservers();
  }

  public float getTemperature() {
    return temperature;
  }

  public void setTemperature(float temperature) {
    this.temperature = temperature;
  }

  public float getHumidity() {
    return humidity;
  }

  public void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  public float getPressure() {
    return pressure;
  }

  public void setPressure(float pressure) {
    this.pressure = pressure;
  }

  @Override
  public String toString() {
    return "WeatherStation{"
        + "temperature="
        + temperature
        + ", humidity="
        + humidity
        + ", pressure="
        + pressure
        + '}';
  }
}
