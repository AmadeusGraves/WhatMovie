package whatMovie.client.rcp;

import whatMovie.shared.domain.spotify.AlbumSearch;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SpotifyServiceAsync {
  
	void getSpotifyAlbums(String artist, AsyncCallback<AlbumSearch> callback);
}
