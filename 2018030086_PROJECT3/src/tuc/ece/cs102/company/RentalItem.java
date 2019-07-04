package tuc.ece.cs102.company;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.util.DatePeriod;

import java.util.Date;

import tuc.ece.cs102.company.model.Rental;

public class RentalItem extends Item{
	private Rental rental;

	public RentalItem(Rental ir) {
		this.rental = ir;
	}

	public Object key() {
		return null;
	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		return false;

	}

	public String toString() {
		return rental.toString();

	}

	public void print() {
		rental.print();
	}

	public Object getData(){
		return this.rental;
	}

	public DatePeriod getDatePeriod() {
		Date dDate = rental.getDeliveryDate();
		Date rDate = rental.getReturnDate();
		DatePeriod renPer = new DatePeriod(dDate,rDate);
		return renPer;
	}
}
