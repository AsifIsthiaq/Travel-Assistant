package resturentsactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.travel_assistantt.R;

public class SelectCity_RandA extends AppCompatActivity {

    ListView list_view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city__rand);






        list_view1 = (ListView) findViewById(R.id.list_view1);

        String[] values = new String[]{
                "BARISHAL",
                "COX'S BAZAR",
                "CHITTAGONG",
                "DHAKA",
                "DINAJPUR",
                "KHULNA",
                "KUSHTIA",
                "RAJSHAHI",
                "RANGPUR",
                "SHYLET"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1,values);

        list_view1.setAdapter(adapter);

        list_view1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;

                String ClickedValue = list_view1.getItemAtPosition(myPosition).toString();

                Toast.makeText(getApplicationContext(),"U Clicked "+ClickedValue,Toast.LENGTH_LONG).show();

                if(ClickedValue=="DHAKA"){
                    Intent i = new Intent(SelectCity_RandA.this, SelectResturantActivity.class); ///
                    startActivity(i);
                }
            }
        });
    }
}
