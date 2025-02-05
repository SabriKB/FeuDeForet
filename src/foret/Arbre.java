package foret;

import java.util.ArrayList;

public class Arbre {
	private Position position;
	private Etat etat;
	private int etapeBrule;
	private ArrayList<Arbre> arbreAdjacent;
	private Foret foret;
	
	public Arbre(Position position, Foret foret) {
		this.etat = new EtatIntact(this);
		this.etapeBrule = 0;
		this.position = position;
		this.foret = foret;
		this.arbreAdjacent = new ArrayList<Arbre>();
	}
	
	public void ajoutVoisin(Arbre arbre) {
		if(!arbreAdjacent.contains(arbre)) {
			arbreAdjacent.add(arbre);
			arbre.ajoutVoisin(this);
		}
	}
	
	public void MiseAJour(int etape) {
		if(etape != this.etapeBrule) {
			this.etat.effetEtat(etape);
		}
	}
	
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public Etat getEtat() {
		return this.etat;
	}
	
	public ArrayList<Arbre> getArbreAdjacent(){
		return arbreAdjacent;
	}
	
	public void tentativeFeu(int etape) {
		int randomNum = (int)(Math.random() * 101);
		if(randomNum > foret.getProba() && (this.etat instanceof EtatIntact)) {
			this.etat = new EtatFeu(this);
			this.etapeBrule = etape;
		}
	}
	
	public String toString() {
		return "Arbre a la position " + this.position + " est " + this.etat;
	}

}
