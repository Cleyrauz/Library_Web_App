package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.SparkBase.staticFileLocation;
import static spark.Spark.get;

public class MainController {

    public static void main(String[] args) {
        Seeds.seedData();

        staticFileLocation("/public");

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
