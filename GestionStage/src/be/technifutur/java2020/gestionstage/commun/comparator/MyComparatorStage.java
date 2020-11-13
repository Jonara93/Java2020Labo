package be.technifutur.java2020.gestionstage.commun.comparator;

import be.technifutur.java2020.gestionstage.commun.stage.Stage;

import java.util.Comparator;

public class MyComparatorStage implements Comparator<Stage> {
    @Override
    public int compare(Stage stage1, Stage stage2) {
        int compare;

        if (stage1.getDateDebut().isBefore(stage2.getDateDebut())) {
            compare = -42;
        } else if (stage2.getDateDebut().isBefore(stage1.getDateDebut())) {
            compare = 42;
        } else {
            if (stage1.getDateFin().isBefore(stage2.getDateFin())){
                compare = -42;
            } else if (stage1.getDateFin().isBefore(stage2.getDateFin())){
                compare = 42;
            }else {
                compare = 0;
            }
        }
        return compare;
    }
}
