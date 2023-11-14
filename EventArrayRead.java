public class EventArrayRead extends EventObject{

    int index;
    public EventArrayRead(int thread, int object, int index) {
        super(thread, object);
        this.index = index;
    }
}
