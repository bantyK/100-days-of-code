package com.banty.hellocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String,String> pathVars) {
		
		String userName = pathVars.get("userName");
		String countryName = pathVars.get("countryName");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("msg", "Hello," + userName + "!, How is " + countryName + "?");
		modelAndView.addObject("msg2", "Hello," + userName + "!, How is " + countryName + "?");
		return modelAndView;
	}
	
	@RequestMapping(value="/applicationForm.html", method=RequestMethod.GET)
	public ModelAndView showApplicationForm(){
		ModelAndView model = new ModelAndView("ApplicationForm");
		return model;
	}
	
	@RequestMapping(value="/submitApplicationForm.html", method=RequestMethod.POST)
	public ModelAndView submitApplicationForm(@RequestParam("studentName") String studentName, 
			@RequestParam("studentHobby") String studentHobby){
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details Submitted by Student: Name:  " + studentName + " Hobby: " + studentHobby);
		return model;
	}
	
	@RequestMapping(value="/form.html", method=RequestMethod.GET)
	public ModelAndView showForm(){
		ModelAndView modelAndView = new ModelAndView("Form");
		return modelAndView;
	}
	
	@RequestMapping(value="/display.html", method=RequestMethod.POST)
	public ModelAndView displayFormData(@RequestParam Map<String,String> params){
		String name = params.get("name");
		String age = params.get("age");
		ModelAndView modelAndView = new ModelAndView("FormDataDisplay");
		modelAndView.addObject("msg","Name : " + name + " Age : " + age);
		return modelAndView;
	}

	
	
}
