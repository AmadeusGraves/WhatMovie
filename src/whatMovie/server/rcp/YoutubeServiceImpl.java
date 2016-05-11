package whatMovie.server.rcp;

import java.util.List;

import whatMovie.client.rcp.YoutubeService;
import whatMovie.server.resource.YoutubeResource;
import whatMovie.shared.domain.youtubetriller.Pelis;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class YoutubeServiceImpl extends RemoteServiceServlet implements YoutubeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2332203395616154059L;
	YoutubeResource a = new YoutubeResource();
	@Override
	public List<Pelis> getVideos(String nombre) {
		return a.getVideos(nombre);
	}
	
}
