package Main;

//room defines an accessible room
//Items defines items you can see, hold, pocket, etc
//combination defines items or parts of rooms that need a key to utilize/obtain

public class World {
	public static Room buildWorld() {
		Room hallway = new Room("You are in the hallway.", "hallway");
		
		Room storage = new Room("You are in the storage room.", "storage");
		Items storagekey = new StorageKey("StorageKey", "A key to open the storage room");
		Items briefcase = new Items("briefcase", "This is your work briefcase");
		Items theOrb = new Items("theOrb", "it's a perfectly spherical and shiny ball...it was already here when you moved in"); 
		Room wardrobe = new Room("You are in the walk-in wardrobe", "wardrobe");
		Items clothing = new Items("coat", "This is your worn coat");
		
		Safe safe = new Safe("safe", "It's an impressive safe!");
		Combination chest = new Combination("chest key", "This is the key to your chest");
		Items ring = new Items("Diamond ring", "This is your prized and cherished Diamond ring, it fills you with a soothing feeling");
		
		Room bathroom = new Room("You are in the bathroom", "bathroom");
		
		Room bedroom = new Room("You are in your bedroom", "bedroom");
		Items key = new Items("Door key", "This is a key to the front door");
		
		Room mainhall = new Room("You are in the main floor hallway", "main hall");
		Items ckey = new Items("Car key", "This is the key to your car");
			
		bedroom.addExit('n', hallway);
		bedroom.addExit('s', wardrobe);
		bedroom.addItems(key);
		bedroom.addItems(storagekey);
		
		wardrobe.addExit('n',bedroom);		
		wardrobe.addItems(clothing);
		wardrobe.addCombination(chest);
		wardrobe.addItems(ring);
		wardrobe.addItems(safe);
		
		hallway.addExit('s', bedroom);		
		hallway.addExit('e', storage);
		hallway.addExit('d', mainhall);
		hallway.addExit('w', bathroom);
		
		storage.addExit('w', hallway);
		storage.setlock(true);
		
		mainhall.addExit('u', hallway);
		mainhall.addItems(ckey);
		
		bathroom.addExit('e',hallway);
		
		
		
		return bedroom;
	}
}

