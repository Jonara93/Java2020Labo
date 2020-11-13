package be.technifutur.java2020.gestionstage.commun.prix;

import be.technifutur.java2020.gestionstage.commun.activity.Activity;

import java.util.Collection;

public interface Tarif {
    public String getName();
    public int calculTarif(Collection<Activity> activityCollection);
}
