package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpSalSum {

	public static void main(String[] args) {
		
		private static List<Employee> mapCSV(String empCSVFilePath) {
			List<Employee> empList = new ArrayList<Employee>();
			try {
			    File inputF = new File(emp.txt);
			    InputStream inputFS = new FileInputStream(inputF);
			    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
			// Skip the header since its just coloumn name in table and in CSV file but not the data.
			    empList = br.lines().skip(1).map(csv2EmpObj).collect(Collectors.toList());
			    br.close();
			} catch (IOException e) {
			    System.err.println(e.getMessage());
			}
			return empList;
			}
		
	}

}
