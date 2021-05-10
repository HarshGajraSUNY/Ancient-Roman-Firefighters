package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;
import main.api.exceptions.NotImplementedException;
import main.impls.CityImpl;

public class FirefighterImpl implements Firefighter {
  private CityNode location;
  public int distanceTraveled ;
  boolean [][]visited ;
  
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

public boolean[][] getVisited() {
	return visited;
}

public void setVisited(boolean[][] visited) {
	this.visited = visited;
}
  
}
