package test.driver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;





import model.Animals;

class AnimalsTest {
	
	@Test
	void test_animal_to_String() {
		Animals animal = new Animals(12345, "Lion", "Hasbro", 14.99, 25, 0, "Polyester", "1 foot");
		assertEquals(animal.getSerialNum(), 12345);
		assertEquals(animal.getName(), "Lion");
		assertEquals(animal.getBrand(), "Hasbro");
		assertEquals(animal.getPrice(), 14.99);
		assertEquals(animal.getAvailableCount(), 25);
		assertEquals(animal.getMinimumAge(), 0);
		assertEquals(animal.getMaterial(), "Polyester");
		assertEquals(animal.getSize(), "1 foot");
		
		
	}

}
