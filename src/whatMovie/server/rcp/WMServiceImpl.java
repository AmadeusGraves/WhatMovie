package whatMovie.server.rcp;



import whatMovie.client.rcp.WMService;
import whatMovie.server.resource.WMResource;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class WMServiceImpl extends RemoteServiceServlet implements WMService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3795757702834157548L;
	WMResource tmdbr = new WMResource();
	
	public String getOverview(String nombrePeli){
		return tmdbr.getOverview(nombrePeli);
	}
}
