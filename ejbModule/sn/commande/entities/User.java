package sn.commande.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
	@NamedQuery(name="User.login",query="SELECT u FROM User u WHERE u.login=:email AND u.password=:password")
})
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	@Column
	private String Nom;
	@Column
	private String Prenom;
	@Column(length=100)
	private String password;
	@Column(unique=true,length=200)
	private String login;
	@OneToMany(mappedBy="user",cascade = {CascadeType.ALL})
	private List<Commande> commandes = new ArrayList<Commande>();
	@OneToMany(mappedBy="user",cascade = {CascadeType.ALL})
	private List<Livraison> lieux = new ArrayList<Livraison>();
	


	public User() {
		super();
	}
	public User(int id , String nom, String prenom, String password, String login) {
		super();
		this.id = id;
		Nom = nom;
		Prenom = prenom;
		this.password = password;
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id ) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	

}
