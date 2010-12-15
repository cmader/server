package at.ait.dme.yuma.server.controller.rss;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import at.ait.dme.yuma.server.bootstrap.Data;
import at.ait.dme.yuma.server.controller.FormatHandler;
import at.ait.dme.yuma.server.controller.json.JSONFormatHandler;
import at.ait.dme.yuma.server.model.Annotation;

public class RSSFormatHandlerTest {

	private static List<Annotation> annotations;
	
	@BeforeClass
	public static void setUp() throws Exception {	
		FormatHandler jsonFormat = new JSONFormatHandler();
		annotations = new ArrayList<Annotation>();
		annotations.add(jsonFormat.parse(Data.ANNOTATION_JSON_UPDATE));
	}
	
	@Test
	public void testRSSSerialization() {
		FormatHandler rssFormat = new RSSFormatHandler(
			"YUMA Test Feed",
			"This is just a dummy feed generated by the unit test",
			"http://localhost:8080/yuma-server/feeds/test"
		);
		String rss = rssFormat.serialize(annotations);
		System.out.println(rss);
	}
	
}