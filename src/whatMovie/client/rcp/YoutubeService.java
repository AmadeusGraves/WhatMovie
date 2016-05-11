package whatMovie.client.rcp;

import java.util.List;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import whatMovie.shared.domain.youtubetriller.Pelis;

@RemoteServiceRelativePath("YoutubeService")
public interface YoutubeService extends RemoteService{
	
	public List<Pelis> getVideos(String nombre);

}

