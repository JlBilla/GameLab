package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
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
			String[] words = command.split("");
			
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
					Items item = currentRoom.getItems();
					System.out.println("take", item); //ask for help here
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
				default:
					System.out.println("Sorry, I don't know what you mean by that");
			}
			
		} while(!command.equals("x"));
	
		input.close();
		
		}
	}