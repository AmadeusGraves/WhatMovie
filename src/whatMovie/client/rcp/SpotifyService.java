package whatMovie.client.rcp;

import whatMovie.shared.domain.spotify.AlbumSearch;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("SpotifyService")
public interface SpotifyService extends RemoteService {
	
	public AlbumSearch getSpotifyAlbums(String nombrePeli);

}
