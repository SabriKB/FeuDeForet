package foret;

import java.util.Iterator;

public class EtatFeu implements Etat {
	
	private Arbre arbre;
	
	public EtatFeu(Arbre arbre) {
		this.arbre = arbre;
	}

	@Override
	public void effetEtat(int etape) {
		Iterator<Arbre> listArbre = this.arbre.getArbreAdjacent().iterator();
		while(listArbre.hasNext()) {
			listArbre.next().tentativeFeu(etape);
		}
		this.arbre.setEtat(new EtatCendre(this.arbre));
	}
	
	public String toString() {
		return "en feu";
	}

}
