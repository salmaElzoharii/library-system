package backend;

import java.time.LocalDate;

import constants.FileNames;

public class StudentBookDatabase extends Database {

    public StudentBookDatabase(String filename) {
        super(FileNames.STUDENTSBOOKS_FILENAME);
    }

    @Override
    public StudentBook createRecordFrom(String line) {
    	 String[] UserData = line.split(",");
         StudentBook b1 = new StudentBook(UserData[0],UserData[1],LocalDate.parse(UserData[2]));
         return b1;
    }

}
