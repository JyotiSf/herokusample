package com.syntel.microservices;



import org.springframework.beans.factory.annotation.Autowired;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.bo.Composite;

import com.syntel.model.CompositeDetail;

/**
 * This restContoller will handle all REST endpoints exposed by this micro
 * service e.g. http://<servername>:port/sample/...
 * 
 */
@Controller
@RestController
@RequestMapping(value = "/composite")
public class CustomVisionMicroService {

	/** The Constant LOG. */
	// private static final Logger LOG =
	// LoggerFactory.getLogger(SampleAtomMicroService.class);

	/** The Constant VERSION of the micro service. */
	public static final String VERSION = "1.0";

	@Autowired
	private Composite compositeservice;
	
	@RequestMapping(value = "/id/"+VERSION, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody String custom(@RequestBody CompositeDetail details) {
		return "hello";
		//return compositeservice.CompositeCall(details);
		
	
	}

}
