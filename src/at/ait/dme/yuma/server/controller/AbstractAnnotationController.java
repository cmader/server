package at.ait.dme.yuma.server.controller;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.mongodb.util.JSON;

import at.ait.dme.yuma.server.URIBuilder;
import at.ait.dme.yuma.server.config.Config;
import at.ait.dme.yuma.server.model.Annotation;
import at.ait.dme.yuma.server.model.AnnotationThread;
import at.ait.dme.yuma.server.db.AbstractAnnotationDB;
import at.ait.dme.yuma.server.exception.AnnotationHasReplyException;
import at.ait.dme.yuma.server.exception.AnnotationDatabaseException;
import at.ait.dme.yuma.server.exception.AnnotationModifiedException;
import at.ait.dme.yuma.server.exception.AnnotationNotFoundException;
import at.ait.dme.yuma.server.exception.AnnotationFormatException;

/**
 * This class contains the default annotation controller logic.
 * 
 * @author Christian Sadilek
 * @author Rainer Simon 
 */
public abstract class AbstractAnnotationController {
	
	protected static final String URL_ENCODING = "UTF-8";
	
	@Context
	protected HttpServletRequest request;

	/**
	 * Create a new annotation
	 * @param annotation the JSON representation of the annotation
	 * @return status code 201 and new annotation representation
	 * @throws AnnotationDatabaseException (500)
	 * @throws AnnotationFormatException (415)
	 * @throws AnnotationModifiedException (409)
	 */
	protected Response createAnnotation(String annotation)
		throws AnnotationDatabaseException, AnnotationFormatException, AnnotationModifiedException {
		
		AbstractAnnotationDB db = null;
		String annotationId = null;
		
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			annotationId = db.createAnnotation(new Annotation(annotation));
			annotation = db.findAnnotationById(annotationId).toString();
		} catch(AnnotationNotFoundException e) {
			throw new AnnotationDatabaseException(e);
		} finally {
			if (db != null) db.disconnect();
		}
		return Response.created(URIBuilder.toURI(annotationId)).entity(annotation).build();
	}
	
	/**
	 * Update an existing annotation
	 * @param annotationId the annotation ID 
	 * @param annotation the JSON representation of the annotation
	 * @return status code 200 and updated annotation representation
	 * @throws AnnotationDatabaseException (500)
	 * @throws AnnotationFormatException (415)
	 * @throws AnnotationHasReplyException (409)
	 * @throws UnsupportedEncodingException (500)
	 */
	protected Response updateAnnotation(String annotationId, String annotation)
			throws AnnotationDatabaseException, AnnotationFormatException, AnnotationHasReplyException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			annotationId = db.updateAnnotation(URLDecoder.decode(annotationId, URL_ENCODING), new Annotation(annotation));
			annotation = db.findAnnotationById(annotationId).toString();
		} catch(AnnotationNotFoundException anfe) {
			throw new AnnotationDatabaseException(anfe);
		} finally {
			if(db != null) db.disconnect();
		}	
		return Response.ok().entity(annotation.toString()).header("Location", URIBuilder.toURI(annotationId)).build(); 
	}
	
	/**
	 * Delete an annotation
	 * @param annotationId the annotation ID
	 * @return status code 204
	 * @throws AnnotationDatabaseException (500)
	 * @throws UnsupportedEncodingException (500)
	 * @throws AnnotationHasReplyException (409)
	 * @throws AnnotationNotFoundException (404)
	 */
	protected Response deleteAnnotation(String annotationId)
		throws AnnotationDatabaseException, AnnotationHasReplyException, UnsupportedEncodingException, AnnotationNotFoundException {
		
		AbstractAnnotationDB db = null;
		try {			
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			db.deleteAnnotation(URLDecoder.decode(annotationId, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}	
		
		// response to DELETE without a body should return 204 NO CONTENT see 
		// http://www.w3.org/Protocols/rfc2616/rfc2616.html
		return Response.noContent().build(); 
	}
	
	/**
	 * List annotation threads for the given object
	 * @param objectId the object ID
	 * @return status code 200 and the representation of the found annotations
	 * @throws AnnotationDatabaseException (500)
	 * @throws AnnotationFormatException (415)
	 * @throws UnsupportedEncodingException (500)
	 */
	protected Response listAnnotationThreads(String objectId)
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		List<AnnotationThread> threads = null;
		
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			threads = db.listAnnotationThreads(URLDecoder.decode(objectId, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}
		return Response.ok().entity(JSON.serialize(threads)).build();
	}
	
	/**
	 * Count annotations for the given object
	 * @param objectId the object ID
	 * @return status code and count representation
	 * @throws AnnotationDatabaseException (500)
	 * @throws UnsupportedEncodingException (500
	 */
	protected Response countAnnotations(String objectId)
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		long count = 0;
		
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			count = db.countAnnotations(URLDecoder.decode(objectId, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}
		return Response.ok().entity(count).build();
	}
		
	/**
	 * Find an annotation by its ID
	 * @param annotationId the annotation ID
	 * @return status code 200 and found annotation
	 * @throws AnnotationDatabaseException (500)
	 * @throws UnsupportedEncodingException (500
	 */
	protected Response findAnnotationById(String annotationId)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		Annotation annotation = null;
		
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			annotation = db.findAnnotationById(URLDecoder.decode(annotationId, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}
		return Response.ok(annotation.toString()).build();
	}

	/**
	 * Retrieve the thread which contains the given annotation
	 * @param annotationId the annotation ID
	 * @return status code 200 and representation of the annotation thread
	 * @throws AnnotationDatabaseException (500)
	 * @throws UnsupportedEncodingException (500
	 */
	protected Response findThreadForAnnotation(String annotationId)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		AnnotationThread thread = null;
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			thread = db.findThreadForAnnotation(URLDecoder.decode(annotationId, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}
		return Response.ok().entity(thread.toString()).build();
	}
		
	/**
	 * Find annotations that match the given search term
	 * @param query the query term
	 * @return status code 200 and found annotations
	 * @throws AnnotationDatabaseException (500)
	 * @throws UnsupportedEncodingException (500
	 */
	protected Response findAnnotations(String query)
		throws AnnotationDatabaseException, UnsupportedEncodingException {
		
		AbstractAnnotationDB db = null;
		List<Annotation> annotations = null;		
		
		try {
			db = Config.getInstance().getAnnotationDatabase();
			db.connect(request);
			annotations = db.findAnnotations(URLDecoder.decode(query, URL_ENCODING));
		} finally {
			if(db != null) db.disconnect();
		}
		return Response.ok(annotations).build();
	}
}
