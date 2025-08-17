package fr.egocentrique;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleUi {
    private Scanner sc = new Scanner(System.in);
    private Utilisateur utilisateurActuel;
    private BibliothequeMusicale bibliotheque = new BibliothequeMusicale();
    private Playlist playlistActuelle;
    Lecture lt = new Lecture();

    public void lancerMenu() {
        // demander les infos de base avant d'afficher le menu
        System.out.println("=== Bienvenue dans le gestionnaire de playlists ===");
        System.out.print("Entrez votre nom d'utilisateur : ");
        String nomUtilisateur = sc.nextLine();
        utilisateurActuel = new Utilisateur(nomUtilisateur);

        System.out.print("Entrez le nom de votre playlist principale : ");
        String nomPlaylist = sc.nextLine();
        playlistActuelle = new Playlist(nomPlaylist, utilisateurActuel);
        utilisateurActuel.ajouterPlaylist(playlistActuelle);

        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n\t======= MENU PRINCIPAL =========");
            System.out.println("1- MORCEAU");
            System.out.println("2- PLAYLIST");
            System.out.println("3- UTILISATEUR");
            System.out.println("4- BIBLIOTHÈQUE MUSICALE");
            System.out.println("5- Lecture");
            System.out.println("0- QUITTER");

            System.out.print("Votre choix : ");
            int choix1 = lireInt();

            switch (choix1) {
                case 1 -> menuMorceau();
                case 2 -> menuPlaylist();
                case 3 -> menuUtilisateur();
                case 4 -> menuBibliotheque();
                case 5 -> lecture();
                case 0 -> quitter = true;
                default -> System.out.println("⚠️ Choix invalide !");
            }
        }
        System.out.println("au revoir");
    }

    // === MENU MORCEAU ===
    private void menuMorceau() {
        System.out.println("\n📀 MENU MORCEAU");
        System.out.println("1- Créer un morceau");
        System.out.println("2- Afficher tous les morceaux de la bibliothèque");
        System.out.print("Votre choix : ");
        int choix = lireInt();

        switch (choix) {
            case 1 -> {
                Morceau m = Morceau.creerMorceau();
                bibliotheque.ajuterMorceau(m);
            }
            case 2 -> bibliotheque.afficherMorceauxBibliotheque();
            default -> System.out.println("⚠️ Choix invalide !");
        }
    }

    // === MENU PLAYLIST ===
    private void menuPlaylist() {
        System.out.println("\n🎧 MENU PLAYLIST");
        System.out.println("1- Ajouter un morceau à la playlist");
        System.out.println("2- Retirer un morceau de la playlist");
        System.out.println("3- Voir la durée totale");
        System.out.println("4- Ajouter une catégorie");
        System.out.println("5- Partager avec un utilisateur");
        System.out.println("6- Afficher la playlist");
        System.out.print("Votre choix : ");
        int choix = lireInt();

        switch (choix) {
            case 1 -> {
                bibliotheque.afficherMorceauxBibliotheque();
                System.out.print("Titre du morceau a ajouter: ");
                String titre = sc.nextLine();
                for (Morceau m : bibliotheque.getMorceauxDisponible()) {
                    if (m.getTitre().equalsIgnoreCase(titre)) {
                        playlistActuelle.ajouterMorceau(m);
                        break;
                    }
                }
            }
            case 2 -> {
                playlistActuelle.afficherPlaylist();
                System.out.print("Titre du morceau a retirer: ");
                String titre = sc.nextLine();
                for (Morceau m : playlistActuelle.getMorceaux()) {
                    if (m.getTitre().equalsIgnoreCase(titre)) {
                        playlistActuelle.retirerMorceau(m);
                        break;
                    }
                }
            }
            case 3 -> {
                System.out.println("Duree total de la playlist en seconde: " + playlistActuelle.getDureeTotal() + "sec");
            }
            case 4 -> {
                System.out.println("Nom de la categorie: ");
                String Cat = sc.nextLine();
                playlistActuelle.ajouterCategorie(Cat);
            }
            case 5 -> {
                System.out.println("Le nom d'utilisateur avec qui vous voulez partager votre playlist: ");
                String autreUtilisateur = sc.nextLine();
                Utilisateur autre = new Utilisateur(autreUtilisateur);
                playlistActuelle.partagerAvecUnAutreUtilisateur(autre);
            }
            case 6 -> {
                playlistActuelle.afficherPlaylist();
            }
            default -> System.out.println("Choix invalide !");
        }
    }


    private void menuUtilisateur() {
        System.out.println("\n👤 MENU UTILISATEUR");
        System.out.println("1- Voir mes playlists");
        System.out.println("2- Voir mes favoris");
        System.out.print("Votre choix : ");
        int choix = lireInt();

        switch (choix) {
            case 1 -> {
                for (Playlist p : utilisateurActuel.getPlaylistCree()) {
                    p.afficherPlaylist();
                }
            }
            case 2 -> {
                for (Morceau m : utilisateurActuel.getFavorie()) {
                    System.out.println("-" + m);
                }
            }
            default -> System.out.println("Choix invalide !");
        }
    }

    // === MENU BIBLIOTHÈQUE MUSICALE ===
    private void menuBibliotheque() {
        System.out.println("\n🎼 MENU BIBLIOTHÈQUE MUSICALE");
        System.out.println("1- Rechercher par titre");
        System.out.println("2- Rechercher par artiste");
        System.out.print("Votre choix : ");
        int choix = lireInt();

        switch (choix) {
            case 1 -> {
                System.out.print("Titre : ");
                String titre = sc.nextLine();
                var resultat = bibliotheque.rechercherMorceauParTitre(titre);
                bibliotheque.afficherResultatsRecherche(resultat);
            }
            case 2 -> {
                System.out.print("artiste : ");
                String artiste = sc.nextLine();
                var resultat = bibliotheque.rechercherParArtiste(artiste);
            }
            default -> System.out.println("choix invalide n");
        }
    }

    // === MÉTHODES UTILITAIRES ===
    private void afficherMorceauxBiblioteque() {
        System.out.println("\n🎵 Morceaux disponibles :");
        for (Morceau m : bibliotheque.getMorceauxDisponible()) {
            System.out.println("- " + m);
        }
    }

    private void afficherResultatRecherche(java.util.List<Morceau> resultat) {
        if (resultat.isEmpty()) {
            System.out.println("❌ Aucun morceau trouvé.");
        } else {
            for (Morceau m : resultat) {
                System.out.println("- " + m);
            }
        }
    }

    // === MENU Lecture ===
    private void lecture() {
        System.out.println("\n🎼 Menu de Lecture");
        System.out.println("1- Ajouter un morceau a la file d'attente");
        System.out.println("2- Lire un morceau dans la file d'attente");
        System.out.println("3- Mettre un morceau en pause");
        System.out.println("4- Lire le prochain morceau <Suivant>");
        System.out.println("5- Afficher la liste d'attente ");
        System.out.print("Votre choix : ");
        int choix = lireInt();

        switch (choix) {
            case 1 -> {
                System.out.println("Morceau disponible :");
                bibliotheque.afficherMorceauxBibliotheque();


                if (bibliotheque.getMorceauxDisponible().isEmpty()){
                    String resultat = "Desole vous ne pouver rien entrer ";
                    System.out.println(resultat);
                    return ;
                }else {
                    System.out.println("Entrer le titre du morceau a ajouter a la file :");
                    String titre = sc.nextLine();
                    for (Morceau m : bibliotheque.getMorceauxDisponible()) {
                        if (m.getTitre().equalsIgnoreCase(titre)) {

                            lt.ajouterALaFile(m);
                            break;
                        }
                    }
                }

            }
            case 2 -> {
                    lt.lire();
            }
            case 3 -> {

                    lt.pause();

            }

            case 4 -> {

                lt.suivant();
            }

            case 5 -> {

                lt.afficherFileAttente();
            }
        }
    }
    private int lireInt() {
        try {
            while (!sc.hasNextInt()) {
                System.out.println("Entrer un nombre valide :");
                sc.next();
            }
        }catch (IllegalStateException | NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        int valeur = sc.nextInt();
        sc.nextLine();
        return valeur;
    }
    /*
    Note: Cette classe permet de gerer tout ce qui est affichage dans la concole.

     */
}

