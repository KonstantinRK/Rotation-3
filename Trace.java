import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Trace {

    PartialOrder<Event> trace;

    Trace(ArrayList<Event> trace){
        Set<Integer> threads = new TreeSet<>();
        for (Event e : trace) {
            threads.add(e.thread);
        }
        this.initialiseTrace(threads.size(), trace);

    }

    Trace(int threadCount, ArrayList<Event> trace) {
        this.initialiseTrace(threadCount, trace);
    }

    public void  initialiseTrace(int threadCount, ArrayList<Event> trace) {
        this.trace = new PartialOrder<Event>(threadCount);
        for (Event e : trace) {
            this.trace.addObject(e.thread, e);
        }
        this.trace.finaliseGraph();
    }

    public void computeInitialRelations() {

    }
}
