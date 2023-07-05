package Aud7Generics;

public class MyListElement<E> {
	
	public MyListElement(E obj) {
		this.object = obj;
		
	}
	
	public E getObject() {
		return object;
	}
	public void setObject(E object) {
		this.object = object;
	}
	public MyListElement<E> getNext() {
		return next;
	}
	public void setNext(MyListElement<E> next) {
		this.next = next;
	}
	private E object;
	private MyListElement<E> next;

}
