package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.stage.StageList;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class Vue {

    public void afficheMessage(String message) {
        System.out.println(message);
    }

    public void consigneAjoutDuree() {
        System.out.println("" +
                "Veuillez saisir une durée en minute ou \"q\" pour quitter." +
                "Une durée d'activitée doit être supérieure à 0 minute"
        );
    }

    public void ajoutDateDebut() {
        System.out.println("Entrée la date et l'heure de début");
    }

    public void ajoutDateFin() {
        System.out.println("Entrée la date et l'heure de fin");
    }

    public void consigneAjoutDateStage() {
        System.out.println("Veuillez ajouter la date et l'heure sous le format suivant : \"jj\".\"mm\".\"aaaa\".\"hh\".\"mm\" ou \"q\" pour quitter.");
    }

    public void setError(String message) {
        System.out.println(message);
    }

    public void afficheStage(Stage stage) {
        afficheStage(stage.getIntituleStage(), stage.getDateDebut(), stage.getDateFin());
    }

    public void afficheStage(String name, LocalDateTime dateDebut, LocalDateTime dateFin) {
        System.out.println("" +
                "Nom du stage : " + name + "\n" +
                "Début du stage : " + dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")) + "\n" +
                "Fin du stage : " + dateFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")) + "\n"
        );
    }

    public void afficheDate(LocalDateTime localDateTime) {
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm")));
    }

    public void afficheHoraire(Stage stage, List<Activity> activityList) {
        LocalDate dateDebutStage = stage.getDateDebut().toLocalDate();
        Activity testActivityFirstDay = activityList.get(0);
        if (!activityList.isEmpty()) {
            System.out.println("Horaire du stage : " + stage.getIntituleStage());
            if (dateDebutStage.isEqual(testActivityFirstDay.getDateDebut().toLocalDate())) {
                System.out.println("" +
                        dateDebutStage.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE).toUpperCase() + " " +
                        dateDebutStage.getDayOfMonth() + " " +
                        dateDebutStage.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE).toUpperCase() + " " +
                        dateDebutStage.getYear()
                );
            }
            for (Activity activity : activityList) {
                if (dateDebutStage.isBefore(activity.getDateDebut().toLocalDate())) {
                    dateDebutStage = activity.getDateDebut().toLocalDate();
                    System.out.println("" +
                            dateDebutStage.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE).toUpperCase() + " " +
                            dateDebutStage.getDayOfMonth() + " " +
                            dateDebutStage.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE).toUpperCase() + " " +
                            dateDebutStage.getYear()
                    );
                }
                System.out.print("      " +
                        activity.getDateDebut().format(DateTimeFormatter.ofPattern("H'h'mm")) + " - " +
                        activity.getDateDebut().plusMinutes(activity.getDuration()).format(DateTimeFormatter.ofPattern("H'h'mm")) + " " +
                        activity.getNameActivity() + " " +
                        "(" + activity.getDuration() + " minutes)" + "\n"
                );
            }
        } else {
            System.out.println("Il n'y a pas d'activitée prévu pour ce stage.");
        }
    }

    public void afficheParticipantSimple(Participant participant) {
        System.out.println("Nom et prénom du participant : " + participant.getNomParticipant() + " " + participant.getPrenomParticipant());
    }

    public void afficheParticipant(Participant participant) {
        System.out.println("" +
                "Nom du participant : " + participant.getNomParticipant() + "\n" +
                "Prénom du participant : " + participant.getPrenomParticipant()
        );
        if (!participant.getNomClub().isEmpty()) {
            System.out.println("Nom du club du participant : " + participant.getNomClub());
        } else {
            System.out.println("Nom du club du participant : Non indiqué.");
        }
        if (!participant.getAdresseMail().isEmpty()) {
            System.out.println("Adresse mail du participant : " + participant.getAdresseMail());
        } else {
            System.out.println("Adresse mail du participant : Non indiqué.");
        }
    }

    public void afficheParticipant(Participant participant, StageList stageList) {
        List<Stage> stageCollection = new ArrayList<>(stageList.getMapStageUnmodifiable().values());
        System.out.println("" +
                "Nom du participant : " + participant.getNomParticipant() + "\n" +
                "Prénom du participant : " + participant.getPrenomParticipant()
        );
        if (!participant.getNomClub().isEmpty()) {
            System.out.println("Nom du club du participant : " + participant.getNomClub());
        } else {
            System.out.println("Nom du club du participant : Non indiqué.");
        }
        if (!participant.getAdresseMail().isEmpty()) {
            System.out.println("Adresse mail du participant : " + participant.getAdresseMail());
        } else {
            System.out.println("Adresse mail du participant : Non indiqué.");
        }
        System.out.println("Liste des stages/activités auquels le participant est inscrit : ");
        for (Stage stage : stageCollection) {
            if (stage.containsKeyParticipant(participant.getIDParticipant())) {
                Participation participation = stage.getParticipation(participant.getIDParticipant());
                System.out.println(stage.getIntituleStage() + " : ");
                System.out.println("Tarif pour ce stage : " + participation.getTarif().getName());
                Collection<Activity> activityCollection = participation.getActivityMap().values();
                for (Activity activity: activityCollection ) {
                    System.out.println("    " + activity.getNameActivity());
                }
            }
        }
        System.out.println("\n");
    }

    public String displayModifParticipant() {

        return "" +
                "Veuillez choisir une option : \n" +
                "1. Modifier l'adresse mail.\n" +
                "2. Modifier le nom du club.\n" +
                "q. Quitter la modification.";

    }

    public void afficheListTarifGen(List<Tarif> listGenTarif) {
        int index = 1;
        for (Tarif tarif : listGenTarif) {
            System.out.println(index + " : " + tarif.getName());
            index++;
        }
    }
}
