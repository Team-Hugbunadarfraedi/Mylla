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
	public void LegalMoveTest_Illegal() {
		Mylla m = new Mylla();

		//Illegal inputs
		assertEquals(m.legalMove(-1), false);
		assertEquals(m.legalMove(9), false);
	}

	@Test
	public void LegalMoveTest_Empty() {
		Mylla m = new Mylla();

		//Tests an empty board
		assertEquals(m.legalMove(0), true);
		assertEquals(m.legalMove(1), true);
	}

	@Test
	public void LegalMoveTest_NotEmpty() {
		Mylla m = new Mylla();

		//To be replaced by move
		m.board[0] = 1;
		assertEquals(m.legalMove(0), false);
		assertEquals(m.legalMove(1), true);

		//To be replaced by move
		m.board[1] = 2;
		assertEquals(m.legalMove(1), false);
		assertEquals(m.legalMove(2), true);
		assertEquals(m.legalMove(0), false);


	}
	
	@Test
	public void testGetCellValueEmptyCell() {
		Mylla m = new Mylla();

		assertEquals(0, m.getCellValue(0));
	}


	
}
