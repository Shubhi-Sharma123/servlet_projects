package customer_management_project.service;

import customer_management_project.dao.CustomerDao;

public class CustomerService {
	
	CustomerDao customerDao = new CustomerDao();
	// getByCustomerId method
		public int getByCustomerId(int customerId) {
			return customerDao.getByCustomerId(customerId);
		}
		
	// addCustomer method
		public void addCustomer(int customerId, String customerName, String customerEmail, long customerPhone) {
			
			customerDao.addCustomer(customerId, customerName, customerEmail, customerPhone);
		
		}
		
		// updateCustomer method
		public void updateCustomer(int customerId, String customerName, String customerEmail, long customerPhone) {
			customerDao.updateCustomer(customerId, customerName, customerEmail, customerPhone);
		}

		// deleteCustomer method
		public void deleteCustomer(int customerId) {
			customerDao.deleteCustomer(customerId);
		}
}