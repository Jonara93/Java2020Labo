package be.technifutur.java2020.gestionstage.commun;

import java.util.Comparator;

public class MyComparatorStage implements Comparator<Stage> {
    @Override
    public int compare(Stage stage1, Stage stage2) {
        int compare;

        if (stage1.getDateDebut().isBefore(stage2.getDateDebut())) {
            compare = -1;
        } else if (stage2.getDateDebut().isBefore(stage1.getDateDebut())) {
            compare = 1;
        } else {
            compare = 0;
        }
        return compare;
    }
}
