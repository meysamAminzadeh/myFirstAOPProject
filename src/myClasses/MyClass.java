package myClasses;

import classess.MyAnnotation;

/**
 * Created by asus on 7/16/2020.
 */
public class MyClass {

public void insert(){
    System.out.println(" insert anjam shod ");
}

    public void insert(String name , String family){
        System.out.println(" insert name= "+name +" family:"+family);
    }

    public boolean insert(String name ){
        System.out.println(" insert name= "+name + " return true " );
        return true;
    }

    public void div(int a , int b) throws Exception {

        if(b==0)
           // throw new Exception(" taghsim bar sefr");
         throw new ArithmeticException("taghsim bar sefr");
       else
            System.out.println(a/b);
    }

    public int divWithResult(int a , int b) throws Exception {
        int result=0;
        if(b==0)
            // throw new Exception(" taghsim bar sefr");
            throw new ArithmeticException("taghsim bar sefr");
        else {
            result = a / b;
            System.out.println(result);
           }
        return result;
    }

    @MyAnnotation
    public void login (String userName , String password){

        System.out.println(" login is exceuted ");
    }

    public void select(){
        System.out.println(" select is executed ");
    }
}
