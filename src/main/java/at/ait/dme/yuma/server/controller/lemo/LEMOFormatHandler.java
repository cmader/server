package at.ait.dme.yuma.server.controller.lemo;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.DC;
import com.hp.hpl.jena.vocabulary.RDF;

import at.ait.dme.yuma.server.URIBuilder;
import at.ait.dme.yuma.server.controller.FormatHandler;
import at.ait.dme.yuma.server.exception.InvalidAnnotationException;
import at.ait.dme.yuma.server.model.Annotation;
import at.ait.dme.yuma.server.model.AnnotationTree;
import at.ait.dme.yuma.server.model.MediaType;
import at.ait.dme.yuma.server.model.MapKeys;
import at.ait.dme.yuma.server.model.Scope;
import at.ait.dme.yuma.server.model.SemanticRelation;
import at.ait.dme.yuma.server.model.SemanticTag;

/**
 * Format handler for LEMO RDF format (in different serialization
 * languages).
 * 
 * TODO Finish this!
 * 
 * @author Rainer Simon
 */
public class LEMOFormatHandler implements FormatHandler {
	
	public static final String RDF_XML = "RDF/XML";
	public static final String N3 = "N3";
	public static final String N_TRIPLE = "N-TRIPLE";
	public static final String TURTLE = "TURTLE";
	
	private static final String NS_ANNOTATION = "http://lemo.mminf.univie.ac.at/annotation-core#";
	private static final String NS_SCOPE = "http://lemo.mminf.univie.ac.at/ann-tel#";

	private String serializationLanguage;
	
	/**
	 * Creates a LEMO RDF format handler with the default
	 * serialization (RDF/XML)
	 */
	public LEMOFormatHandler() {
		this.serializationLanguage = RDF_XML;
	}
	
	/**
	 * Creates a LEMO RDF format handler with the specified
	 * RDF serialization language
	 * @param language the language
	 */
	public LEMOFormatHandler(String language) {
		this.serializationLanguage = language;
	}
	
	@Override
	public Annotation parse(String serialized)
		throws InvalidAnnotationException {
		
		Model m = ModelFactory.createDefaultModel();
		m.read(new StringReader(serialized), null);
		
		HashMap<String, Object> properties = new HashMap<String, Object>();
		
		ResIterator it =
			m.listResourcesWithProperty(m.createProperty(NS_ANNOTATION, "annotates"));
		
		if (it.hasNext()) {
			Resource a = it.next();
			
			properties.put(MapKeys.ANNOTATION_ID,
					URIBuilder.toID(a.getURI()));
			
			properties.put(MapKeys.ANNOTATION_OBJECT_URI, 
					a.getProperty(m.createProperty(NS_ANNOTATION, "annotates")).getString());
			
			properties.put(MapKeys.ANNOTATION_CREATED_BY,
					a.getProperty(DC.creator).getString());
			
			properties.put(MapKeys.ANNOTATION_CREATED,
					new Date());
			
			properties.put(MapKeys.ANNOTATION_LAST_MODIFIED,
					new Date());
			
			properties.put(MapKeys.ANNOTATION_TYPE,
					MediaType.IMAGE);
			
			properties.put(MapKeys.ANNOTATION_SCOPE,
					Scope.valueOf(a.getProperty(m.createProperty(NS_SCOPE, "scope")).getString()));
			
			properties.put(MapKeys.ANNOTATION_TITLE,
					a.getProperty(DC.title).getString());
			
			properties.put(MapKeys.ANNOTATION_TEXT,
					a.getProperty(m.createProperty(NS_ANNOTATION, "label")).getString());	
		}
				
		return new Annotation(properties);
	}

	@Override
	public String serialize(Annotation a) {
		Model m = ModelFactory.createDefaultModel();

		addRDFResource(a, m);
		
		return toString(m);
	}

	@Override
	public String serialize(AnnotationTree tree) {
		return serialize(tree.asFlatList());
	}

	@Override
	public String serialize(List<Annotation> annotations) {
		Model m = ModelFactory.createDefaultModel();
		
		for (Annotation a : annotations) {
			addRDFResource(a, m);
		}

		return toString(m);
	}
	
	private void addRDFResource(Annotation a, Model m) {
		m.setNsPrefix("a", NS_ANNOTATION);
		m.setNsPrefix("scope", NS_SCOPE);
		
		Resource annotation = m.createResource(URIBuilder.toURI(a.getAnnotationID()).toString());		
		
		annotation.addProperty(m.createProperty(NS_ANNOTATION, "annotates"), a.getObjectUri());
		annotation.addProperty(RDF.type, m.createProperty(NS_ANNOTATION, "Annotation"));
		annotation.addProperty(DC.title, a.getTitle());
		annotation.addProperty(DC.creator, a.getCreatedBy());
		annotation.addProperty(m.createProperty(NS_ANNOTATION, "created"), a.getCreated().toString());
		annotation.addProperty(m.createProperty(NS_ANNOTATION, "modified"), a.getLastModified().toString());
		annotation.addProperty(m.createProperty(NS_ANNOTATION, "label"), a.getText());
		annotation.addProperty(m.createProperty(NS_SCOPE, "scope"), a.getScope().name());
		
		for (SemanticTag t : a.getTags()) {
			SemanticRelation r = t.getRelation();
			annotation.addProperty(m.createProperty(r.getNamespace(), r.getProperty()), t.getURI().toString());
		}
	}
	
	private String toString(Model m) {
		StringWriter sw = new StringWriter();
		m.write(sw, serializationLanguage);
		return sw.toString();
	}
	
}