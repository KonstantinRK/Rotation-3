import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PartialOrder<E> extends DAG<E> {

    private List<ArrayList<SuffixMinima>> trees;

    PartialOrder(int width) { super(width);}

    PartialOrder(int width, ArrayList<Vertex<E>> vertices) {
        super(width, vertices);
    }

    PartialOrder(int width, ArrayList<Vertex<E>> vertices, ArrayList<Edge<E>> edges) {
        super(width, vertices, edges);
        this.finaliseGraph();
    }

    SuffixMinima get_tree(int chain_from, int chain_to) {
        return this.trees.get(chain_from).get(chain_to);
    }


    public void finaliseGraph() {
        super.finaliseGraph();
        this.trees = new ArrayList<ArrayList<SuffixMinima>>();
        for (int i=0; i<this.width; i++) {
            this.trees.add(new ArrayList<SuffixMinima>(this.width));
            for (int j=0; j< this.width; j++) {
                this.trees.get(i).add(new SuffixMinima(this.out.get(i).get(j)));
            }
        }
    }

    int successor(int chain_from, int chain_to, int index) {
        return this.get_tree(chain_from, chain_to).getMin(index);
    }

    int predecessor(int chain_from, int chain_to, int index) {
        return this.get_tree(chain_from, chain_to).getArgMin(index);
    }

    void insert(int chain_from, int index_from, int chain_to, int index_to) {
        for (int chain_1=0; chain_1 < this.width; chain_1++) {
            for (int chain_2=0; chain_2 < this.width; chain_2++) {
                int index_1 = this.predecessor(chain_from, chain_1, index_from);
                int index_2 = this.successor(chain_to, chain_2, index_to);
                this.get_tree(chain_1, chain_2).update(index_1, index_2);
            }
        }
    }

    boolean query(int chain_from, int index_from, int chain_to, int index_to) {
        return this.successor(chain_from, chain_to, index_from) <= index_to;
    }

}
