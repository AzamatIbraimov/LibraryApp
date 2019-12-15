package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable ("id") Integer id) throws Exception {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    public Book putBook(@PathVariable ("id") Integer id ,@RequestBody Book book) throws Exception {
        return bookService.changeById(id,book);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book) throws Exception {
        bookService.createBook(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable ("id") Integer id)
    {
        bookService.deleteById(id);
    }

    @GetMapping(value="/all")
    public List<Book> getAllCategories() {
        return bookService.getAll();
    }

    @GetMapping(value="/allbyrating")
    public List<Book> getAllProductsByRating() {
        return bookService.getAllByRating();
    }


    @GetMapping(value="/search/{text}")
    public List<Book> byName(@PathVariable ("text") String text) {
        if(text.equals("")){
            return null;
        }
        else {
            return bookService.getByName(text);
        }
    }

    @GetMapping("/category/{id}")
    public List<Book> getByCategory(@PathVariable ("id") Integer id) throws Exception {
        return bookService.getByCategory(id);
    }

    @GetMapping("/subcategory/{id}")
    public List<Book> getBySubCategory(@PathVariable ("id") Integer id) throws Exception {
        return bookService.getBySubcategory(id);
    }

    @GetMapping("/author/{id}")
    public List<Book> getByAuthor(@PathVariable ("id") Integer id) throws Exception {
        return bookService.getByAuthor(id);
    }
}
