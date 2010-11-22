package at.ait.dme.yuma.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import at.ait.dme.yuma.server.exception.InvalidAnnotationException;

/**
 * The annotation.
 * 
 * @author Rainer Simon
 */
public class Annotation {
	
	/**
	 * The ID if this annotation
	 *  
	 * AUTO-GENERATED BY THE DB
	 */
	private String annotationId;	
	
	/**
	 * The ID of the root annotation, if this annotation
	 * is a reply. A root annotation is the first annotation
	 * in an annotation thread and does not have a root or
	 * parent ID itself.
	 *  
	 * OPTIONAL (only for replies)
	 */
	private String rootId;
	
	/**
	 * The ID of the parent annotation, if this annotation
	 * is a reply. 
	 * 
	 * OPTIONAL (only for replies)
	 */
	private String parentId;
	
	/**
	 * The ID of the object which this annotation 
	 * annotates.
	 * 
	 * MANDATORY
	 */
	private String objectId;
	
	/**
	 * Date and time of creation
	 * 
	 * MANDATORY
	 */
	private Date created;
	
	/**
	 * Date and time of last modification
	 * 
	 * MANDATORY
	 */
	private Date lastModified;
	
	/**
	 * The username of the creator
	 * 
	 * MANDATORY
	 */
	private String createdBy;
	
	/**
	 * The title of this annotation
	 * 
	 * OPTIONAL
	 */
	private String title;
	
	/**
	 * The text of this annotation
	 * 
	 * OPTIONAL
	 */
	private String text;
	
	/**
	 * The type of this annotation
	 * 
	 * MANDATORY
	 */
	private AnnotationType type;
	
	/**
	 * The media fragment this annotation annotates
	 * 
	 * OPTIONAL
	 */
	private String fragment;
	
	/**
	 * The scope of this annotation
	 * 
	 * MANDATORY
	 */
	private Scope scope;
	
	/**
	 * This annotation's tags
	 * 
	 * MANDATORY (but size may be 0)
	 */
	private ArrayList<SemanticTag> tags;
	
	/**
	 * Creates a new annotation with the specified properties.
	 * @param map the annotation properties
	 */
	@SuppressWarnings("unchecked")
	public Annotation(Map<String, Object> map) throws InvalidAnnotationException {
		try {
			this.annotationId = (String) map.get(MapKeys.ANNOTATION_ID);
			this.rootId = (String) map.get(MapKeys.ANNOTATION_ROOT_ID);
			this.parentId = (String) map.get(MapKeys.ANNOTATION_PARENT_ID);
			this.objectId = (String) map.get(MapKeys.ANNOTATION_OBJECT_ID);
			this.created = (Date) map.get(MapKeys.ANNOTATION_CREATED);
			this.lastModified = (Date) map.get(MapKeys.ANNOTATION_LAST_MODIFIED);
			this.createdBy = (String) map.get(MapKeys.ANNOTATION_CREATED_BY);
			this.title = (String) map.get(MapKeys.ANNOTATION_TITLE);
			this.text = (String) map.get(MapKeys.ANNOTATION_TEXT);
			this.type = (AnnotationType) map.get(MapKeys.ANNOTATION_TYPE);
			this.fragment = (String) map.get(MapKeys.ANNOTATION_FRAGMENT);
			this.scope = (Scope) map.get(MapKeys.ANNOTATION_SCOPE);
			this.tags = (ArrayList<SemanticTag>) map.get(MapKeys.ANNOTATION_SEMANTIC_TAGS);
			if (this.tags == null)
				tags = new ArrayList<SemanticTag>();
		} catch (Throwable t) {
			throw new InvalidAnnotationException(t);
		}		
		
		// Verify mandatory properties are set
		if (this.getObjectID() == null)
			throw new InvalidAnnotationException("ObjectID may not be null");

		if (this.getCreated() == null)
			throw new InvalidAnnotationException("Creation timestamp may not be null");
		
		if (this.getLastModified() == null)
			throw new InvalidAnnotationException("Last modification timestamp may not be null");
		
		if (this.getCreatedBy() == null)
			throw new InvalidAnnotationException("Creator user name may not be null");
		
		if (this.getType() == null)
			throw new InvalidAnnotationException("Annotation type may not be null");

		if (this.getScope() == null)
			throw new InvalidAnnotationException("Annotation scope may not be null");
	}
	
	public String getAnnotationID() {
		return annotationId;
	}

	public String getRootId() {
		return rootId;
	}

	public String getParentId() {
		return parentId;
	}

	public String getObjectID() {
		return objectId;
	}

	public Date getCreated() {
		return created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}
	
	public AnnotationType getType() {
		return type;
	}

	public String getFragment() {
		return fragment;
	}

	public Scope getScope() {
		return scope;
	}

	public List<SemanticTag> getTags() {
		return tags;
	}
	
	public Map<String, Object> toMap() {
		// TODO optimize! might make more sense to store all this in a map
		// right from the start; deep cloning might be a problem then, though
		
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put(MapKeys.ANNOTATION_ID, annotationId);
		map.put(MapKeys.ANNOTATION_ROOT_ID, rootId);
		map.put(MapKeys.ANNOTATION_PARENT_ID, parentId);
		map.put(MapKeys.ANNOTATION_OBJECT_ID, objectId);
		map.put(MapKeys.ANNOTATION_CREATED, created);
		map.put(MapKeys.ANNOTATION_LAST_MODIFIED, lastModified);
		map.put(MapKeys.ANNOTATION_CREATED_BY, createdBy);
		map.put(MapKeys.ANNOTATION_TITLE, title);
		map.put(MapKeys.ANNOTATION_TEXT, text);
		map.put(MapKeys.ANNOTATION_TYPE, type);
		map.put(MapKeys.ANNOTATION_FRAGMENT, fragment);
		map.put(MapKeys.ANNOTATION_SCOPE, scope);
		map.put(MapKeys.ANNOTATION_SEMANTIC_TAGS, tags);
		
		return map;
	}
	
	@Override
	public boolean equals(Object other) {		
		// TODO implement hashCode()
		
		if (!(other instanceof Annotation))
			return false;
		
		Annotation a = (Annotation) other;
		
		// Compare mandatory properties
		if (!a.getObjectID().equals(this.getObjectID()))
			return false;

		if (!a.getCreated().equals(this.getCreated()))
			return false;
		
		if (!a.getLastModified().equals(this.getLastModified()))
			return false;
		
		if (!a.getCreatedBy().equals(this.getCreatedBy()))
			return false;
		
		if (!a.getType().equals(this.getType()))
			return false;

		if (!a.getScope().equals(this.getScope()))
			return false;
		
		// Compare optional properties (may be null!)
		if (!equalsNullable(a.getRootId(), this.getRootId()))
			return false;
	
		if (!equalsNullable(a.getParentId(), this.getParentId()))
			return false;
						
		if (!equalsNullable(a.getTitle(), this.getTitle()))
			return false;
		
		if (!equalsNullable(a.getText(), this.getText()))
			return false;
		
		if (!equalsNullable(a.getFragment(), this.getFragment()))
			return false;
				
		
		List<SemanticTag> myTags = this.getTags();
		List<SemanticTag> othersTags = a.getTags();
		
		if (myTags.size() != othersTags.size())
			return false;
	
		if (!myTags.containsAll(othersTags))
			return false;
		
		if (!othersTags.containsAll(myTags))
			return false;
		
		return true;
	}
		
	private boolean equalsNullable(Object a, Object b) {
		if (a == null)
			return b == null;
		
		if (b == null)
			return a == null;
		
		return a.equals(b);
	}
	
}
