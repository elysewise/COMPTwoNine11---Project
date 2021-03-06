package quoridor;

/**
 * @author Stump
 * Contains all the information that is relevant to a player. 
 * Thus being - Their name, their token as to be displayed on the board and their current space. 
 */
public abstract class Player {
	protected String name;
	protected String token;
	protected Space space;
	int wallsLeft = 10;

	/**
	 * Constructor for a default player
	 * @param playerNumber can be of value 1 or 2 - for default filling of fields: name, token. 
	 */
	public Player(int playerNumber) {
		if (playerNumber == 1) {
			name = " X ";
			this.space = new Space("e1");
		}
		else {
			name = " O ";
			this.space = new Space("e9");
		}
		setToken(name);
	}

	protected void setToken(String t) {
		this.token = t;
	}

	/**
	 * @return The player's token as a String
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Checks if this player has reached their quota of walls
	 * @return boolean true is player can still place walls
	 */
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

	/**
	 * Obtain the next moved to be played by this player.
	 * Implementation will differ depending on instance of player object
	 * @return move to be played
	 */
	public abstract Move getMove();

	public String toString() {
		return name;
	}

}
