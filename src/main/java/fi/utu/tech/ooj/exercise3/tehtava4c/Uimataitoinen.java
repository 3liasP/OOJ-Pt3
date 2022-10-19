package fi.utu.tech.ooj.exercise3.tehtava4c;

public interface Uimataitoinen {
    default void ui(String kohde) {
        System.out.println(this + " ui paikkaan " + kohde);
    }
}
