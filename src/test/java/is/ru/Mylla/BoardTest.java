package is.ru.Mylla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest{

	@Test
	public void testResetBoard() {
		Board b = new Board();

		for (int i = 0; i < 9; i++){
			assertEquals(0, b.getCellValue(i));
		}
	}

	@Test
	public void testGetCellValueEmptyCell() {
		Mylla m = new Mylla();

		assertEquals(0, m.getBoard().getCellValue(0));
	}

	@Test
	public void testGetCellValuePlayerX() {
		Mylla m = new Mylla();

		m.ticBox(7);
		assertEquals(1, m.getBoard().getCellValue(7));
	}

	@Test
	public void testGetCellValuePlayerO() {
		Mylla m = new Mylla();

		m.ticBox(2);
		m.ticBox(3);
		assertEquals(2, m.getBoard().getCellValue(3));
	}
			
}