const apiEndpoint = 'http://localhost:8080/api/books';

document.addEventListener('DOMContentLoaded', fetchBooks);


async function fetchBooks() {
  try {
    const response = await fetch(apiEndpoint);
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
    const books = await response.json();
    populateTable(books);
  } catch (error) {
    console.error('Error fetching books:', error);
  }
}


function populateTable(books) {
  const tableBody = document.querySelector('#booksTable tbody');
  tableBody.innerHTML = ''; 
  books.forEach(book => {
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${book.id}</td>
    <td>${book.title} </td>
    <td>${book.author}</td>
    <td>${book.releaseYear}"</td>
    <td>${book.genre}"</td>
    <td><button class="edit-btn" data-id="${book.id}">Edit</button></td>
    <td><button class="delete-btn" data-id="${book.id}">Delete</button></td>
    `;
    tableBody.appendChild(row);
  });


const deleteButtons = document.querySelectorAll('.delete-btn');
  deleteButtons.forEach(button => {
    button.addEventListener('click', function() {
      const bookId = this.getAttribute('data-id');
      deleteBook(bookId, this);
    });
  });
}

async function deleteBook(id, button) {
  if (confirm('Are you sure you want to delete this book?')) {
    try {
      const response = await fetch(`${apiEndpoint}/${id}`, {
        method: 'DELETE'
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const row = button.closest('tr');
      row.remove();
    } catch (error) {
      console.error('Error deleting book:', error);
    }
  }
}

async function addBook(event) {
  event.preventDefault(); 

  const title = document.getElementById('title').value.trim();
  const author = document.getElementById('author').value.trim();
  const releaseYear = document.getElementById('releaseYear').value.trim();
  const genre = document.getElementById('genre').value.trim();


  if (!title || !author || !releaseYear ||  !genre ) {
    alert('Null Field Not Allowed');
    return;
  }
  if (isNaN(releaseYear) || releaseYear.length !== 4){
    alert('Please enter a valid 4-digit release year');
    return;
  }

  const bookData = {
    title,
    author,
    releaseYear: parseInt(releaseYear),
    genre
  };

  try {
    const response = await fetch('http://localhost:8080/api/books', {
      method: 'POST',
      headers: {'Content-Type': 'application/json' },
      body: JSON.stringify(bookData)
    });

    if (response.ok) {
      const addedBook = await response.json();
      alert(`Book "${addedBook.title}" added successfully!`);
      document.getElementById('addBookForm').reset();
      fetchBooks(); // Clear the form
    } else {
      const error = await response.json();
      alert(`Failed to create book: ${error.message || 'Unknown error'}`);
    }
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred while adding the book.');
  }
}


