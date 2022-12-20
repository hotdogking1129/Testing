package part1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MyFrame extends JFrame {
	
	static JPanel panel;
	
	public MyFrame(List<Food> product){
		
		JButton[] buttons = new JButton[product.size()];
		panel=new JPanel(new FlowLayout(3));
		this.setSize(1280,720);
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(product.get(i).toString());
			buttons[i].setSize(300, 300);
			buttons[i].setActionCommand(String.valueOf(i));
			buttons[i].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				/*
				JFrame frame = new JFrame();
				JLabel label = new JLabel();
				label.setText(product.get(Integer.valueOf(e.getActionCommand())).toString());
				label.setSize(300,400);
				label.setVisible(true);
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.CENTER);
				label.setFont(new Font("MV Boli",Font.PLAIN,180));
				frame.add(label);
				frame.setVisible(true);
			  	*/
			  }
			});
			panel.add(buttons[i]);
		}
		
	}	
	
	public static void main(String[] args) {
		
		List<Food> food = new ArrayList<>();

		food.add(new Food("Nasi Lemak", 360, 4.50));
		food.add(new Food("Roti canai", 200, 2.00));
		food.add(new Food("Nasi Madu Ayam", 500, 5.00));
		
		MyFrame frame = new MyFrame(food);
		frame.add(panel);
		frame.setVisible(true);
	}
}
