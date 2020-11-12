package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.DataBase;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParticipantList  implements Serializable {
    /*
    FIELD
     */
    private Map<String,Participant> mapParticipant = new HashMap<>(); // key = NOM+PRENOM
    private DataBase dataBase;

    /*
    METHOD
     */

    public void addParticipant(String IDParticipant, Participant participant){
        mapParticipant.putIfAbsent(IDParticipant,participant);
    }

    public boolean verifParticipantInList(String IDParticipant){
        return mapParticipant.containsKey(IDParticipant);
    }
    /*
    GETTER AND SETTER
     */

    public Participant getParticipant(String IDParticipant){
        return mapParticipant.get(IDParticipant);
    }

    public Map<String, Participant> getMapParticipant() {
        return mapParticipant;
    }

    public void setMapParticipant(Map<String, Participant> mapParticipant) {
        this.mapParticipant = mapParticipant;
    }

    public Collection<Participant> getCollectionParticipant(){
        return mapParticipant.values();
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

}
