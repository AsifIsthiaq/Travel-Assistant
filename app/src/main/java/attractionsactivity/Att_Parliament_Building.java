package attractionsactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.travel_assistantt.R;

public class Att_Parliament_Building extends AppCompatActivity {

    TextView tv1;

    private static ImageView imgView;
    private static Button buttonSbm;

    private SeekBar seekBar;
    private TextView textView;
    private int current_image_index;
    int[] images = {R.drawable.pb2,R.drawable.pb3,R.drawable.pb4,R.drawable.pb5,R.drawable.pb6,R.drawable.pb7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att__parliament__building);

        imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setImageResource(R.drawable.pb1);

        tv1=(TextView) findViewById(R.id.tv1);
        tv1.setText("# Jatiyo Sangsad Bhaban or National Parliament House, is the house of the Parliament of Bangladesh," +
                " located at Sher-e-Bangla Nagar in the Bangladeshi capital of Dhaka.");


        buttonClick();

    }
    public void MoreInfoButtonClickedd(View v){
        tv1.setText("");
        tv1.setText("#Type: National Assembly Building\n" +
                "Architectural style: Modern, Monumental\n" +
                "Location: Dhaka, Bangladesh\n" +
                "Construction started: 1961\n" +
                "Completed: 1982\n" +
                "Cost: US$32 million");
    }
    public  void buttonClick() {
        imgView = (ImageView)findViewById(R.id.imageView);
        buttonSbm =(Button)findViewById(R.id.button);
        buttonSbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current_image_index++;
                        current_image_index = current_image_index % images.length;
                        imgView.setImageResource(images[current_image_index]);
                        //imgView.setImageResource(R.drawable.and_image2);
                    }
                }
        );
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

