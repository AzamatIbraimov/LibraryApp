package com.library.service;


import com.library.entity.Author;
import com.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public Author findById(Integer id) throws Exception {
        return authorRepository.findById(id).orElseThrow(Exception::new);
    }

    public String deleteById(Integer id) {
        authorRepository.deleteById(id);
        return "Author number " + id + " has been deleted!";
    }

    public Author changeById(Integer id,Author author) throws Exception {
        return authorRepository.findById(id)
                .map(newAuthor-> {
                    newAuthor.setId(author.getId());
                    newAuthor.setBooks(author.getBooks());
                    newAuthor.setContact(author.getContact());
                    newAuthor.setName(author.getName());
                    return authorRepository.save(newAuthor);
                }).orElseThrow( Exception::new);
    }

    public Author createAuthor(Author author)  {
        return authorRepository.save(author);
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

}