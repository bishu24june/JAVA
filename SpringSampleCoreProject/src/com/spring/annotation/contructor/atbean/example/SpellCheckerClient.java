package com.spring.annotation.contructor.atbean.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpellCheckerClient {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		TextEditor te = ctx.getBean(TextEditor.class);
		te.spellCheck();
	}

}
