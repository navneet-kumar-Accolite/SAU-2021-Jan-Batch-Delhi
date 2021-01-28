package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public class info {
	@WebMethod
	@WebResult(partName="")
	public static void main(String[] args) {
		
	}
}
