package aud5Rekapitulacija;

public class MainList {

	public static void main(String[] args) {
		SimpleArrayList list = new SimpleArrayList();
	    list.add("first");
	    list.add("second");
	    list.add("third");

	    System.out.println(list.size()); // 3
	    for(int i = 0; i < list.size(); i++)
	      System.out.println("Element " + i + ": " + list.get(i));
	    System.out.println(list.indexOf("second")); // 1

	}

}
