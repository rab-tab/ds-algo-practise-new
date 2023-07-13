package priorityQueue;

import java.util.Comparator;
import java.util.List;

public class Compare implements Comparator<List<Data>> {

    @Override
    public int compare(List<Data> o1, List<Data> o2) {
        if(o1.get(0).value >o1.get(0).value) return o1.get(0).value;
        else return o2.get(0).value;
    }
}
