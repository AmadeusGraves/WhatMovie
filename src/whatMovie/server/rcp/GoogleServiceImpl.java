package whatMovie.server.rcp;

import whatMovie.client.rcp.GoogleService;
import whatMovie.server.resource.SearchGoogleResource;
import whatMovie.shared.domain.google.Images;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GoogleServiceImpl extends RemoteServiceServlet implements GoogleService{

	private static final long serialVersionUID = -2089214287723911714L;

	SearchGoogleResource gpr = new SearchGoogleResource();
	
	public Images getGoogleSearch(String pelicula) {
		
		return gpr.getSearch(pelicula);
	}

}
