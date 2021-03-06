package at.ait.dme.yuma.server.db.europeana;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import at.ait.dme.yuma.server.db.AbstractAnnotationDB;
import at.ait.dme.yuma.server.exception.AnnotationDatabaseException;
import at.ait.dme.yuma.server.exception.AnnotationHasReplyException;
import at.ait.dme.yuma.server.exception.AnnotationModifiedException;
import at.ait.dme.yuma.server.exception.AnnotationNotFoundException;
import at.ait.dme.yuma.server.exception.InvalidAnnotationException;
import at.ait.dme.yuma.server.model.Annotation;
import at.ait.dme.yuma.server.model.AnnotationTree;

/**
 * Adapter class that implements an AbstractAnnotationDB
 * front-end to the remote Europeana Annotation API.
 * 
 * @author Rainer Simon
 */
public class EuropeanaDB extends AbstractAnnotationDB {

	@Override
	public void init() throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect(HttpServletRequest request) {
		// 
	}

	@Override
	public void disconnect() {
		// 
	}

	@Override
	public void commit() {
		// 
	}

	@Override
	public void rollback() {
		//
	}

	@Override
	public String createAnnotation(Annotation annotation)
			throws AnnotationDatabaseException, AnnotationModifiedException,
			InvalidAnnotationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAnnotation(String annotationId, Annotation annotation)
			throws AnnotationDatabaseException, AnnotationNotFoundException,
			AnnotationHasReplyException, InvalidAnnotationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAnnotation(String annotationId)
			throws AnnotationDatabaseException, AnnotationNotFoundException,
			AnnotationHasReplyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnnotationTree findAnnotationsForObject(String objectUri)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAnnotationsForObject(String objectUri)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Annotation> findAnnotationsForUser(String username)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annotation findAnnotationById(String annotationId)
			throws AnnotationDatabaseException, AnnotationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countReplies(String annotationId)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AnnotationTree getReplies(String annotationId)
			throws AnnotationDatabaseException, AnnotationNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annotation> getMostRecent(int n, boolean publicOnly)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annotation> findAnnotations(String query)
			throws AnnotationDatabaseException {
		// TODO Auto-generated method stub
		return null;
	}

}
