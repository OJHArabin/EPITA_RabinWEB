
package fr.epita.rabincore.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import fr.epita.rabincore.datamodel.Identity;


/**
 * @author rabin
 *
 */
@Repository
public class HibernateIdentityDAO {
	@Inject
	private SessionFactory sessionFactory;

	public void save(Identity identity) {

		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		session.save(identity);
		tx.commit();

	}
	public void update(Identity identity) {

		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		System.out.println("into update");
		session.update(identity);
		tx.commit();

	}
	public void delete(Identity identity) {

		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		session.delete(identity);
		tx.commit();

	}

	public Collection<Identity> search(Identity criteria) {
		List<Identity> identitiesList = new ArrayList<>();
		final Session session = sessionFactory.openSession();
//		identitiesList = session.createQuery("from Identity", Identity.class).list();
        identitiesList=session.createQuery("from Identity WHERE IDENTITY_DISPLAY_NAME='"+criteria.getDisplayName() +"' AND IDENTITY_EMAIL='"+criteria.getEmail() +"'",Identity.class).list();
		return identitiesList;
	}
	
	public Collection<Identity> searchAll(Identity criteria) {
		List<Identity> identitiesList = new ArrayList<>();
		final Session session = sessionFactory.openSession();
		identitiesList = session.createQuery("from Identity", Identity.class).list();
//        identitiesList=session.createQuery("from Identity WHERE IDENTITY_DISPLAY_NAME='"+criteria.getDisplayName() +"' AND IDENTITY_EMAIL='"+criteria.getEmail() +"' AND IDENTITY_BIRTHDATE='"+criteria.getBirthDate()+"'",Identity.class).list();
		return identitiesList;
	}
	
	public Identity getById(long id) {
		final Session session = sessionFactory.openSession();
		
		return session.get(Identity.class, id);
	}
	
}
