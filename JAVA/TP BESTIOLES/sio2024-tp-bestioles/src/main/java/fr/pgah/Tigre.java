package fr.pgah;

import java.awt.Color;


public class Tigre extends Bestiole {
        
    private static final Color[] Couleurs = {Color.RED, Color.GREEN, Color.BLUE};
    private static final int nbMouvementParPhase = 3;
    private int couleurIndex = 0;
    private int mouvementCount = 0;

    //pour les actions 
    //Infecte si un ennemi est en face,sinon si un mur est en face ou à droite, alors tourne à gauche,sinon si un autre tigre est en face, alors tourne à droite,sinon saute.
    public Action getAction(BestioleInfo info) {
        if (info.getEnFace() == Voisin.AUTRE) {
        return Action.INFECTER;
        } else if (info.getEnFace() == Voisin.MUR || info.getADroite() == Voisin.MUR) {
        return Action.GAUCHE;
        } else if (info.getEnFace() == Voisin.MEME) {
        return Action.DROITE;
        } else {
        return Action.SAUTER;
        }
    }

    //méthode qui permet que la couleur reste la même pendant trois mouvements, puis change à nouveau pour les trois mouvements suivants
    public Color getCouleur() {
        //La variable mouvementCount va compter le nombre de mouvement depuis le dernier changement de couleur
        if (mouvementCount == 0) {
        couleurIndex = (couleurIndex + 1) % Couleurs.length;
        }
        Color couleur = Couleurs[couleurIndex];
        mouvementCount = (mouvementCount + 1) % nbMouvementParPhase;
        return couleur;
    }

    @Override
    public String toString() {
        return "G";
    }

           
    
}
