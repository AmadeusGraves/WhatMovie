package whatMovie.client.rcp;

import whatMovie.shared.domain.google.Images;





import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GoogleServiceAsync {

	 public void getGoogleSearch(String imagen, AsyncCallback<Images> callback);

	
}

