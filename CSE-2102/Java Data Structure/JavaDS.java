import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.random.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.HashMap;


class TempObject{
    String val;
    TempObject(String v){
        this.val = v; 
    }
    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != this.getClass()) return false; 
        if(this == o) return true;
        TempObject t = (TempObject) o; 
        return Objects.equals(this.val, t.val); // not directly o.val -> first doing type casting  
    }
    @Override
    public int hashCode(){ // importance of hashcode 
        // return Objects.hash(this); 
        return Objects.hash(this.val); 
    }

    @Override
    public String toString(){
        return "Custon String " + this.val; 
    }
}

public class JavaDS{

    static void useArr(){
        int arr [] = new int [5];
        String arr2[] = new String [5];
        arr2[0] = "abc"; 
        arr2[1] = "def";
        // printing method 1
        for(int i=0; i<2; i++){
            System.out.println(arr2[i]);
        }
        // printing method 2
        System.out.println(Arrays.toString(arr2));
        // printing method 3
        for(String s:arr2){
            System.out.println(s);
        }
        // using Arrays class [having a lot of utility methods/bunch of methods]
        Arrays.stream(arr2).forEach( x-> System.out.println(x));
    }

    static void twoDArrays(){
        char arr[][] = new char[3][3];
        Random r = new Random(); 
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                int v = r.nextInt(2);
                if(v%2 == 0) {
                    arr[i][j] = 'o'; 
                }
                else{
                    arr[i][j] = 'x';
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+ " "); 
            }
            System.out.println(); 
        }
        System.out.println(Arrays.deepToString(arr)); 
        System.out.println(Arrays.toString(arr)); 
        System.out.println(arr); 
    }

    static void usingLists(){
        /* in this implementation I can put any type of object altogether */
        // List list = new ArrayList(); 
        // list.add("color");
        // list.add(10.5);
        // list.add('a'); 
        // for(int i=0; i<list.size(); i++){
        //     System.out.println(list.get(i)); // list[i] x 
        // }
        
        // /* in this implementation I can only put a type of object as I have specified */
        List <String> list = new ArrayList<>(); // already specified which type to put here
        // vs ArrayList <String> list = new ArrayList<>(); vs LinkedList <String> list = new ArrayList<>();
        list.add("color");
        list.add("yellow");
        list.add("green"); 
        for(int i=0; i<list.size(); i++){ // Observe here the function is size() not length attribute 
            System.out.println((list.get(i)));
        } 
        list.set(1, "class"); // to update a particular index 
        System.out.println(list.contains("yellow")); // return boolean
        System.out.println(list.contains("black")); 
        /* an unimutable list creation */
        List<String>temp = List.of(
            "black", "green", "yellow", "pink"
        );
        // temp.add("orange"); // this will cause an error, because, this list can not be increased
        //temp.set(1, "creamson"); // similar kind of concern
    }

    static void usingStack(){
        Stack<Integer>s = new Stack<>();
        s.push(10);
        s.push(76);
        s.push(456); 

        System.out.println(s.peek());
        while(s.empty() == false){
            System.out.println(s.pop());
        }

    }
    static void usingQueue(){
        Queue<Integer>Q = new LinkedList<>(); // Be careful, Queue is abstract, right hand side is different
        Q.add(10);
        Q.add(76);
        Q.add(456);

        while (Q.isEmpty() == false) {
            System.out.println(Q.peek());
            Q.poll(); // remember Queue interface does not have pop() in its implementation 
        }
    }
    static void usingLL(){
        LinkedList<String> l = new LinkedList<>();
        l.add("empty");
        l.add("value");
        l.add("given not");
    
       // l.pop(); // remove vs poll 
       ListIterator<String> lt = l.listIterator(); 
       while(lt.hasNext()){ // vs hasPrevious 
        System.out.println(lt.next()); // lt.previous
       }
       for(int i=0; i<l.size(); i++){
        System.out.println(l.get(i));
       }
    }

    static void usingSet(){
        // no repitition will hold 
        Set<String>S = new HashSet<>(); // HashSet is unordered (elements can be kept in any position), Another possibility is TreeSet which is ordered 
        
        S.add("yellow");
        S.add("mango");
        S.add("orange");

        S.add("yellow");
        S.add("mango");
        S.add("orange");

        // we can not directly access the elements of a set 
        Iterator<String> it = S.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        S.remove("yellow"); 
        it = S.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        } // multiple copies are never stored. Only a single value is stored here 
        
        for(String s:S){ // another way for printing 
            System.out.println(s);
        }
        S.forEach(System.out::println); // another way to work with the value 

        // What if, we consider the object here (value based comparison vs memory based comparison)

    }

    static void usingMap(){
        Map<Integer, String> m = new HashMap<>();
        m.put(1, "rizvee");
        m.put(2, "redwan");
        m.put(3, "ahmed"); 

        //m.put(1, "akash"); 
        System.out.println(m.get(2));
        System.out.println(m.keySet()); 
        m.forEach((x, y) -> System.out.println("key is " + x + " value is " + y));
        m.keySet().forEach(x -> System.out.println("key is " + x));
        m.entrySet().forEach(x ->System.out.println("key is  " + x + " value is " +x.getValue()));
        System.out.println(m); 

        Map<TempObject, Integer> m2 = new HashMap<>();
        m2.put(new TempObject("rizvee"), 1);
        m2.put(new TempObject("redwan"), 2);
        m2.put(new TempObject("ahmed"), 3);

        System.out.println(m2.get(new TempObject("redwan")));
        System.out.println(m2.keySet()); 
        m2.forEach((x, y) -> System.out.println("key is " + x + " value is " + y));
        m2.keySet().forEach(x -> System.out.println("key is " + x));
        m2.entrySet().forEach(x ->System.out.println("key is  " + x + " value is " +x.getValue()));
        System.out.println(m2); 

    }
    public static void main (String [] args){
        //useArr();
        //twoDArrays();
        //usingLists();
        //usingStack();
        //usingQueue();
        //usingLL();
        //usingSet();
        usingMap();
        // TempObject a = new TempObject("a");
        // TempObject b = new TempObject("a");
        // System.out.println(a.equals(b));
    }
}