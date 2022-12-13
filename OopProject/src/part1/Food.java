package part1;

public class Food extends Product{
	final static int spicy = 1;
	final static int normal = 2;
	final static int tomato = 3;
	private int sauce;
	
	Food(String foodName, double detail, double price){
		super(foodName, detail, price);
	}
	
	public void addSauce() {
		
	}
	
	public String toString() {
		return getProductName() + "(" + getDetail() + " kcal)"+"-RM" + String.format("%.2f",getPrice());
	}
	
}
