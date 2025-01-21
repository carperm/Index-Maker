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
