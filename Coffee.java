public class Coffee extends Beverage{
	private boolean extraShot;
	private final double SHOT_PRICE = .5;
	
	private boolean extraSyrup;
	private final double SYRUP_PRICE = .5;
	
	public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
		super(name, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if(extraShot)
			price += SHOT_PRICE;
		if(extraSyrup)
			price += SYRUP_PRICE;
		return price;
	}
	
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}
	
	public boolean hasExtraShot() {
		return extraShot;
	}
	
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}
	
	public boolean hasExtraSyrup() {
		return extraSyrup;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o))
			return false;
		if(!(o instanceof Coffee))
			return false;
		
		Coffee other = (Coffee) o;
		return this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
		
	}
	
	@Override
	public String toString() {
		return super.toString() +", Extra Shot: " + (extraShot ? "Yes" : "No") + ", Extra Syrup: " + (extraSyrup ? "Yes" : "No") + ", Price: $" + String.format("%.2f", calcPrice());
	}
}
