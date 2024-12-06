 package Main;
import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	private Room up;
	private Room down;
	private boolean lock;
	private String name;
	private String desc_lable;
	
	
	private HashMap <String, Items> item = new HashMap <String, Items>();
	
	public Room(String n) { //constructor
		name = n;
		Game.rooms.put(name, this);
	}
	
	
	public Items getItem(String name) { //Remember. you can put multiple returned items in a get function.
		return item.get(name);
	}
	
	public void addItems(Items I) { //edit this and getItems, you already finished removeItem
		item.put(I.getName(), I);
	}
	

	public String toString() {
		return Game.descript.get(name); //remember to ask about this for next time
	}
	
	public void removeItem() {
		item = null;
	}

	public boolean getlock() {	//This 
		return lock;
	}
	
	public void setlock(boolean l) {
		lock = l;
	}
		
	public String getname() {
		return name;
	}
	
	public void setname(String n) {
		name = n;
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

