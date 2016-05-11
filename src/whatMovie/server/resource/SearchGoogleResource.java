package whatMovie.server.resource;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import whatMovie.shared.domain.google.Images;

public class SearchGoogleResource {

	// Uri google Search Custom
	private String uriSearch = "https://www.googleapis.com/customsearch/v1?q=";
	private String uriSearch2 = "&cx=000187597668682588519:prublamjr6u&searchType=image&key=AIzaSyCPlaanZo0P71-uh35tKPUNmypP5PBwe7Y";

	public Images getSearch(String pelicula) {

		ClientResource cr = null;
		Images result = null;
		try {
			cr = new ClientResource(uriSearch + pelicula + uriSearch2);
			result = cr.get(Images.class);
		} catch (ResourceException re) {
			System.err
					.println("Error when retrieving the pelicula search result:"
							+ cr.getResponse().getStatus());

		}
		return result;
	}

}
