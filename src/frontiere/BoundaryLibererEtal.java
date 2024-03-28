package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre"
					+ " marché aujourd'hui!");
		}
		else {
			String[] donneesEtal = new String[5];
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneesEtal[0];
			
			if(etalOccupe.equals("true")) {
				String produit = donneesEtal[2];
				String quantiteInitial = donneesEtal[3];
				String quantiteVendu = donneesEtal[4];
				System.out.println("Vous avez vendu "+quantiteVendu+" sur "+quantiteInitial+" "+produit+".");
				
				System.out.println("Au revoir "+nomVendeur+", passez une bonne journée");
			}
		}
	}

}
