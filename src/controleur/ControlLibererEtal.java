package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur)!=null;
	}

	/**
	 * 
	 * @param produit
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		Boolean isOccupe = etalVendeur.isEtalOccupe();
		Integer quantiteDebutMarche = etalVendeur.getQuantiteDebutMarche(); 
		Integer quantite = etalVendeur.getQuantite();;
		
		donneesEtal[0] = isOccupe.toString();
		donneesEtal[1] = nomVendeur;
		donneesEtal[2] = etalVendeur.getProduit();
		donneesEtal[3] = quantiteDebutMarche.toString();
		donneesEtal[4] = quantite.toString();
		return donneesEtal;
	}

}
