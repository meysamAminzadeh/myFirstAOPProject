package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by asus on 7/16/2020.
 */
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Before("execution(void insert())")
    public void beforeInserts(){

        System.out.println(" before for example void insert without paramater ");
    }
    @Before("execution(void insert(..))")
    public void beforeInserts2(){

        System.out.println(" before for example void insert with  parameters  ");
    }
    @Before("execution(* insert(..))")
    public void beforeInserts3(){

        System.out.println(" before for example with return type insert ");
    }
    @Before("execution(void insert(..))")
    public void beforeInserts2(JoinPoint joinPoint){
        System.out.println(" before for example void insert with  parameters ");
        System.out.println("joinPoint : "+joinPoint.getSignature());
    }

    @After(value = "execution(void insert())")
    public void afterInserts(){

        System.out.println(" After for example void insert without paramater ");
    }
    @After("execution(void insert(..))")
    public void afterInserts2(){

        System.out.println(" After for example void insert with  parameters  ");
    }
    @After("execution(* insert(..))")
    public void afterInserts3(){

        System.out.println(" After for example with return type insert ");
    }
    @After("execution(void insert(..))")
    public void afterInserts2(JoinPoint joinPoint){
        System.out.println(" After for example void insert with  parameters ");
        System.out.println("joinPoint : "+joinPoint.getSignature());
    }

    @AfterThrowing(value = " execution( * div (..))",throwing = "ex")
    public void afterException (Throwable ex){
        System.err.println(" exception class : "+ex.getClass());
        System.err.println(" exception message : "+ ex.getMessage());
    if(ex.getClass().toString().contains("Arithmetic"))
        System.out.println("khataie riazi");

    }
    @AfterThrowing(pointcut = " execution( * div (..))",throwing = "ex")
    public void afterException (JoinPoint joinPoint, Throwable ex){
        System.err.println(" exception class : "+ex.getClass());
        System.err.println(" exception message : "+ ex.getMessage());

        if(ex.getClass().toString().contains("Arithmetic"))
            System.out.println("khataie riazi in " + joinPoint.getSignature());

        if(ex.getClass()== ArithmeticException.class)
            System.out.println("khataie riazi in " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution( * div (..))")
    public void afterSuccess (JoinPoint joinPoint){
        System.out.println(" this method= "+ joinPoint.getSignature() +" excute withou any exception ");
    }

    @AfterReturning(pointcut = "execution( * divWithResult (..))",returning = "result")
    public void afterSuccess (JoinPoint joinPoint,int result){
        System.out.print(" this method= "+ joinPoint.getSignature() +" excute withou any exception ");
        System.out.println( " and return value is = " +result );
    }

    @Around(value = "execution( * div (..))")
    public void around(ProceedingJoinPoint pj){

        System.out.println("before around");
        System.out.println("joinpoint is :"+pj.getSignature());
        try {
            pj.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after around");
    }

    @Around(value ="execution( void login (..))")
    public void aroundLogin(ProceedingJoinPoint pj) throws Throwable {
        System.out.println(" before login ");

        for (Object o : pj.getArgs())
            System.out.println(o.toString());

        if(!(pj.getArgs()[0].toString().contains("'") || pj.getArgs()[1].toString().contains("'")))
                  pj.proceed();

        System.out.println(" after login ");
    }

    @Before(value = "execution( @ *.MyAnnotation * *(..) )")
    public void beforeAnnotation(){
        System.out.println(" before annotation ***** ");
    }
    @Before(value = "bean(mySpringBean)")
    public void springBean(){
        System.out.println(" advice Bean anjam shod ");
    }

    @Before(value = "bean(mySpringBean) || execution(* insert(..))")
    public void springBean1(){
        System.out.println(" advice Bean  and insert method anjam shod ");
    }
    @Before(value = "bean(mySpringBean) || execution( @ *.MyAnnotation * *(..) ) || execution(* insert(..))")
    public void springBean2(){
        System.out.println(" advice Bean  and insert method and anotation anjam shod ");
    }
    @After(value = "adviceExpression.Advicess.myMethod()")
    public void methodAdvice(){
        System.out.println(" expression in other class with method executed ");
    }
}
