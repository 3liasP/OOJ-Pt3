package fi.utu.tech.ooj.exercise3.tehtava5;

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

    public Säähavainto(String aika,
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
                "Havainto %s (%.2f°N, %.2f°E) @ %s: lämpö %.2f°C, %s",
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

        return new Säähavainto(
                String.format("%04d/%02d/%02d", vuosi, kuukausi, päivä),
                Kunta.values()[new Random().nextInt(4)].name(),
                new Random().nextFloat() * 360 - 180,
                new Random().nextFloat() * 360 - 180,
                new Random().nextFloat() * 80 - 40,
                new Random().nextBoolean()
        );
    }
}
