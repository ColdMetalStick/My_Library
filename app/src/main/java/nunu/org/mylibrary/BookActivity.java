package nunu.org.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private Button btnCurrentlyReading2, btnWantToRead, btnAlreadyRead2, btnAddToFavorites;
    private ImageView bookImage;
    private TextView txtBookName2, txtAuthorName, txtPages, txtLongDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        String longDescription = "saddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsaddddddddddddddsadddddddddddddd";

        //TODO: Get data form recycler view in here
//        Book books = new Book(1, "12 Rules for Life", "Jordan Peterson",409,"https://ia803104.us.archive.org/BookReader/BookReaderImages.php?zip=/17/items/jordanb.peterson12rulesforlife/Jordan%20B.%20Peterson%20-%2012%20Rules%20For%20Life%20%28EPUB%29_jp2.zip&file=Jordan%20B.%20Peterson%20-%2012%20Rules%20For%20Life%20%28EPUB%29_jp2/Jordan%20B.%20Peterson%20-%2012%20Rules%20For%20Life%20%28EPUB%29_0000.jp2&id=jordanb.peterson12rulesforlife&scale=4&rotate=0"
//                , "An Antidote for Chaos", longDescription);

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);


                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }

//        setData(books);

    }

    private void handleFavoriteBooks(final Book incomingBook) {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavoriteBooks = false;

        for (Book b: favoriteBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInFavoriteBooks = true;
            }
        }

        if (existInFavoriteBooks) {
            btnAddToFavorites.setEnabled(false);

        } else {
            btnAddToFavorites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToFavorite(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookActivity.this, FavoriteBookActivity.class));
                    } else {
                        Toast.makeText(BookActivity.this, "Failed to add book", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleCurrentlyReadingBooks(final Book incomingBook) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;

        for (Book b: currentlyReadingBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInCurrentlyReadingBooks = true;
            }
        }

        if (existInCurrentlyReadingBooks) {
            btnCurrentlyReading2.setEnabled(false);

        } else {
            btnCurrentlyReading2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReading(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookActivity.this, CurrentlyReadingActivity.class));
                    } else {
                        Toast.makeText(BookActivity.this, "Failed to add book", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book incomingBook) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for (Book b: wantToReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInWantToReadBooks = true;
            }
        }

        if (existInWantToReadBooks) {
            btnWantToRead.setEnabled(false);

        } else {
           btnWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToWantToRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookActivity.this, WantToReadActivity.class));
                    } else {
                        Toast.makeText(BookActivity.this, "Failed to add book", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleAlreadyRead(final Book incomingBook) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b: alreadyReadBooks) {
            if (b.getId() == incomingBook.getId()) {
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAlreadyRead2.setEnabled(false);

        } else {
            btnAlreadyRead2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(incomingBook)) {
                        Toast.makeText(BookActivity.this, "Book Added sucessfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(BookActivity.this, AlreadyReadBookActivity.class));
                    } else {
                        Toast.makeText(BookActivity.this, "Failed to add book", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book books) {
        txtBookName2.setText(books.getName());
        txtAuthorName.setText(books.getAuthor());
        txtPages.setText(String.valueOf(books.getPages()));
        txtLongDesc.setText(books.getLongDesc());
        Glide.with(this)
                .asBitmap().load(books.getUrl())
                .into(bookImage);


    }

    private void initViews() {
        btnCurrentlyReading2 = findViewById(R.id.btnCurrentlyReading2);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAlreadyRead2 = findViewById(R.id.btnAlreadyRead2);
        btnAddToFavorites = findViewById(R.id.btnAddToFavorites);

        bookImage = findViewById(R.id.bookImage);

        txtBookName2 = findViewById(R.id.txtBookName2);
        txtAuthorName = findViewById(R.id.txtAuthorName);
        txtPages = findViewById(R.id.txtPages);
        txtLongDesc = findViewById(R.id.txtLongDesc);
    }

}