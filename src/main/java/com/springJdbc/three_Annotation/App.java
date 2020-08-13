package com.springJdbc.three_Annotation;

import com.springJdbc.three_Annotation.DAO.EmployDAO;
import com.springJdbc.three_Annotation.Entity.Employ;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        EmployDAO employDAO = context.getBean("employDAO", EmployDAO.class);
        //Insert
        Employ employ = new Employ();
        employ.setId(102);
        employ.setName("Employ-2");
        employ.setCity("Khulna");

        int r = employDAO.insert(employ);
        System.out.println("Number of row inserted: "+r);

        //Update
        /*Employ employ1 = new Employ();
        employ1.setId(102);
        employ1.setName("Emoloy-2");
        employ1.setCity("Barisal");
        int r1 = employDAO.change(employ1);
        System.out.println("updated data: "+r1);*/


        //Delete
       /* int r3 = employDAO.delete(102);
        System.out.println(r3+" employ deleted");*/

        //fetch one
        /*Employ employ = employDAO.getEmploy(102);
        System.out.println(employ);
*/

        //fetch all
      /*  List<Employ> employs = employDAO.getAllEmploys();
        for (Employ e: employs){
            System.out.println(e);
        }*/

    }
}
