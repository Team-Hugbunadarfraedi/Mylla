package is.ru.Mylla;


public class Mylla {
	int board[] = new int[9]; //Represents the board
	boolean player1Turn = true; //Is it player 1's turn?
	boolean isFinished = false; //Is the game finished?
	
	//Has some one won?
	public boolean checkForWin()
	{
		return true;
	}
	
	//Is it legal to tic box number x?
	public boolean legalMove(int x)
	{
		if((x < 0) || (x > 8))
		{
			return false;
		}

		if(isFinished)
		{
			return false;
		}

		if(board[x] == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Tic box number x
	public void move(int x)
	{
		
	}

    public static void main(String[] args) {
		
    }
}

