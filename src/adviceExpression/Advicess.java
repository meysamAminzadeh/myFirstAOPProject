package adviceExpression;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by asus on 7/23/2020.
 */
public class Advicess {
   @Pointcut(value = "execution( *  select (..))")
    public void myMethod(){}
}
