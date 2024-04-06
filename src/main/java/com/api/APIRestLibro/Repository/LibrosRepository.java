package com.api.APIRestLibro.Repository;


import com.api.APIRestLibro.Modelo.LibroModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository  extends CrudRepository<LibroModelo, Integer> {
    List<LibroModelo> findByAuthor(String author);

    List<LibroModelo> findByBookName(String bookName);

    List<LibroModelo> findByReleaseDate(String releaseDate);
    List<LibroModelo> findAll();

}


