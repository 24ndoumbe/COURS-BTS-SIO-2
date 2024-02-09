package fr.pgah;

import java.awt.Color;

public class TigreBlanc extends Bestiole {

  private boolean AInfecter = false;

    public Action getAction(BestioleInfo info) {
        if (info.getEnFace() == Voisin.AUTRE) {
            AInfecter = true;
            return Action.INFECTER;
          } else if (info.getEnFace() == Voisin.MUR || info.getADroite() == Voisin.MUR) {
            return Action.GAUCHE;
          } else if (info.getEnFace() == Voisin.MEME) {
            return Action.DROITE;
          } else {
            return Action.SAUTER;
          }
    }
    
    public Color getCouleur() {
        return Color.white;
    }
    
    public String toString() {
        if (AInfecter){
            return "B";
          } else {
            return "b";
          }
    }
        
            
      
    
}
