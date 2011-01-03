package at.ait.dme.yuma.server.controller.lemo;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import at.ait.dme.yuma.server.controller.AbstractAnnotationController;
import at.ait.dme.yuma.server.exception.AnnotationDatabaseException;
import at.ait.dme.yuma.server.exception.AnnotationHasReplyException;
import at.ait.dme.yuma.server.exception.AnnotationModifiedException;
import at.ait.dme.yuma.server.exception.AnnotationNotFoundException;
import at.ait.dme.yuma.server.exception.InvalidAnnotationException;

/**
 * An annotation controller which produces an RDF/XML
 * representations of annotations based on the 
 * LEMO RDF annotation model.
 * 
 * @author Rainer Simon
 */
public class LEMOAnnotationController extends AbstractAnnotationController {

	@POST
	@Consumes("application/rdf+xml")
	@Path("/annotation")
	public Response createAnnotation(String annotation)
		throws AnnotationDatabaseException, InvalidAnnotationException, AnnotationModifiedException {
		
		return super.createAnnotation(annotation, new LEMOFormatHandler());
	}
	
	@PUT
	@Consumes("application/rdf+xml")
	@Path("/annotation/{id}")
	public Response updateAnnotation(@PathParam("id") String id, String annotation) 
			throws AnnotationDatabaseException, InvalidAnnotationException, AnnotationHasReplyException, UnsupportedEncodingException {
		
		return super.updateAnnotation(id, annotation, new LEMOFormatHandler());
	}
	
	@GET
	@Produces("application/rdf+xml")
	@Path("/annotation/{id}")
	public Response getAnnotationXML(@PathParam("id") String id)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		return super.getAnnotation(id, new LEMOFormatHandler());
	}

	@GET
	@Produces("application/x-turtle")
	@Path("/annotation/{id}")
	public Response getAnnotationTurtle(@PathParam("id") String id)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		return super.getAnnotation(id, new LEMOFormatHandler(LEMOFormatHandler.TURTLE));
	}
	
	@GET
	@Produces("application/rdf+xml")
	@Path("/tree/{objectId}")
	public Response getAnnotationTreeXML(@PathParam("objectId") String objectId)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		return super.getAnnotationTree(objectId, new LEMOFormatHandler());
	}
	
	@GET
	@Produces("application/x-turtle")
	@Path("/tree/{objectId}")
	public Response getAnnotationTreeTurtle(@PathParam("objectId") String objectId)
		throws AnnotationDatabaseException, AnnotationNotFoundException, UnsupportedEncodingException {
		
		return super.getAnnotationTree(objectId, new LEMOFormatHandler(LEMOFormatHandler.TURTLE));
	}
	
}
