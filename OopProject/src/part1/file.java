package part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;	
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class file {

	public static void main(String[] args) throws IOException {
		
		/*
		List<User>user = new ArrayList<>();
		
		user.add(new User("sun","AI210343","1234"));
		user.add(new User("see","AI210334","4321"));
		user.add(new User("edison","AI210408","2314"));
		user.add(new User("MD RASHEDUJJAMAN REZA","AI210045","210045"));
		user.add(new User("MUKHTAR ABDULKARIM SANI","AI210029","2100029"));
		
		List<User>test3 = new ArrayList<>();
		
		File file = null;
		try {
			file = new File("user.txt");
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
				 System.out.println(file.getAbsolutePath());
		      } else {
		        System.out.println("File already exists.");
		      }
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		file.setWritable(true);
		 
		FileWriter userFile = new FileWriter("user.txt");
		for(int i = 0 ; i < user.size() ; i++) {
			userFile.write(user.get(i).toFile() + "\n");
		}
		userFile.close();
		
		//Read part
		Scanner scanner = new Scanner(new File("user.txt"));
		int j = 0;
		while (scanner.hasNextLine()) {
			String a = scanner.nextLine();
			String[] b = a.split("/", 3);
			
			//Input food arrayList
			test3.add(new User("","",""));
			test3.get(j).setName(b[0]);
			test3.get(j).setNoMatrics(b[1]);
			test3.get(j).setPassword(b[2]);
			
			j++;
		}
		*/
		

		
		/*
		List<Food>food = new ArrayList<>();
		List<Drink>drink = new ArrayList<>();
		
		food.add(new Food("Nasi Lemak", 360, 4.50));
		food.add(new Food("Roti canai", 200, 2.00));
		food.add(new Food("Nasi Madu Ayam", 500, 5.00));
		//food.add(new Food("JIJI",300,1.00));
		
		drink.add(new Drink("Milo", 100, 2.00));
		drink.add(new Drink("Sirap", 210, 1.80));
		drink.add(new Drink("Teh O", 120, 1.50));
		drink.add(new Drink("Kopi",180,3.00));
		drink.add(new Drink("Latte",100, 5.00));
		
		List<Food> test1 = new ArrayList<>();
		List<Drink>test2 = new ArrayList<>();
		
		//Create and write file 
		File file = null;
		try {
			file = new File("product.txt");
		      if (file.createNewFile()) {
		        System.out.println("File created: " + file.getName());
				 System.out.println(file.getAbsolutePath());
		      } else {
		        System.out.println("File already exists.");
		      }
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		 
		file.setWritable(true);
		 
		FileWriter foodFile = new FileWriter("product.txt");
		int size = food.size()<drink.size() ? drink.size():food.size() ;
		for(int i = 0 ; i < size ; i++) {
			foodFile.write( (food.size()<=i ? "!":food.get(i).toFile()) + "#" + (drink.size()<= i ? "!":drink.get(i).toFile()) + "\n");
		}
		foodFile.close();
		
		//Read part
		Scanner scanner = new Scanner(new File("product.txt"));
		int j = 0;
		while (scanner.hasNextLine()) {
			String a = scanner.nextLine();
			String[] b = a.split("#",2);
			String[] c = b[0].split("/", 3);
			String[] d = b[1].split("/",3);
			//System.out.println(x);
			//System.out.println(z[0]);
			//System.out.println(z[1]);
			if(c[0].equalsIgnoreCase("!")) {
				//Do nothing
			}else {
				//Input food arrayList
				test1.add(new Food ("",0,0));
				test1.get(j).setProductName(c[0]);
				test1.get(j).setDetail(Double.valueOf(c[1]));
				test1.get(j).setPrice(Double.valueOf(c[2]));
			}
			if(d[0].equalsIgnoreCase("!")) {
				//Do nothing
			}else {
				//Input food arrayList
				test2.add(new Drink("",0,0));
				test2.get(j).setProductName(d[0]);
				test2.get(j).setDetail(Double.valueOf(d[1]));
				test2.get(j).setPrice(Double.valueOf(d[2]));
			}
			j++;
		}
		
		//Printing information
		for(int i = 0 ; i < test1.size() ; i++) {
			System.out.println(test1.get(i).toString());
		}
		System.out.println();
		for(int i = 0 ; i < test2.size() ; i++) {
			System.out.println(test2.get(i).toString());
		}
	}
	*/
	}
}
