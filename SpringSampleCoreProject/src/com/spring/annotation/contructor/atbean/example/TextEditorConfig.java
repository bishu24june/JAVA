package com.spring.annotation.contructor.atbean.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * Because you are using Java-based annotations, so you also need to add CGLIB.jar from your Java 
 * installation directory and ASM.jar library which can be downloaded from asm.ow2.org.
 */

@Configuration
public class TextEditorConfig {
	@Bean
	public TextEditor textEditor() {
		return new TextEditor(spellChecker());
	}

	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
}