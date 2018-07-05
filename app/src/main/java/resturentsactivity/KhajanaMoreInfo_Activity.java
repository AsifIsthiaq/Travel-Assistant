package resturentsactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.travel_assistantt.R;

public class KhajanaMoreInfo_Activity extends AppCompatActivity {

    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khajana_more_info_);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText("*Khazana is a treasure of Indian Cuisine."+ "\n" +
                "*Khazana is the place where the tradition is blended with modern twist." + "\n" +
                "*The traditional recipes which holds the heritage of Indian cuisine."+"\n"+
                "*Also has khazana mithai.");
    }
}
