package Aud7Generics;

public class MySortedList<T extends Comparable<T>> {
	
	private MyListElement<T> head;
	
	
	int add(T item) {
		if (head == null) {
			head = new MyListElement(item);
			return 0;
		}
		else {
			MyListElement<T> current = head;
			int in=0;
			boolean najmanji = true;
			while (current.getNext() != null) {
				if (item.compareTo(current.getObject()) < 0) {
					System.out.println("aa");
					current.setNext(current);
					current.setObject(item);
					najmanji=false;
					in++;
					return in;
				}
				current = current.getNext();
				System.out.println("bb");
			}
			if (najmanji) {
				current.setNext(new MyListElement (item));
			}
			return in+1; 
		}
	}

	void removeAt(int index) {
		if (index == 0) {
			head = head.getNext();
			return;
		}
		int in=0;
		MyListElement<T> current = head;
		while (in<index-1) {
			current = current.getNext();
		}
		if (current.getNext().getNext() != null) {
			current.setNext(current.getNext().getNext());
		}
	}
	
	T elementAt(int index) {
		MyListElement<T> current = head;
		int in=0;
		while (in<index) {
			current = current.getNext();
		}
		return current.getObject();
		
	}
	
	int size() {
		MyListElement<T> current = head;
		int in=0;
		while (current.getNext() != null) {
			current = current.getNext();
			in++;
		}
		return in;
	}
	
	void print() {
		MyListElement<T> current = head;
		for (int i=0; i<size();i++) {
			System.out.println(current.getObject());
		}
	}
}
