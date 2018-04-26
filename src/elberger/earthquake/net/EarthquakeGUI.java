package elberger.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Comparator;
import java.util.Optional;

import javax.swing.*;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeGUI extends JFrame implements WindowListener
{
	private static final long serialVersionUID = 6111006689421939040L;
	private JTextField monthMag = new JTextField();
	private JTextField monthLoc = new JTextField();
	private JTextField weekMag = new JTextField();
	private JTextField weekLoc = new JTextField();
	private JTextField dayMag = new JTextField();
	private JTextField dayLoc = new JTextField();
	private JTextField hourMag = new JTextField();
	private JTextField hourLoc = new JTextField();
	
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://earthquake.usgs.gov")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	
	UsgsEarthquakeService service = retrofit.create(UsgsEarthquakeService.class);
		
	public EarthquakeGUI()
	{
		setTitle("Largest Earthquakes");
		setSize(700, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(8, 2));
		
		JLabel monthMagLabel = new JLabel("Past month magnitude:");
		JLabel monthLocLabel = new JLabel("Past month location:");
		JLabel weekMagLabel = new JLabel("Past week magnitude:");
		JLabel weekLocLabel = new JLabel("Past week location:");
		JLabel dayMagLabel = new JLabel("Past day magnitude:");
		JLabel dayLocLabel = new JLabel("Past day location:");
		JLabel hourMagLabel = new JLabel("Past hour magnitude:");
		JLabel hourLocLabel = new JLabel("Past hour location:");

		earthquakePanel.add(monthMagLabel);
		earthquakePanel.add(monthMag);
		earthquakePanel.add(monthLocLabel);
		earthquakePanel.add(monthLoc);
		earthquakePanel.add(weekMagLabel);
		earthquakePanel.add(weekMag);
		earthquakePanel.add(weekLocLabel);
		earthquakePanel.add(weekLoc);
		earthquakePanel.add(dayMagLabel);
		earthquakePanel.add(dayMag);
		earthquakePanel.add(dayLocLabel);
		earthquakePanel.add(dayLoc);		
		earthquakePanel.add(hourMagLabel);
		earthquakePanel.add(hourMag);
		earthquakePanel.add(hourLocLabel);
		earthquakePanel.add(hourLoc);		
		
		monthMag.setEditable(false);
		monthLoc.setEditable(false);		
		weekMag.setEditable(false);
		weekLoc.setEditable(false);
		dayMag.setEditable(false);
		dayLoc.setEditable(false);
		hourMag.setEditable(false);
		hourLoc.setEditable(false);
		
		addWindowListener(this);
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);

	}

	public void getMonthValues()
	{
		Call<EarthquakeFeed> callMonth = service.getAllMonth();
		callMonth.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callMonth, Response<EarthquakeFeed> responseMonth)
					{
						EarthquakeFeed feedMonth = responseMonth.body();
						
						Optional<Earthquake> greatestMonth = feedMonth.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							String monthMagValue = String.valueOf(greatestMonth.get().getProperties().getMag());
							String monthLocValue = String.valueOf(greatestMonth.get().getProperties().getPlace());
							monthMag.setText(monthMagValue);
							monthLoc.setText(monthLocValue);
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}
	
	public void getWeekValues()
	{
		Call<EarthquakeFeed> callWeek = service.getAllWeek();
		callWeek.enqueue(new Callback<EarthquakeFeed>()
				{
					@Override
					public void onResponse(Call<EarthquakeFeed> callWeek, Response<EarthquakeFeed> responseWeek)
					{
						EarthquakeFeed feedWeek = responseWeek.body();
						
						Optional<Earthquake> greatestWeek = feedWeek.getFeatures()
								.stream()
								.max(Comparator.comparing(e -> e.getProperties().getMag()));
							
							String weekMagValue = String.valueOf(greatestWeek.get().getProperties().getMag());
							String weekLocValue = String.valueOf(greatestWeek.get().getProperties().getPlace());
							weekMag.setText(weekMagValue);
							weekLoc.setText(weekLocValue);
					}
					
					@Override
					public void onFailure(Call<EarthquakeFeed> callMonth, Throwable t)
					{
						t.printStackTrace();
					}
				});
	}
	
	public void getDayValues()
	{
		Call<EarthquakeFeed> callDay = service.getAllDay();
		callDay.enqueue(new Callback<EarthquakeFeed>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeed> callDay, Response<EarthquakeFeed> responseDay)
			{
				EarthquakeFeed feedDay = responseDay.body();
				
				Optional<Earthquake> greatestDay = feedDay.getFeatures()
						.stream()
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
					
					String dayMagValue = String.valueOf(greatestDay.get().getProperties().getMag());
					String dayLocValue = String.valueOf(greatestDay.get().getProperties().getPlace());
					dayMag.setText(dayMagValue);
					dayLoc.setText(dayLocValue);
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callDay, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}
	
	public void getHourValues()
	{
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
				
				String hourMagValue = String.valueOf(greatestHour.get().getProperties().getMag());
				String hourLocValue = String.valueOf(greatestHour.get().getProperties().getPlace());
				hourMag.setText(hourMagValue);
				hourLoc.setText(hourLocValue);
			}
			
			@Override
			public void onFailure(Call<EarthquakeFeed> callHour, Throwable t)
			{
				t.printStackTrace();
			}
		});
		
	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		
	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		
	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		
	}
	
	@Override
	public void windowOpened(WindowEvent e)
	{
		getMonthValues();
		getWeekValues();
		getDayValues();
		getHourValues();		
	}
		
	public static void main(String[] args)
	{
		new EarthquakeGUI().setVisible(true);
	}
}
