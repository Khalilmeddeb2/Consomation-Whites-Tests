package de.tekup.soap.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;


@Service
public class SoapClient {
	
	private WebServiceTemplate serviceTemplate;
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse getStatus (StudentRequest studentRequest) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse whiteTestResponse = (WhiteTestResponse) serviceTemplate
				.marshalSendAndReceive("http://localhost:7000/ws", studentRequest);
		
		return whiteTestResponse;

}
	
}
