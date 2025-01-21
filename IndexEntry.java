import java.util.*;

public class IndexEntry{
    private String word;
    private ArrayList<Integer> numList;

    public IndexEntry(String w){
        word = w.toUpperCase();
        numList = new ArrayList<Integer>();
    }

    public void addLineNumber(int num){
        
        if(!numList.contains((Integer)num)) {
            numList.add(num);
        }
    }

    public String getWord(){
        return word;
    }

    public String toString(){
        String out = word + " ";
        for(int i = 0; i < numList.size(); i++) {
            out += numList.get(i) + ", ";
            
        }
        
        return out.substring(0, out.length()-2) + "\n";
    }

/*public static void main(String[] args){
        IndexEntry entry = new IndexEntry("Hello");
        entry.add(10);
        entry.add(10);
        entry.add(15);
        System.out.println(entry);
    }*/
}
