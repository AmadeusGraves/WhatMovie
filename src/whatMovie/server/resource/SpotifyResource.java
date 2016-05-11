package whatMovie.server.resource;

import org.restlet.resource.ClientResource;

import whatMovie.shared.domain.spotify.AlbumSearch;

public class SpotifyResource {
	
	private String uri="https://api.spotify.com/v1/search?q=";

	public AlbumSearch getSpotifyAlbums(String artist) {
		ClientResource cr = new	ClientResource(  uri + artist +  "A&type=album");
		AlbumSearch message = cr.get(AlbumSearch.class);
		return message;
        }
	
}
