public class Edge<E> {

    private Vertex<E> from;
    private Vertex<E> to;

    public Edge(Vertex<E> from, Vertex<E> to) {
        this.from = from;
        this.to = to;
    }

    public Vertex<E> getFrom() {
        return from;
    }

    public Vertex<E> getTo() {
        return to;
    }

    public Vertex<E> from() {
        return this.from;
    }

    public Vertex<E> to() {
        return this.to;
    }
}
