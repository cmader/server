package at.ait.dme.yuma.server.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import at.ait.dme.yuma.server.exception.AnnotationModifiedException;

@Provider
public class AnnotationModifiedExceptionMapper 
	implements ExceptionMapper<AnnotationModifiedException> {

	@Override
	public Response toResponse(AnnotationModifiedException ame) {
		return Response.status(Status.CONFLICT).entity(ame.getMessage()).build();
	}
}
