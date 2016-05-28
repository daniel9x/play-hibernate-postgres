package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import models.Person;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
	
	@Inject
	private FormFactory formFactory;
	
	@Inject
	private JPAApi api;
	
    public Result index() {
        return ok(index.render("Favorite People"));
    }
    
    @Transactional
    public Result addPerson() {
    	EntityManager em = api.em();
    	Person person = new Person(formFactory.form().bindFromRequest().get("name"));
    	em.persist(person);
    	return redirect(routes.HomeController.index());
    }
    
    @Transactional
    public Result getPersons() {
    	EntityManager em = api.em();
    	String query = "select p from Person p ";
    	List<Person> persons = em.createQuery("select p from Person p", Person.class).getResultList();
    	return ok(Json.toJson(persons));
    }
    
    @Transactional
    public Result getPersonById(Long id) {
    	EntityManager em = api.em();
    	Person person = em.find(Person.class, id);
    	return ok(Json.toJson(person));
    }
 
}
