
public class Runner {

	public static void main(String[] args) {
		
		//long d = new Timestamp(new Date().getTime()).getTime();

		/*Block b0 = new Block(0, "1/11/2017", "Hello", "");
		System.out.println(b0.hash);
		b0.generateBlock(4);
		Block b1 = new Block(0,  "1/11/2017", "Hello", b0.hash);
		b1.generateBlock(4);
		
		System.out.println(b0.hash);
		System.out.println(b1.hash);*/
		
		/*int difficulty = 5;
		String hash = "000005ba8299c9ebafd9b9a67da87045b3dea0602f61c0a417d4c7a2060a02e2";
		System.out.println(hash.substring(0, difficulty));
		String zeros = "";
		for(int i = 0; i < difficulty; i++) {
			zeros += "0";
		}
		
		System.out.println(hash.substring(0, difficulty).equals(zeros));*/
		
	
		BlockChain b = new BlockChain();
		b.addBlock("Hi", "11/5/1201");
		System.out.println(b.recentBlock().hash);
		
		b.addBlock("Hi", "11/5/1201");
		System.out.println(b.recentBlock().hash);
		
		b.addBlock("Hi", "11/5/1201");
		System.out.println(b.recentBlock().hash);
		
		System.out.println(b.isValid());
		
		System.out.println(b.size());
		
		
	}

}
