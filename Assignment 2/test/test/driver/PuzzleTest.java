package test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;






import model.Puzzles;

class PuzzleTest {
	
	@Test
	void test_Puzzle_to_String() {
		Puzzles puzzle = new Puzzles("12345", "Eiffel Tower", "Hasbro", (float) 14.99, 50, 14, "Trivia");
		
		assertEquals(puzzle.getSerialNum(), "12345");
		assertEquals(puzzle.getName(), "Eiffel Tower");
		assertEquals(puzzle.getBrand(), "Hasbro");
		assertEquals(puzzle.getPrice(), (float) 14.99);
		assertEquals(puzzle.getAvailableCount(), 50);
		assertEquals(puzzle.getMinimumAge(), 14);
		assertEquals(puzzle.getPuzzleType(), "Trivia");
		
		
		
	}

}