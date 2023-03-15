package model;
/**
 * Child class of Toy.
 * @author Max
 *
 */
public class Animals extends Toy {
/**
 * takes in classification of a toy and adds its own classification
 * @param serialNum
 * @param name
 * @param brand
 * @param price
 * @param availableCount
 * @param minimumAge
 * @param material
 * @param size
 */
	public Animals(String serialNum, String name, String brand, float price, int availableCount, int minimumAge, String material, String size) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.material = material;
		this.size = size;
	}
	/**
	 * initializes material
	 */
	private String material;
	/**
	 * initializes size
	 */
	private String size;
	
	/**
	 * gets material 
	 * @return material
	 */
	public String getMaterial() {
		return material;
	}
	/**
	 * sets material
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}
	/**
	 * get size
	 * @return size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * sets size
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * formats animals
	 */
	@Override
	public String toString() {
		return super.toString() + "Material: " + material + " Size: " + size;
	}
	/**
	 * formats animals
	 */
	@Override 
	public String format() {
		return super.format() + ";" + material + ";" + size;
	}
}
