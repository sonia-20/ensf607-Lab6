
/**
 * @author Sonia Soleimani
 *@version 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteRecord {

	ObjectOutputStream objectOut = null;
	MusicRecord record = null;
	Scanner stdin = null;
	Scanner textFileIn = null;
	ArrayList<MusicRecord> a =new ArrayList<>();

	/**
	 * Creates an blank MusicRecord object
	 */
	public WriteRecord() {
		record = new MusicRecord();
	}
	
	public MusicRecord getNewRecord() {
		return new MusicRecord();
	}

	/**
	 * Initializes the data fields of a record object
	 * @param year - year that song was purchased
	 * @param songName - name of the song
	 * @param singerName - singer's name
	 * @param price - CD price
	 */
	public MusicRecord setRecord(int year, String songName, String singerName, double price) {
		MusicRecord record = getNewRecord(); 
		record.setSongName(songName);
		record.setSingerName(singerName);
		record.setYear(year);
		record.setPrice(price);
		return record;
	}
    
	/**
	 * Opens a file input stream, using the data field textFileIn
	 * @param textFileName name of text file to open
	 * @throws FileNotFoundException 
	 */
	public void openFileInputStream(String textFileName) throws FileNotFoundException {
     // TO BE COMPLETED BY THE STUDENTS
		
        File file = new File(textFileName);
        InputStream stream = new FileInputStream(file);
		textFileIn = new Scanner(stream);
        
        
	}
	/**
	 * Opens an ObjectOutputStream using objectOut data field
	 * @param objectFileName name of the object file to be created
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void openObjectOutputStream(String objectFileName) throws FileNotFoundException, IOException {
        
    // TO BE COMPLETED BY THE STUDENTS
		FileOutputStream c=new FileOutputStream(objectFileName);
		objectOut   = new ObjectOutputStream(c);
        
	}
	
	/**
	 * Reads records from given text file, fills the blank MusicRecord
	 * created by the constructor with the existing data in the text
	 * file and serializes each record object into a binary file
	 * @throws IOException 
	 */
	public void createObjectFile() throws IOException {

		while (textFileIn.hasNext()) 
		{
			int year = Integer.parseInt(textFileIn.nextLine());
			System.out.print(year + "  ");       //data read from text file
            
			String songName = textFileIn.nextLine();
			System.out.print(songName + "  ");  //data read from text file
            
			String singerName = textFileIn.nextLine();
			System.out.print(singerName + "  "); 
            
			double price = Double.parseDouble(textFileIn.nextLine());
			System.out.println(price + "  ");    // echo data read from text file
            
			
			
			record = setRecord(year, songName, singerName, price);
			textFileIn.nextLine();   // read the dashed lines and do nothing
			objectOut.writeObject(record);

            // THE REST OF THE CODE TO BE COMPLETED BY THE STUDENTS
		}			

		// YOUR CODE GOES HERE
		try {
			if (objectOut!= null)
				objectOut.close();
		}catch(IOException e) {
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}

	public static void main(String[] args) throws IOException {
        
		WriteRecord d = new WriteRecord();
        
		String textFileName = "someSongs.txt"; // name of a text file that contains
                                               
        
		String objectFileName = "mySongs.ser"; // name of the binary file to
                                               // serialize record objects
        
		d.openFileInputStream(textFileName);   // open the text file to read from
        
		d.openObjectOutputStream(objectFileName); // open the object file to
                                                  // write music records into it
        
		d.createObjectFile();   // read records from opened text file, and write
                                // them into the object file.
	}
}
