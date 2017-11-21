package ucl.cs;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class Example {

  public static void main(String[] args) {

    // This is just an example of using the 3rd party API - delete this class before submission.

    ForecastInterface forecastInterface = new ForecastInterfaceProxy(new Forecaster());

    Forecast londonForecast = forecastInterface.getForecast(Region.LONDON, Day.MONDAY);

    System.out.println("London outlook: " + londonForecast.summary());
    System.out.println("London temperature: " + londonForecast.temperature());

    Forecast edinburghForecast = forecastInterface.getForecast(Region.EDINBURGH, Day.MONDAY);

    System.out.println("Edinburgh outlook: " + edinburghForecast.summary());
    System.out.println("Edinburgh temperature: " + edinburghForecast.temperature());

    Forecast londonForecast2 = forecastInterface.getForecast(Region.LONDON, Day.MONDAY);

    System.out.println("London outlook: " + londonForecast2.summary());
    System.out.println("London temperature: " + londonForecast2.temperature());

    Forecast edinburghForecast2 = forecastInterface.getForecast(Region.EDINBURGH, Day.MONDAY);

    System.out.println("Edinburgh outlook: " + edinburghForecast2.summary());
    System.out.println("Edinburgh temperature: " + edinburghForecast2.temperature());
  }
}
