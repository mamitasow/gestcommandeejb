package sn.commande.metier;

import java.util.List;

import javax.ejb.Local;

import sn.commande.entities.Commande;


@Local
public interface ICommandeLocal {

	public int add(Commande commande);
	public int update(Commande commande);
	public int delete(int id);
	public Commande get(int id);
	public List <Commande> liste();

}
