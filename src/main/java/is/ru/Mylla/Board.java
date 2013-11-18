package is.ru.Mylla;

public class Board {
	private int board[]; 

	public Board() { //Constructor
		board = new int[9];
	}

	public void resetBoard() {
		board = new int[9];
	}

	public int getBoardByIndex(int index) {
		return board[index];
	}

	/**
	* Method to allow client programs to get value of cells on the board	 */
	public int getCellValue(int x) {

		return board[x];
	}

	public void setCell(int index, int y) {
		board[index] = y; 

	}

}