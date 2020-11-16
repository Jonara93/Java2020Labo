package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.DataBase;
import be.technifutur.java2020.gestionstage.Menu;
import be.technifutur.java2020.gestionstage.MenuGestionActivity;
import be.technifutur.java2020.gestionstage.MenuGestionStage;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlCreateActivity;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlDisplayParticipant;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlInscription;
import be.technifutur.java2020.gestionstage.commun.activity.ActivityCtrlRemoveParticipant;
import be.technifutur.java2020.gestionstage.commun.participant.*;
import be.technifutur.java2020.gestionstage.commun.participation.Participation;
import be.technifutur.java2020.gestionstage.commun.stage.*;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifDateDebut;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifDateFin;
import be.technifutur.java2020.gestionstage.commun.stage.modifstage.StageCtrlModifName;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifList;

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
    //sousmenu
    private MenuGestionStage menuGestionStage;
    private MenuGestionActivity menuGestionActivity;
    //stage
    private StageList stageList;
    private StageCtrlCreateStage stageCtrlCreateStage;
    private StageCtrlDisplayStage stageCtrlDisplayStage;
    private DisplayHoraireCtrl displayHoraireCtrl;
    private StageCtrlModif stageCtrlModif;
    private StageCtrlModifDateDebut stageCtrlModifDateDebut;
    private StageCtrlModifDateFin stageCtrlModifDateFin;
    private StageCtrlModifName stageCtrlModifName;
    // activity
    private ActivityCtrlCreateActivity activityCtrlCreateActivity;
    private ActivityCtrlInscription activityCtrlInscription;
    private ActivityCtrlDisplayParticipant activityCtrlDisplayParticipant;
    private ActivityCtrlRemoveParticipant activityCtrlRemoveParticipant;
    // participant
    private ParticipantList participantList;
    private ParticipantCtrlAdd participantCtrlAdd;
    private ParticipantCtrlDisplay participantCtrlDisplay;
    private ParticipantCtrlModif participantCtrlModif;
    private ParticipantCtrlRemove participantCtrlRemove;
    private ParticipantCtrlCreate participantCtrlCreate;
    //tarif
    private TarifList tarifList;


    /*
    METHOD
     */

    //menu
    public Menu getMenu() {
        Menu menu = new Menu();
        menu.setStageCtrlCreateStage(getStageCtrlCreateStage());
        menu.setStageCtrlDisplayStage(getStageCtrlDisplayStage());
        menu.setMenuGestionStage(getMenuGestionStage());
        menu.setUser(getUser());
        menu.setParticipantCtrlDisplay(getParticipantCtrlDisplay());
        menu.setDataBase(getDataBase());
        menu.setStageList(getStageList());
        return menu;
    }

    public MenuGestionStage getMenuGestionStage() {
        if (this.menuGestionStage == null) {
            this.menuGestionStage = new MenuGestionStage();
            this.menuGestionStage.setUser(getUser());
            this.menuGestionStage.setVue(getVue());
            this.menuGestionStage.setUtility(getUtility());
            this.menuGestionStage.setStageList(getStageList());
            this.menuGestionStage.setDataBase(getDataBase());
            this.menuGestionStage.setActivityCtrlCreateActivity(getActivityCtrlCreateActivity());
            this.menuGestionStage.setDisplayHoraireCtrl(getDisplayHoraireCtrl());
            this.menuGestionStage.setParticipantCtrlAdd(getParticipantCtrlAdd());
            this.menuGestionStage.setParticipantCtrlDisplay(getParticipantCtrlDisplay());
            this.menuGestionStage.setParticipantCtrlRemove(getParticipantCtrlRemove());
            this.menuGestionStage.setMenuGestionActivity(getMenuGestionActivity());
            this.menuGestionStage.setStageCtrlModif(getStageCtrlModif());
        }
        return menuGestionStage;
    }

    public MenuGestionActivity getMenuGestionActivity() {
        if (this.menuGestionActivity == null) {
            this.menuGestionActivity = new MenuGestionActivity();
            this.menuGestionActivity.setUtility(getUtility());
            this.menuGestionActivity.setUser(getUser());
            this.menuGestionActivity.setVue(getVue());
            this.menuGestionActivity.setDataBase(getDataBase());
            this.menuGestionActivity.setActivityCtrlInscription(getActivityCtrlInscription());
            this.menuGestionActivity.setActivityCtrlDisplayParticipant(getActivityCtrlDisplayParticipant());
            this.menuGestionActivity.setActivityCtrlRemoveParticipant(getActivityCtrlRemoveParticipant());
        }
        return menuGestionActivity;
    }


    // activity
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

    public ActivityCtrlInscription getActivityCtrlInscription() {
        if (this.activityCtrlInscription == null) {
            this.activityCtrlInscription = new ActivityCtrlInscription();
            this.activityCtrlInscription.setVue(getVue());
            this.activityCtrlInscription.setUtility(getUtility());
            this.activityCtrlInscription.setParticipantCtrlModif(getParticipantCtrlModif());
            this.activityCtrlInscription.setParticipantCtrlCreate(getParticipantCtrlCreate());
            this.activityCtrlInscription.setParticipantList(getParticipantList());
        }
        return activityCtrlInscription;
    }

    public ActivityCtrlRemoveParticipant getActivityCtrlRemoveParticipant() {
        if (this.activityCtrlRemoveParticipant == null) {
            this.activityCtrlRemoveParticipant = new ActivityCtrlRemoveParticipant();
            this.activityCtrlRemoveParticipant.setUtility(getUtility());
            this.activityCtrlRemoveParticipant.setVue(getVue());
        }
        return activityCtrlRemoveParticipant;
    }

    public ActivityCtrlDisplayParticipant getActivityCtrlDisplayParticipant() {
        if (this.activityCtrlDisplayParticipant == null) {
            this.activityCtrlDisplayParticipant = new ActivityCtrlDisplayParticipant();
            this.activityCtrlDisplayParticipant.setVue(getVue());
        }
        return activityCtrlDisplayParticipant;
    }

    //participant

    public ParticipantCtrlAdd getParticipantCtrlAdd() {
        if (this.participantCtrlAdd == null) {
            this.participantCtrlAdd = new ParticipantCtrlAdd();
            this.participantCtrlAdd.setUser(getUser());
            this.participantCtrlAdd.setUtility(getUtility());
            this.participantCtrlAdd.setVue(getVue());
            this.participantCtrlAdd.setParticipantList(getParticipantList());
            this.participantCtrlAdd.setDataBase(getDataBase());
            this.participantCtrlAdd.setParticipantCtrlCreate(getParticipantCtrlCreate());
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


    public ParticipantCtrlRemove getParticipantCtrlRemove() {
        if (this.participantCtrlRemove == null) {
            this.participantCtrlRemove = new ParticipantCtrlRemove();
            this.participantCtrlRemove.setVue(getVue());
            this.participantCtrlRemove.setUtility(getUtility());
        }
        return participantCtrlRemove;
    }

    public ParticipantCtrlCreate getParticipantCtrlCreate() {
        if (this.participantCtrlCreate == null) {
            this.participantCtrlCreate = new ParticipantCtrlCreate();
            this.participantCtrlCreate.setParticipantList(getParticipantList());
            this.participantCtrlCreate.setUtility(getUtility());
        }
        return participantCtrlCreate;
    }

    //stage
    public DisplayHoraireCtrl getDisplayHoraireCtrl() {
        if (this.displayHoraireCtrl == null) {
            this.displayHoraireCtrl = new DisplayHoraireCtrl();
            this.displayHoraireCtrl.setUser(getUser());
            this.displayHoraireCtrl.setUtility(getUtility());
            this.displayHoraireCtrl.setVue(getVue());
        }
        return displayHoraireCtrl;
    }

    public StageCtrlCreateStage getStageCtrlCreateStage() {
        if (this.stageCtrlCreateStage == null) {
            this.stageCtrlCreateStage = new StageCtrlCreateStage();
            this.stageCtrlCreateStage.setVue(getVue());
            this.stageCtrlCreateStage.setUtility(getUtility());
            this.stageCtrlCreateStage.setStageList(getStageList());
            this.stageCtrlCreateStage.setUser(getUser());
            this.stageCtrlCreateStage.setDataBase(getDataBase());
            this.stageCtrlCreateStage.setTarifList(getTarifList());
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

    public StageCtrlModif getStageCtrlModif() {
        if (this.stageCtrlModif == null) {
            this.stageCtrlModif = new StageCtrlModif();
            this.stageCtrlModif.setDataBase(getDataBase());
            this.stageCtrlModif.setVue(getVue());
            this.stageCtrlModif.setUtility(getUtility());
            this.stageCtrlModif.setStageCtrlModifDateDebut(getStageCtrlModifDateDebut());
            this.stageCtrlModif.setStageCtrlModifDateFin(getStageCtrlModifDateFin());
            this.stageCtrlModif.setStageCtrlModifName(getStageCtrlModifName());
        }
        return stageCtrlModif;
    }

    public StageCtrlModifDateDebut getStageCtrlModifDateDebut() {
        if (stageCtrlModifDateDebut == null) {
            stageCtrlModifDateDebut = new StageCtrlModifDateDebut();
            stageCtrlModifDateDebut.setUtility(getUtility());
            stageCtrlModifDateDebut.setVue(getVue());
        }
        return stageCtrlModifDateDebut;
    }

    public StageCtrlModifDateFin getStageCtrlModifDateFin() {
        if (stageCtrlModifDateFin==null){
            stageCtrlModifDateFin = new StageCtrlModifDateFin();
            stageCtrlModifDateFin.setUtility(getUtility());
            stageCtrlModifDateFin.setVue(getVue());
        }
        return stageCtrlModifDateFin;
    }

    public StageCtrlModifName getStageCtrlModifName() {
        if (stageCtrlModifName==null){
            stageCtrlModifName = new StageCtrlModifName();
            stageCtrlModifName.setUtility(getUtility());
            stageCtrlModifName.setVue(getVue());
            stageCtrlModifName.setStageList(getStageList());
        }
        return stageCtrlModifName;
    }

    //gestion des données
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


    //others


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

    public TarifList getTarifList() {
        if (this.tarifList == null){
            this.tarifList = new TarifList();
        }
        return tarifList;
    }
}
