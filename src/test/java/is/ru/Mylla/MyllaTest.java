package is.ru.Mylla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyllaTest
{
	@Test
	public void CheckForWinTest()
	{
		
	}
	
	@Test
	public void LegalMoveTest()
	{
		Mylla m = new Mylla();

		//Illegal inputs
		assertEquals(m.LegalMove(-1), false);
		assertEquals(m.LegalMove(9), false);

		//Tests an empty board
		assertEquals(m.LegalMove(0), true);
		assertEquals(m.LegalMove(1), true);

		//To be replaced by move
		m.board[0] = 1;
		assertEquals(m.LegalMove(0), false);
		assertEquals(m.LegalMove(1), true);

		//To be replaced by move
		m.board[1] = 2;
		assertEquals(m.LegalMove(1), false);
		assertEquals(m.LegalMove(2), true);
		assertEquals(m.LegalMove(0), false);


	}
	
	@Test
	public void MoveTest()
	{
	
	}
	
}
