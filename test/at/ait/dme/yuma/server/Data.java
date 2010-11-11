package at.ait.dme.yuma.server;

public class Data {
	public static final String LEMO_ANNOTATION = "" +
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	"<rdf:RDF xmlns:a=\"http://lemo.mminf.univie.ac.at/annotation-core#\" " +
		"xmlns:ann=\"http://www.w3.org/2000/10/annotation-ns#\" " +
		"xmlns:scope=\"http://lemo.mminf.univie.ac.at/ann-tel#\" " +
		"xmlns:image=\"http://lemo.mminf.univie.ac.at/annotation-image#\" " +
		"xmlns:video=\"http://lemo.mminf.univie.ac.at/annotation-video#\" " +
		"xmlns:rel=\"http://lemo.mminf.univie.ac.at/ann-relationship#\" " +
		"xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
		"xmlns:h=\"http://www.w3.org/1999/xx/http#\" " +
		"xmlns:tr=\"http://www.w3.org/2001/03/thread#\" " +
		"xmlns:svg=\"http://www.w3.org/2000/svg\" " +
		"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" " +
		"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> " +
		"<rdf:Description>" +
		"<image:svg-fragment rdf:parseType=\"Literal\"> " +
				"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" width=\"640px\" height=\"480px\" viewbox=\"0px 0px 640px 480px\"> " +
					"<svg:defs xmlns:svg=\"http://www.w3.org/2000/svg\"> " +
						"<svg:symbol xmlns:svg=\"http://www.w3.org/2000/svg\" id=\"Polygon\"> " +
						"<svg:polygon xmlns:svg=\"http://www.w3.org/2000/svg\" " +
						"points=\"0,24 45,22 45,32 49,32 49,23 190,20 285,19 193,0 119,17 48,5\" stroke=\"rgb(229,0,0)\" " +
						"stroke-width=\"2\" fill=\"none\"> " +
						"</svg:polygon> " +
						"</svg:symbol> " +
					"</svg:defs>" +
					"<svg:image xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					" xlink:href=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\" x=\"-38px\" y=\"-16px\" " +
					"width=\"715px\" height=\"536px\" preserveAspectRatio=\"none\"> " +
					"</svg:image> " +
					"<svg:use xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					"xlink:href=\"#Polygon\" x=\"334px\" y=\"252px\" width=\"285px\" height=\"32px\"> " +
					"</svg:use> " +
				"</svg:svg> " +
		"</image:svg-fragment> " +
		"<rdf:type rdf:resource=\"http://www.w3.org/2000/10/annotationType#Comment\"/> " +
		"<a:annotates rdf:resource=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\"/> " +
		"<rdf:type rdf:resource=\"http://lemo.mminf.univie.ac.at/annotation-core#Annotation\"/> " +
		"<ann:body> " +
		"<rdf:Description> " +
		"<h:Body rdf:parseType=\"Literal\"><html><head><title>Ponte 25 de Abril</title></head><body>text " +
			"text text lisbon</body></html> " +
		"</h:Body> " +
		"<h:ContentType>text/html</h:ContentType> " +
		"<h:ContentLength>653</h:ContentLength> " +
		"</rdf:Description> " +
		"</ann:body> " +
		"<dc:creator>csa1980</dc:creator> " +
		"<a:author>csa1980</a:author> " +
		"<a:author>rsmion</a:author> " +		
		"<scope:scope>public</scope:scope> " +
		"<dc:title>Ponte 25 de Abril</dc:title> " +
		"<a:created>2008-11-19T15:20:42+01:00</a:created> " +
		"<dc:date>2008-11-19T18:11:03+01:00</dc:date> " +
		"<dc:format>image/jpeg</dc:format> " +
		"<a:modified>2008-11-19T18:11:03+01:00</a:modified> " +
		"<a:fragment>http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg#mp(~region(polygon(334,276,45,-2,0,10,4,0,0,-9,141,-3,95,-1,-92,-19,-74,17,-71,-12)))</a:fragment> " +
		"<a:label>text text text lisbon</a:label> " +
		"<rel:isLinkedTo>someexternalobject</rel:isLinkedTo>"+
		"<rel:isLinkedToResources rdf:parseType=\"Literal\">vienna</rel:isLinkedToResources>"+		
		"</rdf:Description> " +
		"</rdf:RDF>";
	
	public static final String LEMO_ANNOTATION_REPLY = "" +
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	"<rdf:RDF xmlns:a=\"http://lemo.mminf.univie.ac.at/annotation-core#\" " +
		"xmlns:ann=\"http://www.w3.org/2000/10/annotation-ns#\" " +
		"xmlns:scope=\"http://lemo.mminf.univie.ac.at/ann-tel#\" " +
		"xmlns:image=\"http://lemo.mminf.univie.ac.at/annotation-image#\" " +
		"xmlns:video=\"http://lemo.mminf.univie.ac.at/annotation-video#\" " +
		"xmlns:rel=\"http://lemo.mminf.univie.ac.at/ann-relationship#\" " +
		"xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
		"xmlns:h=\"http://www.w3.org/1999/xx/http#\" " +
		"xmlns:tr=\"http://www.w3.org/2001/03/thread#\" " +
		"xmlns:svg=\"http://www.w3.org/2000/svg\" " +
		"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" " +
		"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> " +
		"<rdf:Description>" +
		"<tr:root rdf:resource=\"$ID\"/> " +
		"<tr:inReplyTo rdf:resource=\"$ID\"/> " +
		"<image:svg-fragment rdf:parseType=\"Literal\"> " +
				"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" width=\"640px\" height=\"480px\" viewbox=\"0px 0px 640px 480px\"> " +
					"<svg:defs xmlns:svg=\"http://www.w3.org/2000/svg\"> " +
						"<svg:symbol xmlns:svg=\"http://www.w3.org/2000/svg\" id=\"Polygon\"> " +
						"<svg:polygon xmlns:svg=\"http://www.w3.org/2000/svg\" " +
						"points=\"0,24 45,22 45,32 49,32 49,23 190,20 285,19 193,0 119,17 48,5\" stroke=\"rgb(229,0,0)\" " +
						"stroke-width=\"2\" fill=\"none\"> " +
						"</svg:polygon> " +
						"</svg:symbol> " +
					"</svg:defs>" +
					"<svg:image xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					" xlink:href=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\" x=\"-38px\" y=\"-16px\" " +
					"width=\"715px\" height=\"536px\" preserveAspectRatio=\"none\"> " +
					"</svg:image> " +
					"<svg:use xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					"xlink:href=\"#Polygon\" x=\"334px\" y=\"252px\" width=\"285px\" height=\"32px\"> " +
					"</svg:use> " +
				"</svg:svg> " +
		"</image:svg-fragment> " +
		"<rdf:type rdf:resource=\"http://www.w3.org/2000/10/annotationType#Comment\"/> " +
		"<a:annotates rdf:resource=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\"/> " +
		"<rdf:type rdf:resource=\"http://lemo.mminf.univie.ac.at/annotation-core#Annotation\"/> " +
		"<ann:body> " +
		"<rdf:Description> " +
		"<h:Body rdf:parseType=\"Literal\"><html><head><title>Ponte 25 de Abril</title></head><body>text " +
			"text Lisbon</body></html> " +
		"</h:Body> " +
		"<h:ContentType>text/html</h:ContentType> " +
		"<h:ContentLength>653</h:ContentLength> " +
		"</rdf:Description> " +
		"</ann:body> " +
		"<dc:creator>csa1980</dc:creator> " +
		"<a:author>csa1980</a:author> " +
		"<scope:scope>public</scope:scope> " +
		"<dc:title>Ponte 25 de Abril</dc:title> " +
		"<a:created>2008-11-19T15:20:42+01:00</a:created> " +
		"<dc:date>2008-11-19T18:11:03+01:00</dc:date> " +
		"<dc:format>image/jpeg</dc:format> " +
		"<a:modified>2008-11-19T18:11:03+01:00</a:modified> " +
		"<a:fragment>http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg#mp(~region(polygon(334,276,45,-2,0,10,4,0,0,-9,141,-3,95,-1,-92,-19,-74,17,-71,-12)))</a:fragment> " +
		"<a:label>text text text</a:label> " +
		"</rdf:Description> " +
		"</rdf:RDF>";
	
	public static final String LEMO_ANNOTATION_REPLY_REPLY = "" +
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	"<rdf:RDF xmlns:a=\"http://lemo.mminf.univie.ac.at/annotation-core#\" " +
		"xmlns:ann=\"http://www.w3.org/2000/10/annotation-ns#\" " +
		"xmlns:scope=\"http://lemo.mminf.univie.ac.at/ann-tel#\" " +
		"xmlns:image=\"http://lemo.mminf.univie.ac.at/annotation-image#\" " +
		"xmlns:video=\"http://lemo.mminf.univie.ac.at/annotation-video#\" " +
		"xmlns:rel=\"http://lemo.mminf.univie.ac.at/ann-relationship#\" " +
		"xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
		"xmlns:h=\"http://www.w3.org/1999/xx/http#\" " +
		"xmlns:tr=\"http://www.w3.org/2001/03/thread#\" " +
		"xmlns:svg=\"http://www.w3.org/2000/svg\" " +
		"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" " +
		"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> " +
		"<rdf:Description>" +
		"<tr:root rdf:resource=\"$ROOTID\"/> " +
		"<tr:inReplyTo rdf:resource=\"$ID\"/> " +
		"<image:svg-fragment rdf:parseType=\"Literal\"> " +
				"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" width=\"640px\" height=\"480px\" viewbox=\"0px 0px 640px 480px\"> " +
					"<svg:defs xmlns:svg=\"http://www.w3.org/2000/svg\"> " +
						"<svg:symbol xmlns:svg=\"http://www.w3.org/2000/svg\" id=\"Polygon\"> " +
						"<svg:polygon xmlns:svg=\"http://www.w3.org/2000/svg\" " +
						"points=\"0,24 45,22 45,32 49,32 49,23 190,20 285,19 193,0 119,17 48,5\" stroke=\"rgb(229,0,0)\" " +
						"stroke-width=\"2\" fill=\"none\"> " +
						"</svg:polygon> " +
						"</svg:symbol> " +
					"</svg:defs>" +
					"<svg:image xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					" xlink:href=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\" x=\"-38px\" y=\"-16px\" " +
					"width=\"715px\" height=\"536px\" preserveAspectRatio=\"none\"> " +
					"</svg:image> " +
					"<svg:use xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					"xlink:href=\"#Polygon\" x=\"334px\" y=\"252px\" width=\"285px\" height=\"32px\"> " +
					"</svg:use> " +
				"</svg:svg> " +
		"</image:svg-fragment> " +
		"<rdf:type rdf:resource=\"http://www.w3.org/2000/10/annotationType#Comment\"/> " +
		"<a:annotates rdf:resource=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\"/> " +
		"<rdf:type rdf:resource=\"http://lemo.mminf.univie.ac.at/annotation-core#Annotation\"/> " +
		"<ann:body> " +
		"<rdf:Description> " +
		"<h:Body rdf:parseType=\"Literal\"><html><head><title>Ponte 25 de Abril</title></head><body>text " +
			"text Lisbon</body></html> " +
		"</h:Body> " +
		"<h:ContentType>text/html</h:ContentType> " +
		"<h:ContentLength>653</h:ContentLength> " +
		"</rdf:Description> " +
		"</ann:body> " +
		"<dc:creator>csa1980</dc:creator> " +
		"<a:author>csa1980</a:author> " +
		"<scope:scope>public</scope:scope> " +
		"<dc:title>Ponte 25 de Abril</dc:title> " +
		"<a:created>2008-11-19T15:20:42+01:00</a:created> " +
		"<dc:date>2008-11-19T18:11:03+01:00</dc:date> " +
		"<dc:format>image/jpeg</dc:format> " +
		"<a:modified>2008-11-19T18:11:03+01:00</a:modified> " +
		"<a:fragment>http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg#mp(~region(polygon(334,276,45,-2,0,10,4,0,0,-9,141,-3,95,-1,-92,-19,-74,17,-71,-12)))</a:fragment> " +
		"<a:label>text text text</a:label> " +
		"</rdf:Description> " +
		"</rdf:RDF>";
	
	public static final String LEMO_ANNOTATION_WITH_ID = "" +
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	"<rdf:RDF xmlns:a=\"http://lemo.mminf.univie.ac.at/annotation-core#\" " +
		"xmlns:ann=\"http://www.w3.org/2000/10/annotation-ns#\" " +
		"xmlns:scope=\"http://lemo.mminf.univie.ac.at/ann-tel#\" " +
		"xmlns:image=\"http://lemo.mminf.univie.ac.at/annotation-image#\" " +
		"xmlns:video=\"http://lemo.mminf.univie.ac.at/annotation-video#\" " +
		"xmlns:rel=\"http://lemo.mminf.univie.ac.at/ann-relationship#\" " +
		"xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
		"xmlns:h=\"http://www.w3.org/1999/xx/http#\" " +
		"xmlns:tr=\"http://www.w3.org/2001/03/thread#\" " +
		"xmlns:svg=\"http://www.w3.org/2000/svg\" " +
		"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" " +
		"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> " +
		"<rdf:Description rdf:about=\"http://dme.arcs.ac.at/annotation-middleware/Annotation/13mqhvi2dx1\"> "+
		"<image:svg-fragment rdf:parseType=\"Literal\"> " +
				"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" width=\"640px\" height=\"480px\" viewbox=\"0px 0px 640px 480px\"> " +
					"<svg:defs xmlns:svg=\"http://www.w3.org/2000/svg\"> " +
						"<svg:symbol xmlns:svg=\"http://www.w3.org/2000/svg\" id=\"Polygon\"> " +
						"<svg:polygon xmlns:svg=\"http://www.w3.org/2000/svg\" " +
						"points=\"0,24 45,22 45,32 49,32 49,23 190,20 285,19 193,0 119,17 48,5\" stroke=\"rgb(229,0,0)\" " +
						"stroke-width=\"2\" fill=\"none\"> " +
						"</svg:polygon> " +
						"</svg:symbol> " +
					"</svg:defs>" +
					"<svg:image xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					" xlink:href=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\" x=\"-38px\" y=\"-16px\" " +
					"width=\"715px\" height=\"536px\" preserveAspectRatio=\"none\"> " +
					"</svg:image> " +
					"<svg:use xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					"xlink:href=\"#Polygon\" x=\"334px\" y=\"252px\" width=\"285px\" height=\"32px\"> " +
					"</svg:use> " +
				"</svg:svg> " +
		"</image:svg-fragment> " +
		"<rdf:type rdf:resource=\"http://www.w3.org/2000/10/annotationType#Comment\"/> " +
		"<a:annotates rdf:resource=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\"/> " +
		"<rdf:type rdf:resource=\"http://lemo.mminf.univie.ac.at/annotation-core#Annotation\"/> " +
		"<ann:body> " +
		"<rdf:Description rdf:about=\"http://dme.arcs.ac.at/annotation-middleware/Annotation/body/13mqhvi2dx1\"> " +
		"<h:Body rdf:parseType=\"Literal\"><html><head><title>Ponte 25 de Abril</title></head><body>The 25 de Abril " +
			"Bridge is a suspension bridge connecting the city of Lisbon, capital of Portugal, to the municipality of " +
			"Almada on the left bank of the Tagus river. It was inaugurated on August 6, 1966 and a train platform was " +
			"added in 1999. It is often compared to the Golden Gate Bridge in San Francisco, USA, due to their similarities " +
			"and same construction company. With a total length of 2,277 m, it is the 19th largest suspension bridge in " +
			"the world. The upper platform carries six car lanes, the lower platform two train tracks. Until 1974 the bridge " +
			"was named Salazar Bridge.</body></html> " +
		"</h:Body> " +
		"<h:ContentType>text/html</h:ContentType> " +
		"<h:ContentLength>653</h:ContentLength> " +
		"</rdf:Description> " +
		"</ann:body> " +
		"<dc:creator>csa1980</dc:creator> " +
		"<a:author>csa1980</a:author> " +
		"<scope:scope>public</scope:scope> " +
		"<dc:title>Ponte 25 de Abril</dc:title> " +
		"<a:created>2008-11-19T15:20:42+01:00</a:created> " +
		"<dc:date>2008-11-19T18:11:03+01:00</dc:date> " +
		"<dc:format>image/jpeg</dc:format> " +
		"<a:modified>2008-11-19T18:11:03+01:00</a:modified> " +
		"<a:fragment>http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg#mp(~region(polygon(334,276,45,-2,0,10,4,0,0,-9,141,-3,95,-1,-92,-19,-74,17,-71,-12)))</a:fragment> " +
		"<a:label>The 25 de Abril Bridge is a suspension bridge connecting the city of Lisbon, capital of Portugal, " +
		"to the municipality of Almada on the left bank of the Tagus river. It was inaugurated on August 6, 1966 and a " +
		"train platform was added in 1999. It is often compared to the Golden Gate Bridge in San Francisco, USA, due to " +
		"their similarities and same construction company. With a total length of 2,277 m, it is the 19th largest suspension " +
		"bridge in the world. The upper platform carries six car lanes, the lower platform two train tracks. Until 1974 the " +
		"bridge was named Salazar Bridge.</a:label> " +
		"</rdf:Description> " +
		"</rdf:RDF>";
	
	public static final String LEMO_ANNOTATION_WITHOUT_ID = "" +
	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
	"<rdf:RDF xmlns:a=\"http://lemo.mminf.univie.ac.at/annotation-core#\" " +
		"xmlns:ann=\"http://www.w3.org/2000/10/annotation-ns#\" " +
		"xmlns:scope=\"http://lemo.mminf.univie.ac.at/ann-tel#\" " +
		"xmlns:image=\"http://lemo.mminf.univie.ac.at/annotation-image#\" " +
		"xmlns:video=\"http://lemo.mminf.univie.ac.at/annotation-video#\" " +
		"xmlns:rel=\"http://lemo.mminf.univie.ac.at/ann-relationship#\" " +
		"xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
		"xmlns:h=\"http://www.w3.org/1999/xx/http#\" " +
		"xmlns:tr=\"http://www.w3.org/2001/03/thread#\" " +
		"xmlns:svg=\"http://www.w3.org/2000/svg\" " +
		"xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\" " +
		"xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"> " +
		"<rdf:Description>" +
		"<image:svg-fragment rdf:parseType=\"Literal\"> " +
				"<svg:svg xmlns:svg=\"http://www.w3.org/2000/svg\" width=\"640px\" height=\"480px\" viewbox=\"0px 0px 640px 480px\"> " +
					"<svg:defs xmlns:svg=\"http://www.w3.org/2000/svg\"> " +
						"<svg:symbol xmlns:svg=\"http://www.w3.org/2000/svg\" id=\"Polygon\"> " +
						"<svg:polygon xmlns:svg=\"http://www.w3.org/2000/svg\" " +
						"points=\"0,24 45,22 45,32 49,32 49,23 190,20 285,19 193,0 119,17 48,5\" stroke=\"rgb(229,0,0)\" " +
						"stroke-width=\"2\" fill=\"none\"> " +
						"</svg:polygon> " +
						"</svg:symbol> " +
					"</svg:defs>" +
					"<svg:image xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					" xlink:href=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\" x=\"-38px\" y=\"-16px\" " +
					"width=\"715px\" height=\"536px\" preserveAspectRatio=\"none\"> " +
					"</svg:image> " +
					"<svg:use xmlns:svg=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
					"xlink:href=\"#Polygon\" x=\"334px\" y=\"252px\" width=\"285px\" height=\"32px\"> " +
					"</svg:use> " +
				"</svg:svg> " +
		"</image:svg-fragment> " +
		"<rdf:type rdf:resource=\"http://www.w3.org/2000/10/annotationType#Comment\"/> " +
		"<a:annotates rdf:resource=\"http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg\"/> " +
		"<rdf:type rdf:resource=\"http://lemo.mminf.univie.ac.at/annotation-core#Annotation\"/> " +
		"<ann:body> " +
		"<rdf:Description> " +
		"<h:Body rdf:parseType=\"Literal\"><html><head><title>Ponte 25 de Abril</title></head><body>The 25 de Abril " +
			"Bridge is a suspension bridge connecting the city of Lisbon, capital of Portugal, to the municipality of " +
			"Almada on the left bank of the Tagus river. It was inaugurated on August 6, 1966 and a train platform was " +
			"added in 1999. It is often compared to the Golden Gate Bridge in San Francisco, USA, due to their similarities " +
			"and same construction company. With a total length of 2,277 m, it is the 19th largest suspension bridge in " +
			"the world. The upper platform carries six car lanes, the lower platform two train tracks. Until 1974 the bridge " +
			"was named Salazar Bridge.</body></html> " +
		"</h:Body> " +
		"<h:ContentType>text/html</h:ContentType> " +
		"<h:ContentLength>653</h:ContentLength> " +
		"</rdf:Description> " +
		"</ann:body> " +
		"<dc:creator>csa1980</dc:creator> " +
		"<a:author>csa1980</a:author> " +
		"<scope:scope>public</scope:scope> " +
		"<dc:title>Ponte 25 de Abril</dc:title> " +
		"<a:created>2008-11-19T15:20:42+01:00</a:created> " +
		"<dc:date>2008-11-19T18:11:03+01:00</dc:date> " +
		"<dc:format>image/jpeg</dc:format> " +
		"<a:modified>2008-11-19T18:11:03+01:00</a:modified> " +
		"<a:fragment>http://upload.wikimedia.org/wikipedia/commons/7/77/Lissabon.jpg#mp(~region(polygon(334,276,45,-2,0,10,4,0,0,-9,141,-3,95,-1,-92,-19,-74,17,-71,-12)))</a:fragment> " +
		"<a:label>The 25 de Abril Bridge is a suspension bridge connecting the city of Lisbon, capital of Portugal, " +
		"to the municipality of Almada on the left bank of the Tagus river. It was inaugurated on August 6, 1966 and a " +
		"train platform was added in 1999. It is often compared to the Golden Gate Bridge in San Francisco, USA, due to " +
		"their similarities and same construction company. With a total length of 2,277 m, it is the 19th largest suspension " +
		"bridge in the world. The upper platform carries six car lanes, the lower platform two train tracks. Until 1974 the " +
		"bridge was named Salazar Bridge.</a:label> " +
		"</rdf:Description> " +
		"</rdf:RDF>";
	
	public static final String JSON_ANNOTATION =
		"{ \"id\" : 123198553 , " +
		  "\"tags\" : [ { \"title\" : \"tagA\"} , { \"title\" : \"tagB\"} , { \"title\" : \"tagC\"}] , "+
		  "\"parent-id\" : 765423 , " +
		  "\"root-id\" : 2345345 , " +
		  "\"text\" : \"Just some random test annotation.\" ," +
		  "\"title\" : \"Test Annotation\" , "+
		  "\"last-modified\" : { \"$date\" : \"2010-11-11T10:58:23Z\"} ,"+
		  "\"created\" : { \"$date\" : \"2010-11-11T10:58:23Z\"} , "+
		  "\"replies\" : [ \"reply01\" , \"reply02\" , \"reply03\" , \"reply04\" , \"reply05\" , \"reply06\"] , "+
		  "\"created-by\" : \"guest\" , "+
		  "\"fragment\" : \"<svg/>\" , "+
		  "\"object-id\" : \"asdf23adsf\"" +
		"}";

}
