package sn.commande.metier;

import java.util.List;

import javax.ejb.Remote;

import sn.commande.entities.Livraison;
@Remote
public interface ILivraisonRemote {
	public int add(Livraison livraison);
	public int update(Livraison livraison);
	public int delete(int id);
	public Livraison get(int id);
	public List <Livraison> liste();

}
