package e_commerce_order_management;

/**
 * Author: Sumit Vilas Awatade
 * Date: 20-Jun-2026
 */
public class Product {
	private int productId;
    private String name;
    private String category;   // ELECTRONICS, CLOTHING, GROCERY, BOOKS
    private double price;
    private int stock;
	public Product(int productId, String name, String category, double price, int stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stock = stock;
	}
	public int getProductId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stock=" + stock + "]";
	}
	

}
