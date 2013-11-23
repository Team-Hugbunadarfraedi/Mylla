package is.ru.Mylla;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest {

	@Test
	public void testResetBoard() {
		Board b = new Board();

		for (int i = 0; i < 9; i++){
			assertEquals(0, b.getCellValue(i));
		}
	}

	@Test
	public void testGetCellValueEmptyCell() {
		Board b = new Board();

		assertEquals(0, b.getCellValue(0));
	}			
}