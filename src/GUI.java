import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/****************************************************************************
 * 
 * Gui Container and Creator class for RandomDrawing
 * 
 * Liam Sargent
 * v2
 * 7/13/2014
 * 
 *
 ****************************************************************************/

public class GUI implements ActionListener
{
    private JFrame mainFrame = new JFrame("Cloudera Referral Drawing");
    private JPanel mainContainer, winningBox;
    private JButton getWinner;
    private JTextArea outputArea, credArea;
    private JPanel bottomPanel;
    private Font bigFont;
    
    
    /***********************************************************************
     * Is it even possible to read Swing class code? Why are you even
     * looking at this file? Why did I use Swing? I need to rethink my life 
     * choices.
     */
    public GUI()
    {
        bigFont = new Font("Helvetica", Font.BOLD, 36);
        mainContainer = (JPanel) mainFrame.getContentPane();
        mainContainer.setLayout(new BorderLayout()); 
        getWinner = new JButton("Pick a Winner!");
        outputArea = new JTextArea("And the winner is...",2,17);
        outputArea.setFont( bigFont );
        winningBox = new JPanel(new BorderLayout());
        credArea = new JTextArea("By Liam Sargent - IT Intern 2014 - github.com/themailman05 -",1,15);
        getWinner.addActionListener( this );
        
        mainContainer.add( getWinner, BorderLayout.WEST );
        mainContainer.add( outputArea, BorderLayout.CENTER );
        mainContainer.add(credArea, BorderLayout.SOUTH);
        
        bigFont = new Font("Calibri", Font.BOLD, 36);
        
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.validate();
        
    }
    
    /**********************************************************************
     * Because nothing says efficiency like a good ol' fashioned 
     * ActionListener.
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == getWinner)
        {
                try
                {
                    Thread.sleep( 3000 );
                }
                catch ( InterruptedException e1 )
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                outputArea.setFont( bigFont );
                outputArea.setText( "Congratulations " + Drawing.getRandomName() + "!" );
                mainFrame.pack();
                mainFrame.validate();
          
            
        }

    }
}
