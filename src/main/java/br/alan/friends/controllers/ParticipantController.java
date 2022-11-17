package br.alan.friends.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.alan.friends.models.Participant;
import br.alan.friends.repositories.ParticipantRepository;
import br.alan.friends.services.ParticipantService;

@Controller
@RequestMapping("/participant")
public class ParticipantController {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@Autowired
	private ParticipantService participantService;
	
	@GetMapping("/search")
	public ModelAndView search() {
		ModelAndView mv = new ModelAndView("participant/list2");
		mv.addObject("participants", participantRepository.findAll());
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Participant participant) {
		ModelAndView mv = new ModelAndView("participant/add");
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView add(@Valid Participant participant, BindingResult result) {
		if(result.hasErrors()) {
			return add(participant);
		}
		participantService.toPersist(participant);
		return new ModelAndView("redirect:/participant/search");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Optional<Participant> participant = participantRepository.findById(id);
		if(participant.isPresent()) {
			mv.addObject("participant", participant.get());
			mv.setViewName("participant/edit");
		}
		else {
			mv.setViewName("error");
		}
		return mv;
	}
	
	@PostMapping("/edit")
	public ModelAndView edit(@Valid Participant participant, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.addObject("participant", participant);
			mv.setViewName("participant/edit");
		}
		else {
			participantService.toPersist(participant);
			mv.setViewName("redirect:/participant/search");
		}
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		Optional<Participant> participant = participantRepository.findById(id);
		if(participant.isPresent()) {
			participantRepository.deleteById(participant.get().getId());
			mv.setViewName("redirect:/participant/search");
		}
		else {
			mv.setViewName("error");
		}
		return mv;
	}
}
