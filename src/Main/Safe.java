package Main;

//I'm trying to see if the key is in the player's inventory
//I am trying to ask the open method if the item is in the players inventory
//returnItem takes the combination item from the inventory
//and pulls it out so it can be used


public class Safe extends Items {

	public Safe(String desc, String name) {
		super(desc, name);
	}
	
	public void open() {
		if (Game.returnItem("chest key") == null) {
			System.out.println("The safe is locked and you don't have the combination");
		}
		else {
			Game.print("Using the combination, you find several keepsakes, inlcuding your diamond ring! which you obviously take");
		}
		
		
	}

}
