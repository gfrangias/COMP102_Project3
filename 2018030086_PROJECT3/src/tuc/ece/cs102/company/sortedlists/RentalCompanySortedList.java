package tuc.ece.cs102.company.sortedlists;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;
import tuc.ece.cs102.list.SortedList;

public class RentalCompanySortedList extends SortedList {

	public  RentalCompanySortedList() {
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
		try{
			while (tmp!=null){
				Item item = tmp.getValue();				
				if (Class.forName(className).isInstance(item.getData())){
					item.print();
				}
				tmp = tmp.getNext();
			}
		}catch (ClassNotFoundException ex){
			System.out.println("This class "+className+" does not exist...");
		}		
	}

}