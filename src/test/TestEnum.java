package test;

public class TestEnum {
	public static void main(String[] args) {
		for(Food food : Food.values()) {
			System.out.println(food.getPrice());
			if(food.name().equals("APPLE"))
				food.setPrice(3.5f);
			System.out.println(food.getPrice());
		}
	}
}
enum Food {
	APPLE(3,"RED"),
	ORANGE(2, "GREEN");
	private float price;
	private String color;
	private Food(float price, String color) {
		this.price = price;
		this.color = color;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
}
