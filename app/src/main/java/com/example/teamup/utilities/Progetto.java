package com.example.teamup.utilities;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Progetto {
    private static final String TAG = Progetto.class.getSimpleName();

    private String id;
    private String titolo;
    private String descrizione;
    private List<String> etichette;
    private Leader leader;
    private List<Teammate> personale;
    private Map<String, Boolean> obiettivi;

    public Progetto(Leader leader, String titolo, String descrizione, List<String> etichette, List<String> goalsToAchieve) {
        Log.d(TAG, "Costruttore");

        //  genera id
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();

        this.leader = leader;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.etichette = etichette;
        this.obiettivi = new HashMap<>();

        for (String goal : goalsToAchieve) {
            this.obiettivi.put(goal, false);
        }
    }

    public void setTitolo(String title) {
        titolo = title;
    }

    public void setDescrizione(String description) {
        descrizione = description;
    }

    public void addEtichetta(String tag) {
        etichette.add(tag);
    }

    public void removeEtichetta(String tag) {
        List<String> result = new ArrayList<>();

        for (String oldTag : etichette) {
            if (!oldTag.equals(tag)) {
                result.add(oldTag);
            }
        }

        etichette = new ArrayList<>(result);
    }

    public void addTeammate(Teammate teammate) {
        personale.add(teammate);
    }

    public void removeTeammate(Teammate teammate) {
        List<Teammate> result = new ArrayList<>();

        for (Teammate oldTeammate : personale) {
            if (oldTeammate != teammate) {
                result.add(oldTeammate);
            }
        }

        personale = new ArrayList<>(result);
    }

    public void addObiettivoDaRaggiungere(String goal) {
        obiettivi.put(goal, false);
    }

    public void removeObiettivo(String goalToRemove) {
        obiettivi.remove(goalToRemove);
    }

    public void setObiettivoRaggiunto(String goalAchieved) {
        obiettivi.replace(goalAchieved, true);
    }

    public String getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public List<String> getEtichette() {
        return etichette;
    }

    public Leader getLeader() {
        return leader;
    }

    public List<Teammate> getPersonale() {
        return personale;
    }

    public Map<String, Boolean> getObiettivi() {
        return obiettivi;
    }
}