import javax.swing.*;

public class test {
    public static void main ( String [] args ) {
        JFrame frame = new JFrame ( "test" );
        JPanel panel = new JPanel();
        frame.getContentPane().add( panel );
        frame.pack ();
        frame.setVisible ( true );
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    
    } 
}