/*package ds;
import java.util.ArrayList;

	class Node {
		String location;
		ArrayList<Node> next = new ArrayList<>();
		ArrayList<Double> distance = new ArrayList<>();
		ArrayList<String> path = new ArrayList<>();
		ArrayList<Double> total = new ArrayList<>();
		
		Node(String location) {
			this.location = location;
		}
		
		public void addNode(Node node, double distance) {
			this.next.add(node);
			this.distance.add(distance);
		}
		
		public void findPath(Node head, String lastPath, double lastDistance) {
			Node temp = head;
			
			//System.out.println(temp.location);
			
			lastPath += " -> " + temp.location;
			if(temp.next.size() == 0) {
				path.add(lastPath);
				total.add(lastDistance);
				return;
			}else {
				for(int i=0 ; i<temp.next.size() ; i++) {
					lastDistance += temp.distance.get(i);
					if(i>=1) {
						for(int j=0 ; j<temp.next.size()-1 ; j++) {
							lastDistance -= temp.distance.get(j);
						}
					}
					findPath(temp.next.get(i), lastPath, lastDistance);
					
				}
			}
		}
	}

	class Graph {
		Node head;
		Graph(Node node){
			this.head = node; 
		}	
	}

	public class test {

		public static void main(String[] args) {
			Node kl = new Node("KL");
			Node puchong = new Node("Puchong");
			Node paritRaja = new Node("Parit Raja");
			Node singapure = new Node("Singapure");
			
			Graph graph = new Graph(kl);
			
			kl.addNode(paritRaja, 20);
			kl.addNode(puchong, 40);
			puchong.addNode(singapure, 30);
			paritRaja.addNode(puchong,100);
			paritRaja.addNode(singapure, 70);
			
			graph.head.findPath(graph.head,"",0);
			for(int i=0 ; i<graph.head.path.size() ; i++) {
				System.out.println(graph.head.path.get(i) + " = " + graph.head.total.get(i));
			}
		}

	}
	*/

