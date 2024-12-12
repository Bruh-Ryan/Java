import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Home extends JFrame implements ActionListener{
    
    JButton menu_opt;

    public Home() {
        //Image backGround;// contains under java awt package;

        // Set window size
        setSize(720, 1080);
        // Set window title
        setTitle("Jump!");
        setLocation(480, 1080);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the window visible
        setLayout(null);

        //MENU::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        JLabel menu_txt= new JLabel("-Menu----------");
        menu_txt.setFont(new  Font("Comic Sans MS",Font.BOLD,30));
        menu_txt.setForeground(Color.CYAN);
        menu_txt.setBounds(10, 10, 300, 50); 
        add(menu_txt);
        
        //buttons menu::::::::::::::::::::::::::::
        
        // JButton menu_opt1=new JButton();
        // menu_opt1.setText("Play Jump!");
        // menu_opt1.setBounds(80, 80, 100, 40);
        // menu_opt1.setLayout(null);//free to place anywhere by the user
        // menu_opt1.setFocusable(false);
        // menu_opt1.setBackground(Color.gray);
        // add(menu_opt1);
     

        //BACKGROUND SKY LOADED:::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        ImageIcon backGround= new ImageIcon("SkyBG.jpeg");//.getImage()
        JLabel bgIMG=new JLabel(backGround);
        bgIMG.setBounds(0, 0, 720, 1080); // Set the size of the label to cover the frame
        add(bgIMG);

        setVisible(true);

    }

    // private void showButton()
    // {
    //     JLabel menu_opt=new JLabel();
    //     menu_opt.setText("Control in action: Button"); 
    //     menu_opt.setLocation(50, 40);

    //     JButton play_opt=new JButton("Play");
    //     play_opt.setFont(new Font("Broadway", Font.ITALIC,20));

    //     setVisible(true);

    
    // }
    public static void main(String[] args) {
        // Create and display the frame
        new Home();
       // new showButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menu_opt)//menu_opt is now a global constructor
        {

        }
    }
}
