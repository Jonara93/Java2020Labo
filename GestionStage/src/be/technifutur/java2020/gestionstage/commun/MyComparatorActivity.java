package be.technifutur.java2020.gestionstage.commun;

import java.util.Comparator;

public class MyComparatorActivity implements Comparator<Activity> {
    @Override
    public int compare(Activity activity1, Activity activity2) {
        int compare;

        if (activity1.getDateDebut().isBefore(activity2.getDateDebut())) {
            compare = -1;
        } else if (activity2.getDateDebut().isBefore(activity1.getDateDebut())) {
            compare = 1;
        } else {
            compare = 0;
        }
        return compare;
    }
}
