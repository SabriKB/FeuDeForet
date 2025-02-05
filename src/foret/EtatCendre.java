package foret;

public class EtatCendre implements Etat {

	private Arbre arbre;
	
	public EtatCendre(Arbre arbre) {
		this.arbre = arbre;
	}
	
	@Override
	public void effetEtat(int etape) {
		//L'arbre a deja brule, n'a pas d'effet
		
	}
	
	public String toString() {
		return "en cendre";
	}
}
