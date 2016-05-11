package whatMovie.server.resource;

import java.util.List;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


public class WMResource {
	
	private String uri = "http://api.themoviedb.org/3/search/movie?query=";
	private String idioma = "&language=es";
	private String apiKey = "&api_key=3290ba2dd569f99feba075d9c243e0a5";

	public String getOverview(String peli) {
		ClientResource cr = null;
		whatMovie.shared.domain.moviedb.Pagina page = null;
		List<whatMovie.shared.domain.moviedb.Resultado> res = null;
		String sinopsis = null;
		try {
			cr = new ClientResource(uri + peli + idioma + apiKey);
			page = cr.get(whatMovie.shared.domain.moviedb.Pagina.class);
			res = page.getResults();
			sinopsis = res.get(0).getOverview();
		} catch (ResourceException e) {
			System.err.println("Error cuando se obtiene la sinopsis de la pelicula:"+ cr.getResponse().getStatus());
		}
		return sinopsis;
	}
}
