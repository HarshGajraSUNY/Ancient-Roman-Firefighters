package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;
import main.api.exceptions.NotImplementedException;

public class FirefighterImpl implements Firefighter {
  private CityNode location;
  public int distanceTraveled ;
	
  
  public FirefighterImpl() {
	  distanceTraveled=0;
}

@Override
  public CityNode getLocation() {
    // TODO
	  return location;
  }

  @Override
  public int distanceTraveled() {
    // TODO
    return distanceTraveled;
  }
  
  public void setLocation(CityNode cityNode) {
	  
	  this.location=cityNode;
	  
  }
  
}
