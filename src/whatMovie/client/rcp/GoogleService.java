package whatMovie.client.rcp;

import whatMovie.shared.domain.google.Images;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("SearchGoogle")
public interface GoogleService extends RemoteService{
	
	 public Images getGoogleSearch(String imagen);
	 

}
