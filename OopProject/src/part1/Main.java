package part1;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main {
		
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		
		List<User>user = new ArrayList<>();
		List<Food>food = new ArrayList<>();
		List<Drink>drink = new ArrayList<>();
		List<OrderList>orderList = new ArrayList<>();
		
		/*
		food.add(new Food("Nasi Lemak", 360, 4.50));
		food.add(new Food("Roti canai", 200, 2.00));
		food.add(new Food("Nasi Madu Ayam", 500, 5.00));
		
		drink.add(new Drink("Milo", 100, 2.00));
		drink.add(new Drink("Sirap", 210, 1.80));
		drink.add(new Drink("Teh O", 120, 1.50));
		*/
		
		//Read product from the file
		Scanner readFile = new Scanner(new File("product.txt"));
		int fileloop = 0;
		while (readFile.hasNextLine()) {
			String a = readFile.nextLine();
			String[] b = a.split("#",2);
			String[] c = b[0].split("/", 3);
			String[] d = b[1].split("/",3);
			if(c[0].equalsIgnoreCase("!")) {
				//Do nothing
			}else {
				//Input food arrayList
				food.add(new Food ("",0,0));
				food.get(fileloop).setProductName(c[0]);
				food.get(fileloop).setDetail(Double.valueOf(c[1]));
				food.get(fileloop).setPrice(Double.valueOf(c[2]));
			}
			if(d[0].equalsIgnoreCase("!")) {
				//Do nothing
			}else {
				//Input food arrayList
				drink.add(new Drink("",0,0));
				drink.get(fileloop).setProductName(d[0]);
				drink.get(fileloop).setDetail(Double.valueOf(d[1]));
				drink.get(fileloop).setPrice(Double.valueOf(d[2]));
			}
			fileloop++;
		}
		
		/*
		user.add(new User("sun","AI210343","1234"));
		user.add(new User("see","AI210334","4321"));
		user.add(new User("edison","AI210408","2314"));
		*/
		
		//Read part
		Scanner readUserFile = new Scanner(new File("user.txt"));
		fileloop = 0;
		while (readUserFile.hasNextLine()) {
			String a = readUserFile.nextLine();
			String[] b = a.split("/", 3);
			
			//Input food arrayList
			user.add(new User("","",""));
			user.get(fileloop).setName(b[0]);
			user.get(fileloop).setNoMatrics(b[1]);
			
			// now convert the string to byte array
            // for decryption
            byte[] bb = new byte[b[2].length()];
            for (int i=0; i<b[2].length(); i++) {
                bb[i] = (byte) b[2].charAt(i);
            }
            String password = "";
            try {
	            // decrypt the text
	            String key = "Bar12345Bar12345";
	            SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.DECRYPT_MODE, aesKey);
	            password = new String(cipher.doFinal(bb));
            }catch (Exception e) {
            	e.printStackTrace();
            }
			
			user.get(fileloop).setPassword(password);
			
			fileloop++;
		}
		
		
		
		Scanner scanner = new Scanner(System.in);
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
		Thread.sleep(1500);
		for (int i = 0; i < 50; ++i) System.out.println();
		//Menu
		int option = 0;
		do {
			
			do {
				
				System.out.println("------------Food Ordering System-------------");
				System.out.println("|1)Order Food                               |");
				System.out.println("|2)Order Drink                              |");
				System.out.println("|3)View Order                               |");
				System.out.println("|4)Cancel Order                             |");
				System.out.println("|5)Exit                                     |");
				System.out.println("---------------------------------------------");
				
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
				//Add food
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
				
				//Add Sauce
				int sauce = 3;
				do {
					Scanner input = new Scanner(System.in);
					System.out.println("--------------------Sauce--------------------");
					System.out.println("1) Chili ");
					System.out.println("2) Tomato ");
					System.out.println("3) No Sauce ");
					do {
						System.out.println("Enter the sauce that your want to add:");
						try {
							sauce = input.nextInt();
							valid = true;
						}catch (InputMismatchException e) {
							System.out.println("Please enter a number of the sauce that you want !!!");
							valid = false;
						}
						if(sauce <1 || sauce >3) {
							System.out.println("Your should input number from 1-3");
						}
					}while(sauce<1 || sauce >3);
				}while (!valid);
				foodOrder.setSauce(sauce);
				
				//Add quantity
				System.out.println("Enter the quantity of food you want");
				int numberOfFood = scanner.nextInt();
				foodOrder.setQuantityInOrder(numberOfFood);
				
				//Set date
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date(); 
			    
			    //Input ordered food in to orderList
				if(orderList.size() == 0) {
					orderList.add(new OrderList(userLogin, foodOrder, date));
				}else {
					orderList.get(0).setOrderFood(orderList, userLogin, foodOrder);
				}
				break;
				
				
			case 2:
				
				//Add drink
				do {
					Scanner input = new Scanner(System.in);
					System.out.println("--------------------Drink LIST--------------------");
					for(int i = 0; i<drink.size();i++) {
						System.out.println(i+1 + ") " + drink.get(i).toString());
					}
					System.out.println("-------------------------------------------------");
					
						num = 0;
					try {
						System.out.println("Enter the type of drink you want");
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
				Drink drinkOrder = new Drink(drink.get(num-1).getProductName(),drink.get(num-1).getDetail(),drink.get(num-1).getPrice());
				
				//Set size for drink
				String size = "";
				do {
					valid = true;
					Scanner input = new Scanner(System.in);
					System.out.println("Did you want to go-Large the drink? (Y/N)");
					size = input.nextLine();
					if(size.equalsIgnoreCase("y")) {
						drinkOrder.goLarge();
						drinkOrder.setDetail(drinkOrder.getDetail()*2);
					}else if(size.equalsIgnoreCase("n")) {
						
					}else {
						System.out.println("Please enter y or n.");
						valid = false;
					}
				}while(!valid);
				
				//Set status for drink
				String hot = "";
				do {
					valid = true;
					Scanner input = new Scanner(System.in);
					System.out.println("Did you want to order a cold drink? (Y/N)");
					hot = input.nextLine();
					if(hot.equalsIgnoreCase("y")) {
						drinkOrder.addIce();
					}else if(hot.equalsIgnoreCase("n")) {
						
					}else {
						System.out.println("Please enter y or n.");
						valid = false;
					}
				}while(!valid);
				
				System.out.println("Enter the quantity of drink you want");
				int numberOfdrink = scanner.nextInt();
				drinkOrder.setQuantityInOrder(numberOfdrink);
				date = new Date(); 
				if(orderList.size() == 0) {
					orderList.add(new OrderList(userLogin, drinkOrder, date));
				}else {
					orderList.get(0).setOrderDrink(orderList, userLogin, drinkOrder);
				}
				break;
				
				
			case 3:
				
				if(orderList.size()==0) {
					System.out.println("You have no order anything.");
				}else {
					double calories = 0, price = 0;
					int numArrayListUser = orderList.get(0).findUser(orderList, userLogin);
					if(orderList.get(numArrayListUser).getFood().size() != 0) {
						System.out.println("---------------Food---------------");
					}
					for(int i = 0 ; i < orderList.get(numArrayListUser).getFood().size() ; i++) {
						System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getFood().get(i) + " --- " + orderList.get(numArrayListUser).getFood().get(i).getQuantityInOrder() );
						calories += orderList.get(numArrayListUser).getFood().get(i).getDetail() * orderList.get(numArrayListUser).getFood().get(i).getQuantityInOrder();
						price += orderList.get(numArrayListUser).getFood().get(i).getPrice() * orderList.get(numArrayListUser).getFood().get(i).getQuantityInOrder();
					}
					if(orderList.get(numArrayListUser).getDrink().size() != 0) {
						System.out.println("---------------Drink--------------");
					}
					for(int i = 0; i<orderList.get(numArrayListUser).getDrink().size();i++) {
						System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getDrink().get(i) + " --- " + orderList.get(numArrayListUser).getDrink().get(i).getQuantityInOrder());
						calories += orderList.get(numArrayListUser).getDrink().get(i).getDetail() * orderList.get(numArrayListUser).getDrink().get(i).getQuantityInOrder();
						price += orderList.get(numArrayListUser).getDrink().get(i).getPrice() * orderList.get(numArrayListUser).getDrink().get(i).getQuantityInOrder();
					}
					System.out.println("------------------------------");
					System.out.println("Total calories: " + calories + "kcal");
					System.out.println("Total price: RM" + String.format("%.2f", price));
					System.out.println("\nEnter any key to continue...");
					scanner.next();
				}
				break;
				
				
			case 4:
				if(orderList.size()==0) {
					System.out.println("You have no order anything.");
				}else {
					int cancel = 0;
					do {
						System.out.println("---------------Cancel order---------------");
						System.out.println("1) Cancel all order");
						System.out.println("2) Cancel a order");
						System.out.println("3) Exit");
						System.out.println("------------------------------------------");
						do {
							try {
								Scanner input = new Scanner(System.in);
								System.out.println("Enter the number of option you want:");
								cancel = input.nextInt();
								valid = true;
							}catch (InputMismatchException e) {
								System.out.println("!!! Please enter a number !!!");
								valid = false;
							}
						}while(!valid);
						
						if(cancel == 1) {
							String comfirm = "";
							do {
								try {
								System.out.println("Are you sure to remove all order.(Y/N)");
								Scanner input = new Scanner(System.in);
								comfirm = input.nextLine();
								if(comfirm.equalsIgnoreCase("y")) {
									orderList.remove(orderList.get(0).findUser(orderList, userLogin));
								}else if(comfirm.equalsIgnoreCase("n")) {
									
								}else {
									System.out.print("Please enter y or n.");
									valid = false;
								}
								valid = true;
								}catch (InputMismatchException e) {
									System.out.println("!!! Please enter a number !!!");
									valid = false;
								}
							}while(!valid);
							break;
							
						}else if(cancel == 2) {
						
							int numArrayListUser = orderList.get(0).findUser(orderList, userLogin);
							System.out.println("---------------OrderList---------------");
							for(int i = 0 ; i < orderList.get(numArrayListUser).getFood().size() ; i++) {
								System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getFood().get(i) + " --- " + orderList.get(numArrayListUser).getFood().get(i).getQuantityInOrder());
							}
							for(int i = orderList.get(numArrayListUser).getFood().size(); i<orderList.get(numArrayListUser).getFood().size() + orderList.get(numArrayListUser).getDrink().size(); i++) {
								System.out.println( i+1+ ")" + orderList.get(numArrayListUser).getDrink().get(i - orderList.get(numArrayListUser).getFood().size()) + " --- " + orderList.get(numArrayListUser).getDrink().get(i - orderList.get(numArrayListUser).getFood().size()).getQuantityInOrder() );
							}
							System.out.println("---------------------------------------");
							int cancelOrder = 0;
							do {
								try {
									Scanner input = new Scanner(System.in);
									System.out.println("Enter the list that you want to delete:");
									cancelOrder = input.nextInt();
									valid = true;
									break;
								}catch (InputMismatchException e) {
									System.out.println("!!! Please enter a number !!!");
									valid = false;
								}
							}while(!valid);
							if(cancelOrder<= orderList.get(numArrayListUser).getFood().size() && orderList.get(numArrayListUser).getFood().size() != 0) {
								orderList.get(numArrayListUser).getFood().remove(cancelOrder -1);
							}else if(cancelOrder <= orderList.get(numArrayListUser).getFood().size() + orderList.get(numArrayListUser).getDrink().size()) {
								orderList.get(numArrayListUser).getDrink().remove(cancelOrder - orderList.get(numArrayListUser).getFood().size() -1);
							}
							if(orderList.get(numArrayListUser).getFood().size() == 0 && orderList.get(numArrayListUser).getDrink().size() == 0 ){
								orderList.remove(orderList.get(0).findUser(orderList, userLogin));
							}
							break;
							
						}else if(cancel == 3){
						}else {
							System.out.println("Enter your should input number from 1-3");
						}
					}while(cancel != 3);
				}
				
				break;
				
				
			case 5:
				System.out.println("End");
				break;
				
				
			default: 
				System.out.println("Your should input number from 1-7.");
			}
			
			
		}while(option != 5);
		
		}while(true);
		
	}
}
