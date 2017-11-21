package ucl.cs;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Region;

/**
 * Created by Suyash on 21-Nov-17.
 */
public interface ForecastInterface {
    Forecast getForecast(Region region, Day day);
}
