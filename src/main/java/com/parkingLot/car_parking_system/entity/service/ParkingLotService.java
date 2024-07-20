package com.parkingLot.car_parking_system.entity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkingLot.car_parking_system.constatnt.VehicleType;
import com.parkingLot.car_parking_system.entity.ParkingLot;
import com.parkingLot.car_parking_system.entity.Vehicle;

@Service

public interface ParkingLotService  {

	
	public void init(int numOfFloors, int capacityPerFloor, VehicleType type) ;

	public  int asigneVehicleToParking(String registrationNumber, String color, VehicleType type) ;

	public double deleteVehicle(int token, long parkedHours) ;

	public boolean checkAvailabilityofVehicle(VehicleType type);
}
