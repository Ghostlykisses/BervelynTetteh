/*
 * Class: CMSC203 30124
 * Instructor: Ashique Tanveer
 * Description: Make a beverage shop app that takes the users order allowing them to add some modifications to 
 * certain drinks and be able to display various info about their order
 * Due: 05/6/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Bervelyn Tetteh
*/


import java.util.Scanner;
public class BevShopDriverApp {

	public static void main(String[] args) {
		BevShop shop = new BevShop();
		Scanner scan = new Scanner(System.in);
		
		//Info sentences
		System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());
		
		//Customer info gathering
		boolean continuing = true;
		
		while(continuing) {
			System.out.println("\nStart please a new order:");
            System.out.print("Would you please enter your name: ");
            String name = scan.nextLine();

            System.out.print("Would you please enter your age: ");
            int age = scan.nextInt();
            scan.nextLine(); // Consume newline

            System.out.print("Enter the order time (0-23): ");
            int time = scan.nextInt();
            scan.nextLine(); // Consume newline

            System.out.print("Enter the order day (e.g., MONDAY): ");
            String dayInput = scan.nextLine().toUpperCase();
            Day day = Day.valueOf(dayInput);

            shop.startNewOrder(time, day, name, age);

            System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());

            if (age >= shop.getMinAgeForAlcohol()) {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            } else {
                System.out.println("Your Age is not appropriate for alcohol drink!!");
            }

            boolean addMore = true;
            while (addMore) {
                System.out.println("\nWould you please add a drink? (yes/no)");
                String addDrink = scan.nextLine().toLowerCase();
                if (addDrink.equals("no")) break;

                System.out.println("Enter drink type (COFFEE, ALCOHOL, SMOOTHIE): ");
                String typeInput = scan.nextLine().toUpperCase();
                Type type = Type.valueOf(typeInput);

                if (type == Type.ALCOHOL && age < shop.getMinAgeForAlcohol()) {
                    System.out.println("Your Age is not appropriate for alcohol drink!!");
                    continue;
                }

                System.out.print("Enter drink name: ");
                String drinkName = scan.nextLine();

                System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                Size size = Size.valueOf(scan.nextLine().toUpperCase());

                if (type == Type.COFFEE) {
                    System.out.print("Add extra shot? (true/false): ");
                    boolean extraShot = scan.nextBoolean();
                    System.out.print("Add extra syrup? (true/false): ");
                    boolean extraSyrup = scan.nextBoolean();
                    scan.nextLine(); // Consume newline
                    shop.processCoffeeOrder(drinkName, size, extraShot, extraSyrup);
                } 
                else if (type == Type.SMOOTHIE) {
                    System.out.print("Enter number of fruits: ");
                    int numOfFruits = scan.nextInt();
                    System.out.print("Add protein? (true/false): ");
                    boolean addProtein = scan.nextBoolean();
                    scan.nextLine(); // Consume newline
                    shop.processSmoothieOrder(drinkName, size, numOfFruits, addProtein);

                    if (numOfFruits > 5) {
                        System.out.println("You reached a Maximum number of fruits");
                    }
                } 
                else if (type == Type.ALCOHOL) {
                    if (shop.isEligibleForMore()) {
                        shop.processAlcoholOrder(drinkName, size);
                        if (!shop.isEligibleForMore()) {
                            System.out.println("You have a maximum alcohol drinks for this order");
                        }
                    } else {
                        System.out.println("You have a maximum alcohol drinks for this order");
                    }
                }

                System.out.println("The current order of drinks is " + shop.getCurrentOrder().getBeverages().size());
                System.out.println("The Total price on the Order: " + shop.getCurrentOrder().calcOrderTotal());
            }

            System.out.println("#------------------------------------#");
            System.out.println("Total price on this Order: " + shop.getCurrentOrder().calcOrderTotal());

            System.out.println("\nWould you like to start a new order? (yes/no)");
            String newOrder = scan.nextLine().toLowerCase();
            if (newOrder.equals("no"))
                continuing = false;
		}
		System.out.println("\nTotal amount for all Orders: " + shop.totalMonthlySale());
		System.exit(0);

	}

}
