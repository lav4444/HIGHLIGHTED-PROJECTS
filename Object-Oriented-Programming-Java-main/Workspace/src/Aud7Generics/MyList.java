package Aud7Generics;

public class MyList<T> {
	
	private MyListElement<T> head;
	private int cnt = 0;
	
	int add(T item) {
		if (head == null) {
			head = new MyListElement(item);
			return 0;
		} else {
		int indx = 0;
		MyListElement<T> current = head;
		while (current.getNext() != null) {
			indx++;
			current = current.getNext();
			
		}
		current.setNext(new MyListElement<> (item));
		indx++;
		return indx;
		}
	}
	
	void print() {
		MyListElement<T> current = head;
		while (current.getNext() != null) {
			System.out.println(current.getObject());
			current = current.getNext();
		}
		System.out.println(current.getObject());
	}
	
	T elementAt(int index) {
		MyListElement<T> current = head;
		int indx = 0;
		while (indx != index) {
			indx++;
			current = current.getNext();
		}
		return current.getObject();
	}
	
	int size() {
		MyListElement<T> current = head;
		int indx = 0;
		while (current.getNext() != null) {
			indx++;
			current = current.getNext();
		}
		return indx+1;
	}
	
	void removeAt(int index) {
		boolean prom = false;
		int indx = 0;
		if (index == 0) {
			head = head.getNext();
			return;
		}
		MyListElement<T> current = head;
		for (int i=0; i < index-1; i++) {
			current = current.getNext();
		}
		if (current.getNext() != null) {
			current.setNext(current.getNext().getNext());
		}
			
	}

}
