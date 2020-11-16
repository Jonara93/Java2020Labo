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
                "1", "Ztage", "10.10.2020.08.00", "12.10.2020.16.00","o","1","o","3","o","5","n",
                "1", "Stage de Karaté -15", "02.12.2020.08.00", "10.10.2021.16.00","o","2","o","4","o","6","n",
                "1", "Ctage Multisport", "10.10.2020.08.00", "24.02.2021.16.00","o","1","o","2","o","3","o","5","o","6","n",
                "1", "Stage Java", "10.11.2020.08.00", "13.11.2020.16.00","o","1","o","2","o","5","n",
                "q"
        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

    private static User createActivity() {
        String[] inputTab = new String[]{
                "3",

                "Ztage",
                "2", "Angular", "10.10.2020.08.00", "60",
                "2", "Java base 1", "10.10.2020.08.00", "60",
                "2", "Communication", "11.10.2020.09.00", "85",
                "2", "Android 1", "11.10.2020.12.00", "125",
                "2", "Android 2", "12.10.2020.14.00", "115",
                "2", "Java base 2", "12.10.2020.11.45", "180",

                "q",
                "3",

                "Stage Java",
                "2", "Intro Prog 1", "11.11.2020.08.00", "180",
                "2", "Intro Prog 2", "12.11.2020.08.00", "220",
                "2", "Intro Prog 3", "13.11.2020.08.00", "115",
                "2", "Intro Prog 4", "13.11.2020.12.30", "85",

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
                "5", "Arabia", "Jonathan", "q", "q","2",
                "5", "Arabia", "Christophe", "q", "q","1",
                "5", "Arcka", "Pierre", "q", "q","3",
                "5", "Pompidou", "Georges", "q", "q","4",

                "q",

                //Stage Java

                "3",
                "Stage Java",
                "5", "Dybala", "Paulo", "q", "q","1",
                "5", "Pierre", "Jean", "q", "q","2",
                "5", "Ronaldo", "Cristiano", "q", "q","4",

                "q",

                //Ctage Multisport

                "3",
                "Ctage Multisport",
                "5", "Doe", "John", "q", "q","2",
                "5", "Osiris", "Rathus", "q", "q","3",
                "5", "Doe", "Jane", "q", "q","1",

                "q",
                "q"
        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }

    private static User insertParticipantIntoActivity() {
        String[] inputTab = new String[]{
                "3", "Ztage", "8", "Angular",

                "1", "Arabia", "Jonathan", "n", "o",
                "1", "Pierre", "Jean", "o", "n","3",
                "1", "Arabia", "Christophe", "n", "o",

                "q", "q",

                "3", "Stage Java", "8", "Intro Prog 3",

                "1", "Dybala", "Paulo", "n", "o",
                "1", "Pierre", "Jean", "n", "o",
                "1", "Ronaldo", "Cristiano", "n", "o",

                "q", "q", "q", "q"


        };
        return new ArrayUser(Arrays.asList(inputTab).iterator());
    }
}
