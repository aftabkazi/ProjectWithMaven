
package com.tutorial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "project started" );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
        
        //creating student
        Student st=new Student();
        st.setId(101);
        st.setName("Aftab");
        st.setCity("Gadhinglaj");
        
        Student st1=new Student();
        st1.setId(102);
        st1.setName("Bushra");
        st1.setCity("Gadhinglaj");
        System.out.println(st);
        
        Address ad=new Address();
        ad.setStreet("street 1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.4);
        
        // reading image
        FileInputStream fis=new FileInputStream("src/main/java/image.jpeg");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
      
        Session session=factory.openSession();
        
        session.beginTransaction();
        session.save(st);
        session.save(st1);
        session.save(ad);
        session.getTransaction().commit();
        
        session.close();
        
       System.out.println("factory : "+factory);
    }
}
