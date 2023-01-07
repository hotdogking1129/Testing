package ds;

import java.util.ArrayList;

class Node{
	String location;
	ArrayList<Node> next = new ArrayList<>();
	ArrayList<Double> distance = new ArrayList<>();
	ArrayList<String> path = new ArrayList<>();
	ArrayList<Double> total = new ArrayList<>();
	ArrayList<Double> price = new ArrayList<>();
	ArrayList<Double> ticket = new ArrayList<>();
	
	Node(String location) {
		this.location = location;
	}
	
	public void addNode(Node node, double distance, double ticket) {
		this.next.add(node);
		this.distance.add(distance);
		this.ticket.add(ticket);
	}
	
	public void findPath(Node head, String lastPath, double lastDistance,double lastticket) {
			Node temp = head;
			
			if(lastPath.equalsIgnoreCase("")) {
				lastPath += temp.location;
			}else {
				lastPath += " -> " + temp.location;
			}
			if(temp.next.size() == 0) {
				path.add(lastPath);
				total.add(lastDistance);
				price.add(lastticket);
				return;
			}else {
				for(int i=0 ; i<temp.next.size() ; i++) {
					lastDistance += temp.distance.get(i);
					lastticket += temp.ticket.get(i);
					if(i>= 1) {
						lastDistance -= temp.distance.get(i-1);
						lastticket -= temp.ticket.get(i-1);
					}
					findPath(temp.next.get(i), lastPath, lastDistance, lastticket);
					}
			}
		}
	}
	class Graph{
		Node head;
		Graph(Node node){
			this.head = node; 
		}	
		public int minDistance(Node head) {
			int min = 0;
			double minDis = head.total.get(0);
			for(int i=0 ; i<head.total.size() ; i++) {
				if(minDis > head.total.get(i)) {
					minDis = head.total.get(i);
					min = i;
				}
			}
			return min;
		}
	}
	
	public class test2 {

		public static void main(String[] args) {
			Node kl = new Node("KL");
			Node kajang = new Node("Kajang");
			Node paritRaja = new Node("Parit Raja");
			Node singapure = new Node("Singapure");
			Node Nusa = new Node("Nusa Jaya");
			Node jb = new Node("JB");
			
			Graph graph = new Graph(kl);
			
			kl.addNode(paritRaja, 20, 10);
			kl.addNode(kajang, 40, 20);
			kajang.addNode(Nusa, 30, 15);
			paritRaja.addNode(kajang,100, 50);
			Nusa.addNode(jb,180, 90);
			paritRaja.addNode(singapure, 70, 35);
			paritRaja.addNode(singapure,50, 25);
			jb.addNode(singapure, 100, 50);
			
			long startTime = System.nanoTime();
			
			graph.head.findPath(graph.head,"",0,0);
			
	        long elapsedTime = System.nanoTime() - startTime;
	        System.out.println("Time Execution:" + Float.valueOf(elapsedTime)/1000000 + "sec" );
		
	        System.out.println("Distance(km) \tPrice(RM) \tPath");
	        System.out.println("-------------------------------------------------------------");
	        
			for(int i=0 ; i<graph.head.path.size() ; i++) {
					System.out.println( graph.head.total.get(i) + " \t\t" + graph.head.price.get(i) + "\t\t" + graph.head.path.get(i) );
			}
			
		}
	}

