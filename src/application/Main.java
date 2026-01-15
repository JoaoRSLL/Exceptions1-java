package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), sdf);
		System.out.println("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), sdf);
		

		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.println("Check-in date (dd/MM/yyyy): ");
		checkIn = LocalDate.parse(sc.next(), sdf);
		System.out.println("Check-out date (dd/MM/yyyy): ");
		checkOut = LocalDate.parse(sc.next(), sdf);
		
		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		} catch(DateTimeParseException e){
			System.out.println("Invalid date formart");	
		}
		catch(IllegalArgumentException e){
			System.out.println("Error in reservation: " + e.getMessage());	
		}	
		
		sc.close();
	}

}
