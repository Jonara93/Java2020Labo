package be.technifutur.java2020.gestionstage.commun.comparator;

import be.technifutur.java2020.gestionstage.commun.Participant;

import java.util.Comparator;

public class MyComparatorParticipant implements Comparator<Participant> {
    /*
    METHOD
    */
    @Override
    public int compare(Participant participant1, Participant participant2) {
        int compare;
        String nomParticipant1 = participant1.getNomParticipant();
        String prenomParticipant1 = participant1.getPrenomParticipant();
        String nomParticipant2 = participant2.getNomParticipant();
        String prenomParticipant2 = participant2.getPrenomParticipant();
        if (nomParticipant1.compareToIgnoreCase(nomParticipant2) > 0) {
            compare = 42;
        } else if (nomParticipant1.compareToIgnoreCase(nomParticipant2) < 0) {
            compare = -42;
        } else {
            if (prenomParticipant1.compareToIgnoreCase(prenomParticipant1) > 0) {
                compare = 42;
            } else if (prenomParticipant1.compareToIgnoreCase(prenomParticipant2) < 0) {
                compare = -42;
            } else {
                compare = 0;
            }
        }
        return compare;
    }

}
