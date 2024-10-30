package Main;
//items for now will be basic, glasses, gloves, keys, whatnot.
public class Items {
	private String description;
	private String names;

	public Items(String desc, String name){
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
	
}