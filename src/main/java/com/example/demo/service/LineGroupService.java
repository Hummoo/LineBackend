package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LineGroupRepository;
import com.example.demo.entity.LineGroup;

@Service
public class LineGroupService {
	private static final Logger log = LoggerFactory.getLogger(LineGroupService.class);

	@Autowired
	LineGroupRepository lineGroupRepository;

	public void register(LineGroup lineGroup) {
		log.info("register");

		lineGroupRepository.save(lineGroup);
		
		log.info("line group added");
	}

}
