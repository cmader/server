package at.ait.dme.yuma.server.gui.documentation;

import org.apache.wicket.PageParameters;

import at.ait.dme.yuma.server.gui.BaseTextPage;

public class API extends BaseTextPage {
	
	public API(final PageParameters parameters) {
    	super(parameters);
    	
    	setTitle("YUMA Annotation Server - Documentation - API");
		setHeading("yuma server > documentation");
		setNavbar(new DocumentationNavbar(API.class));
    }

}
