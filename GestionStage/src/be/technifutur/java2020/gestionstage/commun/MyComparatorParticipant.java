package be.technifutur.java2020.gestionstage.commun;

import java.util.Comparator;

public class MyComparatorParticipant implements Comparator<Participant> {
    /*
    METHOD
    */
    @Override
    public int compare(Participant participant1, Participant participant2) {
        int compare;
        String nomParticipant1 = participant1.getNomParticipant();
        String nomParticipant2 = participant2.getNomParticipant();
        if (nomParticipant1.compareTo(nomParticipant2) > 0) {
            compare = 2;
        } else if (nomParticipant1.compareTo(nomParticipant2) < 0){
            compare = -15;
        }else {
            compare = 0;
        }
            return compare;
    }

}
