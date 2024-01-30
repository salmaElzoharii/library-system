package backend;

import constants.FileNames;

public class BookDatabase extends Database {
	 public BookDatabase(String filename) {
	        super(FileNames.BOOKS_FILENAME);
	    }

	    @Override
	    public Book createRecordFrom(String line) {
	        String[] UserData = line.split(",");
	        Book b=new Book(UserData[0], UserData[1], UserData[2], UserData[3], Integer.parseInt(UserData[4]));
	        return b;
	    }
}