package sg.edu.np.mad.madpractical6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MessageGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        Fragment fragment1 = new sg.edu.np.mad.madpractical6.Fragment1();
        Fragment fragment2 = new sg.edu.np.mad.madpractical6.Fragment2();
        Button group1 = findViewById(R.id.group1);
        Button group2 = findViewById(R.id.group2);

        group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, fragment1);
                ft.commit();
            }
        });

        group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, fragment2);
                ft.commit();

            }
        });

    }

}