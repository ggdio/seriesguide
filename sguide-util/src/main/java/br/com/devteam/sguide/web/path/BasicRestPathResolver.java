package br.com.devteam.sguide.web.path;

/**
 * REST paths resolver
 * @author Guilherme Dio
 *
 */
public class BasicRestPathResolver implements PathResolver {

	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveCreate()
	 */
	@Override
	public String resolveCreate(){
		return "/";
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveUpdate(java.lang.String)
	 */
	@Override
	public String resolveUpdate(Long id){
		return "/" + id;
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveDelete(java.lang.String)
	 */
	@Override
	public String resolveDelete(Long id){
		return "/" + id;
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveGet()
	 */
	@Override
	public String resolveGet() {
		return "/";
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveGet(java.lang.String)
	 */
	@Override
	public String resolveGet(Long id){
		return "/" + id;
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.web.path.PathResolver#resolveList(java.lang.String)
	 */
	@Override
	public String resolveList(){
		return "/";
	}
	
}