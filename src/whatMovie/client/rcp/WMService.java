package whatMovie.client.rcp;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SearchSinopsis")
public interface WMService extends RemoteService{
	
	public String getOverview(String nombrePeli);
}
