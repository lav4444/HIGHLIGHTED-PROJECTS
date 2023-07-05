package Aud9DatotekeAnonim;

import java.util.function.Predicate;

public class JuniorEmployee implements Predicate<Employee> {
	
	@Override
	public boolean test(Employee t) {
		if (t.getSalary()<80000) {
			return true;
		}
		else {
			return false;
		}
	}

}
