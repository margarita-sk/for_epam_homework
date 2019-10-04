package entity;

public abstract class Toy {

	private String name;
	private double price;
	private ChildsAge childsage;
	private Size size;

	public enum ChildsAge {
		from0to3, from4to7, from8to18
	}

	public enum Size {
		BIG, SMALL, MEDIUM
	}

	public ChildsAge getChildsage() {
		return childsage;
	}

	public void setChildsage(ChildsAge childsage) {
		this.childsage = childsage;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
