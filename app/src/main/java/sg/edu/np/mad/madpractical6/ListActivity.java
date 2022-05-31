package sg.edu.np.mad.madpractical6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Random rando = new Random();
        ArrayList<User> userList = new ArrayList<User>(){};
        DBHandler db = new DBHandler(this);

        if (db.CountUsers() == 0)
        {
            for (int i = 0; i < 20; i++)
            {
                String desc = "Description " + rando.nextInt(1000000000);
                String name = "Name" + rando.nextInt(1000000000);
                db.insertUser(new User(name, desc, i, rando.nextBoolean()));
            }
        }

        userList = db.getUsers();

        RecyclerView rv = findViewById(R.id.recyclerView);
        UsersAdapter adapter = new UsersAdapter(ListActivity.this, userList);
        LinearLayoutManager layout = new LinearLayoutManager(this);

        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);
    }
}