public class EventAcquire extends EventObject{

    public EventAcquire(int thread, int object) {
        super(thread, object);
    }
}
