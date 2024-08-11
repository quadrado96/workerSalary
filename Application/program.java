package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.worker;
import entities.enums.WorkerLevel;

public class program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Worker name: ");
		sc.nextLine();
		String workerName = sc.nextLine();
		
		System.out.print("level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		worker worker = new worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName)); 
		
		System.out.print("How many contracts to this worker? ");
		int contractNumber = sc.nextInt();
		
		for (int i = 1; i < contractNumber; i++) {
			System.out.println("Enter contract #"+ i+" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		
		
		sc.close();
	}

}
