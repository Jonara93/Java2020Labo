package be.technifutur.java2020.gestionstage.commun;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Activity  implements Serializable {
    private String nameActivity;
    private LocalDateTime dateDebut;
    private int duration;

    public Activity(LocalDateTime dateDebut, int duration, String nameActivity) {
        setNameActivity(nameActivity);
        setDateDebut(dateDebut);
        setDuration(duration);
    }

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

}