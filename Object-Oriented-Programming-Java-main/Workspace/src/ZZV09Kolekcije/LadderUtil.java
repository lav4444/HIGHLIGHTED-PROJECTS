package ZZV09Kolekcije;

import java.util.*;

public class LadderUtil {

	static Iterable<Pair<String>> randomDraw(Ladder ladder) {
		
		String p1 = null, p2 = null;
		List<Pair<String>> draw = new LinkedList<>();
		
		while (ladder.standings().size() > 0) {
			if ( ladder.standings().size() == 1 ) {
				p1 = ladder.standings().getFirst();
				p2 = "FREE";
				ladder.standings().remove(p1);
				draw.add(new Pair(p1,p2));
				continue;
			}
			int r1 =  (int) (Math.random() * ladder.count() );
			int r2 =  (int) (Math.random() * ladder.count() );
			if (r1 == r2) continue;
			int cnt=0;
			for (String s: ladder.standings()) {
				if (cnt == r1) {
					p1 = s;
				}
				if (cnt == r2) {
					p2 = s;
				}
				cnt++;
			}
			
			ladder.standings().remove(p1);
			ladder.standings().remove(p2);
			draw.add(new Pair(p1,p2));
		}
		
		return draw;
		
	}
}
