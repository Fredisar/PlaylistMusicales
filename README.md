# 🎵 Système de Gestion de Playlists Musicales

## 📖 Description
Ce projet est une application **Java en console** qui permet de gérer une bibliothèque musicale, 
des playlists, des utilisateurs et de simuler la lecture de morceaux.

Il a été développé avec **Java 17** et testé dans **IntelliJ IDEA**.

---

## ⚡ Fonctionnalités
- Gestion des **morceaux** (ajouter, afficher, rechercher, supprimer)
- Gestion des **playlists** (ajouter/retirer des morceaux, durée totale, partager)
- Gestion des **utilisateurs**
- Gestion d’une **bibliothèque musicale**
- Simuler la **lecture musicale** :
  - Ajouter à la file d’attente
  - Lire un morceau
  - Mettre en pause
  - Passer au morceau suivant

---

## 🏗️ Architecture du projet
1. Architecture
   ```
   src/
      ├── App
        ├── Main.java
      └── fr/egocentrique/
        ├── ConsoleUi.java
        ├── Morceau.java
        ├── Playlist.java
        ├── Utilisateur.java
        ├── BibliothequeMusicale.java
        └── LecteurMusique.java



---

## 🚀 Installation et exécution
1. Cloner le dépôt :
   ```bash
   git clone https://github.com/tonpseudo/playlist-manager-java.git
   cd playlist-manager-java
2. Ouvrir le projet dans Intelliji IDEA (ou n'importe quel IDE java).
3. Vérifier que vous utilisez JDK 17 ou plus
4. Exécuter  la classe main: javac src/fr/egocentrique/*.java
                             java fr.egocentrique.Main

##🖥️ Exemple d’utilisation
1. Code :
   ```bash
     /home/fayama/.jdks/ms-17.0.15/bin/java -javaagent:/snap/intellij-idea-community/643/lib/idea_rt.jar=37849 -Dfile.encoding=UTF-8 -classpath /home/fayama/Téléchargements/POO_UVBF_2025-20250802T170451Z-1-001/POO_UVBF_2025/Playlist_musicale/out/production/Playlist_musicale app.Main
    === Bienvenue dans le gestionnaire de playlists ===
    Entrez votre nom d'utilisateur : Bado
    Entrez le nom de votre playlist principale : fredis
    
    ======= MENU PRINCIPAL =========
    1- MORCEAU
    2- PLAYLIST
    3- UTILISATEUR
    4- BIBLIOTHÈQUE MUSICALE
    5- Lecture
    0- QUITTER
    Votre choix : 1

## 📖 Resource complementaire 
1. Diagramme de classe fait avec le logiciel start uml 
2. Documentation dans le code source 
3. Manuelle d'utilisation 
