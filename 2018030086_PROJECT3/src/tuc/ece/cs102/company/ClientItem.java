package tuc.ece.cs102.company;

import tuc.ece.cs102.company.model.clients.Client;
import tuc.ece.cs102.list.Item;

public class ClientItem extends Item{

	private Client client;

	public ClientItem(Client icl) {
		this.client = icl;
	}

	public Object key() {
		return client.getTin();

	}

	public boolean equals(Item o) {
		return key().equals(o.key());

	}

	public boolean less(Item o) {
		if (((Integer) key()).compareTo((Integer) o.key()) < 0)
			return true;
		return false;

	}

	public String toString() {
		return client.toString();

	}

	public void print() {
		client.print();

	}


	public Object getData(){
		return this.client;
	}
}
