package Aud7Generics;

public class MainList {

	public static void main(String[] args) {
		

		MyList<String> list = new MyList<>();
		   
        list.add("F");
        list.add("B");
        list.add("C");
        list.add("H");
        list.add("A");
        list.add("E");
        list.add("G");
        list.print();
        
        System.out.println();
        
        System.out.println(list.size());
        
        System.out.println();
                
        list.removeAt(2);
        list.print();
        System.out.println();
        
        list.add("D");
        list.print();
        
        //list.add(1); //compile error   

	}

}
