import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class myPanel extends JPanel implements ActionListener ///since we are using a actionListener interface we can use...(TBC .A.)
{
    final int PANNEL_WIDTH=1920;
    final int PANNEL_HEIGHT=1080;

    Image rocket;  //just like data type int,float etc. we have Image i.g!?
    Image BackGroundImage;
    Timer timer;   //same here a timer data type; though we gotta have to import it.
    int xvelocity=1;
    int yvelocity=1;

    int xStartCord=0;//starting coordinates;
    int yStartCord=0;
    
     
    myPanel()
    {
        this.setPreferredSize(new Dimension(PANNEL_HEIGHT,PANNEL_WIDTH));
        
        rocket= new ImageIcon("Rocket.png").getImage();

        BackGroundImage=new ImageIcon("Earth.jpg").getImage();
        
        this.setBackground(Color.BLACK);
        //(TBC .A.) for timer we can use ActionerListner interface using .this:
        timer= new javax.swing.Timer((10), this); //action in every millisecons 1000=1sec;
        timer.start();
    }
    public void paint(Graphics g)
    {
        super.paint(g);//paint background;
        Graphics2D g2d =  ( Graphics2D) g;
        g2d.drawImage(BackGroundImage, 0, yStartCord, null);

        g2d.drawImage(rocket, xStartCord, yStartCord, null); //observer=null

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(xStartCord>=PANNEL_WIDTH-rocket.getWidth(null)||xStartCord<0)
        {
            xvelocity=xvelocity*(-1);
        }
        xStartCord= xStartCord + xvelocity;
       

        if(yStartCord>=PANNEL_WIDTH-rocket.getWidth(null)||yStartCord<0)
        {
            yvelocity=yvelocity*(-1);
        }
        yStartCord= yStartCord + yvelocity;
      
        repaint();


    }
}