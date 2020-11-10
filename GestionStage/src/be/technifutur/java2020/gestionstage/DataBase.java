package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.ParticipantList;
import be.technifutur.java2020.gestionstage.commun.StageList;

import java.io.*;

public class DataBase implements Serializable {
    /*
    FIELD
     */
    private StageList stageList;
    private ParticipantList participantList;

    /*
    CONSTRUCTOR
     */



    /*
    METHOD
     */

    public void saveData() throws IOException {

        File file = new File("db.ser");

        // ouverture d'un flux sur un fichier
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

        // serialization de l'objet
        oos.writeObject(this);
    }

    public void loadData() throws IOException, ClassNotFoundException {

    }

    /*
    SETTER AND GETTER
     */

    public StageList getStageList() {
        return stageList;
    }

    public ParticipantList getParticipantList() {
        return participantList;
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }

    public void setParticipantList(ParticipantList participantList) {
        this.participantList = participantList;
    }
}
