
package fr.egocentrique;
import java.lang.Override;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Morceau {
    // Creation des attributs de la classe Morceau

    private String titre;
    private String artiste;
    private String album;
    private double duree;
    private String genre;

    // creation du conteneur de la classe Morceau
    public Morceau(String titre, String artiste, String album, double duree, String genre){

        // instanciation des attribut de la classe
        this.titre = titre;
        this.artiste = artiste;
        this.album = album;
        this.duree = duree;
        this.genre = genre;
    }

    // creaton de la methode pour cree un morceau

    public static Morceau creerMorceau(){

        // Appel de la methode Scanner de la classe java.util
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Creation d'un nouvau morceau ===");

        System.out.print("Titre: ");
        String titre = sc.nextLine();

        System.out.print("Artiste: ");
        String artiste = sc.nextLine();

        System.out.print("Album: ");
        String album = sc.nextLine();

        //Duree en seconde
        double duree = 0;

        // Gestion de l'exeption InputMismatchException

        try {
            System.out.print("duree: ");
            duree = sc.nextDouble();
            sc.nextLine();
        }catch (InputMismatchException e){
            System.out.println("entrer une duree valide");
            // Redemander la saisie du morceau depuis le debut
            creerMorceau().getClass();
        }
        System.out.print("Genre: ");
        String genre = sc.nextLine();

        Morceau resultat = new Morceau(titre,artiste,album,duree,genre);

        return resultat;
    }

    // les differents acesseur (Getter & Setter )

    // Getter
    public String getArtiste() {return artiste;}
    public String getGenre() {return genre;}
    public String getAlbum() {return album;}
    public String getTitre() {return titre;}
    public double getDuree() {return duree;}

    // Setter
    public void setGenre(String genre) {this.genre = genre;}
    public void setDuree(double duree) {this.duree = duree;}
    public void setAlbum(String album) {this.album = album;}
    public void setArtiste(String artiste) {this.artiste = artiste;}
    public void setTitre(String titre) {this.titre = titre;}

    // Redefinition de la methode tosString de la super classe object
    @Override
    public  String toString(){
        return titre + " - " + artiste + " (" + album + ") [" + getDuree() + " sec, " + genre + "]";
    }

}
