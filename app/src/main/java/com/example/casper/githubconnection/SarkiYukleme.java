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


    ListView lvSarkiListesi;
    CustomAdapter customAdapter;
    String[] sarkiAdi, sarkiMelodisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sarki_array_list);

        SarkiListesiYukle();
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

    public void SarkiListesiYukle(){
        SarkiListesi sl = (SarkiListesi) getApplicationContext();
        sarkiAdi = sl.getSarkiAdi();
        sarkiMelodisi = sl.getSarkiMelodisi();
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
            return sarkiAdi.length;
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
            textViewName.setText(sarkiAdi[i]);

            lvSarkiListesi.setOnItemClickListener(this);

            return view;
        }
    }
}
