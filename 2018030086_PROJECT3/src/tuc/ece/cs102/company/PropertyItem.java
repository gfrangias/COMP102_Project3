package tuc.ece.cs102.company;

import tuc.ece.cs102.company.model.properties.Property;
import tuc.ece.cs102.list.Item;

public class PropertyItem extends Item{

	private Property property;

	public PropertyItem(Property ip) {
		this.property = ip;
	}

	public Object key() {
		return property.getPropertyCode();

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
		return property.toString();

	}

	public void print() {
		property.print();

	}


	public Object getData(){
		return this.property;
	}
}
