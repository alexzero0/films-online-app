package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textLogin, textPassword;
    DBusers dbUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLogin = findViewById(R.id.editTextTextPersonName);
        textPassword = findViewById(R.id.editTextTextPassword);

        dbUsers = new DBusers(this);
    }

    public void SigIn(View view)
    {
        Button SigIn = findViewById(R.id.button);
        Intent PrimIn = new Intent(this, PrimaryActivity.class);
        String tLogin = textLogin.getText().toString();
        Log.i("Myeror ", tLogin);
        PrimIn.putExtra("MyKey",tLogin);
        if(checkAuth())
        {
            startActivity(PrimIn);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkAuth()
    {
        SQLiteDatabase database = dbUsers.getReadableDatabase();
        Cursor cursor = database.query(dbUsers.TABLE_CONTACTS,
                null,null,null,null,null,null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(dbUsers.KEY_ID);
            int myID = cursor.getColumnIndex(dbUsers.KEY_USERS);
            int nameIndex = cursor.getColumnIndex(dbUsers.KEY_NAME);
            int emailIndex = cursor.getColumnIndex(dbUsers.KEY_PASS);
            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", userID = " + cursor.getString(myID) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", pass = " + cursor.getString(emailIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        if (cursor.moveToFirst())
        {
            int idIndex = cursor.getColumnIndex(dbUsers.KEY_ID);
            int myID = cursor.getColumnIndex(dbUsers.KEY_USERS);
            int nameIndex = cursor.getColumnIndex(dbUsers.KEY_NAME);
            int passIndex = cursor.getColumnIndex(dbUsers.KEY_PASS);
            do {
                String name = cursor.getString(nameIndex);
                if(textLogin.getText().toString().equals(name))
                {
                    String pass = cursor.getString(passIndex);
                    if(textPassword.getText().toString().equals(pass))
                    {
                        cursor.close();
                        return true;
                    }
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return false;
    }


}