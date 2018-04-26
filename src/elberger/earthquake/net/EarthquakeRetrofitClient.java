package elberger.earthquake.net;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import elberger.earthquake.Earthquake;
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
		
		Call<EarthquakeFeed> callMonth = service.getAllMonth();
			
		callMonth.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callMonth, Response<EarthquakeFeed> responseMonth)
					{
						EarthquakeFeed feedMonth = responseMonth.body();
						
						System.out.println(
								feedMonth.getFeatures()
									.stream()
									.filter(e -> e.getProperties().getMag() >= 5)
									.count());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
		

		Call<EarthquakeFeed> callWeek = service.getAllWeek();
		
		callWeek.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callWeek, Response<EarthquakeFeed> responseWeek)
					{
						EarthquakeFeed feedWeek = responseWeek.body();
						
						System.out.println(
								feedWeek.getFeatures()
									.stream()
									.filter(e -> e.getProperties().getMag() >= 5)
									.count());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callWeek, Throwable t)
					{
						t.printStackTrace();
					}
				});

		Call<EarthquakeFeed> callDay = service.getAllDay();
		
		callDay.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callDay, Response<EarthquakeFeed> responseDay)
					{
						EarthquakeFeed feedDay = responseDay.body();
						
						System.out.println(
								feedDay.getFeatures()
									.stream()
									.filter(e -> e.getProperties().getMag() >= 5)
									.count());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callDay, Throwable t)
					{
						t.printStackTrace();
					}
				});
		
		Call<EarthquakeFeed> callHour = service.getAllHour();
		
		callHour.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callHour, Response<EarthquakeFeed> responseHour)
					{
						EarthquakeFeed feedHour = responseHour.body();
						
						Optional<Earthquake> greatestHour = feedHour.getFeatures()
							.stream()
							.max(Comparator.comparing(e -> e.getProperties().getMag()));
						
						System.out.println(greatestHour.get().getProperties().getMag());
						System.out.println(greatestHour.get().getProperties().getPlace());
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callHour, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}	
}
