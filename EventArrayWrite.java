public class EventArrayWrite extends EventObject{

    int index;
    public EventArrayWrite(int thread, int object, int index) {
        super(thread, object);
        this.index = index;
    }
}
