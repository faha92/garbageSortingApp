package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class addActivity extends AppCompatActivity {

    //Garbage V3

    // GUI variables
    private TextView message;
    private Button addNew;
    private EditText what;
    private EditText where;
    // Model: Database of items

    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        message = findViewById(R.id.message);
        message.setText("Insert new item:");
        what = findViewById(R.id.what);
        where = findViewById(R.id.where);
        addNew= findViewById(R.id.add_new);


        addNew.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {
          itemsDB = itemsDB.get();
          itemsDB.addItem(what.getText().toString().trim(),where.getText().toString().trim());
          message = findViewById(R.id.message);
          message.setText("1 new item was added");
          Intent intent = new Intent(addActivity.this, mainActivity.class);
          startActivity(intent);



                                         }
                                     }



        );




    }
}