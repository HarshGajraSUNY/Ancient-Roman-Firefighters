package main.impls;

import main.api.Building;
import main.api.CityNode;
import main.api.exceptions.FireproofBuildingException;
import main.api.exceptions.NoFireFoundException;

public class BuildingQueue {

public Building building;

public int distanceTraveledByFireFighter;

public BuildingQueue(Building building, int distanceTraveledByFireFighter) {
	this.building = building;
	this.distanceTraveledByFireFighter = distanceTraveledByFireFighter;
}

public Building getBuilding() {
	return building;
}

public void setBuilding(Building building) {
	this.building = building;
}

public int getDistanceTraveledByFireFighter() {
	return distanceTraveledByFireFighter;
}

public void setDistanceTraveledByFireFighter(int distanceTraveledByFireFighter) {
	this.distanceTraveledByFireFighter = distanceTraveledByFireFighter;
}



}
