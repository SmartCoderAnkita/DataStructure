package DataStructureDemo;

import java.util.Map;
import java.util.TreeMap;

public class Test1 {
      
    public static int[] computeTimes(int n, LogEntry[] entries) {
        // implement your solution here
       
        Map<Integer,Integer> mapID = new TreeMap<>();
        int time = 0;
        for(LogEntry log : entries){
            
        	if(mapID.containsKey(log.getMethodId())) {
        		int val = log.getTimeStamp() -mapID.get(log.getMethodId())-time;
               time = val;
                mapID.put(log.getMethodId(),val);
        	}else{
                //time = log.getTimeStamp();
        		 mapID.put(log.getMethodId(),log.getTimeStamp());
            }
        }
        int[] res = new int[mapID.size()];
        int i=0;
       for(Map.Entry<Integer, Integer> v : mapID.entrySet()){
        	res[i]=v.getValue();
        	i++;
        };
        return res;      
    }
    
    // object for log entry, parsed from the log string format
    // access as obj.methodId, obj.action, obj.timestamp
    static class LogEntry {
        int methodId;
        String action;    // EXIT/ENTER
        int timestamp;
        
        LogEntry(int methodId, String action, int timestamp) {
            this.methodId = methodId;
            this.action = action;
            this.timestamp = timestamp;
        }
        
        public int getMethodId() {
            return this.methodId;
        }
        
        public int getTimeStamp() {
            return this.timestamp;
        }
        
        public String getAction() {
            return this.action;
        }
    }

    // boilerplate code to parse log entries
    public static int[] solution(long n, String[] logs) {
        LogEntry[] entries = new LogEntry[logs.length];
        for (int i = 0; i < logs.length; i++) {
            String[] tokens = logs[i].split(",");
            int methodId = Integer.valueOf(tokens[0].trim());
            int timestamp = Integer.valueOf(tokens[2].trim());
            
            entries[i] = new LogEntry(methodId, tokens[1].trim(), timestamp);
        }
        return computeTimes((int) n, entries);
    }
}

