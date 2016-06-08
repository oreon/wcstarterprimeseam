package org.witchcraft.seam.action;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("simpleConverter")
public class SimpleConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String sarg) {
		// TODO Auto-generated method stub
		 if(sarg.equalsIgnoreCase("true"))
			 return Boolean.TRUE;
		 
		 if(sarg.equalsIgnoreCase("False"))
			 return Boolean.FALSE;
		 
		 
		 return sarg;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		return obj.toString();
	}
	
	
	
}