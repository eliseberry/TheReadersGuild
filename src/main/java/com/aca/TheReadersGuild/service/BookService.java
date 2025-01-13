package com.aca.TheReadersGuild.service;

import com.aca.TheReadersGuild.dao.BookDaoImpl;
import com.aca.TheReadersGuild.dao.BookDaoMock;
import com.aca.TheReadersGuild.dao.BooksDao;
import com.aca.TheReadersGuild.modal.BookException;
import com.aca.TheReadersGuild.modal.Books;
import com.aca.TheReadersGuild.modal.Genre;
import java.util.List;

public class BookService {

    private BooksDao booksDao = new BookDaoImpl();

    public List<Books> getBook() {

        return booksDao.getBook();
    }

    public List<Books> getBooksByGenre(Genre genre) {
        return booksDao.getBooksByGenre(genre);
    }
    public List<Books> getBooksByAuthor(String authorValue){
        return booksDao.getBooksByAuthor(authorValue);
    }

    public List<Books> getBooksByReleaseYear(Integer releaseYear) throws BookException {
        validateReleaseYear(releaseYear);
        return booksDao.getBooksByReleaseYear(releaseYear);
    }

    private void validateReleaseYear(Integer releaseYear) throws BookException {
        if (null == releaseYear){
            throw new BookException("Invalid release year, null value is not allowed");

        } else if (releaseYear < 1921 || releaseYear > 2025) {
            throw new BookException("Release year not valid, must be > 1921 and < 2025");
        }
    }

    public List<Books> getBooksById(Integer bookId) {
        return booksDao.getBooksById(bookId);
    }

    public List<Books> getBooksByTitle(String titleValue) {
        return booksDao.getBooksByTitle(titleValue);
    }

    public Books createBooks(Books newBook) throws BookException {
        validateReleaseYear(newBook.getReleaseYear());
        return booksDao.createBooks(newBook);
    }


    public Books updateBooks(Books updateBook) {
        return booksDao.updateBooks(updateBook);
    }

    public Books deleteBooksById(Integer bookIdValue) {
        return booksDao.deleteBooksById(bookIdValue);
    }
}

