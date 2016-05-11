package whatMovie.client.rcp;

import java.util.List;
import whatMovie.shared.domain.youtubetriller.Pelis;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YoutubeServiceAsync {
	
	
	public void getVideos(String bso, AsyncCallback<List<Pelis>> asyncCallback);

}
