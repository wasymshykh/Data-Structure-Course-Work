
public class Linked {
	
	Node head;
	
	Linked(){
		head = null;
	}
	
	public void insert(int data) {
		
		Node node = new Node();
		node.data = data;
		
		if(head == null) {
			head = node;
			head.next = node;
			head.previous = node;
		}else {
			Node temp = head;
			while(temp.next != head) {
				temp = temp.next;
			}
			node.next = head;
			head.previous = node;
			node.previous = temp;
			temp.next = node;
		}
		
	}
	
	public void insertAt(int data, int index) {
		
		if(index > -1) {
			if(index == 0) {
				Node node = new Node();
				node.data = data;
				
				Node temp = head;
				while(temp.next != head) {
					temp = temp.next;
				}
				temp.next = node;
				node.next = head;
				node.previous = temp;
				head = node;
				
			} else {
				
				int counter = 1;
				Node temp = head;
				
				while(temp.next != head && counter < index) {
					temp = temp.next;
					counter++;
				}
				
				if(counter == index) {
					
					Node node = new Node();
					node.data = data;
					node.next = temp.next;
					node.previous = temp;
					temp.next = node;
					
				} else {
					System.out.println("Cannot be inserted");
				}
			
			}
		} else {
			System.out.println("Invalid Index");
		}
		
	}
	
	public String toString() {
		
		System.out.println(head.next.next.previous.data);
		
		String s = " { ";
		
		Node temp = head;
		int i = 0;
		while(temp.next != head) {
			s += temp.data + ", ";
			temp = temp.next;
			i++;
		}
		
		s += temp.data + " } ";
		
		return s;
	}
	
}
