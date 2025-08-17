package fr.egocentrique;

// importer la classe ArrayList
import java.util.ArrayList;
import java.util.List;
/*
Creation de la classe playlist pour la gestion des morceau dans une playlis
 */
public class Playlist {
    private String nom;
    private List<Morceau> morceaux; // Liste d'element de type Morceau
    private List<String> categories;//List d'element de type String
    private Utilisateur createur;

    public Playlist(String nom, Utilisateur createur){
        this.nom = nom;
        this.morceaux = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.createur = createur;

    }

    // Mehode ajouterMorceau pour l'ajout de maorceau dans la playlist

    public void ajouterMorceau(Morceau morceau){
        try {
            if (!morceaux.contains(morceau)){
                morceaux.add(morceau);
                System.out.println("Morceau ajouté dans la playlist: " + morceau.getTitre());
            }else{
                System.out.println("le morceau est deja present dans la playlist!");
            }
        }catch (NullPointerException | IllegalStateException e){
            System.out.println(e.getMessage());
        }


    }
    // Methode retirerMorceau pour retirer un morceau dans la l a playlist

    public void retirerMorceau(Morceau morceau){
        try {
            if (morceaux.contains(morceau)){
                morceaux.remove(morceau);
                System.out.println("Morceau supprimée: "+ morceau.getTitre());
            }else {
                System.out.println("Le morceau est introuvable dans la playlist !");
            }
        }catch (NullPointerException | IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    // Methode pour obtenir la urer total des morceau dans la plalist

    public double getDureeTotal(){
        double total = 0;
        for (Morceau m : morceaux){
            total += m.getDuree();
        }
        return  total;
    }

    // Ajouter une categorie dans la playlist

    public void ajouterCategorie(String categorie){
        try {
            if (!categories.contains(categorie)){
                categories.add(categorie);
            }else{
                System.out.println("La categorie existe deja: " + categorie);
            }
        }catch (NullPointerException | IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    // Methode afficherPlaylist pour afficher les tout le smorceau de la playlist plus les information des morceau

    public void afficherPlaylist(){
        System.out.println("Nom de la playlit: "+ nom);
        System.out.println("Createur : " + createur.getNom());
        System.out.println("Categories: "+ categories);
        System.out.println("La duree total en second: "+ getDureeTotal());
        System.out.println("Les infos du morceau: ");
        for (Morceau m : morceaux){
            System.out.println("-" + m);
        }
    }

    // Methode partagerAvecUnAutreUtilisateur pour le partage de playlist entre utilisateur
    public void partagerAvecUnAutreUtilisateur(Utilisateur autreUtilisateur){
        autreUtilisateur.ajouterPlaylistPartagee(this);
        System.out.println("Playlist partage ave : "+autreUtilisateur.getNom());
    }

    // Getter
    public String getNom() {return nom;}
    public List<Morceau> getMorceaux() {return morceaux;}
    public List<String> getCategories() {return categories;}
    public Utilisateur getCreateur() {return createur;}

    /*
    Note: La classe playlist a pour role de gerer les morceaux dans une playlist.
          Utilisation de collection avec l'interface ArrayList

     */

}
