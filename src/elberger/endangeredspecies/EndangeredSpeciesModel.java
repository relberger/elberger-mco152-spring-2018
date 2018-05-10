package elberger.endangeredspecies;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EndangeredSpeciesModel
{
	public static void main(String[] args) throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
		
				.baseUrl("https://ecos.fws.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		EndangeredSpeciesService service = retrofit.create(EndangeredSpeciesService.class);
		
		Call<EndangeredSpeciesModel> call = service.getSpecies();
		
		call.enqueue(new Callback<EndangeredSpeciesModel>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EndangeredSpeciesModel> response)
			{
				EndangeredSpeciesModel feed = response.body();
				
				Optional<Earthquake> greatestMonth = feed/*.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
					
					System.out.println("Month magnitude: " + greatestMonth.get().getProperties().getMag());
					System.out.println("Month location: " + greatestMonth.get().getProperties().getPlace());*/
			}
			
			@Override
			public void onFailure(Call<EndangeredSpeciesModel> call, Throwable t)
			{
				t.printStackTrace();
			}

			@Override
			public void onResponse(Call<EndangeredSpeciesModel> arg0, Response<EndangeredSpeciesModel> arg1)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
