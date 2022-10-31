package fi.utu.tech.ooj.exercise3.tehtava5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

// TODO: Toteuta tänne tehtävän 5 järjestykset ja lajitteludemo

public class Säähavainto {
    // oletetaan muodoksi YYYY/MM/DD HH:MM:SS
    // esim. keskiyö 1.1.2000 on muotoa 2000/01/01 00:00:00
    private String aika;
    private String paikka;
    private float lämpotila;
    private boolean sataako;
    private float pituusaste;
    private float leveysaste;

    public Säähavainto(int vuosi,
                       int kuukausi,
                       int päivä,
                       int tunti,
                       int minuutti,
                       int sekunti,
                       String paikka,
                       float pituusaste,
                       float leveysaste,
                       float lämpotila,
                       boolean sataako) {
        this(
                String.format("%04d/%02d/%02d %02d:%02d:%02d", vuosi, kuukausi, päivä, tunti, minuutti, sekunti),
                paikka,
                pituusaste,
                leveysaste,
                lämpotila,
                sataako
        );
    }

    private Säähavainto(String aika,
                       String paikka,
                       float pituusaste,
                       float leveysaste,
                       float lämpotila,
                       boolean sataako) {
        this.aika = aika;
        this.paikka = paikka;
        this.pituusaste = pituusaste;
        this.leveysaste = leveysaste;
        this.lämpotila = lämpotila;
        this.sataako = sataako;
    }

    @Override
    public String toString() {
        return String.format(
                "Havainto %s (%.2f°N, %.2f°E) @ %s, lämpö %.2f°C, %s",
                paikka,
                pituusaste,
                leveysaste,
                aika,
                lämpotila,
                sataako ? "sataa" : "ei sada"
        );
    }

    private enum Kunta {
        Oulu,
        Turku,
        Tampere,
        Kuhmo
    }

    public static Säähavainto keksi() {
        var päivä = new Random().nextInt(28) + 1;
        var kuukausi = new Random().nextInt(12) + 1;
        var vuosi = new Random().nextInt(100) + 1922;
        var tunti = new Random().nextInt(24);
        var minuutti = new Random().nextInt(60);
        var sekunti = new Random().nextInt(60);

        return new Säähavainto(
                vuosi, kuukausi, päivä, tunti, minuutti, sekunti,
                Kunta.values()[new Random().nextInt(4)].name(),
                new Random().nextFloat() * 360 - 180,
                new Random().nextFloat() * 360 - 180,
                new Random().nextFloat() * 80 - 40,
                new Random().nextBoolean()
        );
    }
    // Että saamme arvoja vertailtavaksi.
    public String getAika() {
        return this.aika;
    }
    public float getPituusaste() {
        return pituusaste;
    }
    public float getLeveysaste() {
        return leveysaste;
    }

    // Toimii nyt sivuvaikuttaen, voidaan luoda myös uusi lista ja kopoida.
    // Tarkoituksena oli kuitenkin järjestää lista, joka parametriksi annetaan.
    // Järjestää listan aikaleiman mukaan nousevaksi.
    public static ArrayList<Säähavainto> Luonnollinen(ArrayList<Säähavainto> shl) {
        Collections.sort(shl, new Comparator<Säähavainto>() {
            @Override
            public int compare(Säähavainto o1, Säähavainto o2) {
                return o1.getAika().compareTo(o2.getAika());
            }
        });
        Collections.sort(shl, Comparator.comparing(Säähavainto::getAika));
        return shl;
    }

    // Toimii nyt sivuvaikuttaen, voidaan luoda myös uusi lista ja kopoida.
    // Tarkoituksena oli kuitenkin järjestää lista, joka parametriksi annetaan.
    // Järjestää listan pituusasteen mukaan nousevaksi.
    // Jos pituusasteet sattumalta samat, järjestetään leveysasteen mukaan nousevaksi.
    public static ArrayList<Säähavainto> PituusLeveys(ArrayList<Säähavainto> shl) {
        Collections.sort(shl, new Comparator<Säähavainto>() {
            @Override
            public int compare(Säähavainto o1, Säähavainto o2) {
                int returnable = 0;
                if((Float.compare(o1.getPituusaste(), o2.getPituusaste())) == 0) {
                    returnable = Float.compare(o1.getLeveysaste(), o2.getLeveysaste());
                } else {
                    returnable = Float.compare(o1.getPituusaste(), o2.getPituusaste());
                }
                return returnable;
            }
        });
        Collections.sort(shl, Comparator.comparing(Säähavainto::getPituusaste));
        return shl;
    }

}
