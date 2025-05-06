public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean proteinPowder;
	
	private final double PROTEIN_POWDER_COST = 1.5;
	private final double FRUIT_COST = .5;
	
	public Smoothie(String name, Size size, int numOfFruits, boolean proteinPowder) {
		super(name, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.proteinPowder = proteinPowder;
	}
	
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		price += FRUIT_COST * numOfFruits;
		if(proteinPowder)
			price += PROTEIN_POWDER_COST;
		return price;
	}
	
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public void setProteinPowder(boolean proteinPowder) {
		this.proteinPowder = proteinPowder;
	}
	
	public boolean hasProteinPowder() {
		return proteinPowder;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o))
			return false;
		if(!(o instanceof Smoothie))
			return false;
		
		Smoothie other = (Smoothie) o;
		return this.numOfFruits == other.numOfFruits && this.proteinPowder == other.proteinPowder;
		
	}
	
	@Override
	public String toString() {
		return super.toString() +", Protein Powder: " + (proteinPowder ? "Yes" : "No") + ", Number Of Fruits: " + numOfFruits + ", Price: $" + String.format("%.2f", calcPrice());
	}
}
