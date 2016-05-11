package whatMovie.client;

import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AboutView extends Composite {
	private final VerticalPanel mainPanel = new VerticalPanel();
	private final HorizontalPanel topPanel = new HorizontalPanel();
	private final HorizontalPanel contentPanel = new HorizontalPanel();

	public AboutView(Map<String, Object> params) {
		initWidget(mainPanel);
		Button backButton = new Button("< Back");
		backButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ProyectoAISS.go("search");
			}
		});
		topPanel.add(backButton);
		HTML info = new HTML(

				"<h1>WhatMovie</h1>"
						+"<img src='/logo.png' id='logo' />"
								+ "<h2>Descripci&oacute;n del proyecto</h2>"
								+ "<p>Nuestra aplicaci&oacute;n WhatMovie surge de la idea de integrar varias API que abordan el tema de la cinematograf&iacute;a "
								+ "con el objetivo de facilitar toda la informaci&oacute;n posible acerca de alguna pel&iacute;cula como facilitar la banda sonora,"
								+ "imagenes relacionadas, el argumento y por &uacute;ltimo permite agregar tu opini&oacute;n sobre dicha pel&iacute;cula</p>"
								+ "	<h3> ¿Qu&eacute; solucionamos?</h3>"
								+ "	<p>Ya no ser&aacute; necesario tener varias ventanas abiertas por cada"
								+ "		aplicaci&oacute;n. Unificamos toda la informaci&oacute;n ofrecida por estos sitios"
								+ "		web de manera f&aacute;cil y sencilla en una misma interfaz gr&aacute;fica. Gracias"
								+ "		a nuestro buscador tendr&aacute;s acceso a toda la informaci&oacute;n referente a"
								+ "		los servicios mencionados.Es la aplicaci&oacute;n perfecta para cualquier"
								+ "		apasionado del cine.</p>"
								+ "	<table width='90%'>"
								+ "		<tr>"
								+ "			<td style='font-weight: bold;'>Arquitectura e Integraci&oacute;n de"
								+ "				Sistemas Software Grupo 1</td>"
								+ "		</tr>"
								+ "		<tr>"
								+ "			<td>Lizseth Esquen Saavedra</td>"
								+ "		</tr>"
								+ "		<tr>"
								+ "			<td>Daniel Rodriguez Caro</td>"
								+ "		</tr>"
								+ "		<tr>"
								+ "			<td>Angel Rodriguez Sanchez</td>"
								+ "		</tr>"
								+ "		<tr>"
								+ "			<td>Antonio Vidal Perez</td>"
								+ "		</tr>"
								+ "		<tr>"
								+ "			<td colspan='2' style='color: red;' id='errorLabelContainer'></td>"
								+ "		</tr>" + "</table>");
		contentPanel.add(info);
		mainPanel.add(topPanel);
		mainPanel.add(contentPanel);
	}
	// TODO
}
