package Aud9DatotekeAnonim;

import java.util.function.*;

public class SeniorEmployee implements Predicate<Employee>{

	@Override
	public boolean test(Employee t) {
		if (t.getSalary()>=80000) {
			return true;
		}
		else {
			return false;
		}
	}

	
	

}
