package model;

public class Animals extends Toy {

	public Animals(int serialNum, String name, String brand, double price, int availableCount, int minimumAge, String material, String size) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.material = material;
		this.size = size;
	}
	private String material;
	private String size;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return super.toString() + "Material: " + material + "Size: " + size;
	}
	@Override 
	public String format() {
		return super.format() + material + size;
	}
}
