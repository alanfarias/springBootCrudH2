package br.alan.friends.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.alan.friends.models.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long>{
	
}
