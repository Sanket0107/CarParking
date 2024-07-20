package com.parkingLot.car_parking_system.entity;

import java.util.List;

import com.parkingLot.car_parking_system.constatnt.VehicleType;

import lombok.Data;

@Data

public class VehicleSpace {
	
	private int spaceNumber;
	
    private boolean isAvailable;
    
    private VehicleType type;
    
    private Vehicle vehicle;
    
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public VehicleSpace (int capacity, VehicleType type)
	{
		super();
		
	}
	public List<VehicleSpace> getSpaces() {
	        return getSpaces();
	    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }
    
    public void deleteVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }

}

