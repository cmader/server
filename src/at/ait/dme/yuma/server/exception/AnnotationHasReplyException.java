package at.ait.dme.yuma.server.exception;

/**
 * This exception indicates that an annotation cannot be changed because
 * it has already been referenced.
 * 
 * @author Christian Sadilek
 *
 */
public class AnnotationHasReplyException extends Exception {
	private static final long serialVersionUID = 3843311695698544428L;

	public AnnotationHasReplyException() {		
		super("annotation already referenced");
	}

	public AnnotationHasReplyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnnotationHasReplyException(String message) {
		super(message);
	}

	public AnnotationHasReplyException(Throwable cause) {
		super(cause);
	}
}