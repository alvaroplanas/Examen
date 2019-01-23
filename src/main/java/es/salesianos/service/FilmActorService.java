package es.salesianos.service;

import es.salesianos.model.FilmActor;
import es.salesianos.repository.FilmActorRepository;
import es.salesianos.model.ActorFilmDTO;

public class FilmActorService {

	FilmActorRepository repository = new FilmActorRepository();

	public void insert(FilmActor filmActor) {
		repository.insert(filmActor);
	}
	public ActorFilmDTO filterActorFilm(String role) {
		return repository.filterActorFilm(role);
	}

}