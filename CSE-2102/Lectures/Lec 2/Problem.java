
class Person{
    int age;
    String name;
    int pref[];
    //Person(){}
    Person(int a, String s, int p, int q, int r){
        pref = new int[10];
        this.age = a; 
        this.name = s;
        pref[0] = p;
        pref[1] = q;
        pref[2] = r;
    }

    boolean checkPref(int ch){
        for(int i=0; i<3; i++){
            if(this.pref[i] == ch) {
                return true; 
            }
        }
        return false;
    }

    boolean checkName(String s){
        if(s.length() != name.length()) {
            return false; 
        }
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == name.charAt(i)) {
                continue; 
            }
            return false; 
        }
        return true; 
    }

    boolean checkAge(int a){
        if (age == a) return true; 
        return false; 
    }

    boolean validity(int a, String s, int ch) {
        boolean o1 = checkAge(a);
        boolean o2 = checkName(s);
        boolean o3 = checkPref(ch); 
        boolean decision = o1 & o2 & o3;
        return decision; 
    }

    void setAge(int age){
        this.age = age; 
    }
    int getAge() {
        return this.age; 
    }
}

public class Problem{
    public static void main (String [] args) {
        //Person p = new Person();
        Person p = new Person(10, "rizvee", 7, 13, 25);
        boolean check = p.validity(10, "rizvee", 13);
        System.out.println("User verdict: "  + check);
        Person pArr[] = new Person[30]; 
        pArr[0] = new Person(20, "a", 1 , 2 , 3);
        pArr[18] = p;
    }
}