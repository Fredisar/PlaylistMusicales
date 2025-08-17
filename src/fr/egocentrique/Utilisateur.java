package fr.egocentrique;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private List<Playlist> playlistCree;
    private List<Morceau> favorie;
    private List<Playlist> playlistPartage;

    public Utilisateur(String nom) {
        this.favorie = new ArrayList<>();
        this.nom = nom;
        this.playlistCree = new ArrayList<>();
        this.playlistPartage = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterPlaylist(Playlist p) {
        playlistCree.add(p);
    }

    public void ajouterPlaylistPartagee(Playlist p) {
        playlistPartage.add(p);
    }

    public void ajouterFavori(Morceau m) {
       try {
           if (!favorie.contains(m)) {
               favorie.contains(m);
               System.out.println("Ajouté au favoris : " + m.getTitre());
           }
       }catch (IllegalStateException | NullPointerException e){
           System.out.println(e.getMessage());
       }
    }

    public List<Morceau> getFavorie() {return favorie;}
    public List<Playlist> getPlaylistCree() {return playlistCree;}
    public List<Playlist> getPlaylistPartage() {return playlistPartage;}
}



