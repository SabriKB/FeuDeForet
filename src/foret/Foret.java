package foret;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Foret {
	private Arbre[][] foret;
	private int hauteur;
	private int largeur;
	private int probabiliteFeu;
	private int etape;
	
	public Foret(int hauteur, int largeur, int prob) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.probabiliteFeu = prob;
		this.etape = 0;
		this.foret = new Arbre[hauteur][largeur];
		
		for(int i = 0; i<hauteur; i++) {
			for(int j=0; j<largeur; j++) {
				foret[i][j] = new Arbre(new Position(i, j), this);
				if(i>0) {
					foret[i][j].ajoutVoisin(foret[i-1][j]);
				}
				if(j>0) {
					foret[i][j].ajoutVoisin(foret[i][j-1]);
				}
			}
		}
	}
	
	public int getProba() {
		return probabiliteFeu;
	}
	
	public void initialisationFeuDeForet(ArrayList<Position> positions) {
		for(Position position : positions) {
			foret[position.getX()][position.getY()].setEtat(new EtatFeu(foret[position.getX()][position.getY()]));
		}
	}
	
	public boolean propagation() {
		this.etape++;
		System.out.println("Etape " + this.etape);
		boolean toutBrule = true;
		for(int i = 0; i<hauteur; i++) {
			for(int j=0; j<largeur; j++) {
				if(!(foret[i][j].getEtat() instanceof EtatCendre)) {
					toutBrule = false;
					foret[i][j].MiseAJour(etape);
				}
				System.out.println(foret[i][j]);
			}
			
		}
		System.out.println("Press \"ENTER\" to continue...");
		Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		return toutBrule;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myObj = new Scanner(System.in);  
	    System.out.println("Bonjour, veuillez renseigner le nombre de case en hauteur");
	    int hauteur = myObj.nextInt();  // Read user input
	    System.out.println("Veuillez renseigner le nombre de case en largeur");
	    int largeur = myObj.nextInt();  // Read user input
	    System.out.println("Veuillez renseigner la probabilite de mettre le feu a un arbre entre 1 et 99");
	    int prob = myObj.nextInt();  // Read user input
	    
	    System.out.println("Veuillez renseigner le nombre d'arbre a mettre en feu");
	    int nbArbreFeu = myObj.nextInt();  // Read user input
	    
	    Random ran = new Random();
	    ArrayList<Position> positions = new ArrayList<Position>();
	    for(int i = 0; i<nbArbreFeu; i++) {
	    	positions.add(new Position(ran.nextInt(hauteur), ran.nextInt(largeur)));
	    }
	    
	    boolean foretEnCours = false;
	    Foret foret = new Foret(hauteur, largeur, prob);
	    foret.initialisationFeuDeForet(positions);
	    
	    while(!foretEnCours) {
	    	foretEnCours = foret.propagation();
	    }
	    
	}

}
