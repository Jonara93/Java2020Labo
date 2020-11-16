package be.technifutur.java2020.gestionstage.commun.stage;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;
import be.technifutur.java2020.gestionstage.commun.comparator.MyComparatorParticipant;
import be.technifutur.java2020.gestionstage.commun.participant.Participant;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifBase;
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
    private Map<String, Activity> mapActivity;//key = nameActivity
    private Map<String, Participation> mapParticipation; //key = idParticipant
    private List<Tarif> tarifAppliquable;

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
        mapParticipation = new HashMap<>();//key idParticipant
        tarifAppliquable = new ArrayList<>();
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
        mapActivity.put(nameActivity, new Activity(dateDebut, duration, nameActivity, this));
    }

    public void addParticipantion(Participant participant, Tarif tarif) {
        String idParticipant = participant.getIDParticipant();
        Participation participation = new Participation(participant, tarif);
        mapParticipation.put(idParticipant, participation);
    }

    public void removeParticipantion(Participant participant) {
        String idParticipant = participant.getIDParticipant();
        mapParticipation.remove(idParticipant);
    }

    public String addTarif(Tarif tarif) {
        String message = "Tarif déjà présent pour ce stage.";
        if (!tarifAppliquable.contains(tarif)) {
            tarifAppliquable.add(tarif);
            message = "Tarif ajouté correctement au stage.";
        }
        return message;
    }


    public Collection<Activity> getActivityCollection() {
        return Collections.unmodifiableCollection(mapActivity.values());
    }

    public Participant createParticipation(String IDParticipant, String nomParticipant, String prenomParticipant, String clubParticipant, String mailParticipant, Tarif tarif) {
        Participant participant = new Participant(nomParticipant, prenomParticipant, clubParticipant, mailParticipant);
        Participation participation = new Participation(participant, tarif);
        this.mapParticipation.put(IDParticipant, participation);
        return participant;
    }

    public boolean containsKeyParticipant(String idParticipant) {
        return mapParticipation.containsKey(idParticipant);
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

    public Activity getActivity(String nameActivity) {
        return mapActivity.get(nameActivity);
    }

    public Map<String, Participation> getMapParticipation() {
        return mapParticipation;
    }

    public List<Participant> getAllParticipant() {
        List<Participant> participantList = new ArrayList<>();
        for (Participation participation : mapParticipation.values()) {
            participantList.add(participation.getParticipant());
        }
        return participantList;
    }

    public Participation getParticipation(String idParticipant) {
        return getMapParticipation().get(idParticipant);
    }

    public List<Participant> getParticapantInActivity(Activity activity) {
        List<Participant> participantListInActivity = null;
        Collection<Participation> participationCollection = this.getMapParticipation().values();
        for (Participation participation : participationCollection) {
            if (participation.getActivityMap().containsKey(activity.getNameActivity())) {
                participantListInActivity.add(participation.getParticipant());
            }
        }
        participantListInActivity.sort(new MyComparatorParticipant());
        return participantListInActivity;
    }

    public Participant getParticipant(String idParticipant) {
        return getParticipation(idParticipant).getParticipant();
    }

    public List<Tarif> getTarifAppliquable() {
        return tarifAppliquable;
    }

    public Map<String, Activity> getMapActivity() {
        return mapActivity;
    }
}
