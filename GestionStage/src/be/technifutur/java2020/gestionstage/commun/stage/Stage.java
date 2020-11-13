package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.prix.Tarif;
import be.technifutur.java2020.gestionstage.exception.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Stage implements Serializable {
    /*
    FIELD
     */

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String intituleStage;
    private Map<String, Activity> mapActivity;
    private Map<String, Participant> mapParticipant;
    private List<Tarif> tarifAppliquable;
    private Map<String, Tarif> participantTarifMap;// key idParticipant

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
        mapActivity = new HashMap<>();// key nameActivity
        mapParticipant = new HashMap<>();//key idParticipant
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
        if (dateDebut.isBefore(this.dateDebut)) {
            throw new ExceptionGestionStageDate("La date de début de l'activité est avant le début du stage.");
        }
        mapActivity.put(nameActivity, new Activity(dateDebut, duration, nameActivity,this));
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
        return Collections.unmodifiableCollection(mapActivity.values());
    }

    public Participant createParticipant(String IDParticipant, String nomParticipant, String prenomParticipant, String clubParticipant, String mailParticipant) {
        Participant participant = new Participant(nomParticipant, prenomParticipant, clubParticipant, mailParticipant);
        this.mapParticipant.put(IDParticipant, participant);
        return participant;
    }

    public boolean containsKeyParticipant(String idParticipant) {
        return mapParticipant.containsKey(idParticipant);
    }

    public boolean containsKeyActivity(String nameActivity) {
        return mapActivity.containsKey(nameActivity);
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

    public List<Participant> getSortListParticipantByName() {
        Collection<Participant> participantCollection = this.getMapParticipant().values();
        List<Participant> participantList = new ArrayList<>(participantCollection);
        participantList.sort(new MyComparatorParticipant());
        return participantList;
    }

    public Participant getParticipant(String idParticipant) {
        return mapParticipant.get(idParticipant);
    }

    public Activity getActivity(String nameActivity) {
        return mapActivity.get(nameActivity);
    }
}
