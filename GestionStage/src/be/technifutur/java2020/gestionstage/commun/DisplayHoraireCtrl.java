package be.technifutur.java2020.gestionstage.commun;

import java.util.*;

public class DisplayHoraireCtrl {
    /*
    FIELD
     */
    private Utility utility;
    private Vue vue;
    private User user;

    /*
    METHOD
     */

    public void displayHoraireStage(Stage stage) {
        Collection<Activity> activityCollection = stage.getActivityCollection();
        List<Activity> activityList = new ArrayList<>(activityCollection);
        activityList.sort(new MyComparatorActivity());
        vue.afficheHoraire(stage, activityList);
    }



    /*
    SETTER
     */

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
