//John Link Cole Blackman 5/10/17
   import javax.swing.JFrame;
   public class DriverChess
   {
      public static void main(String[] args) //standard driver
      {
         JFrame frame = new JFrame("Chess Game Launcher");
         frame.setSize(1280, 1024);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new GUIPanel());
         frame.setUndecorated(true);
         frame.setResizable(false);
         frame.setVisible(true);
      	
      }
   }