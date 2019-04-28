package main;

import java.io.IOException;

import javax.swing.SwingUtilities;

import controllers.LocationController;
import theards.ThreadGetPublicidade;
import view.SendLocation;

public class execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocationController lc = new LocationController();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	System.out.println("iniciando aplicação .....");
        		SendLocation frame = new SendLocation();
        		frame.setVisible(true);
            }
        });
//		SwingUtilities.invokeLater(new Runnable() {
//			 
//			   @Override
//			   public void run() {
//				   try {
//						lc.saveLocation(2, "user", 1, 0.999999999, 0.4444444);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				  new ThreadGetPublicidade().execute();
//			   }
//			  });
	}

}
