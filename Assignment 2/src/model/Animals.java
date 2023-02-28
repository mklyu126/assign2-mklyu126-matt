package model;

public class Animals extends Toy {

	public Animals(String material, String size) {
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
		return "Material" + material + "size" + size;
	}
}
