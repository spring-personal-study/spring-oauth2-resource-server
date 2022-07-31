package bluebird.emm.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    @GetMapping
    public String[] getArticles() {
        return new String[] { "Article 1", "Article 2", "Article 3" };
    }

}