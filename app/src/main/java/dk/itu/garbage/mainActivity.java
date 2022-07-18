package dk.itu.garbage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {

    //Shopping V1

    // GUI variables
    private Button listItems;
    private Button addNew;
    private TextView items;
    private EditText itemsEdit;

    // Model: Database of items
    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.garbage);
        items = findViewById(R.id.items);
        itemsEdit = findViewById(R.id.plain_text_input);
        listItems= findViewById(R.id.list_button);
        addNew = findViewById(R.id.add_new);

        itemsDB.initialize(mainActivity.this);
        itemsDB = ItemsDB.get();




        items.setVisibility(View.GONE);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(itemsDB.listItems());
                itemsEdit.setVisibility(View.GONE);
                items.setVisibility(View.VISIBLE);
                items.setBackgroundColor(Color.parseColor("#FFFFFF"));
                String msg = itemsDB.garbageLookup(itemsEdit.getText().toString()).trim();
                items.setText(msg);



            }
        }

        );

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity.this, addActivity.class);
                startActivity(intent);
            }
        });



    }
}