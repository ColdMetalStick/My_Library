package nunu.org.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnAllBooks, btnCurrentlyReading, btnAlreadyRead, btnWishlist, btnFavorites, btnAbout;

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnAllBooks:
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
                break;

            case R.id.btnCurrentlyReading:
                intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
                break;

            case R.id.btnAlreadyRead:
                intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
                break;

            case R.id.btnWishlist:
                intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
                break;

            case R.id.btnFavorites:
                intent = new Intent(MainActivity.this, FavoriteBookActivity.class);
                startActivity(intent);
                break;

            case R.id.btnAbout:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Designed and developed by Nunu, check out my website :D");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra("url","https://coldmetalstick.github.io");
                        startActivity(intent);
                    }
                });

                builder.create().show();
            default:
                break;


        }
    }

    private void initViews() {
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWishlist = findViewById(R.id.btnWishlist);
        btnFavorites = findViewById(R.id.btnFavorites);
        btnAbout = findViewById(R.id.btnAbout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(this);
        btnCurrentlyReading.setOnClickListener(this);
        btnAlreadyRead.setOnClickListener(this);
        btnWishlist.setOnClickListener(this);
        btnFavorites.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

        Utils.getInstance(this);



    }



}