package at.ait.dme.yuma.server.controller.formats;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.util.JSON;

import at.ait.dme.yuma.server.exception.InvalidAnnotationException;
import at.ait.dme.yuma.server.model.AnnotationType;
import at.ait.dme.yuma.server.model.Annotation;
import at.ait.dme.yuma.server.model.Scope;
import at.ait.dme.yuma.server.model.MapKeys;
import at.ait.dme.yuma.server.model.SemanticRelation;
import at.ait.dme.yuma.server.model.SemanticTag;

/**
 * Format handler for JSON.
 * 
 * @author Rainer Simon
 */
public class JSONFormatHandler implements FormatHandler {
	
	@Override
	public Annotation parse(String serialized)
		throws InvalidAnnotationException {
		
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) JSON.parse(serialized);
			
			// Convert map from JSON to annotation format
			String type = (String) map.get(MapKeys.ANNOTATION_TYPE);
			if (type != null)
				map.put(MapKeys.ANNOTATION_TYPE, AnnotationType.fromString(type));

			String scope = (String) map.get(MapKeys.ANNOTATION_SCOPE);
			if (scope != null)
				map.put(MapKeys.ANNOTATION_SCOPE, Scope.fromString(scope));
			
			@SuppressWarnings("unchecked")
			List<HashMap<String, Object>> tags =
				(List<HashMap<String, Object>>) map.get(MapKeys.ANNOTATION_SEMANTIC_TAGS);
			if (tags != null) {
				map.put(MapKeys.ANNOTATION_SEMANTIC_TAGS, toAnnotationFormat(tags));
			}
			
			return new Annotation(map);
		} catch (Throwable t) {
			throw new InvalidAnnotationException();
		}
	}

	private List<SemanticTag> toAnnotationFormat(List<HashMap<String, Object>> jsonFormat) throws InvalidAnnotationException {
		ArrayList<SemanticTag> tags = new ArrayList<SemanticTag>();
		
		for (HashMap<String, Object> map : jsonFormat) {
			String uri = (String) map.get(MapKeys.TAG_URI);
			if (uri != null) {
				try {
					map.put(MapKeys.TAG_URI, new URI(uri));
				} catch (URISyntaxException e) {
					throw new InvalidAnnotationException(e);
				}
			}

			@SuppressWarnings("unchecked")
			Map<String, String> relation = (Map<String, String>) map.get(MapKeys.TAG_RELATION);
			if (relation != null)
				map.put(MapKeys.TAG_RELATION, new SemanticRelation(relation));
			
			tags.add(new SemanticTag(map));
		}
		
		return tags;
	}

	
	@Override
	public String serialize(Annotation annotation) {
		return JSON.serialize(toJSONFormat(annotation));
	}

	@Override
	public String serialize(List<Annotation> annotations) {
		ArrayList<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
		
		for (Annotation annotation : annotations) {
			maps.add(toJSONFormat(annotation));
		}
		
		return JSON.serialize(maps);
	}
	
	private Map<String, Object> toJSONFormat(Annotation annotation) {
		Map<String, Object> map = annotation.toMap();
		
		AnnotationType type = (AnnotationType) map.get(MapKeys.ANNOTATION_TYPE);
		map.put(MapKeys.ANNOTATION_TYPE, type.toString());

		Scope scope = (Scope) map.get(MapKeys.ANNOTATION_SCOPE);
		map.put(MapKeys.ANNOTATION_SCOPE, scope.toString());

		@SuppressWarnings("unchecked")
		List<SemanticTag> tags = (List<SemanticTag>) map.get(MapKeys.ANNOTATION_SEMANTIC_TAGS);
		map.put(MapKeys.ANNOTATION_SEMANTIC_TAGS, toJSONFormat(tags));
		
		return map;
	}
	
	private ArrayList<Map<String, Object>> toJSONFormat(List<SemanticTag> tags) {
		ArrayList<Map<String, Object>> maps = new ArrayList<Map<String,Object>>();
		
		for (SemanticTag tag : tags) {
			Map<String, Object> map = tag.toMap();
			
			URI uri = (URI) map.get(MapKeys.TAG_URI);
			map.put(MapKeys.TAG_URI, uri.toString());
			
			SemanticRelation relation = (SemanticRelation) map.get(MapKeys.TAG_RELATION);
			if (relation != null)
				map.put(MapKeys.TAG_RELATION, relation.toMap());
		}
		
		return maps;
	}
		
}
