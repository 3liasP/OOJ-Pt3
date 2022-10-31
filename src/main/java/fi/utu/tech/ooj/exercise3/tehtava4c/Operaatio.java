package fi.utu.tech.ooj.exercise3.tehtava4c;

/*
 * Geneerisyys ilmenee rajapinnassa geneerisen tyyppiparametrin E kautta. Tällä tavoin
 * rajapintaa voivat hyödyntää kaikki ne tyypit, jotka ovat tyypin Eläin alityyppejä ja
 * jotka toteuttavat rajapinnat Uimataitoinen ja Lentävä.
 */

public interface Operaatio<E extends Eläin & Uimataitoinen & Lentävä>{
    
    default void uita(E eläin, int määrä){
        if(eläin instanceof Uimataitoinen){
            for(int i = 0; i < määrä; i++){
                eläin.ui("Turku");
            }
        } else {
            System.out.println(eläin.toString() + " ei ole uimataitoinen.");
        }
    }

    default void lennätä(E eläin, int määrä){
        if(eläin instanceof Lentävä){
            for(int i = 0; i < määrä; i++){
                eläin.lennä("Turku");
            }
        } else {
            System.out.println(eläin.toString() + " ei osaa lentää.");
        }
    }

    default void uitaJaLennätä(E eläin, int määrä1, int määrä2){
        if(eläin instanceof Uimataitoinen && eläin instanceof Lentävä){
            uita(eläin, määrä1);
            lennätä(eläin, määrä2);
        }
    }
}

class Eläinkoe{

    public void operaatio_5_1_55(){
        Liitokala lk = new Liitokala();
        Vesisiippa vs = new Vesisiippa();
        lk.uitaJaLennätä(lk, 5, 5);
        vs.uitaJaLennätä(vs, 5, 5);
    }

}