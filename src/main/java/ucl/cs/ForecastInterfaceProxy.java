package ucl.cs;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by Suyash on 21-Nov-17.
 */
public class ForecastInterfaceProxy implements ForecastInterface {

    Forecaster forecaster;
    HashMap<String,Forecast> wCache = new HashMap<>();
    HashMap<String,Date> tCache = new HashMap<>();


    ForecastInterfaceProxy(Forecaster forecaster) {
        this.forecaster = forecaster;
    }

    @Override
    public Forecast getForecast(Region region, Day day) {
        String query = region.toString() + " " + day.toString();
        Date now = new Date();
        if(tCache.containsKey(query)){
            if(now.getTime() - tCache.get(query).getTime() < 3600000 ){
                return wCache.get(query);
            }
            else{
                Forecast result = forecaster.forecastFor(region,day);
                tCache.replace(query,now);
                wCache.replace(query,result);
                return result;
            }
        }
        else{
            Forecast result = forecaster.forecastFor(region,day);
            tCache.put(query,now);
            wCache.put(query,result);
            return result;
        }
    }
}
