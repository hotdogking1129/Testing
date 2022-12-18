package part1;

public class Drink extends Product{
	private Boolean large = false;
	private Boolean hot = true;
	private final double ADD_ICE = 0.50;
	private final double GO_LARGE = 1.50;

	Drink(String productName, double detail, double price){
		super(productName, detail, price);
	}
	
	Drink(String productName, double detail, double price,int quantity, Boolean large, Boolean hot){
		super(productName, detail, price);
		setQuantityInOrder(quantity);
		this.large = large;
		this.hot = hot;
	}
	
	public void goLarge() {
		if(this.large) {
			System.out.println("Your drink is already a large size .");
		}else {
			double x = getPrice()+ GO_LARGE;
			setPrice(x);
			this.large = true;
			System.out.println("Large size of "+ getProductName() +" have been successfully set up.");
		}
	}
	
	public void addIce() {
		if(this.hot) {
			double x = getPrice() + ADD_ICE;
			setPrice(x);
			this.hot = false;
			System.out.println("Cold drinks of "+ getProductName() +" have been successfully set up."   );
		}else {
			System.out.println("Your drink is already a cold drink.");
		}
	}
	
	public String toString() {
		return getProductName() + " (" + (large == true?"Large":"Small") + ", " + (hot == true?"Hot":"Cold") + " )" + " (" + getDetail() + " kcal)"+"-RM" + String.format("%.2f",getPrice());
	}

	public Boolean getLarge() {
		return large;
	}
	
	public Boolean getHot() {
		return hot;
	}

	
}