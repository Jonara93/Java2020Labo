package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.commun.ArrayUser;
import be.technifutur.java2020.gestionstage.commun.Factory;
import be.technifutur.java2020.gestionstage.commun.User;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory(); //mettre ou non le getUser si je veux automatique ou non
        Menu menu = factory.getMenu();
        factory = null;
        menu.displayMenu();
    }

    private static User createStage() {
        String[] inputTab = new String[]{
                "1",
                "Ztage",
                "10.10.2020.08.00",
                "12.10.2020.16.00",

                "1",
                "Stage de Karaté -15",
                "02.12.2020.08.00",
                "10.10.2021.16.00",

                "1",
                "Ctage Multisport",
                "10.10.2020.08.00",
                "24.02.2021.16.00",

                "1",
                "Stage Java",
                "10.11.2020.08.00",
                "13.11.2020.16.00",
                "q"
        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

    private static User createActivity() {
        String[] inputTab = new String[]{
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
                "1",
                "Java base 2",//activity
                "12.10.2020.11.45",
                "180",

                "q",
                "3",

                "Stage Java",
                "1",
                "Intro Prog 1",
                "11.11.2020.08.00",
                "180",
                "1",
                "Intro Prog 2",
                "12.11.2020.08.00",
                "220",
                "1",
                "Intro Prog 3",
                "13.11.2020.08.00",
                "115",
                "1",
                "Intro Prog 4",
                "13.11.2020.12.30",
                "85",

                "q",
                "q"


        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

    private static User createParticipant() {
        String[] inputTab = new String[]{
                //Ztage
                "3",
                "Ztage",

                "3", "Arabia", "Jonathan", "q", "q",
                "3", "Arabia", "Christophe", "q", "q",
                "3", "Arcka", "Pierre", "q", "q",
                "3", "Pompidou", "Georges", "q", "q",

                "q",

                //Stage Java

                "3",
                "Stage Java",

                "3", "Dybala", "Paulo", "q", "q",
                "3", "Pierre", "Jean", "q", "q",
                "3", "Ronaldo", "Cristiano", "q", "q",

                "q",

                //Ctage Multisport

                "3",
                "Ctage Multisport",

                "3",
                "Doe", "John", "q", "q",
                "3", "Osiris", "Rathus", "q", "q",
                "3", "Doe", "Jane", "q", "q",

                "q",
                "q"
        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

    private static User insertParticipantIntoActivity() {
        String[] inputTab = new String[]{
                "3", "Ztage", "6", "Angular",

                "1", "Arabia", "Jonathan", "n", "o",
                "1", "Pierre", "Jean", "o", "n",
                "1", "Arabia", "Christophe", "n", "o",

                "q", "q", "3", "Stage Java", "6", "Intro Prog 3",

                "1", "Dybala", "Paulo", "n", "o",
                "1", "Pierre", "Jean", "n", "o",
                "1", "Ronaldo", "Cristiano", "n", "o",

                "q", "q", "q", "q"


        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }
}
