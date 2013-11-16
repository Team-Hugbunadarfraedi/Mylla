package is.ru.Mylla;


public class Mylla {
	private int board[] = new int[9]; //Represents the board
	private boolean player1Turn = true; //Is it player 1's turn?
	private boolean isFinished = false; //Is the game finished?
	
	//Has some one won?
	public boolean checkForWin() {
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
	
	
	//resets the game when finished
	public void reset_game(){
	
	setPlayer1Turn(true);

	setIsFinished(false);

	resetBoard();
	}


	public void setPlayer1Turn(boolean input)
	{player1Turn = input;}

	public void setIsFinished(boolean input) 
        {isFinished = input;}

	public void resetBoard(){
	board = new int[9];}

	public boolean getIsFinished(){
	return isFinished;}

	public boolean getPlayer1Turn(){
	return player1Turn;}

	public int getBoardByIndex(int index){
	return board[index];}	








	//Is it legal to tic box number x?
	public boolean legalMove(int x) {
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
	public void ticBox(int x) {
		if(player1Turn) {
			board[x] = 1;
		}
		else {
			board[x] = 2;
		}
		player1Turn = !player1Turn;
	}

	/**
	Method to allow client programs to get value of cells on the board
	*/
	public int getCellValue(int x) {

		return board[x];
	}

    public static void main(String[] args) {
		
    }
}

