import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAG<E> {

    protected List<ArrayList<Vertex<E>>>  vertices;
    protected List<ArrayList<ArrayList<Integer>>> out;
    protected boolean initialised = false;
    protected int width;

    DAG(int width) {
        this.width = width;
        this.vertices = new ArrayList<ArrayList<Vertex<E>>>(width);
        System.out.println(vertices.size());
        System.out.println(width);
        for (int i=0; i< width; i++) {
            this.vertices.add(new ArrayList<Vertex<E>>());
        }
    }

    DAG(int width, ArrayList<Vertex<E>> vertices){
        this.width = width;
        this.vertices = new ArrayList<ArrayList<Vertex<E>>>(width);
        for (int i=0; i< width; i++) {
            this.vertices.add(new ArrayList<Vertex<E>>());
        }
        for (Vertex<E> v : vertices) {
            this.addVertex(v);
        }
        this.initialiseOut();
        this.initialised = true;
    }

    protected void initialiseOut() {
        this.out = new ArrayList<ArrayList<ArrayList<Integer>>>(width);
        for (int i=0; i<width; i++) {
            this.out.add(new ArrayList<ArrayList<Integer>>(width));
            for (int j=0; j< width; j++) {
                this.out.get(i).add(new ArrayList<Integer>(this.getChainLength(i)));
                for (int k=0; k < this.getChainLength(i); k++) {
                    this.out.get(i).get(j).add(-1);
                }
            }
        }
    }

    public void finaliseGraph() {
        this.initialiseOut();
    }

    DAG(int width, ArrayList<Vertex<E>> vertices, ArrayList<Edge<E>> edges) {
        this(width, vertices);
        for (Edge<E> edge : edges) {
            this.addEdge(edge);
        }
    }

    public int getWidth() {
        return width;
    }

    void addVertex(int chain, E object) {
        Vertex<E> vertex = new Vertex<>(this.getChainLength(chain), chain, object);
        this.addVertex(vertex);
    }

    void addVertex(Vertex<E> vertex) {
        if (vertex.index() == -1) {
            vertex.setIndex(this.getChainLength(vertex.chain()));
        }
        this.vertices.get(vertex.chain()).add(vertex);
    }

    void addObject(int chain, E object) {
        Vertex<E> vertex = new Vertex<E>(chain, object);
        if (vertex.index() == -1) {
            vertex.setIndex(this.getChainLength(vertex.chain()));
        }
        this.vertices.get(vertex.chain()).add(vertex);
    }

    void addEdge(Edge<E> edge) {
        this.addEdge(edge.from(), edge.to());
    }

    void addEdge(Vertex<E> from, Vertex<E> to) {
       this. addEdge(from.chain(), from.index(), to.chain(), to.index());
    }

    void addEdge(int chain_from, int index_from, int chain_to, int index_to) {
       this.get_out(chain_from, chain_to).set(index_from, index_to);
    }

    ArrayList<Integer> get_out(int chain_from, int chain_to) {
        return this.out.get(chain_from).get(chain_to);
    }


    Vertex<E> getVertex(int chain, int index) {
        if (index==-1 || chain == -1) {
            return new Vertex<E>();
        }
        return this.vertices.get(chain).get(index);
    }

    int getChainLength(int chain){
        return this.vertices.get(chain).size();
    }

    Vertex<E> successor(Vertex<E> vertex, int chain) {
        int index = this.successor(vertex.chain(), vertex.index(), chain);
        return this.getVertex(chain, index);
    }

    int successor(int chain_from, int chain_to, int index) {
        return -1;
    }

    Vertex<E> predecessor(Vertex<E> vertex, int chain) {
        int index = this.predecessor(vertex.chain(), vertex.index(), chain);
        return this.getVertex(chain, index);
    }

    int predecessor(int chain_from, int chain_to, int index) {
        return -1;
    }

    void insert(Vertex<E> from, Vertex<E> to) {
        this.insert(from.chain(), from.index(), to.chain(), to.index());
    }

    void insert(int chain_from, int index_from, int chain_to, int index_to) {

    }

    boolean query(Vertex<E> from, Vertex<E> to) {
        return this.query(from.chain(), from.index(), to.chain(), to.index());
    }

    boolean query(int chain_from, int index_from, int chain_to, int index_to) {
        return false;
    }

    public List<ArrayList<Vertex<E>>> getVertices() {
        return vertices;
    }

    public List<ArrayList<ArrayList<Integer>>> getOut() {
        return out;
    }
}
