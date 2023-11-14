import java.util.ArrayList;
import java.util.List;

public class Thread {

    private int threadID;
    private Trace trace;
    private List<Event> thread;

    public Thread() {
        this.thread = new ArrayList<>();
    }

    public Thread(Trace trace) {
        this.trace = trace;
        this.thread = new ArrayList<>();
    }

    public Thread(ArrayList<Event> thread) {
        this.thread = thread;
    }


    public int size() {
        return this.thread.size();
    }

    public void addEvent(Event event) {

    }


    // Getters and Setters

    public int getThreadID() {
        return threadID;
    }

    public void setThreadID(int thread_id) {
        this.threadID = thread_id;
    }

    public Trace getTrace() {
        return trace;
    }

    public void setTrace(Trace trace) {
        this.trace = trace;
    }

    public List<Event> getThread() {
        return thread;
    }

    public void setThread(List<Event> thread) {
        this.thread = thread;
    }
}
