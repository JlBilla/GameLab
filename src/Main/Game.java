package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	//inventory = array for player inventory, it holds the items array 
	//The Items array represents the players current items
	//currentRoom is the room the player is currently in
	//input is a method that scans the players input to do actions
	//command asks the player what they want to do and intakes that information
	//words represents the words in a given command, this is interpreted with words[0] which starts from the initially read command like Take and [1] which is the thing in question the player is interacting with
	//case n-d, these represent directions the play can move to in the world
	//case x exits the game
	//case take is meant to allow the player to take items from rooms or locations in game
	//item represents a specific item within the items array
	//null means the absence of, so for if item == null it means (if there is no item) 
	public static void main(String[] args) {
		runGame();
	}

	private static ArrayList <Items> inventory = new ArrayList <Items>();
	
	
	public static void runGame() {
		Room currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		
		String command;
		do {
			System.out.println(currentRoom);
			System.out.print("What do you want to do? ");
			command = input.nextLine();
			String[] words = command.split(" ");
			
			switch(words[0]) {
				case "n":
				case "s":
				case "e":
				case "w":
				case "u":
				case "d":
				currentRoom = currentRoom.getExit(command.charAt(0));
					break;
				case "x":
					System.out.println("See ya! hope you had fun.");
					break;
				case "take":
					Items item = currentRoom.getItem(words[1]);
					System.out.println("take" + item);
					System.out.println("You wasnt to take the"+words[1]);
					if (item == null) {
						System.out.println("There's nothing to take.");
					}
					else {
						currentRoom.removeItem();
						inventory.add(item);
						System.out.println("You pick up the "+item.getName());
					}
					break;
				case "i":
					System.out.println("You are carrying:");
					for (Items i: inventory) {
						System.out.println(i);
					System.out.println();
						//Items item = inventory.getItems();
						//System.out.println(description);
					}
					break;
				case "look":
					Items object = currentRoom.getItem(words[1]);
					if (object == null) {
						System.out.println("There's nothing to look at.");
					}
					else {
						System.out.println(object.getDesc());
					}
				default:
					System.out.println("Sorry, I don't know what you mean by that");
			}
			
		} while(!command.equals("x"));
	
		input.close();
		
		}
	}