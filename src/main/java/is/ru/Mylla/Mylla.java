package is.ru.Mylla;

import static spark.Spark.*;
import spark.*;

public class Mylla {
	
	private Board gameboard = new Board();
	private boolean player1Turn = true; // Is it player 1's turn?
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

		setPlayer1Turn(true);

		setIsFinished(false);

		gameboard.resetBoard();
	}

	public void setPlayer1Turn(boolean input) {
		player1Turn = input;
	}

	public void setIsFinished(boolean input) {
		isFinished = input;
	}

	

	public boolean getIsFinished() {
		return isFinished;
	}

	public boolean getPlayer1Turn() {
		return player1Turn;
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
			if (player1Turn) {
				gameboard.setCell(x, 1);
			} else {
				gameboard.setCell(x, 2);
			}
			player1Turn = !player1Turn;
			countMoves++;
		}
	}

	

	public int getCountMoves() {
		return countMoves;
	}

	public static void main(String[] args) {
		final Mylla mylla = new Mylla();

		staticFileLocation("/public");

		setPort(Integer.valueOf(System.getenv("PORT")));

		post(new Route("/add") {
			@Override
			public Object handle(Request request, Response response) {
				int temp = Integer.valueOf(request.queryParams("ClickedBox"));

				if (!mylla.legalMove(temp)) {
					return 0;
				} else {
					mylla.ticBox(temp);
					if (mylla.checkForWin()) {
						if (!mylla.player1Turn) {
							return 3;
						} else {
							return 4;
						}
					}
					if (mylla.isFinished) {
						if (!mylla.player1Turn) {
							return 5;
						} else {
							return 6;
						}
					} else {
						if (!mylla.player1Turn) {
							return 1;
						} else {
							return 2;
						}
					}
				}
			}
		});
	}
}
