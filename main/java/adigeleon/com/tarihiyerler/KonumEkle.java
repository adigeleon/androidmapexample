package adigeleon.com.tarihiyerler;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class KonumEkle extends AppCompatActivity {

    static SQLiteDatabase database;
    EditText yer;
    EditText enlem;
    EditText boylam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konum_ekle);
        yer = (EditText) findViewById(R.id.editText);
        enlem = (EditText) findViewById(R.id.editText2);
        boylam = (EditText) findViewById(R.id.editText3);
    }

    public void ekle(View view) {
        try {
            database = this.openOrCreateDatabase("tarihiyerler", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS konumlar (yerismi NVARCHAR,enlem DOUBLE,boylam DOUBLE)");
            database.execSQL("INSERT INTO konumlar (yerismi,enlem,boylam) VALUES('" + yer.getText().toString() +"'," +
                    "'"+Double.parseDouble(enlem.getText().toString())+"','"+Double.parseDouble(boylam.getText().toString())+"')");
            Log.i("kayit", "'" + yer.getText().toString() + "'");
            Log.i("kayit2", "'" + enlem.getText().toString() + "'");
            Log.i("kayit3", "'" + boylam.getText().toString() + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);



    }
    }

