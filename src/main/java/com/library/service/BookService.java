package com.library.service;


import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book findById(Integer id) throws Exception {
        return bookRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        bookRepository.deleteById(id);
        return "Book number " + id + " has been deleted!";
    }

    public Book changeById(Integer id,Book book) throws Exception {
        return bookRepository.findById(id)
                .map(newbook-> {
                    newbook.setAuthorId(book.getAuthorId());
                    newbook.setYear(book.getYear());
                    newbook.setDescription(book.getDescription());
                    newbook.setId(book.getId());
                    newbook.setRating(book.getRating());
                    newbook.setAviability(book.isAviability());
                    newbook.setName(book.getName());
                    newbook.setCategory(book.getCategory());
                    newbook.setSubCategory(book.getSubCategory());
                    return bookRepository.save(book);
                }).orElseThrow( Exception::new);
    }

    public Book createBook(Book book)  {
        return bookRepository.save(book);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

}