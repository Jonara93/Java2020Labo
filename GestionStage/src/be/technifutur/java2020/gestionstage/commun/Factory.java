package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.Menu;
import be.technifutur.java2020.gestionstage.MenuGestionStage;

public class Factory {

    /*
    CONSTRUCTEUR
     */
    public Factory() {

    }

    public Factory(User user) {
        this.user = user;
    }

    /*
    FIELD
     */

    private Vue vue;
    private Utility utility;
    private User user;
    private MenuGestionStage menuGestionStage;
    private StageList stageList;
    private ParticipantList participantList;
    private StageCtrlCreateStage stageCtrlCreateStage;
    private StageCtrlDisplayStage stageCtrlDisplayStage;
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private ParticipantCtrlGestion participantCtrlGestion;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private ParticipantCtrlModif participantCtrlModif;

    /*
    METHOD
     */


    public Menu getMenu() {
        Menu menu = new Menu();
        menu.setStageCtrlCreateStage(getStageCtrlCreateStage());
        menu.setStageCtrlDisplayStage(getStageCtrlDisplayStage());
        menu.setMenuGestionStage(getMenuGestionStage());
        menu.setUser(getUser());
        menu.setParticipantCtrlDisplay(getParticipantCtrlDisplay());
        return menu;
    }

    public MenuGestionStage getMenuGestionStage() {
        if (this.menuGestionStage == null) {
            this.menuGestionStage = new MenuGestionStage();
            menuGestionStage.setActivityCtrlCreateActivity(getActivityCtrlCreateActivity());
            menuGestionStage.setDisplayHoraireCtrl(getDisplayHoraireCtrl());
            menuGestionStage.setUser(getUser());
            menuGestionStage.setUtility(getUtility());
            menuGestionStage.setParticipantCtrlGestion(getParticipantCtrlGestion());
            menuGestionStage.setStageList(getStageList());
        }
        return menuGestionStage;
    }


    public StageList getStageList() {
        if (this.stageList == null) {
            this.stageList = new StageList();
        }
        return stageList;
    }

    public ParticipantList getParticipantList() {
        if (this.participantList == null) {
            this.participantList = new ParticipantList();
        }
        return participantList;
    }

    public Vue getVue() {
        if (this.vue == null) {
            this.vue = new Vue();
        }
        return vue;
    }


    public Utility getUtility() {
        if (utility == null) {
            this.utility = new Utility();
            this.utility.setVue(getVue());
            this.utility.setUser(getUser());
        }
        return utility;
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new ConsoleUser();
        }
        return user;
    }

    public StageCtrlCreateStage getStageCtrlCreateStage() {
        if (this.stageCtrlCreateStage == null) {
            this.stageCtrlCreateStage = new StageCtrlCreateStage();
            this.stageCtrlCreateStage.setVue(getVue());
            this.stageCtrlCreateStage.setUtility(getUtility());
            this.stageCtrlCreateStage.setStageList(getStageList());
            this.stageCtrlCreateStage.setUser(getUser());
        }
        return stageCtrlCreateStage;
    }

    public StageCtrlDisplayStage getStageCtrlDisplayStage() {
        if (this.stageCtrlDisplayStage == null) {
            this.stageCtrlDisplayStage = new StageCtrlDisplayStage();
            this.stageCtrlDisplayStage.setStageList(getStageList());
            this.stageCtrlDisplayStage.setVue(getVue());
        }
        return stageCtrlDisplayStage;
    }

    public ActivityCtrlCreateActivity getActivityCtrlCreateActivity() {
        if (this.activityCtrlCreateActivity == null) {
            activityCtrlCreateActivity = new ActivityCtrlCreateActivity();
            activityCtrlCreateActivity.setUtility(getUtility());
            activityCtrlCreateActivity.setVue(getVue());
            activityCtrlCreateActivity.setUser(getUser());
           // activityCtrlCreateActivity.setStageList(getStageList());
        }
        return activityCtrlCreateActivity;
    }

    public DisplayHoraireCtrl getDisplayHoraireCtrl() {
        if (this.displayHoraireCtrl == null) {
            this.displayHoraireCtrl = new DisplayHoraireCtrl();
          //  displayHoraireCtrl.setStageList(getStageList());
            displayHoraireCtrl.setUser(getUser());
            displayHoraireCtrl.setUtility(getUtility());
            displayHoraireCtrl.setVue(getVue());
        }
        return displayHoraireCtrl;
    }

    public ParticipantCtrlGestion getParticipantCtrlGestion() {
        if (this.participantCtrlGestion == null) {
            this.participantCtrlGestion = new ParticipantCtrlGestion();
            participantCtrlGestion.setUser(getUser());
            participantCtrlGestion.setUtility(getUtility());
            participantCtrlGestion.setVue(getVue());
            participantCtrlGestion.setParticipantList(getParticipantList());
            participantCtrlGestion.setStageList(getStageList());
        }
        return participantCtrlGestion;
    }

    public ParticipantCtrlDisplay getParticipantCtrlDisplay() {
        if (participantCtrlDisplay==null){
            this.participantCtrlDisplay = new ParticipantCtrlDisplay();
            participantCtrlDisplay.setParticipantList(getParticipantList());
            participantCtrlDisplay.setVue(getVue());
            participantCtrlGestion.setParticipantCtrlModif(getParticipantCtrlModif());
        }
        return participantCtrlDisplay;
    }

    public ParticipantCtrlModif getParticipantCtrlModif() {
        if (participantCtrlModif == null){
            this.participantCtrlModif = new ParticipantCtrlModif();
            participantCtrlModif.setUtility(getUtility());
            participantCtrlModif.setVue(getVue());
        }
        return participantCtrlModif;
    }
}
