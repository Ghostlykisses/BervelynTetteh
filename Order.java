import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	private static final int MIN_ORDER_NUM = 10000;
	private static final int MAX_ORDER_NUM = 90000;
	
	public int orderNumGen() {
		Random rand = new Random();
		return rand.nextInt(MAX_ORDER_NUM - MIN_ORDER_NUM + 1) + MIN_ORDER_NUM;
	}
	
	public Order(int orderTime, Day orderDay, Customer customer) {
		this.orderNumber = orderNumGen();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = new Customer(customer);
		this.beverages = new ArrayList<>();
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean proteinPowder) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, proteinPowder));
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean isWeekend = (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
		beverages.add(new Alcohol(bevName, size, isWeekend));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order: ").append(orderNumber)
		.append(", Time: ").append(orderTime)
		.append(", Day: ").append(orderDay)
		.append(", Customer: ").append(customer.getName())
		.append(", Age: ").append(customer.getAge())
		.append("\nBeverages:\n");
		
		for(Beverage b : beverages) {
			sb.append(" - ").append(b.toString()).append("\n");
		}
		
		return sb.toString();
	}
	
	@Override
	public int compareTo(Order other) {
		return Integer.compare(this.orderNumber, other.orderNumber);
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = new Customer(customer);
	}
	
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	public ArrayList<Beverage> getBeverages(){
		return beverages;
	}
	
	@Override
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage b : beverages) {
			total += b.calcPrice();
		}
		return total;
	}
	
	@Override
	public boolean isWeekend() {
		return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	}
	
	@Override
	public Beverage getBeverage(int itemNo) {
		if(itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}
		return null;
	}
	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for(Beverage b : beverages) {
			if(b.getType() == type) {
				count ++;
			}
		}
		return count;
	}

	public int getTotalItems() {
		return beverages.size();
	}
}
