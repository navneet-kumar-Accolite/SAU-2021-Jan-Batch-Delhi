package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Application {
    private static Configuration connectionVar  = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Navneet.class);
    private static SessionFactory sessionFactoryVar = connectionVar.buildSessionFactory();

    public static void saveAlienData(){
        Alien alien = new Alien(1002, "Navneet", "Black");
        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
    }

    public static Alien getAlienData(int id){
        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien = (Alien)session.get(Alien.class, id);
        tx.commit();
        return alien;
    }

    public static void firstLevelCaching(){
        System.out.println("Showing First Level Caching");
        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien1 = (Alien)session.get(Alien.class, 1001);
        Alien alien2 = (Alien)session.get(Alien.class, 1001);
        System.out.println(alien1);
        System.out.println(alien2);
        tx.commit();

    }

    public static void secondLevelCaching(){
        System.out.println("Showing Second Level Caching");
        System.out.println("You are in Session : 1");
        Session session1 = sessionFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Alien alien1 = (Alien)session1.get(Alien.class, 1001);
        System.out.println(alien1);
        tx1.commit();

        System.out.println("You are in Session : 2");
        Session session2 = sessionFactoryVar.openSession();
        Transaction tx2 = session2.beginTransaction();
        alien1 = (Alien)session2.get(Alien.class, 1001);
        System.out.println(alien1);
        tx2.commit();
    }

    public static void HQL(int id){
        Alien a ;
        Session session1 = sessionFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = " + id);
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();

        Session session2 = sessionFactoryVar.openSession();
        Transaction tx2 = session2.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = " + id);
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        tx2.commit();
    }

    public static void Query(){
        Alien alien;
        Session session = sessionFactoryVar.openSession();
        Transaction tx2 = session.beginTransaction();

        Query query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien)query.uniqueResult();
        System.out.println("Query 1 Result : " + alien);

        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 2 Result : " + alien);

        query = session.createQuery("from Alien where aname = 'Navneet'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 3 Result : " + alien);

        query = session.createQuery("from Alien where aname = 'Kapil'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 4 Result : " + alien);

        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 5 Result : " + alien);

        tx2.commit();
    }


    public static void main(String [] args){

        saveAlienData();

        Alien alienObj = (Alien)getAlienData(1001);
        System.out.println(alienObj);

        firstLevelCaching();
        secondLevelCaching();
        HQL(1001);
        Query();
    }

}