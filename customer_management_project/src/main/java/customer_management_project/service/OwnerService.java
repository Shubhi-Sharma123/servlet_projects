package customer_management_project.service;

import java.util.Scanner;
import javax.servlet.http.HttpSession;

import customer_management_project.dao.OwnerDao;

public class OwnerService {

	OwnerDao dao = new OwnerDao();
	// ownerLogin method
	public int ownerLogin(int ownerId, String OwnerPassword, int OwnerPasscode) {
		Scanner s = new Scanner(System.in);
		if ((dao.ownerId(ownerId) == dao.ownerPassword(OwnerPassword)) && (dao.ownerId(ownerId) == OwnerPasscode)) {
			System.out.println("Login successfull.....");
			return 1;
		} else {
			System.out.println("invalid creditial please try again!!!");
			return 0;
		}
	}
	
	// displayOwners method
		public void displayOwners() {
			 dao.displayOwners();
		}
}