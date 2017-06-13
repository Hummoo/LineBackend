package com.example.demo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.LineGroup;
import com.example.demo.service.LineGroupService;

@Controller
public class LineGroupController {
	private static final Logger log = LoggerFactory.getLogger(LineGroupController.class);

	@Autowired
	LineGroupService lineGroupService;

	@RequestMapping(value = "/lineGroup/register/{groupUserId}", method = RequestMethod.GET)
	public String showForm(@PathVariable(name = "groupUserId") String groupUserId, Model model) {
		log.info("register");

		log.info("GroupUserId : " + groupUserId);

		LineGroupRegisterForm form = new LineGroupRegisterForm();
		form.setGroupUserId(groupUserId);
		model.addAttribute("lineGroupRegisterForm", form);

		return "register";
	}

	@RequestMapping(value = "/lineGroup/register/add", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute LineGroupRegisterForm lineGroupRegisterForm) {
		log.info("register");

		log.info("GroupUserId : " + lineGroupRegisterForm.getGroupUserId());
		log.info("AgentCode : " + lineGroupRegisterForm.getAgentCode());

		LineGroup lineGroup = new LineGroup();
		lineGroup.setGroupUserId(lineGroupRegisterForm.getGroupUserId());
		lineGroup.setAgentCode(lineGroupRegisterForm.getAgentCode());
		lineGroup.setCreatedDt(new Date());

		lineGroupService.register(lineGroup);

		return new ModelAndView("greeting");
	}

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
		log.info("greeting");

		model.addAttribute("name", name);
		return "greeting";
	}
}
