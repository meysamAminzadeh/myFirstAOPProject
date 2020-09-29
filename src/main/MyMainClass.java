package main;

import classess.Annotated;
import classess.SpringBean;
import myClasses.MyClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by asus on 7/16/2020.
 */
public class MyMainClass {
    public static void main(String[] args)  {

        ApplicationContext context= new ClassPathXmlApplicationContext("conf/application-context.xml");
        MyClass myClass = context.getBean(MyClass.class);
      /*  myClass.insert();
        myClass.insert("meysam","aminzadeh");
        myClass.insert("meysam");*/

        try {
           // myClass.div(10,0);
           // myClass.div(10,2);
           // myClass.divWithResult(10,2);
           // myClass.login("meysam","aminzadeh");
           // myClass.login("mey'sam","aminzadeh");

           // Annotated annotated = context.getBean(Annotated.class);
           // annotated.m1();

           /* SpringBean springBean= context.getBean(SpringBean.class);
            springBean.m3();
            springBean.m4();
*/
        myClass.select();
        } catch (Exception e) {

        }
    }
}
