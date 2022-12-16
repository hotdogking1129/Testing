package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	
import java.util.ArrayList;
import java.util.List;

public class file {

	public static void main(String[] args) throws IOException {
		List<Food>food = new ArrayList<>();
		
		food.add(new Food("Nasi Lemak", 360, 4.50));
		food.add(new Food("Roti canai", 200, 2.00));
		food.add(new Food("Nasi Madu Ayam", 500, 5.00));
		
		File file = null;
		
		try {
			file = new File("test1.txt");
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
				 System.out.println(file.getAbsolutePath());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 file.setWritable(true);
		 
		 FileWriter foodFile = new FileWriter("test1.txt");
		 foodFile.write("Dunno");
		 foodFile.close();
		 
	}

}
