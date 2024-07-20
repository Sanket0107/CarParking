package com.parkingLot.car_parking_system.entity;

import java.util.*;

import com.parkingLot.car_parking_system.constatnt.VehicleType;

import lombok.Data;

@Data
public class Floor {

	private int floorNumber ;
	
	private  List<VehicleSpace> spaces ;
	
	public void addFloor(int floorNumber, int capacity, VehicleType type) {
        this.floorNumber = floorNumber;
        this.spaces = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.spaces.add(new VehicleSpace(i + 1, type));
        }
    }
	 public int getFloorNumber() {
	        return floorNumber;
	    }
	public List<VehicleSpace> getSpaces() {
		return spaces;
	}
	public void setSpaces(List<VehicleSpace> spaces) {
		this.spaces = spaces;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
}
