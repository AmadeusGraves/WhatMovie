
package whatMovie.shared.domain.google;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")

public class Context implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1207302308081284290L;
	private String title;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
