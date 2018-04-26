package elberger.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

public class EarthquakeGUI extends JFrame
{
	private JButton button = new JButton("Find largest earthquakes in past month, week, day, and hour");
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
	
	Call<EarthquakeFeed> callMonth = service.getAllMonth();
	Call<EarthquakeFeed> callWeek = service.getAllWeek();
	Call<EarthquakeFeed> callDay = service.getAllDay();
	Call<EarthquakeFeed> callHour = service.getAllHour();
	
	public EarthquakeGUI()
	{
		setTitle("Largest Earthquakes");
		setSize(1500, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(button, BorderLayout.NORTH);
		
		JPanel earthquakePanel = new JPanel();
		earthquakePanel.setLayout(new GridLayout(4, 5));
		
		JLabel monthLabel = new JLabel("Past month:");
		JLabel monthMagLabel = new JLabel("Magnitude:");
		JLabel monthLocLabel = new JLabel("    Location:");
		JLabel weekLabel = new JLabel("Past week:");
		JLabel weekMagLabel = new JLabel("Magnitude:");
		JLabel weekLocLabel = new JLabel("    Location:");
		JLabel dayLabel = new JLabel("Past day:");
		JLabel dayMagLabel = new JLabel("Magnitude:");
		JLabel dayLocLabel = new JLabel("    Location:");
		JLabel hourLabel = new JLabel("Past hour:");
		JLabel hourMagLabel = new JLabel("Magnitude:");
		JLabel hourLocLabel = new JLabel("    Location:");

		earthquakePanel.add(monthLabel);
		earthquakePanel.add(monthMagLabel);
		earthquakePanel.add(monthMag);
		earthquakePanel.add(monthLocLabel);
		earthquakePanel.add(monthLoc);
		earthquakePanel.add(weekLabel);
		earthquakePanel.add(weekMagLabel);
		earthquakePanel.add(weekMag);
		earthquakePanel.add(weekLocLabel);
		earthquakePanel.add(weekLoc);
		earthquakePanel.add(dayLabel);
		earthquakePanel.add(dayMagLabel);
		earthquakePanel.add(dayMag);
		earthquakePanel.add(dayLocLabel);
		earthquakePanel.add(dayLoc);		
		earthquakePanel.add(hourLabel);
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
		
		button.addActionListener(e -> 
		{
			getMonthValues(e);
			getWeekValues(e);
			getDayValues(e);
			getHourValues(e);
		});
		
		panel.add(earthquakePanel, BorderLayout.CENTER);
		
		add(panel);

	}

	public void getMonthValues(ActionEvent e)
	{
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
	
	public void getWeekValues(ActionEvent e)
	{
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
	
	public void getDayValues(ActionEvent e)
	{
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
	
	public void getHourValues(ActionEvent e)
	{
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
	public static void main(String[] args)
	{
		new EarthquakeGUI().setVisible(true);
	}

}
