package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExceptions;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/aaaa");

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainExceptions ("Check-out date must be after check-in date");
		} 
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration ()
	{
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates (Date checkin, Date checkout) {
		
		Date now = new Date(); // armazena na variavel a data de hoje;

		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainExceptions (" Dates for update must be future dates") ;
		} 
		
		
		
		this.checkin = checkin;
		this.checkout = checkout;
	
	}
		
		
		@Override
		public String toString() {
			return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkin)
				+ ", check-out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
		}
}
