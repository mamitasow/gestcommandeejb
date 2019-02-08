package sn.commande.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
	@Column
 private String libelle;
	@Temporal(TemporalType.TIMESTAMP)
 private Date datecommande;
	@Column
 private Double Montant;
	@Column
 private String etat;
@ManyToOne
@JoinColumn(name="livraison_ID")
 private Livraison livraison = new Livraison();
@ManyToOne
@JoinColumn(name="user_id")
private User user = new User();
public Commande() {
	super();
}
public Commande(int id, String libelle, Date datecommande, Double montant, String etat, Livraison livraison) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.datecommande = datecommande;
	Montant = montant;
	this.etat = etat;
	this.livraison = livraison;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public Date getDatecommande() {
	return datecommande;
}
public void setDatecommande(Date datecommande) {
	this.datecommande = datecommande;
}
public Double getMontant() {
	return Montant;
}
public void setMontant(Double montant) {
	Montant = montant;
}
public String getEtat() {
	return etat;
}
public void setEtat(String etat) {
	this.etat = etat;
}
public Livraison getLivraison() {
	return livraison;
}
public void setLivraison(Livraison livraison) {
	this.livraison = livraison;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
