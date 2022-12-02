package part1;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<User>user = new ArrayList<>();
		List<Food>food = new ArrayList<>();
		List<OrderList>orderList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
			JFrame frame = new JFrame();
			frame.setTitle("Food Ordering System");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setSize(1280,720);
			frame.setVisible(true);
			
			ImageIcon image = new ImageIcon("93370412_p0.jpg");
			frame.setIconImage(image.getImage());
		
	}
}
