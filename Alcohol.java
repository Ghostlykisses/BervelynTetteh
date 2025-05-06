public class Alcohol extends Beverage{
	private boolean isWeekend;
	private final double WEEKEND_COST = .60;
	
	public Alcohol(String name, Size size, boolean isWeekend) {
		super(name, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if(isWeekend)
			price += WEEKEND_COST;
		return price;
	}
	
	public void setIsWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	
	public boolean getIsWeekend() {
		return isWeekend;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o))
			return false;
		if(!(o instanceof Alcohol))
			return false;
		
		Alcohol other = (Alcohol) o;
		return this.isWeekend == other.isWeekend;
		
	}
	
	@Override
	public String toString() {
		return super.toString() +", Weekend: " + (isWeekend ? "Yes" : "No") + ", Price: $" + String.format("%.2f", calcPrice());
	}

}
