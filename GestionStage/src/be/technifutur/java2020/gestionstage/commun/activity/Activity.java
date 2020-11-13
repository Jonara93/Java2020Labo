package be.technifutur.java2020.gestionstage.commun.activity;

import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Activity implements Serializable {
    /*
    FIELD
     */
    private String nameActivity;
    private LocalDateTime dateDebut;
    private int duration;
    private Stage stage;

    /*
    CONSTRUCTOR
     */

    public Activity(LocalDateTime dateDebut, int duration, String nameActivity, Stage stage) {
        setNameActivity(nameActivity);
        setDateDebut(dateDebut);
        setDuration(duration);
        setStage(stage);
    }

    /*
    METHOD
     */

    /*
    SETTER AND GETTER
     */

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}