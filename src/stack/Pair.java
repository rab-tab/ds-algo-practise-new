package stack;

public class Pair implements Comparable<Pair>{

    int startTime;
    int endTime;

    public Pair(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public int compareTo(Pair o) {
        if(this.startTime!=o.startTime) return this.startTime-o.startTime;
        else return this.endTime-o.endTime;
    }
}
