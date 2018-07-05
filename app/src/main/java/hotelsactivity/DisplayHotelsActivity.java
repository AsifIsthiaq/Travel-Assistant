package hotelsactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.travel_assistantt.R;

import java.util.ArrayList;

import data.DatabaseHandler;
import model.MyHotel;


public class DisplayHotelsActivity extends Activity {
    private DatabaseHandler dba;
    private ArrayList<MyHotel> dbHotels = new ArrayList<>(); //dbWishes
    private WishAdapter wishAdapter;
    private ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_hotels);

        listView = (ListView) findViewById(R.id.list);

        refreshData();



    }

    private void refreshData() {
        dbHotels.clear();
        dba = new DatabaseHandler(getApplicationContext());

        ArrayList<MyHotel> hotelsFromDB = dba.getWishes(); //wishesFromDB

        for (int i = 0; i < hotelsFromDB.size(); i++){

            String title = hotelsFromDB.get(i).getTitle();
            String dateText = hotelsFromDB.get(i).getRecordDate();
            String content = hotelsFromDB.get(i).getContent();
            int mid = hotelsFromDB.get(i).getItemId();


            //Log.v("IDs: " , String.valueOf(mid));

            MyHotel myWish = new MyHotel();
            myWish.setTitle(title);
            myWish.setContent(content);
            myWish.setRecordDate(dateText);
            myWish.setItemId(mid);



            dbHotels.add(myWish);


        }
        dba.close();

        //setup adapter
        wishAdapter = new WishAdapter(DisplayHotelsActivity.this,R.layout.wish_row, dbHotels);
        listView.setAdapter(wishAdapter);
        wishAdapter.notifyDataSetChanged();


    }

    public class WishAdapter extends ArrayAdapter<MyHotel>{
        Activity activity;
        int layoutResource;
        MyHotel wish;
        ArrayList<MyHotel> mData = new ArrayList<>();

        public WishAdapter(Activity act, int resource, ArrayList<MyHotel> data) {
            super(act, resource, data);
            activity = act;
            layoutResource = resource;
            mData = data;
            notifyDataSetChanged();


        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public MyHotel getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(MyHotel item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            ViewHolder holder = null;

            if ( row == null || (row.getTag()) == null){

                LayoutInflater inflater = LayoutInflater.from(activity);

                row = inflater.inflate(layoutResource, null);
                holder = new ViewHolder();

                holder.mTitle = (TextView) row.findViewById(R.id.name);
                holder.mDate = (TextView) row.findViewById(R.id.dateText);



                row.setTag(holder);

            }else {

                holder = (ViewHolder) row.getTag();
            }

            holder.myWish = getItem(position);

            holder.mTitle.setText(holder.myWish.getTitle());
            //holder.mDate.setText(holder.myWish.getRecordDate());
            holder.mDate.setText("");



            final ViewHolder finalHolder = holder;
            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String text = finalHolder.myWish.getContent().toString();
                    String dateText = finalHolder.myWish.getRecordDate().toString();
                    String title = finalHolder.myWish.getTitle().toString();

                    int mid = finalHolder.myWish.getItemId();

                    Log.v("MyId: " , String.valueOf(mid));


//




                    Intent i = new Intent(DisplayHotelsActivity.this, HotelDetailActivity.class);
                    i.putExtra("content", text);
                    i.putExtra("date", dateText);
                    i.putExtra("title", title);
                    i.putExtra("id", mid);


                    startActivity(i);

                }
            });




            return row;

        }





        class ViewHolder{

            MyHotel myWish;
            TextView mTitle;
            int mId;
            TextView mContent;
            TextView mDate;

        }

    }


}
