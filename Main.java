import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Event> events1 = new ArrayList<Event>();
        events1.add(new EventAcquire(0,0));
        events1.add(new EventWrite(0,0));
        events1.add(new EventWrite(0,1));
        events1.add(new EventRelease(0,0));
        events1.add(new EventAcquire(1,0));
        events1.add(new EventAcquire(1,1));
        events1.add(new EventWrite(1,2));
        events1.add(new EventRelease(1,1));
        events1.add(new EventWrite(1,1));
        events1.add(new EventRelease(1,0));
        events1.add(new EventAcquire(2,1));
        events1.add(new EventRead(2,2));
        events1.add(new EventRelease(2,1));
        events1.add(new EventWrite(2,0));
        events1.add(new EventWrite(2,0));

        Trace trace = new Trace(3,events1);
        trace.trace.addEdge(0,3,1,0);
        trace.trace.addEdge(1,3,2,0);
        for (ArrayList<Vertex<Event>> tr : trace.trace.vertices) {
            for (Vertex<Event> v : tr) {
                System.out.println(v);
            }
        }
//        for (Integer v : trace.trace.get_out(0,1)){
//            System.out.println(v);
//        }
//
//        for (Integer v : trace.trace.get_out(1,2)){
//            System.out.println(v);
//        }
        System.out.println(trace.trace.successor(0,1,0));
        System.out.println(trace.trace.successor(0,1,1));
        System.out.println(trace.trace.successor(0,1,2));
        System.out.println(trace.trace.successor(0,1,3));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.successor(0,2,0));
        System.out.println(trace.trace.successor(0,2,1));
        System.out.println(trace.trace.successor(0,2,2));
        System.out.println(trace.trace.successor(0,2,3));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.successor(1,0,0));
        System.out.println(trace.trace.successor(1,0,1));
        System.out.println(trace.trace.successor(1,0,2));
        System.out.println(trace.trace.successor(1,0,3));
        System.out.println(trace.trace.successor(1,0,4));
        System.out.println(trace.trace.successor(1,0,5));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.successor(1,2,0));
        System.out.println(trace.trace.successor(1,2,1));
        System.out.println(trace.trace.successor(1,2,2));
        System.out.println(trace.trace.successor(1,2,3));
        System.out.println(trace.trace.successor(1,2,4));
        System.out.println(trace.trace.successor(1,2,5));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.successor(2,0,0));
        System.out.println(trace.trace.successor(2,0,1));
        System.out.println(trace.trace.successor(2,0,2));
        System.out.println(trace.trace.successor(2,0,3));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.successor(2,1,0));
        System.out.println(trace.trace.successor(2,1,1));
        System.out.println(trace.trace.successor(2,1,2));
        System.out.println(trace.trace.successor(2,1,3));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(0,1,0));
        System.out.println(trace.trace.predecessor(0,1,1));
        System.out.println(trace.trace.predecessor(0,1,2));
        System.out.println(trace.trace.predecessor(0,1,3));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(0,2,0));
        System.out.println(trace.trace.predecessor(0,2,1));
        System.out.println(trace.trace.predecessor(0,2,2));
        System.out.println(trace.trace.predecessor(0,2,3));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(1,0,0));
        System.out.println(trace.trace.predecessor(1,0,1));
        System.out.println(trace.trace.predecessor(1,0,2));
        System.out.println(trace.trace.predecessor(1,0,3));
        System.out.println(trace.trace.predecessor(1,0,4));
        System.out.println(trace.trace.predecessor(1,0,5));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(1,2,0));
        System.out.println(trace.trace.predecessor(1,2,1));
        System.out.println(trace.trace.predecessor(1,2,2));
        System.out.println(trace.trace.predecessor(1,2,3));
        System.out.println(trace.trace.predecessor(1,2,4));
        System.out.println(trace.trace.predecessor(1,2,5));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(2,0,0));
        System.out.println(trace.trace.predecessor(2,0,1));
        System.out.println(trace.trace.predecessor(2,0,2));
        System.out.println(trace.trace.predecessor(2,0,3));

        System.out.println("-------------------------------------------------------");

        System.out.println(trace.trace.predecessor(2,1,0));
        System.out.println(trace.trace.predecessor(2,1,1));
        System.out.println(trace.trace.predecessor(2,1,2));
        System.out.println(trace.trace.predecessor(2,1,3));

        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
        System.out.println("-------------------------------------------------------");
    }
}
