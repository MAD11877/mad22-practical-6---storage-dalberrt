package sg.edu.np.mad.madpractical6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://mad-practical-6-realtime-db-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("Users");

        TextInputLayout username = findViewById(R.id.usernameLayout);
        TextInputLayout password = findViewById(R.id.passwordLayout);
        Button loginBtn = findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot user : dataSnapshot.getChildren() ){
                            if (user.child("username").getValue().toString().equals(username.getEditText().getText().toString()))
                            {
                                if (user.child("password").getValue().toString().equals(password.getEditText().getText().toString()))
                                {
                                    Intent ListActivity = new Intent(Login.this, ListActivity.class);
                                    startActivity(ListActivity);
                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {

                    }


                });
            }
        });
    }
}