package whatMovie.server.rcp;

import whatMovie.client.rcp.SpotifyService;
import whatMovie.server.resource.SpotifyResource;
import whatMovie.shared.domain.spotify.AlbumSearch;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SpotifyServiceImpl extends RemoteServiceServlet implements SpotifyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4767416215031466948L;
     
	SpotifyResource spr= new SpotifyResource();
	
	public AlbumSearch getSpotifyAlbums(String nombrePeli){
		return spr.getSpotifyAlbums(nombrePeli);
	}
}
