package test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;







import model.Figures;

class FigureTest {
	
	@Test
	void test_Figure_to_String() {
		Figures figure = new Figures("12345", "Barbie", "Hasbro", (float) 10.99, 40, 10, "Doll");
		assertEquals(figure.getSerialNum(), "12345");
		assertEquals(figure.getName(), "Barbie");
		assertEquals(figure.getBrand(), "Hasbro");
		assertEquals(figure.getPrice(), (float)10.99);
		assertEquals(figure.getAvailableCount(), 40);
		assertEquals(figure.getMinimumAge(), 10);
		assertEquals(figure.getClassification(), "Doll");
		
		
		
	}

}