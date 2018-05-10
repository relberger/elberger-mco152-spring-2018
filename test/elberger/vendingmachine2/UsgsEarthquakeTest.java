package elberger.vendingmachine2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import elberger.earthquake.EarthquakeProperties;
import elberger.earthquake.net.UsgsEarthquakeService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class UsgsEarthquakeTest
{
//integration test
	@Test
	void test() throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);

		Call<EarthquakeFeedModel> call = service.getAllMonth();

		// when
		Response<EarthquakeFeedModel> response = call.execute();

		// then
		assertNotNull(response.body());
		List<Earthquake> features = response.body().getFeatures();
		assertTrue(features.size() > 0);
		EarthquakeProperties properties = features.get(0).getProperties();
		assertTrue(properties.getMag() > 0);
		assertNotNull(properties.getPlace());
	}

}
