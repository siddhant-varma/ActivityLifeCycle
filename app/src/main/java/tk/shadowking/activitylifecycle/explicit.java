package tk.shadowking.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.data;
import static tk.shadowking.activitylifecycle.R.string.act2;

public class explicit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        TextView text = (TextView) findViewById(R.id.activity2);

        text.setText( getIntent().getExtras().getString("MESSAGE") );
        Toast.makeText(this, "Explicit Activity Created",
                Toast.LENGTH_SHORT).show();

        /*if(act2!=null){
            String data = act2.getString("MESSAGE");
            text.setText( data );
        }*/
    }
}
