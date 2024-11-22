package Main;

public class StorageKey extends Items{

	public StorageKey(String desc, String name) {
		super(desc, name);
	}
	
	public void use() {
		Room clocation = Game.getcurrentRoom(); //gets current room the player is in
		String getlocalname = clocation.getname();  //name of current room player is in
		Game.print(getlocalname);
		if (getlocalname.equals("hallway")) {
			Room storetemp = clocation.getExit('e'); //gets the storage room location
			storetemp.setlock(false);
			Game.print("The storage room has been unlocked!");		
		}
		else {
			Game.print("You are not in the right room to unlock this door!");
		}
	}

}
