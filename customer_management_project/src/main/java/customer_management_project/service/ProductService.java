package customer_management_project.service;

import java.util.Scanner;

import customer_management_project.dao.ProductDao;
import customer_management_project.dto.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	// customer login method
	public int customerLogin(int customerId, long customerPhone) {
		if ((productDao.customerId(customerId) == customerId)
				&& ((productDao.customerPhone(customerPhone) == customerPhone))) {
//			System.out.println("welcome to customer Dashboard");
			return 1;
		} else {
//			System.out.println("invalid credential!!!");
			return 0;
		}
	}
	
	// productId method
		public int productId(int productId) {
			return productDao.productId(productId);
		}
		
		// insertProduct by customer
		public void insertProduct(Product product,int customerId) {
			productDao.insertProduct(product, customerId);
		}
		
		// updateProduct by customer
		public void updateProduct(Product product) {
			productDao.updateProduct(product);
		}
		
		// deleteProduct
		public void deleteProduct(int productId) {
			productDao.deleteProduct(productId);
		}
		
		// custemerIdGetByProductId method()
		public int customerIdGetByProductId(int productId) {
			return productDao.customerIdGetByProductId(productId);
		}
		
		// updateProductPrice method
		public void updateProductPrice(int productId, double productPrice) {
			productDao.updateProductPrice(productId, productPrice);
		}
		
		// updateProductAvailable method
		public void updateProductAvailable(int productId, boolean productAvailable) {
			productDao.updateProductAvailable(productId, productAvailable);
		}
}