package theards;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import controllers.PublicidadeController;
import models.Publicidade;
import models.api.PublicidadeResult;

public class ThreadGetPublicidade extends SwingWorker<PublicidadeResult, PublicidadeResult> {
	
	private IThreadResult iThreadResult;

	@Override
	   protected PublicidadeResult doInBackground() {
	    // Simulate doing something useful.
		try {
            return new PublicidadeController().getPublicidade();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	   }
	
	protected void done()
    {
        try
        {
        	Publicidade publicidade = new Publicidade();
        	publicidade = get().getPublicidade();
        	System.out.println("id:: " + publicidade.getId());
        	System.out.println("id:: " + publicidade.getLink());
        	System.out.println("id:: " + publicidade.getMessage());
        	System.out.println("id:: " + publicidade.getTypeUser());
            
        	
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
	public void setOnResult(IThreadResult iThreadResult) {
        this.iThreadResult = iThreadResult;
    }
	
}
