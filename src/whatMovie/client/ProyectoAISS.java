package whatMovie.client;

import java.util.HashMap;
import java.util.Map;

import whatMovie.client.AboutView;
import whatMovie.client.ContentView;
import whatMovie.client.SearchView;

import com.google.gwt.core.client.EntryPoint;

import com.google.gwt.user.client.ui.RootPanel;


public class ProyectoAISS implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		go("init");
	}

	public static void go(String token) {
		go(token, new HashMap<String, Object>());
	}

	public static void go(String token, Map<String, Object> params) {
		RootPanel p = RootPanel.get();
		if (token == "init" || token == "search"){
			p.clear();
			p.add(new SearchView(params));
		} else if (token == "about") {
			p.clear();
			p.add(new AboutView(params));
		} else if (token == "content") {
			p.clear();
			p.add(new ContentView(params));
		}
	}
}

