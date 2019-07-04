package tuc.ece.cs102.company.sortedlists;

import tuc.ece.cs102.company.model.properties.Property;
import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.list.SortedList;

public class PropertySortedList extends SortedList {

	public  PropertySortedList() {
		super();
	}

	public Item search(int key){
		Node tmpNode = head;
		while (tmpNode != null){
			if (tmpNode.getValue().key().equals(new Integer(key))){
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}

	public Item search(String key){
		Node tmpNode = head;
		while (tmpNode != null){
			if (tmpNode.getValue().key().equals(new String(key))){
				return tmpNode.getValue();
			}
			tmpNode = tmpNode.getNext();
		}
		return null;
	}
	
	public void printAllInHierarchy(String className){
		Node tmp = head;
		int sumOfPrices = 0;
		int sumOfGuests = 0;
		try{
			while (tmp!=null){
				Item item = tmp.getValue();	
				Property property = (Property)item.getData();
				if (Class.forName("tuc.ece.cs102.company.model.properties."+className).isInstance(item.getData())){
					sumOfPrices = sumOfPrices + property.getPricePerNight();
					sumOfGuests = sumOfGuests + property.getNumOfGuests();
				}
				tmp = tmp.getNext();
			}
			float average = (float)sumOfPrices / sumOfGuests;
			System.out.println("The Average Cost for all "+className+"s of one Guest is "+average);
		}catch (ClassNotFoundException ex){
			System.out.println("This class "+className+" does not exist...");
		}		
	}

}