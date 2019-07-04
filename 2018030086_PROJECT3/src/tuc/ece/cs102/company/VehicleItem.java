package tuc.ece.cs102.company;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.company.model.vehicles.Vehicle;

public class VehicleItem extends Item{
	private Vehicle vehicle;

	public VehicleItem(Vehicle iv) {
		this.vehicle = iv;
	}

	public Object key() {
		return vehicle.getLicensePlate();

	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if (((String) key()).compareTo((String) o.key()) < 0)
			return true;
		return false;

	}

	public String toString() {
		return vehicle.toString();

	}

	public void print() {
		vehicle.print();

	}


	public Object getData(){
		return this.vehicle;
	}
}
