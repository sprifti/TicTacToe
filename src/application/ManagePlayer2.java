package application;


import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.Entity.player2Table;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class ManagePlayer2 {
	public static SessionFactory
	factory = new Configuration().configure().addAnnotatedClass(player2Table.class).buildSessionFactory();
	 Session session=factory.getCurrentSession();

	public static void main(String[] args) {


	}

	public static void addPlayer2( String name2, int score2){
	      Session session = factory.openSession();


	      try {
	          session.beginTransaction();
	         player2Table play2 = new player2Table( name2, score2);
	         session.save(play2);
	         session.getTransaction().commit();
	      } catch (Exception e) {
	    	  session.getTransaction().rollback();
	      } finally {
	         session.close();
	      }

	   }

	   public static void listPlayer2(String name, int score){
		      Session session = factory.openSession();

		      player2Table play2=null;
		      try {List list=null;
		          session.beginTransaction();
		          Query query = session.createQuery("FROM player2Table where name2='" + name + "'");
		          list=query.getResultList();
		          if(!list.isEmpty()){
		          play2=(player2Table) query.getSingleResult();
		          play2.setPlayerTwo(play2.getPlayerTwo() + score);
		          session.update(play2);
		          } else {
		        	  player2Table newPlayer = new player2Table( name, score);
		        	  session.save(newPlayer);
		          }

		        session.getTransaction().commit();

		      } catch (HibernateException e) {
		        session.getTransaction().rollback();
		      } finally {
		         session.close();
		      }

		      }



	   public static void updatePlayer2(String name, int score ){
		     Session session = factory.openSession();
		      try {
		          session.beginTransaction();
		         player2Table play2 = (player2Table)session.get(player2Table.class, name);
		         play2.setPlayerTwo( score );
				 session.update(play2);
		        session.getTransaction().commit();
		      } catch (HibernateException e) {
		         session.getTransaction().rollback();
		      } finally {
		         session.close();
		      }
		   }


	   public static List afisho(){
		   Session session = factory.openSession();
		 List play2=null;
		      try {

		         session.beginTransaction();
		         play2 = session.createQuery("FROM player2Table order by score2 DESC").list();
		         session.getTransaction().commit();

		      } catch (HibernateException e) {
		         session.getTransaction().rollback();
		      } finally {
		         session.close();
		      }
		      return play2;

	   }


}
