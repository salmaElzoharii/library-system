package backend;

import java.io.IOException;
import java.util.ArrayList;

import constants.FileNames;

public class AdminRole {
	private LibrarianUserDatabase database;

    public AdminRole() throws IOException {
    	database=new LibrarianUserDatabase(FileNames.LIBRARIANS_FILENAME);
        this.database.readFromFile();
        
    }

   
   public void addLibrarian(String librarianid, String Name, String Email, String Address, String Phonenumber){
       LibrarianUser L=new LibrarianUser(librarianid,Name,Email,Address,Phonenumber);
       database.insertRecord(L);
 
   }
   
  
    public LibrarianUser[] getListOfLibrarians() {
    	  LibrarianUser [] arrayusers = new LibrarianUser[database.records.size()];
          return database.records.toArray(arrayusers);
    }
    
    public void removeLibrarian(String key) throws IOException{
        if(database.contains(key))
            database.deleteRecord(key);
        else System.out.println("This user doesn't exist");

    
    }
    
    public void logout() throws IOException{
    
    database.saveToFile();
    
    }
    
    
}

