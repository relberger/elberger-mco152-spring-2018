package elberger.physics;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProjectilePropertyChangeListener
{
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener)
	{
		this.pcs.removePropertyChangeListener(listener);
	}

	private String value;

	public String getValue()
	{
		return this.value;
	}

	public void setValue(String newValue) 
	{
	    String oldValue = this.value;
	    this.value = newValue;
	    this.pcs.firePropertyChange("value", oldValue, newValue);
	}
}