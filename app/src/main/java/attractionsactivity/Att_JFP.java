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

public class Att_JFP extends AppCompatActivity {

    TextView tv1;

    private static ImageView imgView;
    private static Button buttonSbm;

    private SeekBar seekBar;
    private TextView textView;
    private int current_image_index;
    int[] images = {R.drawable.jfp2,R.drawable.jfp3,R.drawable.jfp3,R.drawable.jfp4,R.drawable.jfp5,R.drawable.jfp6,R.drawable.jfp7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_att__jfp);

        imgView = (ImageView)findViewById(R.id.imageView);
        imgView.setImageResource(R.drawable.jfp1);

        tv1=(TextView) findViewById(R.id.tv1);
        tv1.setText("# Conveniently and superbly located in the blooming commercial hub of Baridhara and" +
                "\n Airport Road point over one of the main artery of the Capital City."+
                "\nIt is flanked by Dhakas prestigious business & diplomatic zone of Gulshan, Banani & Baridhara," +
                " just a 5 minute drive to ZIA International Airport");

        buttonClick();

    }
    public void MoreInfoButtonClicked(View v){
        tv1.setText("");
        tv1.setText("#HAS 9(NINE) FLOORS"+
        "\n*Lower and Middle Basement Floor: Reserved for car parking.\n"

        +"\n*From Ground Floor to Fifth Floor : Different category local and international brand shops / outlet / show rooms\n"
        +"Fifth Floor: Entertainment, amusement and recreation floor.");
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


