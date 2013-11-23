package is.ru.Mylla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyllaTest {

	@Test
	public void reset_game() {

		GameLogic m = new GameLogic();

		m.reset_game();
		assertEquals(false, m.getIsFinished());
		assertEquals(true, m.getPlayer().getPlayer1Turn());
		assertEquals(0, m.getBoard().getBoardByIndex(0));
		assertEquals(0, m.getBoard().getBoardByIndex(5));
		assertEquals(0, m.getBoard().getBoardByIndex(8));
	}

	@Test
	public void testCheckForWin() {
		GameLogic m = new GameLogic();

		m.ticBox(0);
		m.ticBox(1);

		assertEquals(false, m.checkForWin());

		m.ticBox(2);
		m.ticBox(8);
		m.ticBox(3);
		m.ticBox(4);
		m.ticBox(5);

		assertEquals(false, m.checkForWin());

		m.ticBox(7);

		assertEquals(true, m.checkForWin());
	}

	@Test
	public void testLegalMoveIllegal() {
		GameLogic m = new GameLogic();

		// Illegal inputs
		assertEquals(false, m.legalMove(-1));
		assertEquals(false, m.legalMove(9));
	}

	@Test
	public void testLegalMoveEmpty() {
		GameLogic m = new GameLogic();

		// Tests an empty board
		assertEquals(true, m.legalMove(0));
		assertEquals(true, m.legalMove(1));
	}

	@Test
	public void testLegalMoveNotEmpty() {
		GameLogic m = new GameLogic();

		m.ticBox(0);
		assertEquals(false, m.legalMove(0));
		assertEquals(true, m.legalMove(1));

		m.ticBox(1);
		assertEquals(false, m.legalMove(1));
		assertEquals(true, m.legalMove(2));
		assertEquals(false, m.legalMove(0));

	}

	@Test
	public void testGetCellValueEmptyCell() {
		GameLogic m = new GameLogic();

		assertEquals(0, m.getBoard().getCellValue(0));
	}

	@Test
	public void testGetCellValuePlayerX() {
		GameLogic m = new GameLogic();

		m.ticBox(7);
		assertEquals(1, m.getBoard().getCellValue(7));
	}

	@Test
	public void testGetCellValuePlayerO() {
		GameLogic m = new GameLogic();

		m.ticBox(2);
		m.ticBox(3);
		assertEquals(2, m.getBoard().getCellValue(3));
	}

	@Test
	public void testTicBoxSingleTic() {
		GameLogic m = new GameLogic();

		m.ticBox(3);
		assertEquals(1, m.getBoard().getCellValue(3));
	}

	@Test
	public void testTicBoxTwoTics() {
		GameLogic m = new GameLogic();

		m.ticBox(4);
		m.ticBox(5);
		assertEquals(1, m.getBoard().getCellValue(4));
		assertEquals(2, m.getBoard().getCellValue(5));

	}

	@Test
	public void testTicBoxThreeTics() {
		GameLogic m = new GameLogic();

		m.ticBox(0);
		m.ticBox(1);
		m.ticBox(2);
		assertEquals(1, m.getBoard().getCellValue(0));
		assertEquals(2, m.getBoard().getCellValue(1));
		assertEquals(1, m.getBoard().getCellValue(2));
	}

	@Test
	public void testCounter() {
		GameLogic m = new GameLogic();

		for (int i = 0; i < 10; i++) {
			m.ticBox(i);
		}
		assertEquals(9, m.getCountMoves());
	}
	
	@Test
	public void testProcessTurnIllegal() {
		GameLogic m = new GameLogic();
		
		assertEquals(0, m.processTurn(-1));
		assertEquals(0, m.processTurn(9));
		
		assertEquals(1, m.processTurn(0));
		assertEquals(0, m.processTurn(0));
		
		assertEquals(2, m.processTurn(1));
		assertEquals(0, m.processTurn(1));
		assertEquals(0, m.processTurn(0));
		
	}
	
	@Test
	public void testProcessTurn1Win() {
		GameLogic m = new GameLogic();
		
		assertEquals(1, m.processTurn(0));
		assertEquals(2, m.processTurn(1));
		
		assertEquals(1, m.processTurn(3));
		assertEquals(2, m.processTurn(4));
		
		assertEquals(3, m.processTurn(6));
		assertEquals(0, m.processTurn(7));
		
	}
	
	@Test
	public void testProcessTurn2Win() {
		GameLogic m = new GameLogic();
		
		assertEquals(1, m.processTurn(0));
		assertEquals(2, m.processTurn(2));
		
		assertEquals(1, m.processTurn(1));
		assertEquals(2, m.processTurn(4));
		
		assertEquals(1, m.processTurn(3));
		assertEquals(4, m.processTurn(6));
		
		assertEquals(0, m.processTurn(8));
	}
	
	@Test
	public void testProcessTurnDraw() {
		GameLogic m = new GameLogic();
	
		assertEquals(1, m.processTurn(4));
		assertEquals(2, m.processTurn(1));
		
		assertEquals(1, m.processTurn(0));
		assertEquals(2, m.processTurn(8));
		
		assertEquals(1, m.processTurn(5));
		assertEquals(2, m.processTurn(3));
		
		assertEquals(1, m.processTurn(6));
		assertEquals(2, m.processTurn(2));
		
		assertEquals(5, m.processTurn(7));
		assertEquals(0, m.processTurn(0));
	}

}
