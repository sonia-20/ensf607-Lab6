
/**
 * @author Sonia Soleimani
 *@version 
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    
    private void readObjectsFromFile(String name) throws ClassNotFoundException, IOException
    {
        MusicRecord record ;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
      
        
        try
        {
            while ( true )
            {   
                // TO BE COMPLETED BY THE STUDENTS
            	record = (MusicRecord) input.readObject();
            	// display record contents on the screen
            	System.out.printf( "%-10d%-12s%-12s%10.2f\n",record.getYear(),
            	record.getSongName(), record.getSingerName(),record.getPurchasePrice()  );
           
            }  
        }catch(EOFException e) {
        	System.out.println("End of file!");
        }
                // ADD NECESSARY catch CLAUSES HERE

    }           // END OF METHOD 
    
    
    public static void main(String [] args) throws ClassNotFoundException, IOException
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("mySongs.ser");
    }
}