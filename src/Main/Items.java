package Main;
//items for now will be basic, glasses, gloves, keys, whatnot.
public class Items {
	private String description;
	private String names;

	public Items(String name, String desc){
		description = desc;
		names = name;
	}
	public String toString() {
		return  names;
	}
	
	public String getName() {
		return names;
	}
	
	public String getDesc() {
		return description;
	}
	
	public void open() {
		Game.print("You can't open that!");
	}
	
	public void use() {
		Game.print("You can't use that!");
	}
	
	
}