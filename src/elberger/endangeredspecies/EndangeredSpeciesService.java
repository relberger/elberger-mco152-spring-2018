package elberger.endangeredspecies;

import retrofit2.Call;
import retrofit2.http.GET;

public class EndangeredSpeciesService
{
	@GET("https://ecos.fws.gov/ecp/report/table/critical-habitat.json")
	Call<EndangeredSpeciesModel> getSpecies();

}
