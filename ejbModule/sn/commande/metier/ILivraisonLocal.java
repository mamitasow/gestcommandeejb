package sn.commande.metier;

import java.util.List;

import javax.ejb.Local;

import sn.commande.entities.Livraison;
@Local
public interface ILivraisonLocal {
	public int add(Livraison livraison);
	public int update(Livraison livraison);
	public int delete(int id);
	public Livraison get(int id);
	public List <Livraison> liste();
}
