/**
 * 
 */
package e_commerce_order_management;

/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class Customer {
	    private int customerId;
	    private String name;
	    private String city;
	    private String tier;   // GOLD, SILVER, BRONZE
		public Customer(int customerId, String name, String city, String tier) {
			this.customerId = customerId;
			this.name = name;
			this.city = city;
			this.tier = tier;
		}
		public int getCustomerId() {
			return customerId;
		}
		public String getName() {
			return name;
		}
		public String getCity() {
			return city;
		}
		public String getTier() {
			return tier;
		}
		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", name=" + name + ", city=" + city + ", tier=" + tier + "]";
		}

}
