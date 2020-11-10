package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.exception.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Stage {
    /*
    FIELD
     */

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String intituleStage;
    private Map<String, Activity> mapActivity;
    private Map<String, Participant> mapParticipant;

    /*
    CONSTRUCTOR
     */

    public Stage(LocalDateTime dateDebut, LocalDateTime dateFin, String intituleStage) throws ExceptionGestionStageDate {
        if (dateFin.isBefore(dateDebut)) {
            throw new ExceptionGestionStageDate("La date de fin n'est pas valide.");
        }
        setDateDebut(dateDebut);
        setDateFin(dateFin);
        setIntituleStage(intituleStage);
        mapActivity = new HashMap<>();
        mapParticipant = new HashMap<>();
    }

    /*
    METHOD
     */

    public void addActivity(LocalDateTime dateDebut, int duration, String nameActivity) throws ExceptionGestionStage {
        if (mapActivity.containsKey(nameActivity)) {
            throw new ExceptionGestionStageDoublonActivity("Cette activité existe déjà pour ce stage.");
        }
        if (dateFin.isBefore(dateDebut.plusMinutes(duration))) {
            throw new ExceptionGestionStageDate("La durée de l'activité dépasse la fin du stage.");
        }
        mapActivity.put(nameActivity, new Activity(dateDebut, duration, nameActivity));
    }

    public void addParticipant(Participant participant) {
        String idParticipant = participant.getIDParticipant();
        mapParticipant.put(idParticipant, participant);
    }

    public void removeParticipant(Participant participant) {
        String idParticipant = participant.getIDParticipant();
        mapParticipant.remove(idParticipant);
    }


    public Map<String, Activity> getMapActivity() {
        return mapActivity;
    }

    public Collection<Activity> getActivityCollection() {
        return mapActivity.values();
    }

    public Participant createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, String clubParticipant, String mailParticipant) {
        Participant participant = new Participant(nomParticipant, prenomParticipant, clubParticipant, mailParticipant, this);
        this.mapParticipant.put(IDParticipant, participant);
        return participant;
    }

    /*
    GETTER AND SETTER
     */

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }


    public String getIntituleStage() {
        return intituleStage;
    }

    public void setIntituleStage(String intituleStage) {
        this.intituleStage = intituleStage;
    }

    public Map<String, Participant> getMapParticipant() {
        return mapParticipant;
    }

    public void setMapParticipant(Map<String, Participant> mapParticipant) {
        this.mapParticipant = mapParticipant;
    }


    public boolean containsKey(String idParticipant) {
        return mapParticipant.containsKey(idParticipant);
    }
}
