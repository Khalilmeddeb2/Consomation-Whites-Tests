package de.tekup.soap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.soap.clients.SoapClient;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;

@Controller
public class CheckController {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/student")
	public String checkWhiteTestForm(Model model)
	{
		StudentRequest student = new StudentRequest();
		model.addAttribute("studentRequest", student);
		return "StudentRequest";
		
	}
	
	@PostMapping("/check/student")
	public String checkResults(@ModelAttribute("studentRequest") StudentRequest student,
			Model model) {
		//invoke of web service
		WhiteTestResponse whiteTestResponse = client.getStatus(student);
		model.addAttribute("whiteTestResponse",whiteTestResponse);
		return "results";
	}

}
