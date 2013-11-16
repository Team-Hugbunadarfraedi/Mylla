package is.ru.Mylla;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Mylla2Test{

	Mylla mylla = new Mylla();

	//testing checkForWin
    @Test
    public void testCheckForWin() {
        mylla.board[0] = 1;
        mylla.board[1] = 2;

		assertEquals(false, mylla.checkForWin());

        mylla.board[2] = 1;
        mylla.board[3] = 1;
        mylla.board[4] = 2;
        mylla.board[5] = 1;

        assertEquals(false, mylla.checkForWin());

        mylla.board[7] = 2;

        assertEquals(true, mylla.checkForWin());
    }
}