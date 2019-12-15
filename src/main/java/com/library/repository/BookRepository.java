package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContaining(String text);
    List<Book> findByCategoryEquals(Integer category);
    List<Book> findBySubCategoryEquals(Integer subcategory);
    List<Book> findByAuthorIdEquals(Integer tag);
}
