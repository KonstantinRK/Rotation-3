class Event {
    int thread;

    public Event(int thread) {
        this.thread = thread;
    }

    @Override
    public String toString() {
        return thread + " -> " + this.getClass().toString().split(" ")[1];
    }
}
