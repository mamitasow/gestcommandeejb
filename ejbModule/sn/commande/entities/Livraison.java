package sn.commande.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Livraison {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String date;
	@OneToMany(mappedBy="livraison",cascade = {CascadeType.ALL})
	private List<Commande> commandes = new ArrayList<Commande>();
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user = new User();
	public Livraison() {
		
	}
	public Livraison(int id, String date, List<Commande> commandes) {
		super();
		this.id = id;
		this.date = date;
		this.commandes = commandes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Commande> getListcommade() {
		return commandes;
	}
	public void setListcommade(List<Commande> listcommade) {
		this.commandes = listcommade;
	}
	
 public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return date;
}
}
		
		