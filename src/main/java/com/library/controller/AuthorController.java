package com.library.controller;

import com.library.entity.Author;
import com.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable ("id") Integer id) throws Exception {
        return authorService.findById(id);
    }

    @PutMapping("/{id}")
    public Author putAuthor(@PathVariable ("id") Integer id ,@RequestBody Author author) throws Exception {
        return authorService.changeById(id,author);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Author postAuthor(@RequestBody Author author) throws Exception {
        authorService.createAuthor(author);
        return author;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable ("id") Integer id)
    {
        authorService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<Author> getAllCategories() {
        return authorService.getAll();
    }
}