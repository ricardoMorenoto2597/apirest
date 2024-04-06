package com.api.APIRestLibro.Service;

import com.api.APIRestLibro.Modelo.LibroModelo;
import com.api.APIRestLibro.Repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {
    @Autowired
    LibrosRepository librosRepository;

    public List<LibroModelo> ObternerLibros() {
        return librosRepository.findAll();
    }

    public void nuevoLibro(LibroModelo libroModelo) {
        librosRepository.save(libroModelo);
    }

    public List<LibroModelo> getBooks(String author, String bookName, String releaseDate) {
        if (author != null) {
            return librosRepository.findByAuthor(author);
        } else if (bookName != null) {
            return librosRepository.findByBookName(bookName);
        } else if (releaseDate != null) {
            return librosRepository.findByReleaseDate(releaseDate);
        } else {
            return librosRepository.findAll();
        }
    }

    public void delateLibros(int bookId) {
        librosRepository.deleteById(bookId);
    }

    public void updateLibros(int bookId, LibroModelo libroModelo) {
        Optional<LibroModelo> existingBookOptional = librosRepository.findById(bookId);
        if (existingBookOptional.isPresent()) {
            LibroModelo existingBook = existingBookOptional.get();
            existingBook.setBookName(libroModelo.getBookName());
            existingBook.setAuthor(libroModelo.getAuthor());
            existingBook.setReleaseDate(libroModelo.getReleaseDate());
            librosRepository.save(existingBook);
        } else {
            // Manejo de error si el libro no existe
            throw new RuntimeException("Book not found with id: " + bookId);
        }
    }

}
