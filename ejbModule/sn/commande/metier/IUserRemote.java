package sn.commande.metier;

import java.util.List;

import javax.ejb.Remote;

import sn.commande.entities.User;




@Remote
public interface IUserRemote 
{
	public int add(User user);
	public int update(User user);
	public int delete(int id);
	public User get(int id);
	public List<User> liste();
	public User verifUser(String email, String password);
	public List<User> recherche(String motCle);
}
