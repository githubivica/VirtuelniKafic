package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

public class RegistracijaDAO {

	private SessionFactory sf = (SessionFactory) new Configuration().configure().buildSessionFactory();
	
	
	
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean upisiUseraUBazu (String userName, String password, double novcanik) {
		
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setNovcanik(novcanik);
		
		Rola rola;
		
		if (ValidacijaZaRegistraciju.daLiJeAdmin(userName, password)) {
			rola = Rola.ADMINISTRATOR;
		}else {
			rola = Rola.KORISNIK;
		}
			
		user.setRola(rola);	
			
			
		Session session = sf.openSession(); 
			session.beginTransaction();
			
		try {
			session.save(user);
			session.getTransaction().commit();
			System.out.println("Uspesno ubacen user");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();	
			System.out.println("Neuspesno ubacen user");
			return false;
		}
		finally {
			session.close();	
		}
	
	}
	
	
	
}

