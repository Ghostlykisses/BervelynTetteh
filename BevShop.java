import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface{
	private int numOfAlcoholDrinksInOrder;
	private ArrayList<Order> orders;
	private Order currentOrder;
	
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		return time >= MIN_TIME && time <= MAX_TIME;
	}
	
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}
	
	@Override
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrinksInOrder;
	}
	
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNumber() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		currentOrder = new Order(time, day, customer);
		orders.add(currentOrder);
		numOfAlcoholDrinksInOrder = 0;
	}
	
	@Override 
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean proteinPowder) {
		if(!isMaxFruit(numOfFruits))
			currentOrder.addNewBeverage(bevName, size, numOfFruits, proteinPowder);
	}
	
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		if(isEligibleForMore() && isValidAge(currentOrder.getCustomer().getAge())) {
			currentOrder.addNewBeverage(bevName, size);
			numOfAlcoholDrinksInOrder++;
		}
	}
	
	@Override
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	public boolean isEligibleForMore() {
		return numOfAlcoholDrinksInOrder < MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override
	public double totalOrderPrice(int orderNo) {
		int index = findOrder(orderNo);
		if(index == -1)
			return 0;
		
		double total = 0;
		for(Beverage b : orders.get(index).getBeverages()) {
			total += b.calcPrice();
		}
		return total;
	}
	
	@Override
	public double totalMonthlySale() {
		double total = 0;
		for(Order o : orders) {
			for(Beverage b : o.getBeverages()) {
				total += b.calcPrice();
			}
		}
		
		return total;
	}
	
	@Override
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	@Override
	public void sortOrders() {
		for(int i = 0; i < orders.size() - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).compareTo(orders.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				Collections.swap(orders, i, minIndex);
			}
		}
	}
	
	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Order o : orders) {
			sb.append(o.toString()).append("\n");
		}
		sb.append("Total Monthly Sale: $").append(String.format("%.2f", totalMonthlySale()));
		return sb.toString();
	}
}
