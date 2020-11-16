package be.technifutur.java2020.gestionstage.commun;

import be.technifutur.java2020.gestionstage.commun.stage.Stage;
import be.technifutur.java2020.gestionstage.commun.tarif.Tarif;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifBase;
import be.technifutur.java2020.gestionstage.commun.tarif.TarifList;

import java.time.LocalDateTime;
import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    private Vue vue;
    private User user;

    public LocalDateTime saisirDate() {
        LocalDateTime date = null;
        Pattern pattern = Pattern.compile("([0][1-9]|[1-2][0-9]|[3][0-1]).([0][1-9]|[1][0-2]).([0-9][0-9][0-9][0-9]).([0][0-9]|[1][0-9]|[2][0-3]).([0-5][0-9])|[qQ]");
        String inputDate;
        int year = 0, month = 0, day = 0, hour = 0, minute = 0;

        inputDate = getInput();
        while (!(inputDate.equalsIgnoreCase("q")) && (date == null)) {
            Matcher matcher = pattern.matcher(inputDate);
            if (matcher.matches()) {
                day = Integer.parseInt(matcher.group(1));
                month = Integer.parseInt(matcher.group(2));
                year = Integer.parseInt(matcher.group(3));
                hour = Integer.parseInt(matcher.group(4));
                minute = Integer.parseInt(matcher.group(5));
                try {
                    date = LocalDateTime.of(year, month, day, hour, minute);
                } catch (Exception e) {
                    vue.setError("La date n'est pas valide");
                    inputDate = getInput();
                }
            } else {
                inputDate = getInput();
            }
        }
        return date;
    }


    public OptionalInt saisirDuree() {
        OptionalInt optionalInt = OptionalInt.empty();
        Pattern pattern = Pattern.compile("[1-9]|[1-9][0-9][0-9]|[1-9][0-9]|[qQ]");
        String inputDuration;
        inputDuration = user.getInput();
        Matcher matcher = pattern.matcher(inputDuration);
        while (!inputDuration.equalsIgnoreCase("q") && !tryParseInt(inputDuration) && !matcher.matches()) {
            vue.consigneAjoutDuree();
            inputDuration = user.getInput();
            matcher = pattern.matcher(inputDuration);
        }
        if (!inputDuration.equalsIgnoreCase("q")) {
            optionalInt = OptionalInt.of(Integer.parseInt(inputDuration));
        }
        return optionalInt;
    }

    public boolean tryParseInt(String value) {
        boolean parse = false;
        try {
            Integer.parseInt(value);
            parse = true;
        } catch (NumberFormatException e) {

        }
        return parse;
    }

    /*
     * @param consigne du message à afficher
     * @return une string ou empty si on a quitter l'insertion
     */
    public String saisirName(String consigne) { // refactor du nom de la fonction
        String nameStage;
        vue.afficheMessage(consigne);
        nameStage = user.getInput();
        while (!nameStage.equalsIgnoreCase("q") && nameStage.isEmpty()) {
            vue.afficheMessage(consigne);
            nameStage = user.getInput();
        }
        if (nameStage.equalsIgnoreCase("q")) {
            nameStage = "";
        }
        return nameStage.trim();
    }

    public String saisirMail(String message) {
        String input;
        Pattern pattern = Pattern.compile(".*[@].*|[qQ]");
        vue.afficheMessage(message);
        input = user.getInput();
        Matcher matcher = pattern.matcher(input);
        while (!input.equalsIgnoreCase("q") && !matcher.matches()) {
            vue.afficheMessage(message);
            input = user.getInput();
            matcher = pattern.matcher(input);
        }
        if (input.equalsIgnoreCase("q")) {
            input = "";
        }
        return input.trim();
    }

    public boolean returnBoolTrueFalse(String message) {
        boolean bool = false;
        String input;
        do {
            vue.afficheMessage(message);
            input = user.getInput();
        } while (!input.equalsIgnoreCase("o") && !input.equalsIgnoreCase("n"));
        if (input.equalsIgnoreCase("o")) {
            bool = true;
        }
        return bool;
    }

    public void choiceTarifToAdd(TarifList tarifList, Stage stage) {
        List<Tarif> listTarifGen = tarifList.getTarifList();
        boolean addTarif = false;
        String inputChoice;
        int choiceTarif;
        addTarif = returnBoolTrueFalse("Ajouter un tarif ? O/N");
        while (addTarif) {
            vue.afficheMessage("Veuillez choisir un tarif à ajouté à votre stage.");
            vue.afficheListTarifGen(listTarifGen);
            inputChoice = saisirName("Insérer le numéro du tarif à ajouter. \"Q\" pour quitter.");
            if (!inputChoice.isEmpty()) {
                try {
                    choiceTarif = Integer.parseInt(inputChoice);
                    if (choiceTarif >= 1 && choiceTarif <= listTarifGen.size()) {
                        System.out.println(stage.addTarif(listTarifGen.get(choiceTarif - 1)));
                    } else {
                        vue.afficheMessage("Le numéro que vous avez rentré n'est pas dans la liste des tarifs.");
                    }
                } catch (NumberFormatException e) {
                    vue.afficheMessage("Vous n'avez pas insérer un nombre.");
                }
            }
            addTarif = returnBoolTrueFalse("Ajouter un tarif ? O/N");
        }
    }

    public Tarif choiceOneTarifFromStage(Stage stage) {
        List<Tarif> tarifListStage = stage.getTarifAppliquable();
        Tarif tarifChoice = new TarifBase();
        String inputChoice;
        int choiceTarif;
        vue.afficheMessage("Veuillez choisir un tarif à ajouté à votre stage.");
        vue.afficheListTarifGen(tarifListStage);
        inputChoice = saisirName("Insérer le numéro du tarif à ajouter. \"Q\" pour quitter.");
        if (!inputChoice.isEmpty()) {
            try {
                choiceTarif = Integer.getInteger(inputChoice);
                if (choiceTarif >= 1 && choiceTarif <= tarifListStage.size()) {
                    System.out.println(stage.addTarif(tarifListStage.get(choiceTarif - 1)));
                } else {
                    vue.afficheMessage("Le numéro que vous avez rentré n'est pas dans la liste des tarifs.");
                }
            } catch (NumberFormatException e) {
                vue.afficheMessage("Vous n'avez pas insérer un nombre.");
            }
        }
        return tarifChoice;
    }
    /*
    GET INPUT USER
     */

    private String getInput() {
        String inputDate;
        vue.consigneAjoutDateStage();
        inputDate = user.getInput();
        return inputDate;
    }

    /*
    SETTER
     */
    public void setUser(User user) {
        this.user = user;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }


}
