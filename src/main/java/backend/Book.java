package backend;

public class Book implements Record {
	String bookId,title,authorName,publisherName;
    int Quantity;

    public Book(String ID, String title, String authorName, String publisherName, int Quantity) {
        this.bookId = ID;
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.Quantity = Quantity;
    }
    
    @Override
    public String lineRepresentation(){
    
    String data;
    data=bookId+","+title+","+authorName+","+publisherName+","+String.valueOf(Quantity);
            return data;
    }
    
    @Override
    public String getSearchKey(){
    return this.bookId;
    }  

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
    
    
    
}
