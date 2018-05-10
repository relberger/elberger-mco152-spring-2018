package elberger.vendingmachine2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import elberger.earthquake.net.EarthquakeController;
import elberger.earthquake.net.EarthquakeView;
import elberger.earthquake.net.UsgsEarthquakeService;
import retrofit2.Call;

class EarthquakeControllerTest
{
//unit test
	@Test
	void testRefreshData()
	{
		//given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		UsgsEarthquakeService service = Mockito.mock(UsgsEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		Call<EarthquakeFeedModel> call = Mockito.mock(Call.class);
		Mockito.when(service.getAllMonth()).thenReturn(call);
		JTextField field = Mockito.mock(JTextField.class);
		Mockito.when(view.getMonthLocTextField()).thenReturn(field);
		//
		
		//when
		controller.requestMonth();
		
		//then
		//assert 
		assertFalse(view.getMonthLocTextField().getText().equals(""));
	}
	@Test
	public void testShowLargestEarthquake()
	{
		//given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		UsgsEarthquakeService service = Mockito.mock(UsgsEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		JTextField mag = Mockito.mock(JTextField.class);
		JTextField loc = Mockito.mock(JTextField.class);
		
		List <Earthquake> list = new ArrayList<Earthquake>();
		list.add(new Earthquake(2, "touro brooklyn", 1));
		list.add(new Earthquake(5, "touro manhattan", 2));
		list.add(new Earthquake(3, "touro queens", 3));
		EarthquakeFeedModel model = new EarthquakeFeedModel("", list);
		
		//when
		controller.showLargestEarthquake(model, mag, loc);
		
		//then
		Mockito.verify(mag).setText("5.0");
		Mockito.verify(loc).setText("touro manhattan");
		
	}

}
