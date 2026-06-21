package e_commerce_order_management;

import java.time.LocalDate;

/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class Order {
	 private int orderId;
	    private Customer customer;
	    private Product product;
	    private int quantity;
	    private double totalAmount;
	    private String status;   // PLACED, SHIPPED, DELIVERED, CANCELLED
	    private LocalDate orderDate;
	    
		public Order(int orderId, Customer customer, Product product, int quantity, double totalAmount, String status,
				LocalDate orderDate) {
			this.orderId = orderId;
			this.customer = customer;
			this.product = product;
			this.quantity = quantity;
			this.totalAmount = totalAmount;
			this.status = status;
			this.orderDate = orderDate;
		}
		
		public int getOrderId() {
			return orderId;
		}
		public Customer getCustomer() {
			return customer;
		}
		public Product getProduct() {
			return product;
		}
		
		public int getQuantity() {
			return quantity;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public String getStatus() {
			return status;
		}
		public LocalDate getOrderDate() {
			return orderDate;
		}
		
		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", customer=" + customer + ", product=" + product + ", quantity="
					+ quantity + ", totalAmount=" + totalAmount + ", status=" + status + ", orderDate=" + orderDate + "]";
		}
	    
	    

}
