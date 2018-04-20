package elberger.earthquake.net;

import retrofit2.Call;
import retrofit2.http.GET;
import elberger.earthquake.EarthquakeFeed;

public interface UsgsEarthquakeService
{
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson")
	Call<EarthquakeFeed> getAllMonth();

}
