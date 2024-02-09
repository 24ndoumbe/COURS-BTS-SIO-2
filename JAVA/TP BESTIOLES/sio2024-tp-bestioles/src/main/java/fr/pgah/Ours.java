package fr.pgah;
import java.awt.*;

public class Ours extends Bestiole {

  private boolean etrePolaire;
  private char mouvement;
    

  public Ours(boolean etrePolaire) {
    this.etrePolaire = etrePolaire;
    }

    //pour l'action
    @Override
  public Action getAction(BestioleInfo info) {
    if (info.getEnFace() == Voisin.AUTRE) {
      return Action.INFECTER;
      } else if (info.getEnFace() == Voisin.RIEN) {
          return Action.SAUTER;
      } else {
          return Action.GAUCHE;
      }
  }


    @Override
  public Color getCouleur() {
    if(etrePolaire) {
      return Color.white;
      } else {
          return Color.black;
      }
      
  }
        

// pour le mouvement
    @Override
  public String toString() {
    if (mouvement == '/') {
      mouvement = '\\';
    } else {
      mouvement='/';
    }
    return Character.toString(mouvement);
        
  }



    
}



