package com.springJdbc.oneUsingXml;

import com.springJdbc.oneUsingXml.DAO.StudentDAO;
import com.springJdbc.oneUsingXml.Entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDAO studentDAO = context.getBean("studentDAOImplement", StudentDAO.class);
        //Insert
       /* Student student = new Student();
        student.setId(1003);
        student.setName("Hashib");
        student.setCity("Mymensingh");

        int r = studentDAO.insert(student);
        System.out.println("Number of row inserted: "+r);*/

        //Update
        /*Student student1 = new Student();
        student1.setId(1003);
        student1.setName("Hashib");
        student1.setCity("Barisal");
        int r1 = studentDAO.change(student1);
        System.out.println("updated data: "+r1);*/


        //Delete
        /*int r3 = studentDAO.delete(1003);
        System.out.println(r3+" student deleted");*/

        //fetch one
       /* Student student = studentDAO.getStudent(1002);
        System.out.println(student);*/


        //fetch all
        List<Student> students = studentDAO.getAllStudents();
        for (Student s: students){
            System.out.println(s);
        }

    }
}
