package ZZV09Kolekcije;

public class Pair<T> {
	
	public void setPair1(T pair1) {
		this.pair1 = pair1;
	}
	public void setPair2(T pair2) {
		this.pair2 = pair2;
	}
	@Override
	public String toString() {
		return "Pair [" + pair1 + ", " + pair2 + "]";
	}
	public T getFirst() {
		return pair1;
	}

	public T getSecond() {
		return pair2;
	}

	public Pair(T pair1, T pair2) {
		super();
		this.pair1 = pair1;
		this.pair2 = pair2;
	}
	T pair1;
	T pair2;

}
