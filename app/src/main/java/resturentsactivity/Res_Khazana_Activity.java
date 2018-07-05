package resturentsactivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.travel_assistantt.R;

import resturants.Resturant;

public class Res_Khazana_Activity extends AppCompatActivity {

    TextView tv1,tv2,tv3;
    Button buttonMoreinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res__khazana_);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        buttonMoreinfo = (Button) findViewById(R.id.buttonMoreinfo);
        //tv1.setText("Asif Isthiaq");
        //ArrayList<Resturant> myResList = new ArrayList<>();

        Resturant res1 = new Resturant();
        res1.setAddress("Address:"+ "\n" +"    House#09,Road#55 Gulshan #2" + "\n          " + "Dhaka-1212, Bangladesh");
        res1.setEmail("Email:"+"\n"+"khazana_restaurant@yahoo.com");
        res1.setTelephone("Phone:"+"\n"+"         01711 476379, 01818 236817");

        //myResList.add(res1);

        tv1.setText(res1.getAddress().toString());
        tv2.setText(res1.getEmail().toString());
        tv3.setText(res1.getTelephone().toString());

        buttonMoreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Res_Khazana_Activity.this, KhajanaMoreInfo_Activity.class);
                startActivity(i);
            }
        });
    }
}
