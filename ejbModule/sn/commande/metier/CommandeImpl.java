package sn.commande.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.commande.entities.Commande;


@Stateless
public class CommandeImpl implements ICommandeLocal,ICommandeRemote {
	 @PersistenceContext(unitName="Gest_CommandeEJB")
	 private EntityManager em;
	@Override
	public int add(Commande commande) {
		 int ok = 0;
			try {
				em.persist(commande);
				em.refresh(commande);
				ok=commande.getId();
			}catch(Exception ex) {
				
			}
			return ok;
	}

	@Override
	public int update(Commande commande) {
		int ok = 0;
		try {
			em.merge(commande);
		}catch(Exception ex) {
			
		}
		return ok;
	}

	@Override
	public int delete(int id) {
		int ok = 0;
		try {
			em.remove(em.find(Commande.class, id));
		}catch(Exception ex) {
			
		}
		return ok;
	}

	@Override
	public Commande get(int id) {
		return (Commande)em.createQuery("select c from Commande c where c.id=:id").setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Commande> liste() {
		return em.createQuery("SELECT c FROM Commande c").getResultList();
	}

}
