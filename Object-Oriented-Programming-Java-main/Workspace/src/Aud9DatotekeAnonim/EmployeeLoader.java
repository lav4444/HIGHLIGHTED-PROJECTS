package Aud9DatotekeAnonim;

import java.util.*;
import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.Paths;
import java.time.LocalDate;

public class EmployeeLoader {
	
	static List<Employee> loadFromFile(String fileName) throws IOException {
		Path p = Paths.get("/Users/lavsmacbook/Documents/FER/labos2/"+fileName);
		List<Employee> zaposlenici = new LinkedList<>();
		List<String> lyricsList = Files.readAllLines(p);
		for (String line: lyricsList) {
			String[] splits = line.split(";");
			zaposlenici.add(new Employee(splits[0], Double.parseDouble(splits[1]), LocalDate.of(Integer.parseInt(splits[2]), Integer.parseInt(splits[3]), Integer.parseInt(splits[4]) ) ));
		}
		return zaposlenici;
		
	}

}
