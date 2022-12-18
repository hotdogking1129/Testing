package part1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderList {
	
	private User user;
	private List<Food> food = new ArrayList<>();
	private List<Drink> drink = new ArrayList<>();
	private String orderTime;
	
	OrderList(User user, Food food, String orderTime){
		this.user = user;
		this.food.add(food);
		this.orderTime = orderTime;
	}
	OrderList(User user, Drink drink, String orderTime){
		this.user = user;
		this.drink.add(drink);
		this.orderTime = orderTime;
	}
	OrderList(User user, Food food , Drink drink, String orderTime){
		this.user = user;
		this.food.add(food);
		this.drink.add(drink);
		this.orderTime = orderTime;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setFood(Food food) {
		this.food.add(food);
	}
	
	public void setDrink(Drink drink) {
		this.drink.add(drink);
	}
	
	public void setFood(List<Food> food) {
		this.food = food;
	}
	
	public void setDrink(List<Drink> drink) {
		this.drink = drink;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	
	public User getUser() {
		return user;
	}
	
	public List<Food> getFood(){
		return food;
	}
	
	public List<Drink> getDrink(){
		return drink;
	}
	
	public int findUser(List<OrderList> orderList, User user) {
		int arrayOfUser = 0,exist =1;
		for(int i = 0; i<orderList.size(); i++) {
			if(user == orderList.get(i).getUser()) {
				arrayOfUser = i;
				exist = 0;
				break;
			}
		}
		return arrayOfUser -exist;
	}
	
	public void setOrderFood(List<OrderList> orderList, User user, Food food) {
		Boolean exist = false,existfood = false;
		int orderListNo = 0,productListNo = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    String strdate = formatter.format(date); 
	    
	    //Check user in order list 
		for(int i = 0; i<orderList.size(); i++) {
			if(user == orderList.get(i).getUser()) {
				exist = true;
				orderListNo = i;
				break;
			}
		}
		if(exist) {
			//Check product in the list
			for(int i = 0; i<orderList.get(orderListNo).food.size(); i++) {
				if(food.getProductName() == orderList.get(orderListNo).getFood().get(i).getProductName() 
						&& food.getSauce() == orderList.get(orderListNo).getFood().get(i).getSauce()) {
					existfood = true;
					productListNo = i;
					break;
				}
			}
			if(existfood) {
				Scanner input = new Scanner(System.in);
				Boolean valid;
				do {
					valid = true;
					System.out.println("Your already order the food, do you want to increase the number of food.(Y/N)");
					String comfirm = input.nextLine();
					if(comfirm.equalsIgnoreCase("y")) {
						this.food.get(productListNo).setQuantityInOrder(this.food.get(productListNo).getQuantityInOrder() + food.getQuantityInOrder() );
					}else if(comfirm.equalsIgnoreCase("n")) {
						
					}else {
						System.out.println("Please enter y or n.");
						valid = false;
					}
				}while(!valid);
				
			}else {
				orderList.get(orderListNo).food.add(food);
			}
			
		}else {
			orderList.add(new OrderList(user, food, strdate));
		}
	}
	
	public void setOrderDrink(List<OrderList> orderList, User user,Drink drink) {
		Boolean exist = false,existdrink= false;
		int orderListNo = 0,productListNo = 0;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    String strdate = formatter.format(date);  
	    
	    //Check user in order list 
		for(int i = 0; i<orderList.size(); i++) {
			if(user == orderList.get(i).getUser()) {
				exist = true;
				orderListNo = i;
				break;
			}
		}
		if(exist) {
			//Check product in the list
			for(int i = 0; i<orderList.get(orderListNo).drink.size(); i++) {
				if(drink.getProductName() == orderList.get(orderListNo).getDrink().get(i).getProductName() 
						&& drink.getHot() == orderList.get(orderListNo).getDrink().get(i).getHot()
							&& drink.getLarge() == orderList.get(orderListNo).getDrink().get(i).getLarge()) {
					existdrink= true;
					productListNo = i;
					break;
				}
			}
			if(existdrink) {
				Scanner input = new Scanner(System.in);
				Boolean valid;
				do {
					valid = true;
					System.out.println("Your already order the drink, do you want to increase the number of drink.(Y/N)");
					String comfirm = input.nextLine();
					if(comfirm.equalsIgnoreCase("y")) {
						this.drink.get(productListNo).setQuantityInOrder(this.drink.get(productListNo).getQuantityInOrder() + drink.getQuantityInOrder() );
					}else if(comfirm.equalsIgnoreCase("n")) {
						
					}else {
						System.out.print("Please enter y or n.");
						valid = false;
					}
				}while(!valid);
			}else {
				orderList.get(orderListNo).drink.add(drink);
			}
			
		}else {
			orderList.add(new OrderList(user, drink, strdate));
		}
	}
	
	public String toFile() {
		String foodString = "", drinkString = "";
		for(int i = 0; i < this.food.size() ; i++) {
			foodString += "@" + this.food.get(i).toFile() + "/" + this.food.get(i).getQuantityInOrder() + "/" + this.food.get(i).getSauce();
		}
		for(int i = 0; i < this.drink.size() ; i++) {
			drinkString += "@" + this.drink.get(i).toFile() + "/" + this.drink.get(i).getQuantityInOrder() + "/" + this.drink.get(i).getHot() + "/" + this.drink.get(i).getLarge();
		}
		
		return user.getNoMatrics() + "#" + foodString + "#" + drinkString + "#" + orderTime; 
	}
}
