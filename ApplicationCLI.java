package com.universite.gestionnotes.ui;

import java.util.List;
import java.util.Scanner;
import com.universite.gestionnotes.service.GestionnaireNotes;

// Importez tous les modèles nécessaires pour la création d'objets
import com.universite.gestionnotes.model.Etudiant;
import com.universite.gestionnotes.model.Professeur;
import com.universite.gestionnotes.model.Matiere;
import com.universite.gestionnotes.model.Note;

public class ApplicationCLI {

    private GestionnaireNotes gestionnaire;
    private Scanner scanner;

    public ApplicationCLI(GestionnaireNotes gestionnaire) {
        this.gestionnaire = gestionnaire;
        this.scanner = new Scanner(System.in);
    }

    public void demarrer() {
        boolean continuer = true;
        while (continuer) {
            afficherMenuPrincipal();
            String choix = scanner.nextLine();

            switch (choix) {
                case "1": ajouterEtudiant(); break;
                case "2": ajouterProfesseur(); break;
                case "3": ajouterMatiere(); break;
                case "4": enregistrerNote(); break;
                case "5": modifierNote(); break;
                case "6": afficherEtudiants(); break;
                case "7": afficherProfesseurs(); break;
                case "8": afficherMatieres(); break;
                case "9": afficherNotes(); break;
                case "10": continuer = false;
                    System.out.println();
                    System.out.println("👋  Au revoir et à bientôt !");
                    System.out.println("🎓  Merci d'avoir utilisé le système de gestion de notes !");
                    System.out.println();
                    break;
                default:  
                    System.out.println();
                    System.out.println("❌  Choix invalide. Veuillez sélectionner un nombre entre 1 et 10.");
                    System.out.println();
            }
        }
        scanner.close();
    }

    private void afficherProfesseurs() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("👥  LISTE DES PROFESSEURS");
        System.out.println("─".repeat(50));
        System.out.println();
        
        if (gestionnaire.getProfesseurs().isEmpty()) {
            System.out.println("📭  Aucun professeur n'a été enregistré.");
            System.out.println();
            return;
        }
        
        int compteur = 1;
        for (Professeur p : gestionnaire.getProfesseurs()) {
            System.out.println("👨‍🏫  " + compteur + ". " + p);
            compteur++;
        }
        System.out.println();
        System.out.println("📊  Total : " + gestionnaire.getProfesseurs().size() + " professeur(s)");
        System.out.println();
    }

    private void afficherMatieres() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📖  LISTE DES MATIÈRES");
        System.out.println("─".repeat(50));
        System.out.println();
        
        if (gestionnaire.getMatieres().isEmpty()) {
            System.out.println("📭  Aucune matière n'a été enregistrée.");
            System.out.println();
            return;
        }
        
        int compteur = 1;
        for (Matiere m : gestionnaire.getMatieres()) {
            System.out.println("📚  " + compteur + ". " + m);
            compteur++;
        }
        System.out.println();
        System.out.println("📊  Total : " + gestionnaire.getMatieres().size() + " matière(s)");
        System.out.println();
    }

    private void afficherNotes() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("🏆  LISTE DES NOTES");
        System.out.println("─".repeat(50));
        System.out.println();
        
        if (gestionnaire.getNotes().isEmpty()) {
            System.out.println("📭  Aucune note n'a été enregistrée.");
            System.out.println();
            return;
        }
        
        int compteur = 1;
        for (Note n : gestionnaire.getNotes()) {
            System.out.println("📝  " + compteur + ". " + n);
            compteur++;
        }
        System.out.println();
        System.out.println("📊  Total : " + gestionnaire.getNotes().size() + " note(s)");
        System.out.println();
    }

    private void afficherMenuPrincipal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎓  SYSTÈME DE GESTION DE NOTES UNIVERSITAIRE  🎓");
        System.out.println("=".repeat(60));
        System.out.println();
        System.out.println("👤  1. Ajouter un étudiant");
        System.out.println("👨‍🏫  2. Ajouter un professeur");
        System.out.println("📚  3. Ajouter une matière");
        System.out.println("📝  4. Enregistrer une note");
        System.out.println("📝  5. Modification de note");
        System.out.println();
        System.out.println("📋  6. Afficher la liste des étudiants");
        System.out.println("👥  7. Afficher la liste des professeurs");
        System.out.println("📖  8. Afficher la liste des matières");
        System.out.println("🏆  9. Afficher la liste des notes");
        System.out.println();
        System.out.println("🚪  10. Quitter");
        System.out.println();
        System.out.print("➤ Entrez votre choix : ");
    }

    // -----------------------------------------------------------------
    // Exemple de méthode d'interaction : Ajouter un étudiant
    // -----------------------------------------------------------------
    private void ajouterEtudiant() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("👤  CRÉATION D'UN ÉTUDIANT");
        System.out.println("─".repeat(50));
        System.out.println();
        
        System.out.print("🆔  Entrez le matricule : ");
        String matricule = scanner.nextLine();

        System.out.print("👤  Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("✨  Entrez le prénom : ");
        String prenom = scanner.nextLine();

        Etudiant nouvelEtudiant = new Etudiant(matricule, nom, prenom);
        gestionnaire.ajouterEtudiant(nouvelEtudiant);
        
        System.out.println();
        System.out.println("✅  Étudiant ajouté avec succès !");
        System.out.println();
    }

    // -----------------------------------------------------------------
    // Une méthode simple de lecture (Read)
    // -----------------------------------------------------------------
    private void afficherEtudiants() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📋  LISTE DES ÉTUDIANTS");
        System.out.println("─".repeat(50));
        System.out.println();
        
        if (gestionnaire.getEtudiants().isEmpty()) {
            System.out.println("📭  Aucun étudiant n'a été enregistré.");
            System.out.println();
            return;
        }
        
        int compteur = 1;
        for (Etudiant e : gestionnaire.getEtudiants()) {
            System.out.println("👤  " + compteur + ". " + e);
            compteur++;
        }
        System.out.println();
        System.out.println("📊  Total : " + gestionnaire.getEtudiants().size() + " étudiant(s)");
        System.out.println();
    }

    // ... autres méthodes à implémenter

    private void ajouterProfesseur() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("👨‍🏫  CRÉATION D'UN PROFESSEUR");
        System.out.println("─".repeat(50));
        System.out.println();
        
        System.out.print("🆔  Entrez l'identifiant : ");
        String id = scanner.nextLine();

        System.out.print("👤  Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("✨  Entrez le prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("✨  Entrez la spécialité : ");
        String specialite = scanner.nextLine();

        Professeur p = new Professeur(id, nom, prenom, specialite);
        gestionnaire.ajouterProfesseur(p);
        
        System.out.println();
        System.out.println("✅  Professeur ajouté avec succès !");
        System.out.println();
    }

    private void ajouterMatiere() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📚  CRÉATION D'UNE MATIÈRE");
        System.out.println("─".repeat(50));
        System.out.println();
        
        System.out.print("🔤  Entrez le code de la matière : ");
        String code = scanner.nextLine();

        System.out.print("📖  Entrez le nom de la matière : ");
        String nom = scanner.nextLine();

        System.out.print("⚖️  Entrez le coefficient de la matière (ex: 1.0) : ");
        double coeffStr = scanner.nextDouble();
        scanner.nextLine(); // Consommer le retour à la ligne

        Matiere m = new Matiere(code, nom, coeffStr);
        gestionnaire.ajouterMatiere(m);
        
        System.out.println();
        System.out.println("✅  Matière ajoutée avec succès !");
        System.out.println();
    }

    private void enregistrerNote() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📝  ENREGISTREMENT D'UNE NOTE");
        System.out.println("─".repeat(50));
        System.out.println();
        
        System.out.print("👤  Entrez le matricule de l'étudiant : ");
        String matricule = scanner.nextLine();

        System.out.print("📚  Entrez le code de la matière : ");
        String codeMatiere = scanner.nextLine();

        System.out.print("🎯  Entrez la valeur de la note (ex: 12.5) : ");
        String valeurStr = scanner.nextLine();
        double valeur;
        
        try {
            valeur = Double.parseDouble(valeurStr.replace(',', '.'));
            
            if (valeur < 0 || valeur > 20) {
                System.out.println();
                System.out.println("⚠️  Attention : La note doit être entre 0 et 20 !");
                System.out.println();
                return;
            }
            
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("❌  Valeur de note invalide. Utilisez un format numérique (ex: 12.5)");
            System.out.println();
            return;
        }

        // Déléguer l'enregistrement au gestionnaire
        try {
            gestionnaire.enregistrerNote(matricule, codeMatiere, valeur);
            System.out.println();
            System.out.println("📊  Note : " + valeur + "/20 pour " + matricule + " en " + codeMatiere);
            System.out.println();
        } catch (AbstractMethodError | NoSuchMethodError ex) {
            System.out.println();
            System.out.println("❌  Erreur : la méthode d'enregistrement n'existe pas avec cette signature.");
            System.out.println();
        } catch (Exception ex) {
            System.out.println();
            System.out.println("❌  Erreur lors de l'enregistrement : " + ex.getMessage());
            System.out.println();
        }
    }

    public void modifierNote() {
        System.out.println("\n" + "─".repeat(50));
        System.out.println("📝  MODIFIER UNE NOTE");
        System.out.println("─".repeat(50));
        System.out.println();

        List<Note> notes = gestionnaire.getNotes();

        if (notes.isEmpty()) {
            System.out.println("📭  Aucune notes n'a été enregistré.");
            System.out.println();
            return;
        }


        System.out.print("👤  Entrez le matricule de l'étudiant : ");
        String matricule = scanner.nextLine();


        for (Note note: notes) {
            Etudiant etudiant = note.getEtudiant();
            if (etudiant.getId().equals(matricule)) {
                System.out.print("📝 Modifier la note : ");
                double nouvelleNote = scanner.nextDouble();
                note.setValeur(nouvelleNote);

                System.out.println();
                System.out.println("✅ Note Modifier avec success pour l'étudiant " + etudiant.getNom() + ", matricule: " + etudiant.getId() + " en " + note.getMatiere());
                System.out.println();
                return;
            } else {
                System.out.println();
                System.out.println("❌ Aucun étudiant ne correspond à ce matricule");
                System.out.println();
            }
        }

    }


}