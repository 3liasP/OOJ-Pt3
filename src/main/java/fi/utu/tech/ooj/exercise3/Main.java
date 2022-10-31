package fi.utu.tech.ooj.exercise3;

import java.util.ArrayList;
import fi.utu.tech.ooj.exercise3.tehtava2.Teht2Demo;
import fi.utu.tech.ooj.exercise3.tehtava4c.Teht4Demo;
import fi.utu.tech.ooj.exercise3.tehtava5.Säähavainto;

public class Main {
    public static void main(String[] args) {

        // TÄMÄ OSIO DEMONSTROI TEHTÄVÄÄ 2
        // Heittää poikkeuksen, kuten tehtävän vastauksessa selitetään.
        Teht2Demo.lukukokoelmaDemo(); // **Huom! Tämä rivi tulee kommentoida pois testataksesi muita demoja!**


        // TÄMÄ OSIO DEMONSTROI TEHTÄVÄÄ 4
        Teht4Demo.operaatio_5_1_55();


        // TÄMÄ OSIO DEMONSTROI TEHTÄVÄÄ 5
        Säähavainto sh = Säähavainto.keksi();
        System.out.println(sh.toString()); // omaa kokeilua
        System.out.println(sh.getAika()); // omaa kokeilua
        
        // Luodaan kymmenen säähavaintoa keksi() metodin avulla ja lisätään ne listaan
        ArrayList<Säähavainto> shl = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Säähavainto shListaan = Säähavainto.keksi();
            shl.add(shListaan);
        }
        // Tulostaan listoista tarvittava tieto ja muotoillaan tulostusta toimivuuden
        // tarkastamisen helpottamiseksi. Tulostetaan kymmenen säähavainnon lista
        // myös ilman muotoilua, jotta nähdään se kokonaisuudessaan.
        System.out.println("----------------------------------------------------------------");
        System.out.println("Ennen järjestämistä:");
        tulostaTarvittavat(shl);
        System.out.println("Lista ilman muotoilua:");
        System.out.println(shl); // tulostetaan lista ilman muotoilua
        System.out.println("----------------------------------------------------------------");
        System.out.println("Aikajärjestys:");
        Säähavainto.Luonnollinen(shl);
        tulostaTarvittavat(shl);
        System.out.println("Lista ilman muotoilua:");
        System.out.println(shl); // tulostetaan lista ilman muotoilua
        System.out.println("----------------------------------------------------------------");
        System.out.println("Pituus- ja leveysperusteinen järjestys:");
        Säähavainto.PituusLeveys(shl);
        tulostaTarvittavat(shl);
        System.out.println("Lista ilman muotoilua:");
        System.out.println(shl); // tulostetaan lista ilman muotoilua

    }
    // Metodi tulostuksen muotoiluun paremmin luettavaksi ja havainnoitavaksi,
    // että listat todella järjestyvät
    public static void tulostaTarvittavat(ArrayList<Säähavainto> shl){
        int j = 1;
        for (Säähavainto sh1 : shl) {
        System.out.println(j + ". Aika: " + sh1.getAika() + " Pituus: " + sh1.getPituusaste() +  " Leveys: " + sh1.getLeveysaste());
        j++;
        }
    }

}