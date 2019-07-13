import java.util.ArrayList;

public class BlockChain {

	private ArrayList<Block> blocks;
	private int difficulty;
	
	BlockChain(){
		blocks = new ArrayList<Block>();
		blocks.add(initialize());
		difficulty = 2;
	}
	
	private Block initialize() {
		Block first = new Block(1, "This is first block", "");
		return first;
	}
	
	public int size() {
		return blocks.size();
	}
	
	public Block recentBlock() {
		return blocks.get(blocks.size() - 1);
	}
	
	public void addBlock(String data, String date) {
		Block newBlock = new Block(blocks.size(), "This is " + blocks.size() + " block and data is " + data, recentBlock().hash);
		newBlock.generateBlock(this.difficulty);
		blocks.add(newBlock);
	}
	
	public boolean isValid() {
		
		Block current, previous;
		
		for(int i = 1; i < size(); i++) {
			current = blocks.get(i);
			previous = blocks.get(i-1);

			if(!current.previousHash.equals(previous.hash)) {
				return false;
			}
			else if(!current.hash.equals(current.calculateHash())) {
				return false;
			}
		}
		
		return true;
	}
	
}
