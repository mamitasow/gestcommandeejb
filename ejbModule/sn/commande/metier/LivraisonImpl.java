package sn.commande.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.commande.entities.Livraison;


@Stateless
public class LivraisonImpl implements ILivraisonLocal,ILivraisonRemote{
	 @PersistenceContext(unitName="Gest_CommandeEJB")
	 private EntityManager em;
	@Override
	public int add(Livraison livraison) {
		 int ok = 0;
			try {
				em.persist(livraison);
				em.refresh(livraison);
				ok=livraison.getId();
			}catch(Exception ex) {
				
			}
			return ok;
	}

	@Override
	public int update(Livraison livraison) {
		int ok = 0;
		try {
			em.merge(livraison);
		}catch(Exception ex) {
			
		}
		return ok;
	}

	@Override
	public int delete(int id) {
		int ok = 0;
		try {
			em.merge(em.find(Livraison.class, id));
		}catch(Exception ex) {
			
		}
		return ok;
	}

	@Override
	public Livraison get(int id) {
		return em.find(Livraison.class, id);
	}

	@Override
	public List<Livraison> liste() {
		return em.createQuery("SELECT l FROM Livraison l").getResultList();
	}

}
