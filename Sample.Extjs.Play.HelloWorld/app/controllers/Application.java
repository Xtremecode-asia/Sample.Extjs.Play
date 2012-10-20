package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import com.typesafe.config.ConfigFactory;

public class Application extends Controller {
  
  public static Result index() {	
    return ok(index.render(ConfigFactory.load().getString("Index.Title")));
  }
  
}