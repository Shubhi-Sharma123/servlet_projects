package customer_management_project.service;

import java.util.Scanner;
import customer_management_project.dao.AdminDao;
import customer_management_project.dto.Admin;

public class AdminService {
	// insertAdmin method
	public String insertAdmin(Admin admin) {
		AdminDao adminDao = new AdminDao();
		int adminId = admin.getAdminId();
		if (adminDao.getById(adminId) == adminId) {
		return 	"<h3 style='color:red'>this Admin id is already present in database.please choose different Admin id</h3>";
		} else {
			adminDao.insertAdmin(admin);
			return "<h3 style='color:green'>data inserted successfully</h3>";	
		}
	}

	// updateAdmin method
	public String updateAdmin(int adminId, String adminName, String adminEmail) {
		AdminDao adminDao = new AdminDao();
		if (adminDao.getById(adminId) == adminId) {
		return adminDao.updateAdmin(adminId, adminName, adminEmail);
		} else {
			return "<h3 style='color:red'>Admin id not present in database</h3>";
		}
	}

	// deleteAdmin method
	public String deleteAdmin(int adminId) {
		AdminDao adminDao = new AdminDao();
		if (adminDao.getById(adminId) == adminId) {
			return adminDao.deleteAdmin(adminId);
		} else {
			return "<h3 style='color:red'>Admin id is not present in database or already deleted</h3>";
		}
	}

	// loginAdmin method
	public int loginAdmin(String adminName, String adminEmail) {
		AdminDao adminDao = new AdminDao();
		if (adminDao.adminName(adminName) == adminDao.adminEmail(adminEmail)) {
			System.out.println("admin login successfully");
			return 1;
		} else {
			System.out.println("invalid credintial please try again!!!");
			return 0;
		}
	}
	
	
}