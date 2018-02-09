package com.example.casper.githubconnection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CASPER on 9.02.2018.
 */

public class SarkiYukleme extends AppCompatActivity{

   private final String[] sarkiAdi = {
            "Şarkı 1"
            , "Şarkı 2"
            , "Şarkı 3"
            , "Şarkı 4"
            , "Şarkı 5"
            , "Şarkı 6"
            , "Şarkı 7"
            , "Şarkı 8"
            , "Şarkı 9"
            , "Şarkı 10"
            , "Şarkı 11"
            , "Şarkı 12"
            , "Şarkı 13"
            , "Şarkı 14"
            , "Şarkı 15"
    };

    private final String sarkiMelodisi[] = {
            "sol mi mi mi sol mi mi mi sol la sol mi fa re fa re re fa re re re fa sol fa re re do"
            ,"re mi fa sol la si"
            ,"do re mi fa sol la si"
            ,"do re mi fa sol la si do re mi fa sol la si"
            ,"do re mi fa fa re re sol la si"
            ,"mi fa re sol la re re re fa re mi fa sol la si"
            ,"fa re mi do re mi fa sol la si"
            ,"mi sol la re do re mi fa sol la si"
            ,"la sol la sol la sol do re mi fa sol la si"
            ,"si la si la do re mi fa sol la si"
            ,"do do do do do re mi fa sol la si"
            ,"fa fa fa re re do re mi fa sol la si"
            ,"mi fa sol re mi fa sol do re mi fa sol la si"
            ,"sol mi mi mi sol mi mi mi sol la sol mi fa re do re mi fa sol la si"
            ,"fa re re re fa re re re re sol sol sol do re mi fa sol la si"
    };

    ListView lvSarkiListesi;
    CustomAdapter customAdapter;
    int sarkiListesiUzunluk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sarki_array_list);

        sarkiListesiUzunluk = getIntent().getIntExtra("ListeUzunlugu", 1);
        SarkiListesiOlustur();
    }


    public void SarkiListesiOlustur() {
//        View view = getLayoutInflater().inflate(R.layout.sarki_array_list, null);

        try {
            lvSarkiListesi = findViewById(R.id.lvSarkiListesi);

            customAdapter = new CustomAdapter();
            lvSarkiListesi.setAdapter(customAdapter);

        }catch (Exception e) {
            Log.d("hata", e.getMessage());
        }
    }
    class CustomAdapter extends BaseAdapter implements AdapterView.OnItemClickListener{

        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Intent sendToMainIntent = new Intent();
            sendToMainIntent.putExtra("SecilenSarkiIndeksi", position);
            setResult(RESULT_OK, sendToMainIntent);
            finish();
        }

        @Override
        public int getCount() {
            return sarkiListesiUzunluk;
        }

        @Override
        public Object getItem(int i) {
            return 0;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.sarki_item, null);

            TextView textViewName = view.findViewById(R.id.textView2);
            textViewName.setText("*    " + sarkiAdi[i]);

            lvSarkiListesi.setOnItemClickListener(this);

            return view;
        }
    }
}
