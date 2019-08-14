package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy) : ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy) : ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("reservation" + reservation);

			System.out.println();
			System.out.println("Enter data to udate the reservation: ");

			System.out.print("Check-in date (dd/mm/yyyy) : ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy) : ");
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkin, checkout);
			System.out.println("reservation" + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainExceptions e) {
			System.out.println("Error in reservation" + e.getMessage());
		}
		catch (RuntimeException e ) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
