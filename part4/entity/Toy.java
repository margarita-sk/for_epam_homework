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
		small, medium, big
	}

	public Toy() {
		super();
	}

	public Toy(double price, ChildsAge childsage, Size size) {
		super();
		this.price = price;
		this.childsage = childsage;
		this.size = size;
	}

	public Toy(double price, Size size) {
		super();
		this.price = price;
		this.size = size;
	}

	@Override
	public boolean equals(Object obj) {
		Toy toy;
		if (obj.getClass().getGenericSuperclass().toString().equals("class entity.Toy")) {
			toy = (Toy) obj;
			if (this.price == toy.price && this.size.name() == toy.size.name()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Toy: " + this.getClass().getSimpleName() + " price: " + this.price + " for children: "
				+ this.childsage.name() + " size: " + this.size.name();
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
