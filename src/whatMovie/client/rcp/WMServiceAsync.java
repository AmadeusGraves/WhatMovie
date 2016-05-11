package whatMovie.client.rcp;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WMServiceAsync {

	public void getOverview(String nombrePeli , AsyncCallback<String> callback);
}
