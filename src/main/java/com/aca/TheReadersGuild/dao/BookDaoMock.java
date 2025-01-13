package com.aca.TheReadersGuild.dao;

import com.aca.TheReadersGuild.modal.Books;
import com.aca.TheReadersGuild.modal.Genre;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BookDaoMock implements BooksDao {

    private static List<Books> book = new ArrayList<>();
    private static Integer lastBookId = 0;

    private static Integer getNextBookId() {
        lastBookId++;
        return lastBookId;

    }

    static {
        Books JadeCity = new Books();
        JadeCity.setTitle("Jade City");
        JadeCity.setGenre(Genre.Fantasy);
        JadeCity.setAuthor("Fonda Lee");
        JadeCity.setReleaseYear(2017);
        JadeCity.setId(getNextBookId());
        JadeCity.setImagePath("C:\\RG Pictures\\Jade City.jpg");

        Books ProjectHailMary = new Books();
        ProjectHailMary.setTitle("Project Hail Mary");
        ProjectHailMary.setGenre(Genre.SciFi);
        ProjectHailMary.setAuthor("Andy Weir");
        ProjectHailMary.setReleaseYear(2021);
        ProjectHailMary.setId(getNextBookId());

        Books TheRitual = new Books();
        TheRitual.setTitle("The Ritual");
        TheRitual.setGenre(Genre.Romance);
        TheRitual.setAuthor("Shantel Tessier");
        TheRitual.setReleaseYear(2021);
        TheRitual.setId(getNextBookId());

        Books TheSilentPatient = new Books();
        TheSilentPatient.setTitle("The Silent Patient");
        TheSilentPatient.setGenre(Genre.Suspense);
        TheSilentPatient.setAuthor("Alex Michaelides");
        TheSilentPatient.setReleaseYear(2019);
        TheSilentPatient.setId(getNextBookId());


        Books ACourtofThornsandRoses = new Books();
        ACourtofThornsandRoses.setTitle("A Court of Thorns and Roses ");
        ACourtofThornsandRoses.setGenre(Genre.Fantasy);
        ACourtofThornsandRoses.setAuthor("Sarah J. Maas");
        ACourtofThornsandRoses.setReleaseYear(2015);
        ACourtofThornsandRoses.setId(getNextBookId());


        Books TheDarknessOutsideUs = new Books();
        TheDarknessOutsideUs.setTitle("The Darkness Outside Us");
        TheDarknessOutsideUs.setGenre(Genre.SciFi);
        TheDarknessOutsideUs.setAuthor("Eliot Schrefer");
        TheDarknessOutsideUs.setReleaseYear(2021);
        TheDarknessOutsideUs.setId(getNextBookId());


        Books KingOfWrath = new Books();
        KingOfWrath.setTitle("King Of Wrath");
        KingOfWrath.setGenre(Genre.Romance);
        KingOfWrath.setAuthor("Ana Haung");
        KingOfWrath.setReleaseYear(2022);
        KingOfWrath.setId(getNextBookId());


        Books BehindClosedDoors = new Books();
        BehindClosedDoors.setTitle("Behind Closed Doors");
        BehindClosedDoors.setGenre(Genre.Suspense);
        BehindClosedDoors.setAuthor("B.A Paris");
        BehindClosedDoors.setReleaseYear(2016);
        BehindClosedDoors.setId(getNextBookId());


        Books CormoranStrike = new Books();
        CormoranStrike.setTitle("Cormoran Strike");
        CormoranStrike.setGenre(Genre.Suspense);
        CormoranStrike.setAuthor("Robert Galbraith");
        CormoranStrike.setReleaseYear(2013);
        CormoranStrike.setId(getNextBookId());


        Books TheSevenHusbands = new Books();
        TheSevenHusbands.setTitle("The Seven Husbands");
        TheSevenHusbands.setGenre(Genre.Romance);
        TheSevenHusbands.setAuthor("Taylor Jenkins Reid");
        TheSevenHusbands.setReleaseYear(2017);
        TheSevenHusbands.setId(getNextBookId());


        Books TheTaintedCup = new Books();
        TheTaintedCup.setTitle("The Tainted Cup");
        TheTaintedCup.setGenre(Genre.Fantasy);
        TheTaintedCup.setAuthor("Robert Jackson Benett");
        TheTaintedCup.setReleaseYear(2024);
        TheTaintedCup.setId(getNextBookId());


        Books GideonTheNinth = new Books();
        GideonTheNinth.setTitle("Gideon The Ninth");
        GideonTheNinth.setGenre(Genre.SciFi);
        GideonTheNinth.setAuthor("Tamsyn Muir");
        GideonTheNinth.setReleaseYear(2019);
        GideonTheNinth.setId(getNextBookId());


        Books Becoming = new Books();
        Becoming.setTitle("Becoming");
        Becoming.setGenre(Genre.Biography);
        Becoming.setAuthor("Michelle Obama");
        Becoming.setReleaseYear(2018);
        Becoming.setId(getNextBookId());


        Books AtomicHabits = new Books();
        AtomicHabits.setTitle("Atomic Habits");
        AtomicHabits.setGenre(Genre.SelfHelp);
        AtomicHabits.setAuthor("James Clear");
        AtomicHabits.setReleaseYear(2018);
        AtomicHabits.setId(getNextBookId());


        Books UntetheredSoulTheJourneyBeyondYourself = new Books();
        UntetheredSoulTheJourneyBeyondYourself.setTitle("Untethered Soul: The Journey Beyond Yourself");
        UntetheredSoulTheJourneyBeyondYourself.setGenre(Genre.Spirituality);
        UntetheredSoulTheJourneyBeyondYourself.setAuthor("Michael A Singer");
        UntetheredSoulTheJourneyBeyondYourself.setReleaseYear(2007);
        UntetheredSoulTheJourneyBeyondYourself.setId(getNextBookId());

        //Fiction Books
        book.add(JadeCity);
        book.add(ProjectHailMary);
        book.add(TheRitual);
        book.add(TheSilentPatient);
        book.add(ACourtofThornsandRoses);
        book.add(TheDarknessOutsideUs);
        book.add(KingOfWrath);
        book.add(BehindClosedDoors);
        book.add(CormoranStrike);
        book.add(TheSevenHusbands);
        book.add(TheTaintedCup);
        book.add(GideonTheNinth);

        //NonFiction Books
        book.add(Becoming);
        book.add(AtomicHabits);
        book.add(UntetheredSoulTheJourneyBeyondYourself);

    }

    @Override
    public List<Books> getBook() {
        List<Books> myBooks = new ArrayList<>();
        myBooks.addAll(book);
        return myBooks;
    }

    @Override
    public List<Books> getBooksByGenre(Genre genre) {
        List<Books> myBooks = new ArrayList<>();

        for (Books books : book) {
            if (books.getGenre().equals(genre)) {
                myBooks.add(books);
            }
        }


        return myBooks;

    }

    @Override
        public List<Books> getBooksByAuthor (String author){
            List<Books> myBooks = new ArrayList<>();

            for (Books books : book) {
                if (books.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                    myBooks.add(books);
                }
            }
            return myBooks;
        }

        @Override
        public List<Books> getBooksByReleaseYear (Integer releaseYear){
            List<Books> myBooks = new ArrayList<>();

            for (Books books : book) {
                if (books.getReleaseYear().intValue() == releaseYear.intValue()) {
                    myBooks.add(books);
                }
            }

            return myBooks;
        }

    @Override
    public List<Books> getBooksById(Integer bookId) {
        List<Books> myBooks = new ArrayList<>();

        for (Books books : book) {
            if (books.getId().intValue() == bookId.intValue()) {
                myBooks.add(books);
            }
        }

        return myBooks;
    }

    @Override
        public List<Books> getBooksByTitle (String title){
            List<Books> myBooks = new ArrayList<>();

            for (Books books : book) {
                if (books.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    myBooks.add(books);
                }
            }
            return myBooks;
        }
        @Override
        public Books createBooks (Books newBook){
            newBook.setId(getNextBookId());
            book.add(newBook);
            return newBook;

        }

        @Override
        public Books updateBooks (Books updateBook){
            for (Books books : book) {
                if (books.getId().intValue() == updateBook.getId().intValue()) {
                    books.setTitle(updateBook.getTitle());
                    books.setReleaseYear(updateBook.getReleaseYear());
                    books.setAuthor(updateBook.getAuthor());
                    books.setGenre(updateBook.getGenre());
                    break;
                }
            }

            return updateBook;
        }

        @Override
        public Books deleteBooksById (Integer bookId){
            List<Books> books = getBooksById(bookId);
            Books book = null;

            if (books.size() > 0) {
                book = books.get(0);
                BookDaoMock.book.remove(book);
            }

            return book;
        }
    }
