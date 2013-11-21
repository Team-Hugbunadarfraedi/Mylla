package is.ru.Mylla;

import static spark.Spark.*;
import spark.*;

public class Mylla {
	
	private Board gameboard = new Board();
	private Player player = new Player();
	private boolean isFinished = false; // Is the game finished?
	private int countMoves = 0;

	// Has some one won?
	public boolean checkForWin() {
		if ((gameboard.getBoardByIndex(0) != 0 && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(1) && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(2)
				|| (gameboard.getBoardByIndex(3) != 0 && gameboard.getBoardByIndex(3) == gameboard.getBoardByIndex(4) && gameboard.getBoardByIndex(3) == gameboard.getBoardByIndex(5))
				|| (gameboard.getBoardByIndex(6) != 0 && gameboard.getBoardByIndex(6) == gameboard.getBoardByIndex(7) && gameboard.getBoardByIndex(8) == gameboard.getBoardByIndex(6))
				|| (gameboard.getBoardByIndex(0) != 0 && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(3) && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(6))
				|| (gameboard.getBoardByIndex(1) != 0 && gameboard.getBoardByIndex(1) == gameboard.getBoardByIndex(4) && gameboard.getBoardByIndex(1) == gameboard.getBoardByIndex(7))
				|| (gameboard.getBoardByIndex(2) != 0 && gameboard.getBoardByIndex(2) == gameboard.getBoardByIndex(5) && gameboard.getBoardByIndex(2) == gameboard.getBoardByIndex(8))
				|| (gameboard.getBoardByIndex(0) != 0 && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(4) && gameboard.getBoardByIndex(0) == gameboard.getBoardByIndex(8))
				|| (gameboard.getBoardByIndex(2) != 0 && gameboard.getBoardByIndex(2) == gameboard.getBoardByIndex(4) && gameboard.getBoardByIndex(2) == gameboard.getBoardByIndex(6)))) {
			return true;
		}
		return false;
	}

	// resets the game when finished
	public void reset_game() {

		player.setPlayer1Turn(true);

		setIsFinished(false);
		setCountMoves(0);

		gameboard.resetBoard();
	}
	
	public void setIsFinished(boolean input) {
		isFinished = input;
	}


	public boolean getIsFinished() {
		return isFinished;
	}
	

	// Is it legal to tic box number x?
	public boolean legalMove(int x) {
		if ((x < 0) || (x > 8)) {
			return false;
		}

		if (isFinished) {
			return false;
		}

		if (gameboard.getBoardByIndex(x) == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Tic box number x
	public void ticBox(int x) {
		if (legalMove(x)) {
			if (player.getPlayer1Turn()) {
				gameboard.setCell(x, 1);
			} else {
				gameboard.setCell(x, 2);
			}
			player.setPlayer1Turn(!player.getPlayer1Turn());
			countMoves++;
			if(getCountMoves() > 8){
				setIsFinished(true);
			}
		}
	}
	
	
	//Returns a returnCode for the javascript
	//and performs the necessary actions for the turn
	public int processTurn(int clickedBox){
		if (!legalMove(clickedBox)) {
					return 0;
				} else {
					ticBox(clickedBox);
					if (checkForWin()) {
						setIsFinished(true);
						if (!player.getPlayer1Turn()) {
							return 3;
						} else {
							return 4;
						}
					}
					if (isFinished) {
						if (!player.getPlayer1Turn()) {
							return 5;
						} else {
							return 6;
						}
					} else {
						if (!player.getPlayer1Turn()) {
							return 1;
						} else {
							return 2;
						}
					}
				}
	}

	
	public int getCountMoves() {
		return countMoves;
	}

	public void setCountMoves(int val) {
		countMoves = val;
	}
	
	public Player getPlayer(){
		return player;
	}

	public Board getBoard(){
		return gameboard;
	}

	public static void main(String[] args) {
		final Mylla mylla = new Mylla();

		staticFileLocation("/public");

		setPort(Integer.valueOf(System.getenv("PORT")));

		post(new Route("/processTurn") {
			@Override
			public Object handle(Request request, Response response) {
				int temp = Integer.valueOf(request.queryParams("ClickedBox"));
				
				return mylla.processTurn(temp) + " " + temp;
			}
		});
		
		
		post(new Route("/resetGame") {
			@Override
			public Object handle(Request request, Response response) {
				mylla.reset_game();
				
				return 0;
			}
		});
	}
}