package whatMovie.server.resource;

import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import whatMovie.shared.domain.youtubetriller.Pelis;
import whatMovie.shared.domain.youtubetriller.VideoList;
//https://www.googleapis.com/youtube/v3/search?part=snippet&order=relevance&q=Terminator&relevanceLanguage=ES&type=video&key=AIzaSyCoq4Ei8m2ZvB4d3YdFl5q1AwRADta_d3A
public class YoutubeResource {
	private String uri1 = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=10&order=relevance&q=";
	private String uri2 = "&type=video&key=";
	private String key ="AIzaSyCoq4Ei8m2ZvB4d3YdFl5q1AwRADta_d3A";
	
	public List<Pelis> getVideos(String nombre){
		ClientResource cr = null;
		VideoList rel = null;
		List<Pelis> res = null;
		nombre ="Trailer%20"+ nombre;
		try{
			cr = new ClientResource(uri1+ nombre+ uri2+key ); 
			rel = cr.get(VideoList.class);
			res = rel.getItems();
		}catch(ResourceException re){
			System.err.println("Error when retrieving the trailerlist: "
					+ cr.getResponse().getStatus());
		}
		return res;
		
	}

}
