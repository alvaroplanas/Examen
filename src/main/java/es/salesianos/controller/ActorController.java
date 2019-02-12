package es.salesianos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.salesianos.model.Actor;
import es.salesianos.service.ActorService;
import java.util.List;

@Controller
public class ActorController {
	@Autowired
	private ActorService service;

	@PostMapping("/insertActor")
	protected ModelAndView insertActor(Actor actor) {
		service.insert(actor);
		return loadList();
	}
	
	@GetMapping("/deleteActor")
	protected ModelAndView deleteActor(@RequestParam Integer cod) {
	if (cod != null) {
			service.delete(cod);
		}
	return loadList();
	}

	@GetMapping("/actor")
	private ModelAndView loadList() {
		List<Actor> actorsList = service.listAllActor();
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", actorsList);
		return model;
	}

	@GetMapping("/filterActors")
	private ModelAndView filterActors(@RequestParam Integer startYear, @RequestParam Integer endYear) {
		List<Actor> filteredActors = service.filterActor(startYear, endYear);
		ModelAndView model = new ModelAndView("actor");
		model.addObject("listAllActors", filteredActors);
		return model;
	}
}
