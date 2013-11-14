package is.ru.Mylla;


public class Mylla {
	int board[] = new int[9]; //Represents the board
	boolean player1Turn = true; //Is it player 1's turn?
	boolean isFinished = false; //Is the game finished?
	
	//Has some one won?
	public boolean checkForWin()
	{
		if((board[0] != 0 && board[0] == board[1] && board[0] == board[2]) ||
			(board[3] != 0 && board[3] == board[4] && board[3] == board[5]) ||
			(board[6] != 0 && board[6] == board[7] && board[8] == board[6]) ||
			(board[0] != 0 && board[0] == board[3] && board[0] == board[6]) ||
			(board[1] != 0 && board[1] == board[4] && board[1] == board[7]) ||
			(board[2] != 0 && board[2] == board[5] && board[2] == board[8]) ||
			(board[0] != 0 && board[0] == board[4] && board[0] == board[8]) ||
			(board[2] != 0 && board[2] == board[4] && board[2] == board[6])){
			return true;
		}
		return false;
	}
	
	//Is it legal to tic box number x?
	public boolean legalMove(int x)
	{
		return true;
	}
	
	//Tic box number x
	public void move(int x)
	{
		
	}

    public static void main(String[] args) {
		
    }
}

