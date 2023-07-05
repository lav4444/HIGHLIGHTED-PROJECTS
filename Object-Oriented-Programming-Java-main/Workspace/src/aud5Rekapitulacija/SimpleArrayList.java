package aud5Rekapitulacija;

import java.util.Arrays;

public class SimpleArrayList {
	
	public SimpleArrayList() {
		super();
	}
	private Object[] polje = new Object[2];
	private int cnt=0;
	
	public boolean add(Object o) {
		if (cnt < polje.length) {
			polje[cnt] = o;
			cnt++;
		} else {
			Object[] brzac = Arrays.copyOf(polje, polje.length*2 );
			polje = Arrays.copyOf(brzac, brzac.length );
			polje[cnt] = o;
			cnt++;

		}
		return true;
	}
	public int size() {
		return cnt;
		
	}
	public Object get(int index) {
		return polje[index];
	}
	public int indexOf(Object o) {
		int idx = -1;
		for (Object bb: polje) {
			idx++;
			if (bb.equals(o)) {
				return idx;
			}
			
		}
		return -33;
	}

}
