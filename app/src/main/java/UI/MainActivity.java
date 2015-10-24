package UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.nationalfreedays.R;

public class MainActivity extends AppCompatActivity {

    private Button mDaysButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDaysButton = (Button) findViewById(R.id.daysButton);
        mDaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FreeDaysActivity.class);
                    startActivity(intent);
            }
        });
    }

}
