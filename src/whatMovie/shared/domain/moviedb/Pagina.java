package whatMovie.shared.domain.moviedb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown=true)
@Generated("org.jsonschema2pojo")
public class Pagina implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2956267040475801208L;
	private Integer page;
	private List<Resultado> results = new ArrayList<Resultado>();
	private Integer totalResults;
	private Integer totalPages;

	/**
	 * 
	 * @return The page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 
	 * @param page
	 *            The page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 
	 * @return The results
	 */
	public List<Resultado> getResults() {
		return results;
	}

	/**
	 * 
	 * @param results
	 *            The results
	 */
	public void setResults(List<Resultado> results) {
		this.results = results;
	}

	/**
	 * 
	 * @return The totalResults
	 */
	public Integer getTotalResults() {
		return totalResults;
	}

	/**
	 * 
	 * @param totalResults
	 *            The total_results
	 */
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	/**
	 * 
	 * @return The totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * 
	 * @param totalPages
	 *            The total_pages
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

}
