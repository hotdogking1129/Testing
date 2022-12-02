package part1;
import java.util.ArrayList;
import java.util.List;

public class OrderList {
	User user;
	List<Food> food = new ArrayList<>();
	OrderList(User user, Food food){
		this.user = user;
		this.food.add(food);
	}
}
