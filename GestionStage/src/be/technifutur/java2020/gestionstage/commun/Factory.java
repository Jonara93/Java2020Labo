package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.Menu;
import be.technifutur.java2020.gestionstage.MenuGestionStage;
import be.technifutur.java2020.gestionstage.ParticipantCtrlRemove;

import java.io.*;

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
    private DataBase dataBase;
    private MenuGestionStage menuGestionStage;
    private StageList stageList;
    private ParticipantList participantList;
    private StageCtrlCreateStage stageCtrlCreateStage;
    private StageCtrlDisplayStage stageCtrlDisplayStage;
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private ParticipantCtrlAdd participantCtrlAdd;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private ParticipantCtrlModif participantCtrlModif;
    private ParticipantCtrlRemove participantCtrlRemove;


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
        menu.setDataBase(getDataBase());
        return menu;
    }

    public MenuGestionStage getMenuGestionStage() {
        if (this.menuGestionStage == null) {
            this.menuGestionStage = new MenuGestionStage();
            this.menuGestionStage.setActivityCtrlCreateActivity(getActivityCtrlCreateActivity());
            this.menuGestionStage.setDisplayHoraireCtrl(getDisplayHoraireCtrl());
            this.menuGestionStage.setUser(getUser());
            this.menuGestionStage.setUtility(getUtility());
            this.menuGestionStage.setParticipantCtrlAdd(getParticipantCtrlAdd());
            this.menuGestionStage.setStageList(getStageList());
            this.menuGestionStage.setParticipantCtrlDisplay(getParticipantCtrlDisplay());
            this.menuGestionStage.setParticipantCtrlRemove(getParticipantCtrlRemove());

        }
        return menuGestionStage;
    }


    public StageList getStageList() {

        if (this.stageList == null) {
            if (getDataBase().getStageList() == null) {
                this.stageList = new StageList();
            } else {
                this.stageList = getDataBase().getStageList();
            }
        }
        return stageList;
    }

    public ParticipantList getParticipantList() {
        if (this.participantList == null) {
            if (getDataBase().getParticipantList() == null) {
                this.participantList = new ParticipantList();
            } else {

                this.participantList = getDataBase().getParticipantList();
            }
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
            this.stageCtrlCreateStage.setDataBase(getDataBase());
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
            this.activityCtrlCreateActivity = new ActivityCtrlCreateActivity();
            this.activityCtrlCreateActivity.setUtility(getUtility());
            this.activityCtrlCreateActivity.setVue(getVue());
            this.activityCtrlCreateActivity.setUser(getUser());
            this.activityCtrlCreateActivity.setDataBase(getDataBase());
        }
        return activityCtrlCreateActivity;
    }

    public DisplayHoraireCtrl getDisplayHoraireCtrl() {
        if (this.displayHoraireCtrl == null) {
            this.displayHoraireCtrl = new DisplayHoraireCtrl();
            this.displayHoraireCtrl.setUser(getUser());
            this.displayHoraireCtrl.setUtility(getUtility());
            this.displayHoraireCtrl.setVue(getVue());
        }
        return displayHoraireCtrl;
    }

    public ParticipantCtrlAdd getParticipantCtrlAdd() {
        if (this.participantCtrlAdd == null) {
            this.participantCtrlAdd = new ParticipantCtrlAdd();
            this.participantCtrlAdd.setUser(getUser());
            this.participantCtrlAdd.setUtility(getUtility());
            this.participantCtrlAdd.setVue(getVue());
            this.participantCtrlAdd.setParticipantList(getParticipantList());
            this.participantCtrlAdd.setDataBase(getDataBase());
        }
        return participantCtrlAdd;
    }

    public ParticipantCtrlDisplay getParticipantCtrlDisplay() {
        if (participantCtrlDisplay == null) {
            this.participantCtrlDisplay = new ParticipantCtrlDisplay();
            this.participantCtrlDisplay.setParticipantList(getParticipantList());
            this.participantCtrlDisplay.setVue(getVue());
            this.participantCtrlAdd.setParticipantCtrlModif(getParticipantCtrlModif());
        }
        return participantCtrlDisplay;
    }

    public ParticipantCtrlModif getParticipantCtrlModif() {
        if (participantCtrlModif == null) {
            this.participantCtrlModif = new ParticipantCtrlModif();
            this.participantCtrlModif.setUtility(getUtility());
            this.participantCtrlModif.setVue(getVue());
        }
        return participantCtrlModif;
    }

    public DataBase getDataBase() {
        if (this.dataBase == null) {
            File file = new File("db.ser");
            if (file.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    // deserialisation de l'objet
                    this.dataBase = (DataBase) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    file.delete();
                }
            }
            if (this.dataBase == null) {
                this.dataBase = new DataBase();
                this.dataBase.setStageList(getStageList());
                this.dataBase.setParticipantList(getParticipantList());
            }
        }
        return dataBase;
    }

    public ParticipantCtrlRemove getParticipantCtrlRemove() {
        if (this.participantCtrlRemove == null) {
            this.participantCtrlRemove = new ParticipantCtrlRemove();
            this.participantCtrlRemove.setVue(getVue());
            this.participantCtrlRemove.setUtility(getUtility());
        }
        return participantCtrlRemove;
    }
}
