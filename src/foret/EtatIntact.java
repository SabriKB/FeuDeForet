package foret;

public class EtatIntact implements Etat {
	private Arbre arbre;
	
	public EtatIntact(Arbre arbre) {
		this.arbre = arbre;
	}

	@Override
	public void effetEtat(int etape) {
		//N'a pas d'effet
		
	}
	
	public String toString() {
		return "est intact";
	}

}
