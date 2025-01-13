const books = [
    {title: "Jade City", author: "Fonda Lee", genre: "Fantasy", image:"../TheReadersGuild/pictures/Jade City.jpg"},
    {title: "Project Hail Mary", author:"Andy Weir",genre: "SciFi", image:"../TheReadersGuild/pictures/Project Hail Mary.jpg" },
    {title: "The Ritual", author: "Shantel Tessier", genre:"Romance" , image:"../TheReadersGuild/pictures/The Ritual.jpg"},
    {title: "The Silent Patient", author: "Alex Michaelides", genre: "Suspense" , image:"../TheReadersGuild/pictures/The Silent Patient.jpg"},
    {title: "A Court Of Thornes And Roses", author: "Sarah J Maas",genre: "Fantasy", image:"../TheReadersGuild/pictures/A Court of Thorns and Roses.jpg"},
    {title: "The Darkness Outside Us", author: "Eliot Schrefer", genre: "SciFi", image:"../TheReadersGuild/pictures/The Darkness Outside Us.jpg"},
    {title: "King Of Wrath", author:"Ana Haug", genre:"Romance", image: "../TheReadersGuild/pictures/King Of Wrath.jpg"},
    {title: "Behind Closed Doors", author:"B.A Paris", genre:"Suspense", image:"../TheReadersGuild/pictures/Behind Closed Doors.jpg"},
    {title: "Cormoran Strike", author:"Robert Galbraith", genre:"Suspense", image:"../TheReadersGuild/pictures/Cormoran Strike.jpg"},
    {title: "The Seven Husbands", author:"Taylor Jenkins Reid", genre:"Romance", image:"/TheReadersGuild/pictures/The Seven Husbands.jpg"},
    {title:  "The Tainted Cup", author:"Robert Jackson Benett", genre:"Fantasy", image:"../TheReadersGuild/pictures/The Tainted Cup.jpg"},
    {title: "Gideon The Ninth", author:"Tamsyn Muir", genre:"SciFi", image:"../TheReadersGuild/pictures/Gideon the Ninth.jpg"},
    {title: "Becoming", author:"Michelle Obama", genre:"Biography", image:"../TheReadersGuild/pictures/Becoming.jpg"},
    {title: "Atomic Habits", author:"James Clear" ,genre:"SelfHelp", image:"../TheReadersGuild/pictures/Atomic Habits.jpg"},
    {title: "Untethered Soul The Journey Beyond Yourself", author:"Michael A Singer", genre:"Spirituality", image:"../TheReadersGuild/pictures/Untethered Soul.jpg"},
    {title: "The Power of Now A Guide to Spiritual Enlightenment", author:"Eckhart Tolle", genre:"Spirituality", image:"../TheReadersGuild/pictures/The power of now.jpg"},
    {title: "Physical Spirituality", author:"Michael Abrahamowitz", genre:"Spirituality", image:"../TheReadersGuild/pictures/Physical Spirtuality.jpg"},
    {title: "Sapiens A Brief History of Humankind", author:"Yuval Harari", genre:"Historic", image:"../TheReadersGuild/pictures/Sapiens.jpg"},
    {title: "The Splendid and The Vile", author: "Erik Larson", genre: "Historic", image:"../TheReadersGuild/pictures/The Slendid And Vile.jpg" },
    {title: "James Madison", author:"Richard Brookhiser", genre: "Historic", image:"../TheReadersGuild/pictures/James Madison.jpg"},
    {title: "The Subtle Art of Not Giving A F*ck", author:"Mark Manson", genre:"SelfHelp", image:"../TheReadersGuild/pictures/The subtle art of not giving a f.jpg"},
    {title: "Think Like A Monk", author:"Jay Shetty", genre:"SelfHelp", image:"../TheReadersGuild/pictures/Think Like a Monk.jpg"},
    {title: "Steve Jobs", author:"Walter Isaacson", genre: "Biography", image:"../TheReadersGuild/pictures/Steve Jobs.jpg"},
    {title: "Educated", author:"Tara Westover", genre: "Biography", image: "../TheReadersGuild/pictures/Educated.jpg"}
]

    function displayBooks(genre){
        const booksContainer = document.getElementById('arrayOfBooks');
        booksContainer.innerHTML = '';

        const filteredBooks = genre === 'All' ? books : books.filter(book => book.genre === genre);
    
        filteredBooks.forEach(book => {
            const bookDiv = document.createElement('div');
            bookDiv.className = 'book-item';
            bookDiv.innerHTML =`
             <img src="${book.image}" alt="${book.title}">
            <h3>${book.title}</h3>            
            `; 
           
            booksContainer.appendChild(bookDiv);
        });
    }