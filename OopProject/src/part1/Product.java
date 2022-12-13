package part1;

public class Product {
	private String productName;
	private double detail;
	private double price;
	private int quantityInOrder;
	
	Product(String productName, double detail, double price){
		setProductName(productName);
		setDetail(detail);
		setPrice(price);
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public void setDetail(double detail){
		this.detail = detail;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setQuantityInOrder(int quantityInOrder){
		this.quantityInOrder = quantityInOrder;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getDetail() {
		return detail;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantityInOrder(){
		return quantityInOrder;
	}
	
}