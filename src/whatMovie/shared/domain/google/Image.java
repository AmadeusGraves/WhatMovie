
package whatMovie.shared.domain.google;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Image implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1919839050652860690L;
	private String contextLink;
    private Integer height;
    private Integer width;
    private Integer byteSize;
    private String thumbnailLink;
    private Integer thumbnailHeight;
    private Integer thumbnailWidth;

    /**
     * 
     * @return
     *     The contextLink
     */
    public String getContextLink() {
        return contextLink;
    }

    /**
     * 
     * @param contextLink
     *     The contextLink
     */
    public void setContextLink(String contextLink) {
        this.contextLink = contextLink;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The byteSize
     */
    public Integer getByteSize() {
        return byteSize;
    }

    /**
     * 
     * @param byteSize
     *     The byteSize
     */
    public void setByteSize(Integer byteSize) {
        this.byteSize = byteSize;
    }

    /**
     * 
     * @return
     *     The thumbnailLink
     */
    public String getThumbnailLink() {
        return thumbnailLink;
    }

    /**
     * 
     * @param thumbnailLink
     *     The thumbnailLink
     */
    public void setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
    }

    /**
     * 
     * @return
     *     The thumbnailHeight
     */
    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    /**
     * 
     * @param thumbnailHeight
     *     The thumbnailHeight
     */
    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    /**
     * 
     * @return
     *     The thumbnailWidth
     */
    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    /**
     * 
     * @param thumbnailWidth
     *     The thumbnailWidth
     */
    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

}
