import whatMovie.server.resource.SearchGoogleResource;

import whatMovie.shared.domain.google.Images;


public class Prueba {

	public static void main(String[] args) {
		SearchGoogleResource a = new SearchGoogleResource();
		Images e = a.getSearch("Terminator");
		System.out.println(e.getItems().toString());

	}

}
