package com.aca.TheReadersGuild.dao;

import com.aca.TheReadersGuild.modal.Books;
import com.aca.TheReadersGuild.modal.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BooksDao{
    private static String selectAllBooks =
            "SELECT Id, Title, GenreId, Author, ReleaseYear " +
                    "FROM Books";
    private static String selectBooksByGenre =
            "SELECT Id, Title, GenreId, Author, ReleaseYear\n" +
                    "FROM Books\n" +
                    "WHERE GenreId = ?;";
    private static String selectBooksByReleaseYear =
            "SELECT Id, Title, GenreId, Author, ReleaseYear\n" +
                    "FROM Books\n" +
                    "WHERE ReleaseYear = ?";
    private static String selectBooksById =
            "SELECT Id, Title, GenreId, Author, ReleaseYear\n" +
                    "FROM Books\n" +
                    "WHERE Id = ?";
    private static String selectBooksByTitle =
            "SELECT Id, Title, GenreId, Author, ReleaseYear\n" +
                    "FROM Books\n" +
                    "WHERE Title = ?";
    private static String deleteBookbyId =
           "DELETE FROM Books\n" +
                   "WHERE Id = ?";
    private static String selectBooksByAuthor =
            "SELECT Id, Title, GenreId, Author, ReleaseYear\n" +
                    "FROM Books\n" +
                    "WHERE Author = ?";
    private static String updateBookbyId =
            "UPDATE books\n" +
                    "SET Title = ?,\n" +
                    "\tGenreId = ?,\n" +
                    "\tAuthor = ?,\n" +
                    "\tReleaseYear = ?\n" +
                    "WHERE Id = ?";
    private static String insertBook =
            "INSERT INTO Books (Title, GenreId, Author, ReleaseYear)\n" +
                    "VALUES (?,?,?,?)";
    @Override
    public List<Books> getBook() {
        List<Books> myBooks = new ArrayList<>();
        ResultSet result = null;
        Statement statement = null;

        Connection conn = MariaDBUtil.getConnection();

        try{
            statement = conn.createStatement();
            result = statement.executeQuery(selectAllBooks);
            myBooks = makeBooks(result);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }



        return myBooks;
    }

    private List<Books> makeBooks(ResultSet result) throws SQLException {
        List<Books> books = new ArrayList<>();

        while(result.next()){
            Books book = new Books();
            book.setTitle(result.getString("Title"));
            book.setId(result.getInt("Id"));
            book.setReleaseYear(result.getInt("ReleaseYear"));
            book.setAuthor(result.getString("Author"));

            String genreString = result.getString("GenreId");
            book.setGenre(Genre.convertStringToGenre(genreString));

            books.add(book);
        }
        return books;
    }


    @Override
    public List<Books> getBooksByGenre(Genre Genre) {
        List<Books> myBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDBUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectBooksByGenre);
            ps.setString(1, Genre.toString());
            result = ps.executeQuery();
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myBooks;
    }

    @Override
    public List<Books> getBooksByReleaseYear(Integer releaseYear) {
        List<Books> myBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDBUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectBooksByReleaseYear);
            ps.setInt(1, releaseYear);
            result = ps.executeQuery();
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
    }
        return myBooks;
    }

    @Override
    public List<Books> getBooksById(Integer bookId) {
        List<Books> myBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDBUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectBooksById);
            ps.setInt(1, bookId);
            result = ps.executeQuery();
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myBooks;
    }

    @Override
    public List<Books> getBooksByTitle(String title) {
        List<Books> myBooks = new ArrayList<>();
        ResultSet result = null;
        PreparedStatement ps = null;

        Connection connection = MariaDBUtil.getConnection();

        try {
            ps = connection.prepareStatement(selectBooksByTitle);
            ps.setString(1, title.toString());
            result = ps.executeQuery();
            myBooks = makeBooks(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return myBooks;
    }
   @Override
   public List<Books> getBooksByAuthor(String author){
       List<Books> myBooks = new ArrayList<>();
       ResultSet result = null;
       PreparedStatement ps = null;

       Connection connection = MariaDBUtil.getConnection();

       try {
           ps = connection.prepareStatement(selectBooksByAuthor);
           ps.setString(1, author.toString());
           result = ps.executeQuery();
           myBooks = makeBooks(result);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

       return myBooks;
   }

    @Override
    public Books createBooks(Books newBook) {
        PreparedStatement ps = null;
        Connection connection = MariaDBUtil.getConnection();

        try {
            ps = connection.prepareStatement(insertBook);
            ps.setString(1,newBook.getTitle());
            ps.setString(2,newBook.getGenre().toString());
            ps.setString(3,newBook.getAuthor());
            ps.setInt(4,newBook.getReleaseYear());
            int rowCount = ps.executeUpdate();
            System.out.println("insert count: " + rowCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return newBook;
    }

    @Override
    public Books updateBooks(Books updateBook) {
        List<Books> books = getBooksById(updateBook.getId());

        if (books.size() > 0){
            PreparedStatement ps = null;
            Connection connection = MariaDBUtil.getConnection();

            try {
                ps = connection.prepareStatement(updateBookbyId);
                ps.setString(1, updateBook.getTitle());
                ps.setString(2,updateBook.getGenre().toString());
                ps.setString(3,updateBook.getAuthor());
                ps.setInt(4,updateBook.getReleaseYear());
                ps.setInt(5,updateBook.getId());
                int rowCount = ps.executeUpdate();
                System.out.println("row updated: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return updateBook;
    }

    @Override
    public Books deleteBooksById(Integer bookId) {
        List<Books> books = this.getBooksById(bookId);
        Books bookToDelete = null;

        if (books.size() > 0){
            bookToDelete = books.get(0);
            PreparedStatement ps = null;
            Connection connection = MariaDBUtil.getConnection();
            try {
                ps = connection.prepareStatement(deleteBookbyId);
                ps.setInt(1,bookId);
                int rowCount = ps.executeUpdate();
                System.out.println("rows delete: " + rowCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return bookToDelete;
    }
}
