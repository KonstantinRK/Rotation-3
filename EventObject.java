public class EventObject extends Event{

    int object;

    public EventObject(int thread, int object) {
        super(thread);
        this.object = object;
    }

    @Override
    public String toString() {
        return thread + " -> " + this.getClass().toString().split(" ")[1] + "(" + this.object + ")";
    }

}
