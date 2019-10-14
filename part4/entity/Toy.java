package entity;

public abstract class Toy {

	private ToyTypes type;
	private double price;
	private ChildsAge childsage;
	private Size size;

	public enum ToyTypes {
		BALL, CUBE, DOLL, TOYCAR
	}

	public enum ChildsAge {
		from0to3, from4to7, from8to18
	}

	public enum Size {
		small, medium, big
	}

	public Toy(ToyTypes type, double price, ChildsAge childsage, Size size) {
		super();
		this.type = type;
		this.price = price;
		this.childsage = childsage;
		this.size = size;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public ToyTypes getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public ChildsAge getChildsage() {
		return childsage;
	}

	public Size getSize() {
		return size;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.type.equals(((Toy) obj).getType())) {
			if (this.price == ((Toy) obj).price && this.size.name() == ((Toy) obj).size.name()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + this.price);
		result = prime * result + this.childsage.hashCode();
		result = prime * result + this.size.hashCode();
		result = prime * result + this.type.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Toy: " + this.getClass().getSimpleName() + " price: " + this.price + " for children: "
				+ this.childsage.name() + " size: " + this.size.name();
	}

}
