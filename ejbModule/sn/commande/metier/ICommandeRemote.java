package sn.commande.metier;

import java.util.List;

import javax.ejb.Remote;

import sn.commande.entities.Commande;

@Remote
public interface ICommandeRemote {
	public int add(Commande commande);
	public int update(Commande commande);
	public int delete(int id);
	public Commande get(int id);
	public List <Commande> liste();
}
