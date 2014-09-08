import java.io.File;

/****************************************************************************
 * 
 * Driver class for running RandomDrawing application.
 * 
 * Liam Sargent
 * v2
 * 7/13/2014
 * 
 *
 ****************************************************************************/

public class RandomDrawingDriver
{
    static Drawing drawing;
    static GUI theGui;
    
    public static void main(String[] args)
    {
        String fileURL = Drawing.getFileURL();
        System.out.println(fileURL);
        
        File inputFile = new File(fileURL);
        
        if(inputFile.exists())
        {
            drawing = new Drawing(fileURL);
            theGui = new GUI();
        }  
        else
            System.exit( 0 );
            
    }
}
