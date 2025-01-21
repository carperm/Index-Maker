import java.util.ArrayList;

public class DocumentIndex extends ArrayList<IndexEntry> {
    //  Creates an empty DocumentIndex with the default initial capacity.
    public DocumentIndex() {
        super();
    }

    //  Creates an empty DocumentIndex with a given  initial capacity.
    public DocumentIndex(int initialCapacity) {
        super(initialCapacity);
    }

    public void addWord(String word, int num){
        (this.get(this.foundOrInserted(word))).addLineNumber(num);
    }

    public void addAllWords(String str, int num) {
  String[] words = str.split("\\W+");
  for(String s : words) {
   if(!s.equals("")) {
    addWord(s, num);
   }
  }
 }
    
    
    /*public void addAllWords(String line, int lineNumber) {
        String[] working = line.split("\\W+");
        for(int i = 0; i < working.length; i++) {
            if(!(working[i].equals(""))) {
                this.addWord(working[i], lineNumber);
            }
        }
    }*/
    
    /*private int foundOrInserted(String word) {
        int i = 0;
        while((this.get(i).getWord()).compareToIgnoreCase(word) <= 0 && i < this.size()) {
            if(((this.get(i)).getWord()).compareToIgnoreCase(word) == 0) {
                return i;
            }
            i++;
        }
        this.add(i, new IndexEntry(word));
        return i;
    }*/
    
    private int foundOrInserted(String word) {
        for(int i = 0; i < this.size(); i++) {
        String entryWord = this.get(i).getWord().toUpperCase();
        if(word.toUpperCase().equals(entryWord)) {
            return i;
        } else if(word.toUpperCase().compareTo(entryWord) < 0) {
            IndexEntry ie = new IndexEntry(word);
            this.add(i, ie);
            
            return i;
        }
    }

    IndexEntry ie = new IndexEntry(word);
    this.add(ie);
    
    return this.size() - 1;
    }


    public static void main(String[] args){
        DocumentIndex doc = new DocumentIndex();
        doc.addAllWords("Good morning students", 1);
        doc.addAllWords("Boy, it's a fine morning", 2);
        System.out.println(doc);
    }
}
