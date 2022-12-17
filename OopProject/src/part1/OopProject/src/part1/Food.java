package part1;

public class Food extends Product{
	final static int spicy = 1;
	final static int tomato = 2;
	final static int  normal = 3;
	private int sauce;
	
	Food(String foodName, double detail, double price){
		super(foodName, detail, price);
		this.sauce = normal;
	}
	
	Food(String foodName, double detail, double price, int quantity , int sauce){
		super(foodName, detail, price);
		this.setQuantityInOrder(quantity);
		this.sauce = sauce;
	}
	
	public void setSauce(int sauce) {
		this.sauce = sauce;
	}

	public String getSauce() {
		if(this.sauce == spicy) {
			return "spicy";
		}else if(this.sauce == tomato) {
			return "tomato";
		}else if(this.sauce == normal) {
			return "normal";
		}else {
			return "";
		}
	}
	
	public String toString() {
		return getProductName() + " (" + getSauce() + ")" + " (" + getDetail() + " kcal)"+"-RM" + String.format("%.2f",getPrice());
	}
	
}	
