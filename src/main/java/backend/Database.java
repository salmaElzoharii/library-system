package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database {
    protected ArrayList<Record> records=new ArrayList<>();
    protected String filename;

    public Database(String filename) {
        this.filename = filename;

    }

    public void readFromFile() {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                records.add(createRecordFrom(line));
            }
            sc.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }

    }

    public abstract Record createRecordFrom(String line);

    public ArrayList<Record> returnAllRecords() {
        return this.records;

    }

    public boolean contains(String key) {
        for (int i=0; i<records.size();i++) {
            if ( records.get(i).getSearchKey().equals(key))
                return true;
        }
        return false;
    }

    public Record getRecord(String key) {
        for (Record record : records) {
            if (record.getSearchKey().equals(key))
                return record;
        }
        return null;
    }


    public void insertRecord(Record record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (int i=0; i< records.size();i++)
        {
            if (records.get(i).getSearchKey().equals(key))
                records.remove(i);
        }
    }

    public void saveToFile() {
        try {
            File file = new File(filename);
            FileWriter filewriter = new FileWriter(file, false);
            for (Record record : records){
                filewriter.write(record.lineRepresentation());
            filewriter.write("\n");
        }
                filewriter.close();
            }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
