package com.omn.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.omn.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {

	private Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);

	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("Inside Home " + System.currentTimeMillis());
		return "modelAttributeHome";
	}

	// version 2 of our home() method
	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modelAttributeHome");
		mv.addObject("command", new Address());
		return mv;
	}

	// version 3 of our home() method
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		ModelAndView mv = new ModelAndView("modelAttributeHome");
		mv.addObject("anAddress", new Address());
		return mv;
	}

	// version 4 of our home() method
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "3000"));
	}

	// version 5 of our home() method
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		return "modelAttributeHome";
	}

	/*
	 * Test series to determine the nature of the @ModelAttribute annotation (on a
	 * method)
	 */
	// Test 1: Demostrating the usage of @ModelAttribute annotation (on a method)
	// to add multiple attributes

	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("Inside modelAttributeTest1 " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed");
		model.addAttribute("testdata1B",
				"We will test both usages of the @ModelAttribute, on Methods and on method arguments");

	}

	// Test 2 Demostrating the usage of the 'name' attribute of the @ModelAttribute
	// annotation (on method)
	@ModelAttribute(name = "testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("Inside modelAttributeTest2");
		return "We will conduct a series of test here";
	}

	// Test 3: Demostrating the usage of the @ModelAttribute annotation (on a
	// method) to implicity add an attribute
	// by returning it and also demostrating the usage of the 'value' attribute of
	// the @ModelAttribute annotation (on a method)
	@ModelAttribute(value = "testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("Inside modelAttribute3");
		return new Address("Adelaide", "5000");
	}

	// Test 4: Desmostrate the default naming stragedy of the @ModelAttribute
	// annotaion (on the method)
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("Inside modelAttribute4");
		return new Address("Sydney", "20000");
	}

	// Test 5: Testing the @ModelAttribute with 'value'  attribute and default binding
	
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipcode());
		return "modelAttributeTest";
	}
	
	// Test 6: Test to determine nature of how the @ModelAttribute (on method) and @RequestMapping 
	// work with no explicit logical view name
	@RequestMapping(value="/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		return new Address("Canberra", "2600");
	}
}
