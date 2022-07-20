package com.busy.apis.entities.matrix;

import java.util.Arrays;

public class ElementsListaGoogle {
	
	private ElementsGoogle[] elements;
	
	public ElementsListaGoogle() {
		
	}
	
	

	public ElementsListaGoogle(ElementsGoogle[] elements) {
		super();
		this.elements = elements;
	}



	public ElementsGoogle[] getElements() {
		return elements;
	}

	public void setElements(ElementsGoogle[] elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "ElementsListaGoogle [elements=" + Arrays.toString(elements) + "]";
	}
	
	
	
	
	
}
