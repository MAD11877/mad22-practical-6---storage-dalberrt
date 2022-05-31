package sg.edu.np.mad.madpractical6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);
        Intent receiveListActivity = getIntent();
        User u = (User) receiveListActivity.getSerializableExtra("user");

        Button followBtn = findViewById(R.id.followBtn);
        Button messageBtn = findViewById(R.id.messageBtn);
        TextView username = findViewById(R.id.loginUsername);
        username.setText(u.Name);
        TextView desc = findViewById(R.id.desc);
        desc.setText(u.Description);

        followBtn.setText(u.Followed ? "Unfollow" : "Follow");
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (followBtn.getText() == "Follow")    //followBtn.setText(user1.Followed ? "Unfollow" : "Follow")
                {
                    followBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    followBtn.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                u.Followed = !u.Followed;
                db.updateUser(u);
            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent messageGroup = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(messageGroup);
            }
        });


    }
}