package at.ait.dme.yuma.server.controller;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import at.ait.dme.yuma.server.controller.formats.JSONFormatHandler;
import at.ait.dme.yuma.server.exception.AnnotationDatabaseException;
import at.ait.dme.yuma.server.exception.InvalidAnnotationException;
import at.ait.dme.yuma.server.exception.AnnotationHasReplyException;
import at.ait.dme.yuma.server.exception.AnnotationModifiedException;
import at.ait.dme.yuma.server.exception.AnnotationNotFoundException;

/**
 * The primary annotation controller which consumes and
 * produces JSON representations of annotations and 
 * annotation threads.
 *  
 * @author Rainer Simon
 */
@Path("/json")
public class JSONAnnotationController extends AbstractAnnotationController {

	@POST
	@Consumes("application/json")
	public Response createAnnotation(String annotation)
		throws AnnotationDatabaseException, InvalidAnnotationException, AnnotationModifiedException {
		
		return super.createAnnotation(annotation, new JSONFormatHandler());
	}
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Response findAnnotationById(@PathParam("id") String id)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		return super.findAnnotationById(id, new JSONFormatHandler());
	}
	
	@PUT
	@Consumes("application/json")
	@Path("/{id}")
	public Response updateAnnotation(@PathParam("id") String id, String annotation) 
			throws AnnotationDatabaseException, InvalidAnnotationException, AnnotationHasReplyException, UnsupportedEncodingException {
		
		return super.updateAnnotation(id, annotation, new JSONFormatHandler());
	}
	
	@DELETE
	@Path("/{id}")

	public Response deleteAnnotation(@PathParam("id") String id) 
			throws AnnotationDatabaseException, AnnotationHasReplyException, UnsupportedEncodingException, AnnotationNotFoundException {
		
		return super.deleteAnnotation(id);
	}
	
}
