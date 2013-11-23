package is.ru.Mylla;

public class Player {

	private boolean player1Turn;

	public Player() {
		 player1Turn = true; // Is it player 1's turn?
	}

	public void setPlayer1Turn(boolean input) {
		player1Turn = input;
	}

	public boolean getPlayer1Turn() {
		return player1Turn;
	}

}