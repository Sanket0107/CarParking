package com.parkingLot.car_parking_system.main;

import com.parkingLot.car_parking_system.constatnt.VehicleType;
import com.parkingLot.car_parking_system.entity.controller.ParkingLotController;

public class Main {

	public static void main(String[] args) {

		ParkingLotController controller = new ParkingLotController();;
		
		 controller.initParkingLot(2, 2, VehicleType.car);

	        int car1 = controller.addNewVehicle("MH 14 KS 4921", "White", VehicleType.car);
	        int car2 = controller.addNewVehicle("MH 12 GF 5816", "Black", VehicleType.car);

	        System.out.println("1st Car has beem parked : " + car1);
	        System.out.println("2nd Car has been parked : " + car2);

	        long parkedHours = 10;
	        double cost1 = controller.deleteVehicle(car1, parkedHours);
	        System.out.println("Car 1 removed with cost: ₹" + cost1);

	        try {
	            controller.addNewVehicle("MH 14 KS 0001", "Gray", VehicleType.car);
	        } catch (IllegalStateException e) {
	            System.out.println(e.getMessage());
	        }

	        boolean availability = controller.checkAvailabilityofVehicle(VehicleType.car);
	        System.out.println("Is space available on floor 1 for cars: " + availability);
	    }
	}
