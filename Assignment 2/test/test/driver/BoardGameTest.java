package test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;






import model.BoardGames;

class BoardGameTest {
	
	@Test
	void test_boardGame_to_String() {
		BoardGames game = new BoardGames(12345, "Monopoly", "Hasbro", 19.99, 30, 8, 6, "Monopoly Man");
		assertEquals(game.getSerialNum(), 12345);
		assertEquals(game.getName(), "Monopoly");
		assertEquals(game.getBrand(), "Hasbro");
		assertEquals(game.getPrice(), 19.99);
		assertEquals(game.getAvailableCount(), 30);
		assertEquals(game.getMinimumAge(), 8);
		assertEquals(game.getNumOfPlayers(), 6);
		assertEquals(game.getNameDesigners(), "Monopoly Man");
		
		
	}

}