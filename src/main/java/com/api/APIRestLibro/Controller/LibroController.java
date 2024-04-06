package com.api.APIRestLibro.Controller;

import com.api.APIRestLibro.Modelo.LibroModelo;
import com.api.APIRestLibro.Service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibrosService librosService;
    @PostMapping
    public void createBook(@RequestBody LibroModelo libroModelo) {
        librosService.nuevoLibro(libroModelo);
    }

    @GetMapping
    public List<LibroModelo> getBooks(@RequestParam(required = false) String author,
                                      @RequestParam(required = false) String bookName,
                                      @RequestParam(required = false) String releaseDate) {
        return librosService.getBooks(author, bookName, releaseDate);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        librosService.delateLibros(bookId);
    }

    @PutMapping("/{bookId}")
    public void updateBook(@PathVariable int bookId, @RequestBody LibroModelo libroModelo) {
        librosService.updateLibros(bookId, libroModelo);
    }
}
