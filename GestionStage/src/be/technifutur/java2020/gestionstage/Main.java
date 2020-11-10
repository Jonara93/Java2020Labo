package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.ArrayUser;
import be.technifutur.java2020.gestionstage.commun.Factory;
import be.technifutur.java2020.gestionstage.commun.User;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory(/*getUser()*/); //mettre ou non le getUser si je veux automatique ou non
        Menu menu = factory.getMenu();
        factory = null;
        menu.displayMenu();
    }

    //TODO EXCEPTION QUAND STAGE DEJA EXISTANT

    private static User getUser() {
        String[] inputTab = new String[]{
                "2",
                "1",
                "Stage de Karaté -15",//stage
                "02.12.2020.08.00",
                "10.10.2021.16.00",
                "1",
                "Stage de Karaté -15",//stage
                "02.12.2020.08.00",
                "10.10.2021.16.00",
                "1",
                "Ctage Multisport",//stage
                "10.10.2020.08.00",
                "24.02.2021.16.00",
                "1",
                "Ztage",//stage
                "10.10.2020.08.00",
                "12.10.2020.16.00",
                "2",
                "3",
                "Ztage",
                "1",
                "Angular",//activity
                "10.10.2020.08.00",
                "60",
                "1",
                "Java base 1",//activity
                "10.10.2020.08.00",
                "60",
                "1",
                "Communication",//activity
                "11.10.2020.09.00",
                "85",
                "1",
                "Android 1",//activity
                "11.10.2020.12.00",
                "125",
                "1",
                "Android 2",//activity
                "12.10.2020.14.00",
                "115",
                "q",
                "3",
                "Ztage",
                "1",
                "Java base 2",//activity
                "12.10.2020.11.45",
                "180",
                "2",//affiche stage
                "3",//gerer participant
                "Jonathan",
                "Arabia",
                "Verlaine",
                "jojo@hotmail.be",
                "3",
                "Pierre",
                "Arcka",
                "q",
                "Arcka.Pierre@hotmail.be",
                "3",
                "Jonathan",
                "Arabia",
                "N",
                "q",
                "q",
                "4",
                "q"
        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

}
