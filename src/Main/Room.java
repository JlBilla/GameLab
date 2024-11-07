 package Main;
import java.util.HashMap;

public class Room {
	private String description;
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	private Room up;
	private Room down;
	

	private HashMap <String, Items> item = new HashMap <String, Items>();
	
	
	public Items getItem(String name) { //Remember. you can put multiple returned items in a get function.
		return item.get(name);
	}
	
	public void addItems(Items I) { //edit this and getItems, you already finished removeItem
		I.getName();
		item.put(description, I);
	}
	
	public Room(String desc) {
		description = desc;
	}

	public String toString() {
		return description;
	}

	public void removeItem() {
		item = null;
	}
	
	public void addExit(char dir, Room r) {
		if (dir == 'e')
			east = r;
		else if (dir == 'w')
			west = r;
		else if (dir == 'n')
			north = r;
		else if (dir == 's')
			south = r;
		else if (dir == 'u')
			up = r;
		else if (dir == 'd')
			down = r;
	}

	public Room getExit(char dir) {
		if (dir == 'n')
			return north;
		
		else if (dir == 's')
			return south;
		
		else if (dir == 'e')
			return east;
		
		else if (dir == 'w') 
			return west;
		
		else if (dir == 'u')
			return up;
		
		else if (dir == 'd')
			return down;
		else
			return null;
		
	}

	public void addCombination(Combination locker) { //ask about this
		// TODO Auto-generated method stub
		
	}	
	
}

