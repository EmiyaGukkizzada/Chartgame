package com.example.chartgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.chartgame.model.PortFolio;
import com.example.chartgame.service.PortFolioService;

@Controller
public class RankController {
	
	@Autowired
	PortFolioService pfs;
	
	@RequestMapping(value = "rank")
	public String rankList(PortFolio portFolio, Model model) {
		System.out.println("RankController rankList() start...");

		List<PortFolio> listRank = pfs.listRank(portFolio);
		
		model.addAttribute("listRank", listRank);
		System.out.println(listRank);
		
		return "rank";
	}
}
