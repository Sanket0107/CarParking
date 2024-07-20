package com.parkingLot.car_parking_system.entity;

import java.util.*;

import org.springframework.stereotype.Component;

import com.parkingLot.car_parking_system.constatnt.VehicleType;
import com.parkingLot.car_parking_system.exception.CustomException;

@Component
public class ParkingLot {
	
private List<Floor> floors;
	
    private CostStrategy costStrategy;
    
    private Map<String, Integer> vehicleTokenMap;
    
    private Map<Integer, VehicleSpace> tokenSpaceMap;
    
    private int nextToken;
 	private int new1 ;
	public ParkingLot(List<Floor> floors, CostStrategy costStrategy, Map<String, Integer> vehicleTokenMap,
			Map<Integer, VehicleSpace> tokenSpaceMap, int nextToken) {
		super();
		this.floors = floors;
		this.costStrategy = costStrategy;
		this.vehicleTokenMap = vehicleTokenMap;
		this.tokenSpaceMap = tokenSpaceMap;
		this.nextToken = nextToken;
	}

	  public int asigneVehicleToParking(Vehicle vehicle) {
	        for (Floor floor : floors) {
	            for (VehicleSpace space : floor.getSpaces()) {
	                if (space.isAvailable() && space.getType() == vehicle.getType()) {
	                    space.parkVehicle(vehicle);
	                    int token = nextToken++;
	                    vehicleTokenMap.put(vehicle.getRegistrationNumber(), token);
	                    tokenSpaceMap.put(token, space);
	                    return token;
	                }
	            }
	        }
	        throw new  CustomException("Parking is full for vehicle type :"+vehicle.getType() );
	    }
	  

	    public double deleteVehicle(int token, long parkedHours) {
	        if (!tokenSpaceMap.containsKey(token)) {
	            throw new IllegalArgumentException("Invalid token");
	        }
	        VehicleSpace space = tokenSpaceMap.get(token);
	        double cost = calculateCost(parkedHours, space.getVehicle().getType());
	        vehicleTokenMap.remove(space.getVehicle().getRegistrationNumber());
	        tokenSpaceMap.remove(token);
	        space.deleteVehicle();
	        return cost;
	    }
	    
	    double calculateCost(long hours, VehicleType type) {
			return 0;
		}

	    public boolean checkAvailability(int floorNumber, VehicleType type) {
	        Floor floor = floors.get(floorNumber - 1);
	        for (VehicleSpace space : floor.getSpaces()) {
	            if (space.isAvailable() && space.getType() == type) {
	                return true;
	            }
	        }
	        return false;
	    }
}
