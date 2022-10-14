package fi.utu.tech.ooj.exercise3.tehtava4a;

import java.util.ArrayList;
import java.util.List;

public abstract class Eläin {
    static <X extends Z, Y extends Z, Z extends Eläin> List<Z> yhdistä(List<X> xs, List<Y> ys) {
        var tmp = new ArrayList<Z>();
        for (var x : xs) tmp.add(x);
        for (var y : ys) tmp.add(y);
        return tmp;
    }
}


