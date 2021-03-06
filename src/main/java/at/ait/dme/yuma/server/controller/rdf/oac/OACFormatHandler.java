package at.ait.dme.yuma.server.controller.rdf.oac;

import at.ait.dme.yuma.server.URIBuilder;
import at.ait.dme.yuma.server.controller.rdf.RDFFormatHandler;
import at.ait.dme.yuma.server.controller.rdf.SerializationLanguage;
import at.ait.dme.yuma.server.model.Annotation;

import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

/**
 * Format handler for OAC RDF(in different serialization
 * languages).
 * 
 * @author Rainer Simon
 */
public class OACFormatHandler extends RDFFormatHandler {
	
	public static final String NS_OAC = "http://www.openannotation.org/ns/";
	
	private Annotation annotation;
	private Model model;
	
	public OACFormatHandler() {
		super(SerializationLanguage.RDF_XML);
	}

	@Override
	public Annotation parse(String serialized) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void addRDFResource(Annotation annotation, Model model) {
		this.annotation = annotation;
		this.model = model;
		
		model.setNsPrefix("oac", NS_OAC);
		
		Resource body = createBodyResource();
		createAnnotationResource(body);
	}
	
	private Resource createBodyResource() {
		Resource body = model.createResource(AnonId.create());
		
		body.addProperty(RDF.type, model.createProperty(NS_OAC, "Body"));
		new BodyPropertiesAppender(body, model).appendProperties(annotation);
		
		return body;
	}
	
	private Resource createAnnotationResource(Resource body) {
		Resource ret = model.createResource(
			URIBuilder.toURI(annotation.getAnnotationID()).toString());
		
		addBasicProperties(ret, body);
		new AnnotationPropertiesAppender(ret).appendProperties(annotation);
		return ret;
	}
	
	private void addBasicProperties(Resource annotResource, Resource body)
	{
		annotResource.addProperty(RDF.type, model.createProperty(NS_OAC, "Annotation"));
		annotResource.addProperty(
			model.createProperty(NS_OAC, "hasBody"), 
			body);
		annotResource.addProperty(
			model.createProperty(NS_OAC, "hasTarget"),
			createTarget());		
	}
	
	private Resource createTarget() {
		if (annotation.getFragment() == null) {
			return model.createResource(annotation.getObjectUri().toString());
		}
		else {
			return createConstrainedTarget();
		}
	}
	
	private Resource createConstrainedTarget() {
		Resource target = model.createResource(AnonId.create());
		
		target.addProperty(RDF.type, model.createProperty(NS_OAC, "ConstrainedTarget"));
		new TargetPropertiesAppender(target, model).appendProperties(annotation);
		
		return target;

	}

}
