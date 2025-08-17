package fr.egocentrique;
import java.util.ArrayList;
import java.util.List;

// creation de la classe BibliothequeMusicale
public class BibliothequeMusicale {
    private List<Morceau> morceauxDisponible;

    public BibliothequeMusicale(){
        this.morceauxDisponible = new ArrayList<>();

    }
    // Methode ajuterMorceau pour l'ajout de morceau dans une biblioheque
    public void ajuterMorceau(Morceau m){
       try {
           if (!morceauxDisponible.contains(m)){
               morceauxDisponible.add(m);
               System.out.println("Morceau ajouter a la bibliothèqque: " + m.getTitre());
           }else{
               System.out.println("Le morceau exite deja dans la bibliothèque: "+ m.getTitre());
           }
       }catch (NullPointerException | IllegalStateException e){
           System.out.println(e.getMessage());
       }

    }

    // Methode rechercherMorceauParTitre pour rechercher un morceau par son titre dans la biblioteque
    public List<Morceau> rechercherMorceauParTitre(String titre){
       try {
           List<Morceau> resultat = new ArrayList<>();
           for (Morceau m : morceauxDisponible){
               if (m.getTitre().equalsIgnoreCase(titre)){
                   resultat.add(m);
               }
           }
           return resultat;
       }catch (NullPointerException | IllegalStateException e){
           System.out.println(e.getMessage());
       }
        return List.of();
    }

    // Methode rechercherParArtiste pour rechercher un morceau par le nom de l'artiste
    public List<Morceau> rechercherParArtiste(String artiste){
       try{
           List<Morceau> resultat = new ArrayList<>();
           for (Morceau m : morceauxDisponible){
               if (m.getArtiste().equalsIgnoreCase(artiste)){
                   resultat.add(m);
               }
           }
           return resultat;
       }catch (NullPointerException | IllegalStateException e){
           System.out.println(e.getMessage());
       }

        return List.of();
    }

    //getter de morceauDisponible
    public List<Morceau> getMorceauxDisponible() {return morceauxDisponible;}

    // Methode afficherMorceauxBibliotheque pour afficher les morceaux de la bibliotheque

    public void afficherMorceauxBibliotheque() {
       try {
           if (morceauxDisponible.isEmpty()) {
               System.out.println("❌ Aucun morceau dans la bibliothèque.");
           } else {
               System.out.println("\n🎼 Morceaux dans la bibliothèque :");
               for (Morceau m : morceauxDisponible) {
                   System.out.println("- " + m);
               }
           }
       }catch (NullPointerException | IllegalStateException e){
           System.out.println(e.getMessage());
       }
    }

    // Methode afficherResultatsRecherche pour afficher les resultat de la recherche.
    public void afficherResultatsRecherche(List<Morceau> resultats) {
        try {
            if (resultats.isEmpty()) {
                System.out.println("❌ Aucun morceau trouvé.");
            } else {
                System.out.println("\n🔍 Résultats de la recherche :");
                for (Morceau m : resultats) {
                    System.out.println("- " + m);
                }
            }
        }catch (NullPointerException | IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    /*
    Note: Classe BibliothequeMusicale pour la gestion de morceau
           Utilisation de collection avec l'interface ArrayList
           Gestion des exeptions de type IllegalStateException & NullPointerException

     */
}
