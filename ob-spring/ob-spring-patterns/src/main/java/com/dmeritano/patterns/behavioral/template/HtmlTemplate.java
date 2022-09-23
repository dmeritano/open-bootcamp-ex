package com.dmeritano.patterns.behavioral.template;

public abstract class HtmlTemplate {

	
	public String render() {
		//opt - text blocks - solo con java 15 o superior
		return String.format("""
				%s
				%s
				%s
				%s
				%s
				""", 
				startHtml(),
				head(), 
				body(), 
				footer(),
				endHtml());		
		
	}
	
	public abstract String head();
	public abstract String body();
	public abstract String footer();
	
	
	private String startHtml() {
		return """
				<!DOCTYPE html>
				<html lang="en">				
				""";
	}

	private String endHtml() {
		return """
				</body>
				</html>				
				""";
	}	
}
