package Main;

public class World {
	public static Room buildWorld() {
		Room hallway = new Room("You are in the hallway.");
		Room storage = new Room("You are in the storage room.");
		
		Room wardrobe = new Room("You are in the walk-in wardrobe");
		Items clothing = new Items("coat", "This is your worn coat");
		
		Safe safe = new Safe("safe", "It's an impressive safe!");
		Combination chest = new Combination("chest key", "This is the key to your chest");
		Items ring = new Items("Diamond ring", "This is your prized and cherished Diamond ring, it fills you with a soothing feeling");
		
		Room bathroom = new Room("You are in the bathroom");
		
		Room bedroom = new Room("You are in your bedroom");
		Items key = new Items("Door key", "This is a key to the front door");
		
		Room mainhall = new Room("You are in the main floor hallway");
		Items ckey = new Items("Car key", "This is the key to your car");
			
		bedroom.addExit('n', hallway);
		bedroom.addExit('s', wardrobe);
		bedroom.addItems(key);
		
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
		
		mainhall.addExit('u', hallway);
		mainhall.addItems(ckey);
		
		bathroom.addExit('e',hallway);
		
		
		
		return bedroom;
	}
}

