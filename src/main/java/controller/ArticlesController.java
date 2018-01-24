package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//Assessment from Amdocs, Cyprus
//@RestController
public class ArticlesController {

    private final ArticleService service;

    public ArticlesController(ArticleService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/articles", produces = "application/json")
    public List<Article> getAllArticles() {
        List<Article> articles = service.getAll();
        if (articles == null || articles.isEmpty())
            return new ArrayList<>();
        return articles;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{id}", produces = "application/json")
    public ResponseEntity<Article> getArticle(@PathVariable int id) {
        ResponseEntity<Article> responseEntity;
        Article article = service.findById(id);
        if (article == null)
            responseEntity = new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        else
            responseEntity = new ResponseEntity<Article>(article, HttpStatus.OK);
        return responseEntity;
    }

    @Service
    class ArticleService {
        // will retrieve all articles stored
        public List<Article> getAll() {
            return null;
        }

        // will use the id to find an article with the same id
        // if none is found, it will return null
        public Article findById(int id) {
            return null;
        }
    }

    class Article {

        private int id;
        private String title;
        private String body;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}