package is.ru.Mylla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameLogicTest {

	@Test
	public void testReset_game() {
		GameLogic g = new GameLogic();

		g.reset_game();
		assertEquals(false, g.getIsFinished());
		assertEquals(true, g.getPlayer().getPlayer1Turn());
		assertEquals(0, g.getBoard().getBoardByIndex(0));
		assertEquals(0, g.getBoard().getBoardByIndex(5));
		assertEquals(0, g.getBoard().getBoardByIndex(8));
	}

	@Test
	public void testCheckForWin() {
		GameLogic g = new GameLogic();

		g.ticBox(0);
		g.ticBox(1);

		assertEquals(false, g.checkForWin());

		g.ticBox(2);
		g.ticBox(8);
		g.ticBox(3);
		g.ticBox(4);
		g.ticBox(5);

		assertEquals(false, g.checkForWin());

		g.ticBox(7);

		assertEquals(true, g.checkForWin());
	}

	@Test
	public void testLegalMoveIllegal() {
		GameLogic g = new GameLogic();

		// Illegal inputs
		assertEquals(false, g.legalMove(-1));
		assertEquals(false, g.legalMove(9));
	}

	@Test
	public void testLegalMoveEmpty() {
		GameLogic g = new GameLogic();

		// Tests an empty board
		assertEquals(true, g.legalMove(0));
		assertEquals(true, g.legalMove(1));
	}

	@Test
	public void testLegalMoveNotEmpty() {
		GameLogic g = new GameLogic();

		g.ticBox(0);
		assertEquals(false, g.legalMove(0));
		assertEquals(true, g.legalMove(1));

		g.ticBox(1);
		assertEquals(false, g.legalMove(1));
		assertEquals(true, g.legalMove(2));
		assertEquals(false, g.legalMove(0));

	}

	@Test
	public void testGetCellValueEmptyCell() {
		GameLogic g = new GameLogic();

		assertEquals(0, g.getBoard().getCellValue(0));
	}

	@Test
	public void testGetCellValuePlayerX() {
		GameLogic g = new GameLogic();

		g.ticBox(7);
		assertEquals(1, g.getBoard().getCellValue(7));
	}

	@Test
	public void testGetCellValuePlayerO() {
		GameLogic g = new GameLogic();

		g.ticBox(2);
		g.ticBox(3);
		assertEquals(2, g.getBoard().getCellValue(3));
	}

	@Test
	public void testTicBoxSingleTic() {
		GameLogic g = new GameLogic();

		g.ticBox(3);
		assertEquals(1, g.getBoard().getCellValue(3));
	}

	@Test
	public void testTicBoxTwoTics() {
		GameLogic g = new GameLogic();

		g.ticBox(4);
		g.ticBox(5);
		assertEquals(1, g.getBoard().getCellValue(4));
		assertEquals(2, g.getBoard().getCellValue(5));

	}

	@Test
	public void testTicBoxThreeTics() {
		GameLogic g = new GameLogic();

		g.ticBox(0);
		g.ticBox(1);
		g.ticBox(2);
		assertEquals(1, g.getBoard().getCellValue(0));
		assertEquals(2, g.getBoard().getCellValue(1));
		assertEquals(1, g.getBoard().getCellValue(2));
	}

	@Test
	public void testCounter() {
		GameLogic g = new GameLogic();

		for (int i = 0; i < 10; i++) {
			g.ticBox(i);
		}
		assertEquals(9, g.getCountMoves());
	}
	
	@Test
	public void testProcessTurnIllegal() {
		GameLogic g = new GameLogic();
		
		assertEquals(0, g.processTurn(-1));
		assertEquals(0, g.processTurn(9));
		
		assertEquals(1, g.processTurn(0));
		assertEquals(0, g.processTurn(0));
		
		assertEquals(2, g.processTurn(1));
		assertEquals(0, g.processTurn(1));
		assertEquals(0, g.processTurn(0));
		
	}
	
	@Test
	public void testProcessTurn1Win() {
		GameLogic g = new GameLogic();
		
		assertEquals(1, g.processTurn(0));
		assertEquals(2, g.processTurn(1));
		
		assertEquals(1, g.processTurn(3));
		assertEquals(2, g.processTurn(4));
		
		assertEquals(3, g.processTurn(6));
		assertEquals(0, g.processTurn(7));
		
	}
	
	@Test
	public void testProcessTurn2Win() {
		GameLogic g = new GameLogic();
		
		assertEquals(1, g.processTurn(0));
		assertEquals(2, g.processTurn(2));
		
		assertEquals(1, g.processTurn(1));
		assertEquals(2, g.processTurn(4));
		
		assertEquals(1, g.processTurn(3));
		assertEquals(4, g.processTurn(6));
		
		assertEquals(0, g.processTurn(8));
	}
	
	@Test
	public void testProcessTurnDraw() {
		GameLogic g = new GameLogic();
	
		assertEquals(1, g.processTurn(4));
		assertEquals(2, g.processTurn(1));
		
		assertEquals(1, g.processTurn(0));
		assertEquals(2, g.processTurn(8));
		
		assertEquals(1, g.processTurn(5));
		assertEquals(2, g.processTurn(3));
		
		assertEquals(1, g.processTurn(6));
		assertEquals(2, g.processTurn(2));
		
		assertEquals(5, g.processTurn(7));
		assertEquals(0, g.processTurn(0));
	}
}
