package es.salesianos.service;

import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;
import es.salesianos.model.ActorFilmDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmActorService implements IFIlmActorService {

	@Autowired
	FilmActorRepository repository;
	
	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
	public ActorFilmDTO filterActorFilm(String role) {
		return repository.filterActorFilm(role);
	}

}