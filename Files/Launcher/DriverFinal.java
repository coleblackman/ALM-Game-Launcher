//John Link 4/24/17
   import javax.swing.JFrame;
   public class DriverFinal
   {
      public static void main(String[] args)
      {
         JFrame frame = new JFrame("Team ALM Launcher");
         frame.setSize(960, 540);
         frame.setLocation(160, 242);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new PanelTitle());
			frame.setUndecorated (true);
         frame.setVisible(true);
        	frame.setResizable(false);
			
      }
   }