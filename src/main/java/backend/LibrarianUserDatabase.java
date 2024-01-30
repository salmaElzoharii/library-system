package backend;

import constants.FileNames;

public class LibrarianUserDatabase extends Database {
	
public LibrarianUserDatabase(String filename) {
        super(FileNames.LIBRARIANS_FILENAME);
    }
   
    @Override
    public LibrarianUser createRecordFrom(String line) {
        String[] UserData = line.split(",");
        LibrarianUser person = new LibrarianUser(UserData[0], UserData[1], UserData[2], UserData[3], UserData[4]);
        return person;
    }
}