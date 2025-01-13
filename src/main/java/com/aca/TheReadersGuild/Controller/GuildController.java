package com.aca.TheReadersGuild.Controller;

import com.aca.TheReadersGuild.modal.BookException;
import com.aca.TheReadersGuild.modal.Books;
import com.aca.TheReadersGuild.modal.Genre;
import com.aca.TheReadersGuild.service.BookService;

import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;



@RestController
//Tells Springboot that this class is a controller,
// is an entry point for HTTP requests


@RequestMapping("api/books")
//Identifies the resource path required to send HTTP request to this path

@CrossOrigin("*")
//says the RESTful services allow anyone to access them

public class GuildController {

    private BookService service = new BookService();

    @RequestMapping(method = RequestMethod.GET,
            produces = "application/json")
    //(method) Identifies the HTTP method that is needed to select this method
    //(produces) Identifies the clients requirement to have the response body be JSON
    public List<Books> getBook() {
        return service.getBook();
    }

    @RequestMapping(value = "/genre/{genreValue}",
            method = RequestMethod.GET,
            produces = "application/json")

    public List<Books> getBooksByGenre(@PathVariable Genre genreValue) {
        System.out.println("genre" + genreValue);
        return service.getBooksByGenre(genreValue);


    }
    @RequestMapping(value = "/author/{authorValue}",
            method = RequestMethod.GET)

    public List<Books> getBooksByAuthor(@PathVariable String authorValue) {
        System.out.println("author: " + authorValue);
        return service.getBooksByAuthor(authorValue);
    }

    @RequestMapping(value = "/releaseyear/{releaseYearValue}",
            method = RequestMethod.GET,
            produces = "application/json")

    public List<Books> getBooksByReleaseYear(@PathVariable Integer releaseYearValue) throws BookException {
        return service.getBooksByReleaseYear(releaseYearValue);
    }
    @RequestMapping(value = "/{bookIdValue}",
            method = RequestMethod.GET)

    public List<Books> getBooksById(@PathVariable Integer bookIdValue) {
        return service.getBooksById(bookIdValue);
    }

    @RequestMapping(value = "/title/{titleValue}",
            method = RequestMethod.GET)

    public List<Books> getBooksByTitle(@PathVariable String titleValue) {
        System.out.println("Title: " + titleValue);
        return service.getBooksByTitle(titleValue);
    }

    @RequestMapping(consumes = "application/json",
            method = RequestMethod.POST)

    public Books createBooks(@RequestBody Books newBook) throws BookException {
        return service.createBooks(newBook);
    }

    @RequestMapping(consumes = "application/json",
            method = RequestMethod.PUT)

    public Books updateBooks(@RequestBody Books updateBook) {
        return service.updateBooks(updateBook);
    }
    @RequestMapping(value = "/{bookIdValue}",
            method = RequestMethod.DELETE)

    public Books deleteBookById(@PathVariable Integer bookIdValue) {
        System.out.println("delete book id:" + bookIdValue);
        return service.deleteBooksById(bookIdValue);
    }
}