package ZZV10Datoteke;

import java.io.IOException;
import java.util.*;

public class MainEuroVision {
	public static void main(String[] args) throws IOException {
		
		PointSaver.saveTelevotingPoints(2008, "Croatia", new ArrayList<String> (Arrays.asList(new String[]{"Albania", "Serbia", "San Marino","Netherlands", "Malta", "Norway","Switzerland", "Russia", "Slovenia","Ireland"})) );
	}

}
