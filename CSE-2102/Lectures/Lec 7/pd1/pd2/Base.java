// public class where to put 
// how to compile, run & output (getting binary file of all the classes - used/not used)
// identifying class from different file 
// accessing a non public class from another file
// multiple main function possible, we identify during runtume package_name.main_class_name

package pd1.pd2;

public class Base{
   public static void main (String [] args){
        Use u = new Use();
        u.printF();

        Normal n = new Normal();
        n.printF();
   }
}