package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy) : ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/mm/yyyy) : ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date ");

		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("reservation" + reservation);

			System.out.println();
			System.out.println("Enter data to udate the reservation: ");

			System.out.print("Check-in date (dd/mm/yyyy) : ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/mm/yyyy) : ");
			checkout = sdf.parse(sc.next());

			Date now = new Date(); // armazena na variavel a data de hoje;

			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} 
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} 
			else {

				reservation.updateDates(checkin, checkout);
				System.out.println("reservation" + reservation);
				System.out.println("vai tomar no cu!");
			}

		}

		sc.close();
	}

}
