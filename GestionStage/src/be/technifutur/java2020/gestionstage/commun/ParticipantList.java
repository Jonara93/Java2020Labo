package be.technifutur.java2020.gestionstage.commun;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ParticipantList {
    /*
    FIELD
     */
    private Map<String,Participant> mapParticipant = new HashMap<>(); // key = NOM+PRENOM

    /*
    METHOD
     */

    public void addParticipant(String IDParticipant, Participant participant){
        mapParticipant.put(IDParticipant,participant);
    }

    // tout les stages qu'un participant à participer

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
}
