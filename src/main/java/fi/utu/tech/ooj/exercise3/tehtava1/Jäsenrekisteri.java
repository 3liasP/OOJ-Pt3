package fi.utu.tech.ooj.exercise3.tehtava1;

import java.util.ArrayList;

public class Jäsenrekisteri {
    private String nimi;  // jäsenrekisterin nimi
    private ArrayList<Jäsen> jäsenet; // equals-metodin suorituskyvyn kannalta ei paras mahdollinen tietorakenne

    public Jäsenrekisteri(String nimi) {
        this.nimi = nimi;
        jäsenet = new ArrayList<>();
    }

    public boolean lisääJäsen(Jäsen j) {
        if (jäsenet.contains(j)) return false;
        jäsenet.add(j);
        return true;
    }

    public boolean poistaJäsen(Jäsen j) {
        if (jäsenet.contains(j)) return false;
        jäsenet.remove(j);
        return true;
    }
}

class Jäsen {
    private String nimi;
    private String hetu;

    public Jäsen(String nimi, String hetu) {
        this.nimi = nimi;
        this.hetu = hetu;
    }

    public String annaNimi() {
        return nimi;
    }

    public void asetaNimi(String nimi) {
        this.nimi = nimi;
    }

    public String annaHetu() {
        return hetu;
    }

    public void asetaHetu(String hetu) {
        this.hetu = hetu;
    }
}