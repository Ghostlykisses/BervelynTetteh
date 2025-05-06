public abstract class Beverage {
	private String name;
	private Type type;
	private Size size;
	
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_PRICE = .5;
	
	public double addSizePrice() {
		switch (size) {
			case LARGE:
				return BASE_PRICE + (SIZE_PRICE*2);
			case MEDIUM:
				return BASE_PRICE + SIZE_PRICE;
			case SMALL:
			default:
				return BASE_PRICE;
		}
	}
	
	public Beverage(String name, Type type, Size size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}
	
	public abstract double calcPrice();
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Beverage))
			return false;
		
		Beverage other = (Beverage) o;
		return name.equals(other.name) && type == other.type && size == other.size;
	}
	
	@Override
	public String toString() {
		return name + ", " + size;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public Size getSize() {
		return size;
	}
	

}
