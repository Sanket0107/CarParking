package com.parkingLot.car_parking_system.entity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkingLot.car_parking_system.constatnt.VehicleType;
import com.parkingLot.car_parking_system.entity.service.ParkingLotService;

@RestController
@RequestMapping
public class ParkingLotController {

	private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);

	@Autowired
	private ParkingLotService parkingLotService;

	public void initParkingLot(int numOfFloors, int capacityPerFloor, VehicleType type) {
		parkingLotService.init(numOfFloors, capacityPerFloor, type);
		logger.info("Initialized parking lot with {} floors, {} spaces per floor for {} vehicles ", numOfFloors, capacityPerFloor, type);

	}

	public int addNewVehicle(String registrationNumber, String color, VehicleType type) {

		int addedVehciles = parkingLotService.asigneVehicleToParking(registrationNumber, color, type);   
		logger.info("Added New vehicle: {} - {} (Type: {}). Assigned token: {}", registrationNumber, color, type,addedVehciles);
		return addedVehciles;
	}

	public double deleteVehicle(int token, long parkedHours) {

		double costOfParkedVehicle = parkingLotService.deleteVehicle(token, parkedHours);
		logger.info("Delete vehicle with token: {}. Parked hours: {}. Cost: {}", token, parkedHours, costOfParkedVehicle);
		return costOfParkedVehicle;

	}

	public boolean checkAvailabilityofVehicle( VehicleType type) {

		boolean isAvailable = parkingLotService.checkAvailabilityofVehicle(type);
		logger.info("Checked availability for {} vehicles: {}", type, isAvailable);
		return isAvailable;
	}

}
