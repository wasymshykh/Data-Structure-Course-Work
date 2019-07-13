
public class Runner {
	
	public static void main(String[] args) {
		
		Linked l = new Linked();
		l.insert(15);
		l.insert(25);
		l.insert(10);
		l.insertAt(20,1);
		l.insertAt(21,1);
		
		System.out.println(l);
		
	}
	
}
