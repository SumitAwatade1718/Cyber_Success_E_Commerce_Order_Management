package e_commerce_order_management;
/**
 * Author: Sumit Vilas Awatade
 * Date: 19-Jun-2026
 */
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to ShopX E-Commerce Order Management System");
		
		 System.out.println("========== Task A ==========");
		 FilterService.getDeliveredHighValue();
		 FilterService.getLowStockElectronics();
		 FilterService.getGoldCancelledCustomers();
		 FilterService.getLast30DayOrder();
		 FilterService.getGroceryOrders();
		 
		 System.out.println("========== Task B ==========");
		 MappingService.getProductNames();
		 MappingService.getOrderSummary();
		 MappingService.getBookWithDiscount();
		 MappingService.getUniqueCity();
		 
		 System.out.println("\n ========== Task C ==========");
		 AggregationService.countShippedOrders();
		 AggregationService.countOrdersPerCategory();
		 AggregationService.totalDeliveredRevenue();
		 AggregationService.totalElectronicsQuantity();
		 AggregationService.averageGoldOrderValue();
		 
		 System.out.println("\n ======== Task D ==========");
		 PrintService.printAllOrders();
		 PrintService.thankYouMessage();
		 PrintService.updateStock();
		 PrintService.categoryWiseProducts();
		 PrintService.topThreeOrders();
		 
	}

}
