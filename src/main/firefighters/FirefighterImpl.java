package main.firefighters;

import java.util.LinkedList;
import java.util.Queue;

import main.api.Building;
import main.api.CityNode;
import main.api.Firefighter;
import main.api.exceptions.NotImplementedException;
import main.impls.CityImpl;

public class FirefighterImpl implements Firefighter {
  private CityNode location;
  public int distanceTraveled ;
  boolean [][]visited ;
  private Queue<Building> assignedBuildings ;
  public int name;
  public FirefighterImpl() {
	  distanceTraveled=0;
	  assignedBuildings = new LinkedList<Building>();
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
