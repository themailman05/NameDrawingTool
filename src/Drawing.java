import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/****************************************************************************
 * 
 * Drawing controller and file IO class for Random Drawing Simulator.
 * 
 * Liam Sargent
 * v3
 * 1/20/2015
 * 
 * @github themailman05
 ****************************************************************************/
public class Drawing
{
    private static String[] drawingNames;
    private static Random random;
    private Scanner names;
    
    
    /*************************************************************************
     * Default Constructor for new Drawing object
     * @param fileName
     */
    public Drawing(String fileName)
    {
        random = new Random();
        drawingNames = chopNames(fileName);
    }
    
    
    /*************************************************************************
     * 
     * This is the Java equivalent of chopping up a sheet with names scrawled
     * all over it and placing the scraps in a fishbowl. Except the namescraps
     * are Strings and the fishbowl is a String array. Magical.
     * 
     * @param inFileName - The name of the input file
     * @return String[] of names extracted from CSV
     */
    private String[] chopNames(String inFileName)
    {
        ArrayList<String> nameArrayList = new ArrayList<String>();
        File inFile = new File(inFileName);
        String[] outString;
        
        try
        {
            names = new Scanner(inFile);
        }
        catch ( FileNotFoundException e )
        {
            System.out.println("File Not Found");
            e.printStackTrace();
            
        }
        
        while (names.hasNext())
            nameArrayList.add( names.nextLine());
        
        outString = new String[nameArrayList.size()];
        nameArrayList.toArray( outString );
        
        return outString;
        
        
    }
    
    /*********************************************************************
     * Returns the URI of the csv file to be used
     * @return URI of CSV
     */
    public static String getFileURL()
    {
                
        final ProtectionDomain domain;
        final CodeSource       source;
        final String              url;
        final String      absoluteURL;

        domain = RandomDrawingDriver.class.getProtectionDomain();
        source = domain.getCodeSource();
        url    = source.getLocation().toString();
        absoluteURL = url.substring( 5, url.lastIndexOf( "/" )+1) + "names.csv";
        return( absoluteURL );
        

        
    }
    /*************************************************************************
     * Incredibly complex and brilliant method for picking a random name
     * from drawingNames. Definitely don't seed this.
     * 
     * @return winner!
     */
    static String getRandomName()
    {
        String winningName;
        
        winningName = drawingNames[random.nextInt(drawingNames.length)];
        return winningName;
    }

    
}
