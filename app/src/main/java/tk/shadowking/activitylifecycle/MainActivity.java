package tk.shadowking.activitylifecycle;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imp = (Button) findViewById(R.id.imp);
        final Button exp = (Button) findViewById(R.id.exp);
        final Button down = (Button) findViewById(R.id.down);
        final EditText msg = (EditText) findViewById(R.id.msg);

        final CheckBox c1 = (CheckBox) findViewById(R.id.check1);
        final CheckBox c2 = (CheckBox) findViewById(R.id.check2);
        final CheckBox c3 = (CheckBox) findViewById(R.id.check3);

        imp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent impIntent = new Intent();
                        impIntent.setAction(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT,msg.getText()).setType("text/plain");
                        if (impIntent.resolveActivity(getPackageManager()) != null)
                            startActivity(impIntent);
                        //startActivity(new Intent().setAction(Intent.ACTION_SEND).putExtra(Intent.EXTRA_TEXT,msg.getText()).setType("text/plain"));
                    }
                }
        );

        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), explicit.class).putExtra("MESSAGE", msg.getText().toString()) );
            }
        });

        down.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent downloaderService = new Intent(getApplicationContext(), DOWNLOAD_SERVICE.getClass());

                downloaderService.setData(Uri.parse("http://www.pdf995.com/samples/pdf.pdf"));
                startService(downloaderService);
            }

        });

        Toast.makeText(this, "Main Activity Created",
                Toast.LENGTH_SHORT).show();
    }


    /*@Override
    protected void onStart(){
        super.onStart();

        Toast.makeText(this, "Main Activity Started",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "Main Activity Resumed",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause(){
        super.onPause();

        Toast.makeText(this, "Main Activity Paused",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop(){
        super.onStop();

        Toast.makeText(this, "Main Activity Stopped",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        Toast.makeText(this, "Main Activity Destroyed",
                Toast.LENGTH_SHORT).show();
    }*/
}
