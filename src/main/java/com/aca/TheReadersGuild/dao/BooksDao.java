package com.aca.TheReadersGuild.dao;

import com.aca.TheReadersGuild.modal.Books;
import com.aca.TheReadersGuild.modal.Genre;

import java.util.List;

public interface BooksDao {
    public List<Books> getBook();
    public abstract List<Books> getBooksByGenre(Genre genre);


    public abstract List<Books> getBooksByReleaseYear(Integer releaseYear);
    public abstract List<Books> getBooksById(Integer bookId);
    public abstract List<Books> getBooksByTitle(String title);

    public abstract List<Books> getBooksByAuthor(String author);

    public abstract Books createBooks(Books newBook);
    public abstract Books updateBooks(Books updateBook);
    public abstract Books deleteBooksById(Integer bookId);
}
