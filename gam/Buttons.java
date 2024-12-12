
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Buttons extends JFrame
{
   public Buttons()
   {
    JButton button= new JButton();
    this.setBounds(100, 100, 50, 20);
    this.setLayout(null);//free to place anywhere by the user
    this.setFocusable(false);
    this.setForeground(Color.gray);
    this.setBackground(Color.DARK_GRAY);

    this.setVisible(true);//button visible

   }
    


}