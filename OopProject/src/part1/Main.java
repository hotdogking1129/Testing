package part1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) throws InterruptedException {
		
		List<User>user = new ArrayList<>();
		List<Food>food = new ArrayList<>();
		List<Drink>drink = new ArrayList<>();
		List<OrderList>orderList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		food.add(new Food("Nasi Lemak", 360, 4.50));
		food.add(new Food("Roti canai", 200, 2.00));
		food.add(new Food("Nasi Madu Ayam", 500, 5.00));
		
		drink.add(new Drink("Milo", 100, 2.00));
		drink.add(new Drink("Sirap", 210, 1.80));
		drink.add(new Drink("Teh O", 120, 1.50));
		
		user.add(new User("sun","AI210343","1234"));
		user.add(new User("see","AI210334","4321"));
		user.add(new User("edison","AI210408","2314"));

		String name,noMatrics,password = "";
		User userLogin;
		
		Boolean valid = true;
		do {
			userLogin = null;
		//Login
		do{
			System.out.println("------Login page------");
			
			//Check validity
			do {
				noMatrics = "";
				try {
					System.out.println("Enter your No Matrics:");
					noMatrics = scanner.nextLine();
				}catch (InputMismatchException e) {
					System.out.println("!!! Please enter a nombor matircs !!!");
				}
			}while(noMatrics == "");
			
			int i;
			password = "";
			
			for(i=0; i<user.size(); i++){
				if(user.get(i).getNoMatrics().equalsIgnoreCase(noMatrics)){
					
					//Check validity
					do {
						try {
							password = "";
							System.out.println("Enter your password:");
							password = scanner.nextLine();
						}catch(InputMismatchException e) {
							System.out.println("!!! Please enter valid password !!!");
						}
					}while(password == "");
					
					if(user.get(i).getPassword().equalsIgnoreCase(password)){
						userLogin = user.get(i);
						System.out.println("Succesful login...");
						break;
					}else{
						System.out.println("!!! Password Incorrect !!!");
						Thread.sleep(1000);
						for (int j = 0; j < 50; ++j) System.out.println();
						break;
					}
				}
			}
			if(password == "") {
				System.out.println("The user is not found");
				Thread.sleep(1000);
				for (int j = 0; j < 50; ++j) System.out.println();
			}
		}while(userLogin == null);
		
		System.out.println("Welcome "+userLogin.getName().toUpperCase());
		Thread.sleep(500);
		//Menu
		int option = 0;
		do {
			
			do {
				Thread.sleep(1000);
				for (int i = 0; i < 50; ++i) System.out.println();
				System.out.println("------------Food Ordering System------------");
				System.out.println("|1)Order Food                               |");
				System.out.println("|2)Order Drink                              |");
				System.out.println("|3)View Order                               |");
				System.out.println("|4)Cancel Order                             |");
				System.out.println("|5)Exit                                     |");
				System.out.println("--------------------------------------------");
				
				option = 0;
				//Check validity
				try {
					Scanner input = new Scanner(System.in);
					System.out.println("Enter the number of menu you want:");
					option = input.nextInt();
					valid = true;
				}catch (InputMismatchException e) {
					System.out.println("!!! Please enter a number !!!");
					valid = false;
				}
			}while(!valid);
			
			switch(option) {
			case 1: 
				int num = 0;

				do {
					Scanner input = new Scanner(System.in);
					System.out.println("--------------------FOOD LIST--------------------");
					for(int i = 0; i<food.size();i++) {
						System.out.println(i+1 + ") " + food.get(i).toString());
					}
					System.out.println("-------------------------------------------------");
					
						num = 0;
					try {
						System.out.println("Enter the type of food you want.");
						num = input.nextInt();
					}catch (InputMismatchException e) {
						System.out.println("!!! Please enter a number !!!");
						Thread.sleep(1000);
						for (int j = 0; j < 50; ++j) System.out.println();
					}
					if(num<0 || num>food.size()+1) {
						System.out.println("The choice was no found.");
						Thread.sleep(1000);
					}
				}while(num<=0 || num>food.size()+1);
				
				Food foodOrder = new Food(food.get(num-1).getProductName(),food.get(num-1).getDetail(),food.get(num-1).getPrice());
				System.out.println("Enter the quantity of food you want");
				int numberOfFood = scanner.nextInt();
				foodOrder.setQuantityInOrder(numberOfFood);
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date(); 
				if(orderList.size() == 0) {
					orderList.add(new OrderList(userLogin, foodOrder, date));
				}else {
					orderList.get(0).setOrderFood(orderList, userLogin, foodOrder);
				}
				
				break;
			case 2:

				do {
					Scanner input = new Scanner(System.in);
					System.out.println("--------------------Drink LIST--------------------");
					for(int i = 0; i<drink.size();i++) {
						System.out.println(i+1 + ") " + drink.get(i).toString());
					}
					System.out.println("-------------------------------------------------");
					
						num = 0;
					try {
						System.out.println("Enter the type of drink you want.");
						num = input.nextInt();
					}catch (InputMismatchException e) {
						System.out.println("!!! Please enter a number !!!");
						Thread.sleep(1000);
						for (int j = 0; j < 50; ++j) System.out.println();
					}
					if(num<0 || num>drink.size()+1) {
						System.out.println("The choice was no found.");
						Thread.sleep(1000);
					}
				}while(num<=0 || num>drink.size()+1);
				
				date = new Date(); 
				Drink drinkOrder = new Drink(drink.get(num-1).getProductName(),drink.get(num-1).getDetail(),drink.get(num-1).getPrice());
				System.out.println("Enter the quantity of drink you want");
				int numberOfdrink = scanner.nextInt();
				drinkOrder.setQuantityInOrder(numberOfdrink);
				
				if(orderList.size() == 0) {
					orderList.add(new OrderList(userLogin, drinkOrder, date));
				}else {
					orderList.get(0).setOrderDrink(orderList, userLogin, drinkOrder);
				}
				
				break;
			case 3:
				
				int numArrayListUser = orderList.get(0).findUser(orderList, userLogin);
				System.out.println("---------------Food---------------");
				for(int i = 0 ; i < orderList.get(numArrayListUser).getFood().size() ; i++) {
					System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getFood().get(i) );
				}
				System.out.println("---------------Drink--------------");
				for(int i = 0; i<orderList.get(numArrayListUser).getDrink().size();i++) {
					System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getDrink().get(i) );
				}
				scanner.next();
				
				break;
			case 4:
				
				break;
			case 5:
				System.out.println("End");
				break;
			default: 
				System.out.println("Enter your should input number form 1-7.");
			}
			
			
		}while(option != 5);
		
		}while(true);
		
	}
}
