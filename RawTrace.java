import java.io.*;
import java.util.*;

public class RawTrace {

    ArrayList<Event> rawTrace;
    HashMap<String, Integer> threadMap;
    HashMap<String, Integer> objectMap;

    RawTrace() {
        this.rawTrace = new ArrayList<Event>();
        this.threadMap = new HashMap<String, Integer>();
        this.objectMap = new HashMap<String, Integer>();
    }

    public void loadRoadRunner(String path) {
        try
        {
            File file=new File(path);    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {   Event event = this.parseRR(line.toString());
                if (this.filter(event)){
                    this.rawTrace.add(event);
                }
            }
            fr.close();    //closes the stream and release the resources
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public Event parseRR(String entry) {
        String entryStr = entry.strip();
        if (entryStr.isEmpty() || entryStr.charAt(0) != '@') {
            return null;
        }
        entryStr = entryStr.replace("@", "").strip();
//        if (entryStr.charAt(0)=='1') {
//            System.out.println(entryStr);
//        }
        String eventStr = entryStr.split("\\|\\|")[0];
        String threadStr = eventStr.split("\\|")[0];
        String eventTypeStr = eventStr.split("\\|")[1];
        String infoStr;
        if (entryStr.split("\\|\\|").length>1) {
            infoStr = entryStr.split("\\|\\|")[1];
        } else {
            infoStr = "";
        }


        return switch (eventTypeStr) {
            case "W", "aW", "vW" -> new EventWrite(this.getThreadId(threadStr), this.getObjectId(infoStr));
            case "R", "aR", "vR" -> new EventRead(this.getThreadId(threadStr), this.getObjectId(infoStr));
            case "lR", "tlR" -> new EventRelease(this.getThreadId(threadStr), this.getObjectId(infoStr));
            case "lA", "tlA" -> new EventAcquire(this.getThreadId(threadStr), this.getObjectId(infoStr));
//            case "tS", "ptS" -> new EventThreadStart(this.getThreadId(threadStr), this.getThreadId(infoStr.split("|")[0]));
//            case "tJ" -> new EventThreadJoin(this.getThreadId(threadStr), this.getObjectId(infoStr));
//            case "tF" -> new EventThreadFinish(this.getThreadId(threadStr), this.getObjectId(infoStr));
//            case "aW" -> new EventArrayWrite(this.getThreadId(threadStr), this.getObjectId(infoStr.split("|")[0]),
//                    Integer.parseInt(infoStr.split("|")[1]));
//            case "aR" -> new EventArrayRead(this.getThreadId(threadStr), this.getObjectId(infoStr.split("|")[0]),
//                    Integer.parseInt(infoStr.split("|")[1]));
            default -> null;
        };
    }

    public int getThreadId(String threadStr){
        if (!this.threadMap.containsKey(threadStr)) {
            this.threadMap.put(threadStr, this.threadMap.size());
        }
        return this.threadMap.get(threadStr);
    }

    public int getObjectId(String objectStr) {
        if (!this.objectMap.containsKey(objectStr)) {
            this.objectMap.put(objectStr, this.objectMap.size());
        }
        return this.objectMap.get(objectStr);
    }

//        switch(expression) {
//            case x:
//                // code block
//                break;
//            case y:
//                // code block
//                break;
//            default:
//                // code block
//        if this.filter()
//    }

    public boolean filter(Event event){
        if (event == null) {
            return false;
        }
        return true;
    }

    public void filterTrace() {
        HashMap<Integer, Set<Integer>> threadCheck = new HashMap<Integer, Set<Integer>>();
        for (Event e : this.rawTrace) {
            if (e instanceof EventObject) {
                int objId = ((EventObject) e).object;
                if (!threadCheck.containsKey(objId)) {
                    threadCheck.put(objId, new TreeSet<Integer>());
                }
                threadCheck.get(objId).add(e.thread);
            }
        }
        ArrayList<Integer> blackList = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Set<Integer>> entry : threadCheck.entrySet()) {
            if (entry.getValue().size() < 2) {
                blackList.add(entry.getKey());
            }
        }
        System.out.println(this.rawTrace.size());
        Iterator<Event> iter = this.rawTrace.iterator();
        while (iter.hasNext()) {
            Event e = iter.next();
            if (e instanceof EventObject) {
                int objId = ((EventObject) e).object;
                if (blackList.contains(objId)){
                    iter.remove();
                }
            }
        }
        System.out.println(this.rawTrace.size());
    }

}
