package main.firefighters;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.api.Building;
import main.api.City;
import main.api.CityNode;
import main.api.FireDispatch;
import main.api.Firefighter;
import main.api.exceptions.NoFireFoundException;
import main.api.exceptions.NotImplementedException;
import main.api.exceptions.OutOfCityBoundsException;
import main.impls.BuildingImpl;
import main.impls.BuildingQueue;

public class FireDispatchImpl implements FireDispatch {

  List<Firefighter> fireFightersHired ;
  City city;	
  Queue<BuildingQueue> queue;
  boolean [][]visited ;
  
  public FireDispatchImpl(City city) {
    // TODO
	this.city =city;
	fireFightersHired = new ArrayList<Firefighter>();
	queue= new LinkedList<BuildingQueue>();
	visited = new boolean[city.getXDimension()][city.getYDimension()];
	
  //  throw new NotImplementedException();
  }

  @Override
  public void setFirefighters(int numFirefighters) {
    // TODO
	  for(int i=0;i<numFirefighters;i++) {
		  FirefighterImpl firefighter = new FirefighterImpl();
		  firefighter.setLocation(city.getFireStation().getLocation());
		  fireFightersHired.add(firefighter);
	  }
	 
  }

  private boolean validateCoordinate(int xCoordinate, int yCoordinate) {
	    if (xCoordinate < 0 || yCoordinate < 0 || xCoordinate >= city.getXDimension()||
	        yCoordinate >= city.getYDimension() || visited[xCoordinate][yCoordinate]==true) {
	      return false;
	    }
	    return true;
	  }
  
  @Override
  public List<Firefighter> getFirefighters() {
    // TODO
    return fireFightersHired;
  }

  @Override
  public void dispatchFirefighers(CityNode... burningBuildings)  {
    // TODO
	if(getFirefighters().size()>1) {
	  
		int count = getFirefighters().size();
		int j=0;
		while(count>0) {
			FirefighterImpl firefighterImpl = (FirefighterImpl) getFirefighters().get(j);
			
			for(int i=0;i<burningBuildings.length;i++) {
				  try {
					  FirefighterImpl  firefighterReturn=dispatchExtinguish(burningBuildings[i],firefighterImpl) ;
					  fireFightersHired.set(j, firefighterReturn);
				} catch (NoFireFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				    
			   }
			
			count--;
			j++;
		}
		
   }else {
	
	  FirefighterImpl firefighterImpl = (FirefighterImpl) getFirefighters().get(0);
	  
	   for(int i=0;i<burningBuildings.length;i++) {
		   try {
			firefighterImpl =dispatchExtinguish(burningBuildings[i],firefighterImpl) ;
			
		   } catch (NoFireFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	   }
	   fireFightersHired.set(0, firefighterImpl);
   }
 }
  
  public FirefighterImpl dispatchExtinguish(CityNode cityNode, FirefighterImpl firefighterImpl) throws NoFireFoundException {
	   
	  
	   Building burningBuilding = city.getBuilding(cityNode);
	   Building fireStation = city.getFireStation();
	   queue.add(new BuildingQueue(city.getBuilding(firefighterImpl.getLocation()), 0));
	   visited[firefighterImpl.getLocation().getX()][firefighterImpl.getLocation().getY()] = true;
	   int distance =0;
	   while(!queue.isEmpty()) {
		   
		   BuildingQueue buildingQueuePop = queue.poll();
		   Building building = buildingQueuePop.getBuilding();
		   distance=buildingQueuePop.getDistanceTraveledByFireFighter();
		   if(building.getLocation().equals(burningBuilding.getLocation()) && !building.isFireproof()) {
			  
				  try {
					burningBuilding.extinguishFire();
				} catch (NoFireFoundException e) {
					// TODO Auto-generated catch block
					throw new NoFireFoundException();
				}
				  firefighterImpl.distanceTraveled=buildingQueuePop.getDistanceTraveledByFireFighter();
				  firefighterImpl.setLocation(building.getLocation());
				  return firefighterImpl;
			  //set firefighter location
			  
			  
		   }
		   
		   //go up
		   if(validateCoordinate(building.getLocation().getX()-1, building.getLocation().getY())) {
			   
			   Building buildingUp =city.getBuilding(building.getLocation().getX()-1, building.getLocation().getY());
			   queue.add(new BuildingQueue(buildingUp, distance+1)) ;
			   visited[buildingUp.getLocation().getX()][buildingUp.getLocation().getY()]=true;
		   }
		   
		   //go down
		   if(validateCoordinate(building.getLocation().getX()+1, building.getLocation().getY())) {
			   Building buildingDown=city.getBuilding(building.getLocation().getX()+1, building.getLocation().getY()) ;
			   queue.add(new BuildingQueue(buildingDown, distance+1));
			   visited[buildingDown.getLocation().getX()][buildingDown.getLocation().getY()]=true;
		   }
		   
		   //go left
		   if(validateCoordinate(building.getLocation().getX(), building.getLocation().getY()-1)) {
			   Building buildingLeft =city.getBuilding(building.getLocation().getX(), building.getLocation().getY()-1) ;
			   queue.add(new BuildingQueue(buildingLeft, distance+1));
			   visited[buildingLeft.getLocation().getX()][buildingLeft.getLocation().getY()]=true;
		   }
		   
		   //go right
		   
		   if(validateCoordinate(building.getLocation().getX(), building.getLocation().getY()+1)) {
			   Building buildingRight = city.getBuilding(building.getLocation().getX(), building.getLocation().getY()+1);
			   queue.add(new BuildingQueue(buildingRight, distance+1) );
			   visited[buildingRight.getLocation().getX()][buildingRight.getLocation().getY()]=true;
		   }
	   }
	   
	return firefighterImpl  ;
  }
  
  
}
