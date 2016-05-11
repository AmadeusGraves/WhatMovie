package whatMovie.client;

import java.util.*;

import whatMovie.client.rcp.GoogleService;
import whatMovie.client.rcp.GoogleServiceAsync;
import whatMovie.client.rcp.SpotifyService;
import whatMovie.client.rcp.SpotifyServiceAsync;
import whatMovie.client.rcp.WMService;
import whatMovie.client.rcp.WMServiceAsync;
import whatMovie.client.rcp.YoutubeService;
import whatMovie.client.rcp.YoutubeServiceAsync;
import whatMovie.shared.domain.google.Images;
import whatMovie.shared.domain.google.Item;
import whatMovie.shared.domain.spotify.AlbumSearch;
import whatMovie.shared.domain.spotify.ItemS;
import whatMovie.shared.domain.youtubetriller.Pelis;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContentView extends Composite {

	private final VerticalPanel mainPanel = new VerticalPanel();
	private final HorizontalPanel logoPanel = new HorizontalPanel();
	private final HorizontalPanel searchPanel = new HorizontalPanel();
	private final HorizontalPanel contentPanel = new HorizontalPanel();
	private final VerticalPanel searchrCustomPanel = new VerticalPanel();
	private final HorizontalPanel searchCustomHeader = new HorizontalPanel();
	private final ScrollPanel searchCustomContent = new ScrollPanel();
	private final VerticalPanel youtubePanel = new VerticalPanel();
	private final VerticalPanel spotifyPanel = new VerticalPanel();
	private final VerticalPanel moviedbPanel = new VerticalPanel();
	private final HorizontalPanel youtubeHeader = new HorizontalPanel();
	private final HorizontalPanel spotifyHeader = new HorizontalPanel();
	private final HorizontalPanel moviedbHeader = new HorizontalPanel();
	private final ScrollPanel youtubeContent = new ScrollPanel();
	private final ScrollPanel spotifyContent = new ScrollPanel();
	private final ScrollPanel moviedbContent = new ScrollPanel();

	/* Declaracion del ServiceAsync */
	private final GoogleServiceAsync googleService = GWT
			.create(GoogleService.class);
	private final WMServiceAsync wmService = GWT.create(WMService.class);

	private final YoutubeServiceAsync youtubeService = GWT
			.create(YoutubeService.class);

	private final SpotifyServiceAsync spotifyService = GWT
			.create(SpotifyService.class);

	/* Objetos presentes en el ContentView */
	public ContentView(Map<String, Object> params) {
		initWidget(mainPanel);
		logoPanel.add(new HTML("<img src='/logo.png' id='logo-content' />"));
		/* Aplicamos el tamaño deseado al panel */
		searchCustomContent.setSize("36em", "80ex");
		moviedbContent.setSize("36em", "80ex");
		spotifyContent.setSize("36em", "80ex");
		youtubeContent.setSize("36em", "80ex");

		/* Pelicula que buscamos */
		final String pelicula = (String) params.get("pelicula");

		/* Botón sobre nosotros */
		Button aboutButton = new Button("Sobre nosotros");
		aboutButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ProyectoAISS.go("about");
			}
		});

		/* Campo de texto de busqueda */
		final TextBox searchBox = new TextBox();
		searchBox.setValue(pelicula);
		Button searchButton = new Button("Buscar pelicula");
		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (searchBox.getText().trim().isEmpty()) {
					Window.alert("Por favor inserta una pelicula a buscar");
				} else {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("pelicula", searchBox.getText().trim());
					ProyectoAISS.go("content", m);
				}

			}
		});

		/* Añadimos todo al panel */
		searchPanel.add(searchBox);
		searchPanel.add(searchButton);
		searchPanel.add(aboutButton);
		searchPanel.getElement().getStyle().setProperty("", "");

		searchVideo(pelicula);
		searchCustomImage(pelicula);
		searchSinopsis(pelicula);
		searchCancion(pelicula);

		searchrCustomPanel.add(searchCustomHeader);
		searchrCustomPanel.add(searchCustomContent);
		moviedbPanel.add(moviedbHeader);
		moviedbPanel.add(moviedbContent);
		spotifyPanel.add(spotifyHeader);
		spotifyPanel.add(spotifyContent);
		youtubePanel.add(youtubeHeader);
		youtubePanel.add(youtubeContent);

		contentPanel.add(youtubePanel);
		contentPanel.add(searchrCustomPanel);
		contentPanel.add(moviedbPanel);
		contentPanel.add(spotifyPanel);

		mainPanel.add(logoPanel);
		mainPanel.add(searchPanel);
		mainPanel.add(contentPanel);
	}

	private void searchVideo(final String pelicula) {

		youtubeContent.clear();
		final VerticalPanel tmpPanel = new VerticalPanel();
		youtubeService.getVideos(pelicula, new AsyncCallback<List<Pelis>>() {

			public void onSuccess(List<Pelis> result) {
				for (final Pelis i : result) {
					String buttonContent = i.getSnippet().getTitle()
							+ "</br>"
							+ "<img src='"
							+ i.getSnippet().getThumbnails().getMedium()
									.getUrl() + "'/>";
					Button videoButton = new Button(buttonContent);

					videoButton.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							selectVideoTrailer(pelicula, i);
						}
					});
					tmpPanel.add(videoButton);
				}
				if (result.isEmpty()) {
					tmpPanel.add(new HTML(
							"<span class='text-error'>No existe la pelicula</span>"));
				}
			}

			public void onFailure(Throwable caught) {
				HTML error = new HTML(
						"<span class='text-error'>Error al buscar el Trailer: "
								+ caught.getCause() + caught.getMessage()
								+ "</span>");
				tmpPanel.add(error);
			}
		});
		youtubeContent.add(tmpPanel);
	}

	private void selectVideoTrailer(final String name, Pelis snippet) {
		youtubeContent.clear();
		Button backButton = new Button("Atras");
		backButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				youtubeHeader.clear();
				searchVideo(name);
			}
		});

		Integer height = 360;
		Integer wight = 480;

		// //www.youtube.com/embed/iG9CE55wbtY" frameborder="0" allowfullscreen

		String url = "https://www.youtube.com/embed/"
				+ snippet.getId().getVideoId();

		youtubeHeader.add(backButton);
		HTML content = new HTML("<h2>" + snippet.getSnippet().getTitle()
				+ "</h2><br/>" + "<iframe width=" + wight + " height=" + height
				+ "src=" + url + " frameborder=0 ></iframe>" + "<br/>"
				+ snippet.getSnippet().getDescription()

		);
		content.setWidth("34.5em");
		youtubeContent.add(content);

	}

	private void searchCustomImage(final String pelicula) {
		searchCustomHeader.clear();
		searchCustomContent.clear();
		final VerticalPanel tmpPanel = new VerticalPanel();
		googleService.getGoogleSearch(pelicula, new AsyncCallback<Images>() {

			@Override
			public void onFailure(Throwable caught) {
				HTML error = new HTML(
						"<span class='text-error'>Error al buscar la pelicula: "
								+ caught.getMessage() + "</span>"); // getCause()
																	// para
																	// saber la
																	// causa
				tmpPanel.add(error);
			}

			@Override
			public void onSuccess(Images result) {

				for (final Item i : result.getItems()) {
					String buttonContent = "<img src='"
							+ i.getImage().getThumbnailLink() + "'/><br/>";
					Button imagenButton = new Button(buttonContent);

					imagenButton.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							Window.open(i.getLink(), "_blank", "");
						}
					});
					tmpPanel.add(imagenButton);
				}
				if (result.getQueries().getRequest().isEmpty()) {
					tmpPanel.add(new HTML(
							"<span class='text-error'>No existen peliculas con ese nombre</span>"));
				}
			}

		});
		searchCustomContent.add(tmpPanel);
	}

	// THEMOVIEDB

	private void searchSinopsis(final String pelicula) {
		moviedbHeader.clear();
		moviedbContent.clear();
		final VerticalPanel tmpPanel = new VerticalPanel();
		wmService.getOverview(pelicula, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				HTML error = new HTML(
						"<span class='text-error'>Error al buscar la pelicula: "
								+ caught.getMessage() + "</span>"); // getCause()
																	// para
																	// saber la
																	// causa
				tmpPanel.add(error);

			}

			@Override
			public void onSuccess(String pelicula) {
				tmpPanel.add(new HTML("<span class='text-result'>" + pelicula
						+ "</span>"));

			}

		});
		moviedbContent.add(tmpPanel);

	}

	// SPOTIFY
	private void searchCancion(final String pelicula) {
		spotifyHeader.clear();
		spotifyContent.clear();
		final VerticalPanel tmpPanel = new VerticalPanel();
		spotifyService.getSpotifyAlbums(pelicula,
				new AsyncCallback<AlbumSearch>() {

					@Override
					public void onFailure(Throwable caught) {

						HTML error = new HTML(
								"<span class='text-error'>Error al buscar la pelicula: "
										+ caught.getMessage() + "</span>");
						tmpPanel.add(error);
					}

					@Override
					public void onSuccess(AlbumSearch nombrePeli) {
						if (nombrePeli != null) {
							for (ItemS a : nombrePeli.getAlbums().getItems()) {
								// tmpPanel.add(new
								// HTML("<span class='text-result'>" +
								// nombrePeli.getAlbums().getItems()
								// + "</span>"));
								tmpPanel.add(new HTML(
										"<span class='text-result'>"
												+ a.getName() + "</span>"));
							}
						}
					}
				});
		spotifyContent.add(tmpPanel);

	}
}
