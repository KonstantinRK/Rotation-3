import java.util.ArrayList;

public class TSOTrace extends Trace{


    TSOTrace(ArrayList<Event> trace) {
        super(trace);
    }

    TSOTrace(int threadCount, ArrayList<Event> trace) {
        super(threadCount, trace);
    }

    public void  initialiseTrace(int threadCount, ArrayList<Event> trace) {
        this.trace = new PartialOrder<Event>(threadCount);
        for (Event e : trace) {
            this.trace.addObject(e.thread, e);
        }
    }
}
