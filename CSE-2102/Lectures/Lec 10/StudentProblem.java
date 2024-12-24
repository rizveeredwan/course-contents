


class Student{
    int roll;
    String name;
    int arr []; 
    Transaction tr[]
    Student(int r, String n){
        roll = r;
        name = n; 
        arr = new int[7]; 
        tr = new Transaction[7];
    }
}

class Transaction{
    int type;
    int amount; 
    Transaction(int t, int a){
        type = t;
        amount = a; 
    }
}

class Customer{
    String id; 
    String name;
    Transaction tr[]
    Customer(String id, String n){
        this.id = id;
        name = n; 
        tr = new Transaction[7];
    }
}



class Teacher{
    Student allStudent[];
    Customer allCustomer[]; 

    int cnt; 
    Teacher(){
        allStudent = new Student[100]; 
        allCustomer = new Customer[100]; 
        int cnt = 0; 
    }
    void addNewStudent(Student s){
        allStudent[cnt] = s; 
        cnt++; 
    }
    void addAttendance(int roll, int day, int pr){
        for(int i=0; i<cnt; i++){
            if(allStudent[i].roll == roll) {
                allStudent[i].arr[day] = pr; 
            }
        }
    }
    void addTransaction(String id, int day, int amount){
        for(int i=0; i<cnt; i++){
            if(allCustomer[i].id == id) {
                if(amount > 0) { // deposit
                    allCustomer[i].tr[day] = Transaction(1,amount)
                }
                if(amount < 0) { // withdraw
                    allCustomer[i].tr[day] = Transaction(2,amount*-1)
                }
                if(amount == 0) { // no transaction
                    allCustomer[i].tr[day] = Transaction(0,0)
                }
            }
        }
    }
    void printStat(int roll){
        for(int i=0; i<cnt; i++){
            if(allStudent[i].roll == roll) {
               int present = 0; 
               for(int j=0; j<7; j++){
                   if(allStudent[i].arr[j] == 1) {
                    present++; 
                   } 
               }
               // ..... 
            }
        }
    }
}


public class StudentProblem{
    public static void main (String [] args){

    }
}