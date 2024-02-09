package fr.pgah;
import java.awt.*;

public class Yeti extends Bestiole {

    private int phase;
    private int mouvementCount;
    private int nbMouvementParPhase;
    private char[] PHASES={'y','e','t','i'};

    public Action getAction(BestioleInfo info) {
        if (info.getEnFace() == Voisin.AUTRE) {
            return Action.INFECTER;
            } else if (info.getEnFace() == Voisin.RIEN) {
                return Action.SAUTER;
            } else {
                return Action.GAUCHE;
            }
      }
    
      public Color getCouleur() {
        return Color.GRAY;
      }
    
      public String toString() {
        char phaseChar = PHASES[phase];

        //La variable mouvementCount est incrémentée à chaque appel et utilisée pour déterminer si la phase actuelle doit être mise à jour
        mouvementCount = (mouvementCount + 1) % nbMouvementParPhase;
        //Si mouvementCount est un multiple de nbMouvementParPhase, la phase est incrémentée et mouvementCount est remis à zéro
        if (mouvementCount == 0) {
            phase = (phase + 1) % PHASES.length;
        }
        return Character.toString(phaseChar);
  }
        
        
    
      
    
}
