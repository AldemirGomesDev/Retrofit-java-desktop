package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.LocationController;
import controllers.PublicidadeController;
import models.Location;
import models.Publicidade;
import models.api.LocationResult;
import models.api.PublicidadeResult;
import theards.IThreadResult;
import theards.ThreadGetPublicidade;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SendLocation extends JFrame implements ActionListener, 
PropertyChangeListener{

	private JPanel contentPane;
	private JTextField txt_userId;
	private JTextField txt_userType;
	private JTextField txt_lat;
	private JTextField txt_lng;
	private Task task;
	private JButton btnEnviar;
	private JTextArea taskOutput;
	private JProgressBar progressBar;


	public SendLocation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEnviarLocalizao = new JLabel("Enviar localiza\u00E7\u00E3o");
		lblEnviarLocalizao.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnviarLocalizao.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnviarLocalizao.setBounds(10, 11, 394, 14);
		panel.add(lblEnviarLocalizao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 63, 394, 166);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIdUser = new JLabel("Id user:");
		lblIdUser.setBounds(10, 11, 46, 14);
		panel_1.add(lblIdUser);
		
		txt_userId = new JTextField();
		txt_userId.setBounds(86, 8, 86, 20);
		panel_1.add(txt_userId);
		txt_userId.setColumns(10);
		
		JLabel lblTypeUser = new JLabel("Type user:");
		lblTypeUser.setBounds(10, 42, 66, 14);
		panel_1.add(lblTypeUser);
		
		txt_userType = new JTextField();
		txt_userType.setColumns(10);
		txt_userType.setBounds(86, 39, 86, 20);
		panel_1.add(txt_userType);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setBounds(10, 70, 66, 14);
		panel_1.add(lblLatitude);
		
		txt_lat = new JTextField();
		txt_lat.setColumns(10);
		txt_lat.setBounds(86, 67, 86, 20);
		panel_1.add(txt_lat);
		
		JLabel lblLongitude = new JLabel("Longitude:");
		lblLongitude.setBounds(10, 100, 66, 14);
		panel_1.add(lblLongitude);
		
		txt_lng = new JTextField();
		txt_lng.setColumns(10);
		txt_lng.setBounds(86, 97, 86, 20);
		panel_1.add(txt_lng);
		
		progressBar = new JProgressBar (0, 100);
		progressBar.setBounds(10, 125, 162, 14);
		progressBar.setValue (0);
		progressBar.setStringPainted (true);
		panel_1.add(progressBar);
		
		btnEnviar = new JButton("Start");
		btnEnviar.setActionCommand("start");
		btnEnviar.addActionListener(this);
		
//		btnEnviar = new JButton("Enviar");
//		btnEnviar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
		btnEnviar.setBounds(250, 38, 89, 23);
		panel_1.add(btnEnviar);
		
		taskOutput = new JTextArea();
		taskOutput.setBounds(203, 95, 181, 44);
		panel_1.add(taskOutput);
		
	}
	
	public class Task extends SwingWorker<LocationResult, LocationResult> {
		
		boolean success = false;
		LocationController lc = new LocationController();
		LocationResult locationResult = new LocationResult();
		Location location = new Location();

		@Override
		   protected LocationResult doInBackground() {
		    // Simulate doing something useful.
			try {
				Random random = new Random();
	            int progress = 0;
	            //Initialize progress property.
	            setProgress(0);
	            while (progress < 100) {
	                //Sleep for up to one second.
	                try {
	                    Thread.sleep(random.nextInt(1000));
	                } catch (InterruptedException ignore) {}
	                //Make random progress.
	                progress += random.nextInt(60);
	                setProgress(Math.min(progress, 100));
	            }
	            
				int userId = Integer.parseInt(txt_userId.getText());
				String userType = txt_userType.getText();
				double lat = Double.parseDouble(txt_lat.getText());
				double lng = Double.parseDouble(txt_lng.getText());
				locationResult = lc.saveLocation(userId, userType, 1, lat, lng);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return locationResult;
		   }
		
		protected void done()
	    {
	        try
	        {
	        	String locatio = get().getMsg();
	        	
	        	System.out.println("result: " +locatio);
	        	
	        	Toolkit.getDefaultToolkit().beep();
	        	btnEnviar.setEnabled(true);
	            setCursor(null); //turn off the wait cursor
	            taskOutput.append("Done!\n");
	            
	        	
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
		
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("propertyChange .....");
		 if ("progress" == evt.getPropertyName()) {
	            int progress = (Integer) evt.getNewValue();
	            progressBar.setValue(progress);
	            taskOutput.append(String.format(
	                    "Completed %d%% of task.\n", task.getProgress()));
	        } 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		btnEnviar.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
		
	}
}
