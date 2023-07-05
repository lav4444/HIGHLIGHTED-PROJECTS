package Aud9DatotekeAnonim;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class MainEmployee {
	 public static void main(String[] args) throws IOException {
		    List<Employee> staff = EmployeeLoader.loadFromFile("proba.txt");

		    printEmployees(staff, new JuniorEmployee());
		    printEmployees(staff, new SeniorEmployee());

		    // raise everyone's salary by 15%
		    for(Employee e: staff)
		      e.raiseSalary(15);

		    // print junior
		    printEmployees(staff, new Predicate<Employee>() {

		      @Override
		      public boolean test(Employee e) {
		        return e.getSalary() < 80_000;
		      }
		    });

		    // print senior
		    printEmployees(staff, e -> e.getSalary() >= 80_000);

		    // theMostSimilarEmployees
		    theMostSimilarEmployees(staff, (a, b) -> (int) (Math.abs(a.getStartedAt().toEpochDay() - b.getStartedAt().toEpochDay())));
		  }

		  private static void printEmployees(Iterable<Employee> employees, Predicate<Employee> predicate) {
			  for(Employee e: employees) {
				  if (predicate.test(e)) {
					  System.out.println(e);
				  }
			  }
			  System.out.println();
		  }
		  

		  public static void theMostSimilarEmployees(Iterable<Employee> employees,
		      BiFunction<Employee, Employee, Integer> similarity) {

			    Employee similar1 = null;
			    Employee similar2 = null;
			    int min = Integer.MAX_VALUE;
			    
			    for (Employee e1: employees) {
			    	for (Employee e2: employees) {
			    		if (! e1.equals(e2)) {
			    			int tren = (int) Math.abs(e1.getStartedAt().toEpochDay() -e2.getStartedAt().toEpochDay());
			    			if (tren<min) {
			    				min = tren;
			    				similar1 = e1;
			    				similar2 = e2;
			    			}
			    		}
			    		
			    	}
			    }
			    System.out.println("Most similar employees are "+similar1.getEmployee()+" and "+similar2.getEmployee());
		  }
}
