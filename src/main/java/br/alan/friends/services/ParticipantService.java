package br.alan.friends.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.alan.friends.models.Participant;
import br.alan.friends.repositories.ParticipantRepository;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepository participantRepository;
	
	@Transactional
	public void toPersist(Participant participant) {
		participantRepository.save(participant);
	}
}
