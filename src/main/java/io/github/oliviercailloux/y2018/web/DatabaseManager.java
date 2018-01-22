package io.github.oliviercailloux.y2018.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.*;

import io.github.oliviercailloux.y2018.Cours;
import io.github.oliviercailloux.y2018.Personne;

/**
 * Please note that this only a temporary solution, pending the creation
 * of the real database.
 * This was done based on the model given in the CDI FakeDB sample.
 */

@ApplicationScoped
public class DatabaseManager {
	private Map<Integer,Cours> coursesById = new LinkedHashMap<>();
	private Map<Integer,Personne> personsById = new LinkedHashMap<>();
	
	public DatabaseManager() {
		init();
	}
	
	public Map<Integer,Cours> getCoursesById() {
		return coursesById;
	}
	
	public Map<Integer,Personne> getPersonsById() {
		return personsById;
	}
	
	public boolean updateCourse(int id,Cours course) {
		coursesById.put(id, course);
		return true;
	}
	
	public boolean updatePersonne(int id, Personne person) {
		personsById.put(id, person);
		return true;
	}
	
	private void init() {
		coursesById.put(1,new Cours());
		coursesById.put(2,new Cours());
		coursesById.put(3,new Cours());
		personsById.put(1, new Personne());
		personsById.put(2, new Personne());
		personsById.put(3, new Personne());
	}
}
