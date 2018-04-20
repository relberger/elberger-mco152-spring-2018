package elberger.earthquake.net;

import java.io.IOException;

import elberger.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient
{
	public static void main(String[] args) throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);
		
		Call<EarthquakeFeed> call = service.getAllMonth();
		
		//Response<EarthquakeFeed> response = call.execute();
		
		call.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response)
					{
						EarthquakeFeed feed = response.body();
						
						System.out.println(
								feed.getFeatures()
									.stream()
									.filter(e -> e.getProperties().getMag() >= 5)
									.count());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> call, Throwable t)
					{
						t.printStackTrace();
					}
				});
		
		
		/*EarthquakeFeed feed = response.body();
		
		System.out.println(
				feed.getFeatures()
					.stream()
					.filter(e -> e.getProperties().getMag() >= 5)
					.count());*/
	}	
}
