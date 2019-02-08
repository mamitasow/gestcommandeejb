package sn.commande.metier;

import java.util.List;

import javax.ejb.Local;

import sn.commande.entities.User;


@Local
public interface IUserLocal 
{
	public int add(User user);
	public int update(User user);
	public int delete(int id);
	public User get(int id);
	public List<User> liste();
	public User verifUser(String email, String password);
	public List<User> recherche(String motCle);
}
