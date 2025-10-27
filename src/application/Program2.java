package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("====TEST 1: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n====TEST 2: department findAll =====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n====TEST 3: department update =====");
		department = departmentDao.findById(6);
		department.setName("Games");
		departmentDao.update(department);
		System.out.println("Upadate Completed!");
		
		System.out.println("\n====TEST 4: department insert =====");
		Department newDepartment = new Department(null, "Chiken");
		departmentDao.insert(newDepartment);
		System.out.println("New department add: " + newDepartment.getName());
		
		System.out.println("\n====TEST 5: department deleteById =====");
		System.out.print("Enter Id to delete from department: ");
		int d = sc.nextInt();
		departmentDao.deleteById(d);
		System.out.println("Delete completed!!");
		
		sc.close();
		
	}

}
