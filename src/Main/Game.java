package Main;

import java.util.HashMap;

import java.io.*;

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
		fileread();
		currentRoom = World.buildWorld();
		gui = new Gameui();
		print(currentRoom);
		
	}

	private static Gameui gui;
	
	private static ArrayList <Items> inventory = new ArrayList <Items>();
	
	public static HashMap <String, Room> rooms = new HashMap <String, Room>(); //continue from here later
	
	public static HashMap <String, String> descript = new HashMap <String, String>();
	
	private static Room currentRoom; 
	
	public static void print(Object obj) {
		gui.textarea.append(obj.toString()+"\n");
		}
	
	public static Room getcurrentRoom() {
			return currentRoom;
	}
	
	//for the Items class as I in the inventory
	//if the name of the item in the inventory
	//is the name pulled from the inventory?
	//return the Items class
	public static Items returnItem(String name) {
		for(Items I: inventory) {	
			if (name.equals(I.getName())){
			return I;
			}
		}
		return null;	
	}
	
	public static void processCommand(String command) {
		String[] words = command.split(" ");
		Items item;
		switch(words[0]) {
			case "n":
			case "s":
			case "e":
			case "w":
			case "u":
			case "d":
			Room targetRoom = currentRoom.getExit(command.charAt(0));
			if (targetRoom.getlock()) {
				Game.print("You can't enter that locked room");
			}
			else {
				Game.print("You enter your target room");
				currentRoom = targetRoom;
				print(currentRoom);
			}
				break;
			case "x":
				Game.print("See ya! hope you had fun.");
				break;
			case "take":
				item = currentRoom.getItem(words[1]);
				Game.print("take" + item);
				Game.print("You went to take the" + words[1]);
				if (item == null) {
					Game.print("There's nothing to take.");
				}
				else {
					currentRoom.removeItem();
					inventory.add(item);
					Game.print("You pick up the "+item.getName());
				}
				break;
			case "i":
				Game.print("You are carrying:");
				for (Items i: inventory) {
					Game.print(i);
					Game.print("");
					//Items item = inventory.getItems();
					//Game.print(description);
				}
				break;
			case "use":
				//item = currentRoom.getItem(words[1]);
				item = returnItem(words[1]);
				Game.print("use" + item);
				Game.print("You used the" + words[1]);
				if (item == null) {
					Game.print("There's nothing to use");
				}
				else {
					item.use();
				}
				break;
			case "open":
				item = currentRoom.getItem(words[1]);
				Game.print("open" + item);
				Game.print("You went to open the" + words[1]);
				if (item == null) {
					Game.print("There's nothing to open.");
				}
			case "look":
				Items object = currentRoom.getItem(words[1]);
				if (object == null) {
					Game.print("There's nothing to look at.");
				}
				else {
					Game.print("");
					Game.print(object.getDesc());
				}
				break;
			case "save":
				saveList("savedata");
				break;
			case "load":
				loadList("savedata");
				
				
			default:
				Game.print("Sorry, I don't know what you mean by that");
		}
	}
	
	public static void saveList(String fileName) {
		File f = new File(fileName);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(rooms);
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File "+fileName+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			Game.print("Bummers, man.");
			}
		}
	
	public static void loadList(String fileName) {
		File f = new File(fileName);
		try {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList) stream.readObject();
			rooms = (HashMap) stream.readObject();
			stream.close();
		} catch (FileNotFoundException e) {
			Game.print("File "+fileName+" not found.");
			System.exit(0);
		} catch (IOException ex) {
			Game.print("Bummers, man.");
		} catch (ClassNotFoundException ex) {
			Game.print("Something went horribly wrong.");
			}
		}
	

		public static void fileread() {
				try {
					Scanner input = new Scanner(new File("room descriptions"));
					while(input.hasNextLine()) {
							String line = input.nextLine();
							String linetwo = input.nextLine();
							descript.put(line, linetwo); 
					}
					input.close();
				} catch (FileNotFoundException e) {
					Game.print("File not found!!!");
				}
		}
	
	public static void runGame() {
		currentRoom = World.buildWorld();
		Scanner input = new Scanner(System.in);
		
		String command;
		do {
			Game.print(currentRoom);
			System.out.print("What do you want to do? ");
			command = input.nextLine();
			String[] words = command.split(" "); //switch statement begins here
			Items item;
			switch(words[0]) {
				case "n":
				case "s":
				case "e":
				case "w":
				case "u":
				case "d":
				Room targetRoom = currentRoom.getExit(command.charAt(0));
				if (targetRoom.getlock()) {
					Game.print("You can't enter that locked room");
				}
				else {
					Game.print("You enter your target room");
					currentRoom = targetRoom;
				}
					break;
				case "x":
					Game.print("See ya! hope you had fun.");
					break;
				case "take":
					item = currentRoom.getItem(words[1]);
					Game.print("take" + item);
					Game.print("You went to take the" + words[1]);
					if (item == null) {
						Game.print("There's nothing to take.");
					}
					else {
						currentRoom.removeItem();
						inventory.add(item);
						Game.print("You pick up the "+item.getName());
					}
					break;
				case "i":
					Game.print("You are carrying:");
					for (Items i: inventory) {
						Game.print(i);
					Game.print("");
						//Items item = inventory.getItems();
						//Game.print(description);
					}
					break;
				case "use":
					//item = currentRoom.getItem(words[1]);
					item = returnItem(words[1]);
					Game.print("use" + item);
					Game.print("You used the" + words[1]);
					if (item == null) {
						Game.print("There's nothing to use");
					}
					else {
						item.use();
					}
					break;
				case "open":
					item = currentRoom.getItem(words[1]);
					Game.print("open" + item);
					Game.print("You went to open the" + words[1]);
					if (item == null) {
						Game.print("There's nothing to open.");
					}
				case "look":
					Items object = currentRoom.getItem(words[1]);
					if (object == null) {
						Game.print("There's nothing to look at.");
					}
					else {
						Game.print("");
						Game.print(object.getDesc());
					}
					break;
				case "save":
					saveList("savedata");
					break;
				case "load":
					loadList("savedata");
					
					
				default:
					Game.print("Sorry, I don't know what you mean by that");
			} //switch statement ends here
			
		} while(!command.equals("x"));
	
		input.close();
		
		}
	}