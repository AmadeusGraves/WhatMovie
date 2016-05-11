package whatMovie.client;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SearchView extends Composite {

	private final VerticalPanel mainPanel = new VerticalPanel();
	private final HorizontalPanel topPanel = new HorizontalPanel();
	private final HorizontalPanel contentPanel = new HorizontalPanel();

	public SearchView(Map<String, Object> params) {
		initWidget(mainPanel);
		Button aboutButton = new Button("About us");
		aboutButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ProyectoAISS.go("about");
			}
		});
		topPanel.add(new HTML(
                "<img src='/logo.png' id='logo' />"));
		
		final TextBox searchBox = new TextBox();
		Button searchButton = new Button("Busca pelicula");
		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (searchBox.getText().trim().isEmpty()) {
					Window.alert("Por favor inserte una pelicula a buscar");
				} else {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("pelicula", searchBox.getText().trim());
					ProyectoAISS.go("content", m);
				}

			}
		});
		contentPanel.add(searchBox);
		contentPanel.add(searchButton);
        contentPanel.add(aboutButton);
		mainPanel.add(topPanel);
		mainPanel.add(contentPanel);
        mainPanel.getElement().getStyle().setProperty("margin", "8% auto");
	}
}
