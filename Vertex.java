public class Vertex<E> {

    private int index;
    private int chain;
    private E object;

    Vertex() {
        this.index = -1;
        this.chain = -1;
        this.object = null;
    }


    Vertex(int chain, E object) {
        this.index = -1;
        this.chain = chain;
        this.object = object;
    }

    Vertex(int index, int chain, E object) {
        this.index = index;
        this.chain = chain;
        this.object = object;
    }

    void setIndex(int index) {
        this.index = index;
    }

    int index(){
        return this.index;
    }

    int chain(){
        return this.chain;
    }

    E getObject(){
        return this.object;
    }

    public String toString() {
        return "(" + this.chain + ", " + this.index + ")  |" + this.object.toString();
    }
}
