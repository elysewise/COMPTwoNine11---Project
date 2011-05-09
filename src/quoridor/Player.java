package quoridor;

/**
 * @author Stump
 * Contains all the information that is relevant to a player. 
 * Thus being - Their name, their token as to be displayed on the board and their current space. 
 */
public class Player {
	private final String name;
	private final String token;
	private Space space;
	int wallsLeft = 10;
	
	public Player(String name, Space space) {
		this.name = name;
		this.space = space;
		this.token = (name+"   ").substring(0,3).toUpperCase();
	}
	
	public Player(String name, int x, int y) {
		this.name = name;
		this.space = new Space(x,y);
		this.token = name.substring(0,3).toUpperCase();
	}
	
	/**
	 * @return The player's token as a String
	 */
	public String getToken() {
		return token;
	}
	
	public Boolean hasWallsLeft() {
		return (wallsLeft > 0); 
	}
	
	public Boolean decrementWallTally() {
		if(this.hasWallsLeft()){
			this.wallsLeft--;
			return true;
		}
		return false;
	}
	
	//used for undo'ing
	public boolean incrementWallTally(){
		if(this.wallsLeft < 20){
			wallsLeft++;
			return true;
		}
		return false;
	}
	
	/**
	 * @return The player's name as a String 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The players current Space as a pointer to a Space object. 
	 */
	public Space getSpace() {
		return space;
	}
	
	public void setSpace(Space newSpace) {
		space = newSpace;
	}
	
	public String toString() {
		return name;
	}

	
}
		