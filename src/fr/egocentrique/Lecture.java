package fr.egocentrique;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.NullPointerException;

/*
 Creation d'une classe pour pouvoir lire les different morceau present dans notre bibliotheque
 */
public class Lecture {
    private Queue<Morceau> fileAttente; // creation d'une file avec l'interface de collection Queue
    private Morceau morceauActtuel;
    private boolean enLecture;

    // Creation du conteneur Lecture

    public Lecture(){
        this.fileAttente = new LinkedList<>(); // Utilisation de LinkedList comme implementation concrete pour l'interface queue
        this.morceauActtuel = null; // On met morceauActuell a null
        this.enLecture = false;
    }

    /*
     * Ajoute un morceau à la file d’attente
     */
    public void ajouterALaFile(Morceau m){
        try {
            fileAttente.add(m);
            System.out.println("Morceau ajoutée a la liste : "+ m.getTitre());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    /*
     * Lance la lecture du morceau actuel ou du prochain dans la file
     */

    public void lire(){

        // On anticipe l'exeption NullPointerException
       try {
           if (morceauActtuel == null) {
               morceauActtuel = fileAttente.poll(); // Il va prendre le prochain morceau dans la file et la retirer de la file
        }
        if (morceauActtuel != null){
               enLecture = true;
               System.out.println("Lecture : "+ morceauActtuel.getTitre());
           }
           else {
               System.out.println("Aucun morceau a lire ");
           }
       }catch (NullPointerException e){
           System.out.println(e.getMessage());
       }
    }

    /*
     * Met en pause la lecture
     */

    public void pause(){
      try {
          if (enLecture){
              enLecture = false;
              System.out.println("Pause : "+morceauActtuel.getTitre());

          }
          else {
              System.out.println("Aucun morceau en lecture");
          }
      }catch (IllegalStateException e){
          System.out.println(e.getMessage());
      }
    }

    /*
     * Passe au morceau suivant
     */

    public void suivant(){
        if (!fileAttente.isEmpty()){
            morceauActtuel = fileAttente.poll();
            System.out.println("Prochain morceau: "+ morceauActtuel.getTitre());
        }
        else {
            morceauActtuel = null;
            System.out.println("Aucun morceau suivant. ");
        }
    }

    /*
     * Affiche la file d’attente
     */

    public void afficherFileAttente(){
        if (fileAttente.isEmpty()){
            System.out.println("La file d'attente est vide");
        }
        else {
            System.out.println("\n File d'attente :");
            for (Morceau m : fileAttente){
                System.out.println("-" + m.getTitre() + "-" + m.getArtiste() + "-" + m.getDuree());
            }
        }
    }
    /*
    Note: La gestion des exception dans cette classe est gere dans la methode lire() & ajouterALaFile()
          car j'ai juger bon de les traiter seulement laba car il font beaucoup appel a fileAttente qui
          est une file qui peut etre souvent delicat a manipuler
     */

}
