package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
	    Acheteur acheteur = new Acheteur(nomAcheteur);
	    acheteur.effectuerAchat();
	}

	private class Acheteur {
	    private String nom;

	    public Acheteur(String nom) {
	        this.nom = nom;
	    }

	    public void effectuerAchat() {
	        if (!controlAcheterProduit.gauloisAppartientVillage(nom)) {
	            System.out.println("Je suis désolée " + nom + " mais "
	                    + "il faut être un habitant de notre village pour commercer ici.");
	            return;
	        }

	        String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
	        Gaulois[] vendeurProduit = controlAcheterProduit.vendeurProduit(produit);

	        if (vendeurProduit == null) {
	            System.out.println("Désolé, personne ne vend ce produit au marché.");
	            return;
	        }

	        for (int i = 0; i < vendeurProduit.length; i++) {
	            System.out.println((i + 1) + "- " + vendeurProduit[i].getNom());
	        }

	        int numCommercant = Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des " + produit + "?");

	        Gaulois vendeur = vendeurProduit[numCommercant - 1];
	        String nomEtalVendeur = vendeur.getNom();

	        if (!controlAcheterProduit.gauloisAppartientVillage(nomEtalVendeur)) {
	            System.out.println("Je suis désolée " + nomEtalVendeur + " mais "
	                    + "il faut être un habitant de notre village pour commercer ici.");
	            return;
	        }

	        Etal etalVendeur = controlAcheterProduit.controlAcheterProduit(nomEtalVendeur);
	        int quantiteEtalVendeur = etalVendeur.getQuantite();

	        System.out.println(nom + " se déplace jusqu'à l'étal du vendeur " + nomEtalVendeur);
	        int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter? ");

	        int quantiteAcheter = etalVendeur.acheterProduit(quantite);
	        if (quantiteAcheter == 0) {
	            System.out.println(nom + " veut acheter " + quantite + " " + produit + ", "
	                    + "malheureusement il n’y en a plus !");
	        } else if (quantite > quantiteAcheter) {
	            System.out.println(nom + " veut acheter " + quantite + " " + produit + ", "
	                    + "malheureusement " + nomEtalVendeur + " n’en a plus que " + quantiteEtalVendeur + ". "
	                    + nom + " achète tout le stocke de " + nomEtalVendeur + ".");
	        } else {
	            System.out.println(nom + " achète " + quantiteAcheter + " " + produit + " à " + nomEtalVendeur + ".");
	        }
	    }
	}


}
