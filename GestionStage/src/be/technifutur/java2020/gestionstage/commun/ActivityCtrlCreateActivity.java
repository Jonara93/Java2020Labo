package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStage;
import be.technifutur.java2020.gestionstage.exception.ExceptionGestionStageNomInvalide;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.OptionalInt;

public class ActivityCtrlCreateActivity {
    private Utility utility;
    private Vue vue;
    private User user;
    private StageList stageList;
    private Collection<String> collection = stageList.getStringCollection();

    public void createActivity() {
        String nameActivity=null, nameStage;
        int duration=0;
        LocalDateTime dateDebut = null;
        boolean createStage = true;

        vue.consigneAjoutNomStage();
        nameStage = user.getInput();
        while (nameStage.isEmpty()) {
            vue.consigneAjoutNomStage();
            nameStage = user.getInput();
        }
        if (nameStage.equalsIgnoreCase("q")) {
            createStage = false;
        } else {
            createStage = nameStageIsValid(nameStage, collection);
        }

        if (createStage) {
            vue.consigneAjoutNomActivity();
            nameActivity = user.getInput();
            while (nameActivity.isEmpty()) {
                vue.consigneAjoutNomActivity();
                nameActivity = user.getInput();
            }
        }
        if (nameActivity.equalsIgnoreCase("q")){
            createStage=false;
        }

        if (createStage) {
            vue.ajoutDateDebut();
            dateDebut = utility.saisirDate();
            if (dateDebut == null) {
                createStage = false;
            }
        }


        if (createStage) {
            OptionalInt inputDuration;
            vue.consigneAjoutDuree();
            inputDuration = utility.saisirDuree();
            if (inputDuration.isEmpty()) {
                createStage = false;
            } else {
                duration = inputDuration.getAsInt();
            }
        }

        if (createStage) {
            try{
                Activity activity = new Activity(nameActivity,dateDebut,duration,nameStage);
            }catch (ExceptionGestionStage e){
                vue.setError(e.getMessage());
            }
        }


    }

    /*
    verifier que le stage existe
     */
    public boolean nameStageIsValid(String nameStage,Collection<String> collection) {
        boolean isValid = false;
        try {
            if (collection.contains(nameStage)) {
                isValid = true;
            } else {
                throw new ExceptionGestionStageNomInvalide("Le stage n'existe pas");
            }
        } catch (ExceptionGestionStageNomInvalide e) {
            vue.setError(e.getMessage());
        }
        return isValid;
    }

    public void setUtility(Utility utility) {
        this.utility = utility;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStageList(StageList stageList) {
        this.stageList = stageList;
    }
}
