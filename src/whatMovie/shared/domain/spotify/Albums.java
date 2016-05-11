package whatMovie.shared.domain.spotify;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Albums implements Serializable {

	
	private static final long serialVersionUID = 3301373113706564633L;
	private String href;
	private List<ItemS> items;		
	
	public Albums() {
		
	}

	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<ItemS> getItems() {
		return items;
	}
	public void setItems(List<ItemS> items) {
		this.items = items;
	}
	   
}
