package com.dmeritano.patterns.behavioral.template;

public class HtmlHome extends HtmlTemplate{

	@Override
	public String head() {
		String head = """
				<head>
					<meta chasrset="UTF-8">
					<title>Home Page</title>
					<h3>Template pattern - OB</h3>
					<link href="./styles.css" />
				</head>								
			""";
		
		return head;
	}

	@Override
	public String body() {

		String body = """
					<body>
						<h2>Bienvenidos a mi web</h2>
						<h3>Template pattern - OB</h3>
						<p>Saludos desde aqui, Eclipse</p>
					</body>								
				""";
		
		return body;
	}

	@Override
	public String footer() {
		String footer = """
				<footer>
					<p>Todos los derechos reservados</p>
				</footer>								
				""";
	
		return footer;			
	}

}
