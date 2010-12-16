package at.ait.dme.yuma.server.controller.rss;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import at.ait.dme.yuma.server.config.Config;
import at.ait.dme.yuma.server.controller.AbstractAnnotationController;
import at.ait.dme.yuma.server.exception.AnnotationDatabaseException;
import at.ait.dme.yuma.server.exception.AnnotationNotFoundException;

@Path("/feeds")
public class RSSAnnotationController extends AbstractAnnotationController {
	
	private static final int FEED_LENGTH = 20;
	private static final String FEED_BASEURL = Config.getInstance().getAnnotationBaseUrl() + "feeds/";
	
	private static final String TIMELINE_TITLE = "YUMA Timeline Feed";
	private static final String TIMELINE_DESCRIPTION = "Most recent annotations on this YUMA annotation server.";
	private static final String TIMELINE_URL = FEED_BASEURL + "timeline";
	
	private static final String OBJECT_FEED_TITLE = "Annotations for ";
	private static final String OBJECT_FEED_DESCRIPTION = "Annotation feed for object with ID ";
	private static final String OBJECT_FEED_URL = FEED_BASEURL + "object/";
	
	/**
	 * Returns a feed with the most recent public annotations in the system.
	 * @return the feed
	 * @throws AnnotationDatabaseException if anything goes wrong with the DB
	 * @throws UnsupportedEncodingException in case of encoding problem
	 */
	@GET
	@Produces("application/rss+xml")
	@Path("/timeline")
	public Response getTimeline()
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		return super.getMostRecent(FEED_LENGTH, new RSSFormatHandler(
				TIMELINE_TITLE,
				TIMELINE_DESCRIPTION,
				TIMELINE_URL));
	}
	
	/**
	 * Returns a feed with the public annotations by the specified user.
	 * @param name the user name
	 * @return the feed
	 * @throws AnnotationDatabaseException if anything goes wrong with the DB
	 * @throws UnsupportedEncodingException in case of encoding problem
	 */
	@GET
	@Produces("application/rss+xml")
	@Path("/user/{name}")	
	public Response getUserFeed(@PathParam("name") String name) 
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		// TODO implement
		return null;
	}
	
	/**
	 * Returns a feed with the public annotation to the specified object.
	 * @param objectId the object ID
	 * @return the feed
	 * @throws AnnotationDatabaseException if anything goes wrong with the DB
	 * @throws UnsupportedEncodingException in case of encoding problem
	 */
	@GET
	@Produces("application/rss+xml")
	@Path("/object/{objectId}")
	public Response getObjectFeed(@PathParam("objectId") String objectId) 
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		return super.getAnnotationTree(objectId, new RSSFormatHandler(
				OBJECT_FEED_TITLE + objectId,
				OBJECT_FEED_DESCRIPTION + objectId,
				OBJECT_FEED_URL + objectId));
	}
	
	/**
	 * Returns a feed with the public replies to the specified annotation.
	 * @param id the annotation id
	 * @return the feed
	 * @throws AnnotationDatabaseException if anything goes wrong with the DB
	 * @throws AnnotationNotFoundException if the specified annotation does not exist
	 * @throws UnsupportedEncodingException in case of encoding problem
	 */
	@GET
	@Produces("application/rss+xml")
	@Path("/annotation/{id}")
	public Response getAnnotationFeed(@PathParam("id") String id) 
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		// TODO implement
		return null;
	}
	
}