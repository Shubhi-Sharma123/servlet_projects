package customer_management_project.controller;

import java.util.Scanner;

import customer_management_project.service.AdminService;

public class AdminController {
	public static void main(String[] args) {
		System.out.println("welcome to Owner Window");
		while (true) {

			System.out.println(
					"1.Login Admin with name and email\n2.Exit");
			System.out.print("Enter your choice: ");
			Scanner s = new Scanner(System.in);
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.print("Enter adminName: ");
				String adminName = s.next();
				adminName += s.nextLine();
				System.out.print("Enter adminEmail: ");
				String adminEmail = s.nextLine();
				AdminService adminService = new AdminService();
				adminService.loginAdmin(adminName, adminEmail);
			}
				break;

			case 2: {
				System.out.println("System.............closed");
				System.exit(choice);
			}
				break;

			default: {
				System.out.println("invalid choice");

			}

			}
		}
	}
}
