package com.example.casper.githubconnection;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SARKI_LISTESI = 100;
    private String[] sarkiAdi, sarkiMelodisi;
    int secilenSarkiIndeksi = 0;
    SarkiCal sarkiCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SarkiListesiYukle();
        SarkiyiEkranaYukle(0);
        sarkiCal = new SarkiCal(getApplicationContext());
    }

    public void PlayDo(View v)
    {
        sarkiCal.PlayDo();
    }

    public void PlayRe(View v)
    {
        sarkiCal.PlayRe();
    }

    public void PlayMi(View v)
    {
        sarkiCal.PlayMi();
    }

    public void PlayFa(View v)
    {
        sarkiCal.PlayFa();
    }

    public void PlaySol(View v)
    {
        sarkiCal.PlaySol();
    }

    public void PlayLa(View v)
    {
        sarkiCal.PlayLa();
    }

    public void PlaySi(View v)
    {
        sarkiCal.PlaySi();
    }

    public void BtnListClicked(View v){
        Intent sarkiListesiIntent = new Intent(this, SarkiYukleme.class);
        startActivityForResult(sarkiListesiIntent, REQUEST_CODE_SARKI_LISTESI);
    }

    public void BtnSarkiCal_Clicked(View v){
        sarkiCal.PlaySong(this.secilenSarkiIndeksi, 400);
        Button btnSarkiCal = findViewById(R.id.btnSarkiCal);
        Button btnSarkiCalIptal = findViewById(R.id.btnSarkiCalIptal);
        btnSarkiCal.setVisibility(View.INVISIBLE);
        btnSarkiCalIptal.setVisibility(View.VISIBLE);
        btnSarkiCal.bringToFront();
    }

    public void BtnSarkiCalIptal_Clicked(View v){
        sarkiCal.StopSong();
        Button btnSarkiCal = findViewById(R.id.btnSarkiCal);
        Button btnSarkiCalIptal = findViewById(R.id.btnSarkiCalIptal);
        btnSarkiCal.setVisibility(View.VISIBLE);
        btnSarkiCalIptal.setVisibility(View.INVISIBLE);
        btnSarkiCalIptal.bringToFront();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_SARKI_LISTESI){
            if(resultCode == RESULT_OK){
                secilenSarkiIndeksi = data.getIntExtra("SecilenSarkiIndeksi", -1);
                if(secilenSarkiIndeksi != -1){
                    SarkiyiEkranaYukle(secilenSarkiIndeksi);
                }
            }
        }
    }

    public void SarkiListesiYukle(){
        SarkiListesi sl = (SarkiListesi) getApplicationContext();
        sarkiAdi = sl.getSarkiAdi();
        sarkiMelodisi = sl.getSarkiMelodisi();
    }

    public void SarkiyiEkranaYukle(int sarkiIndex){
        TextView tvSarkiAdi = findViewById(R.id.tvSarkiAdi);
        TextView tvSarkiMelodisi = findViewById(R.id.tvSarkiMelodisi);

        tvSarkiAdi.setText(sarkiAdi[sarkiIndex].toString());
        tvSarkiMelodisi.setText(sarkiMelodisi[sarkiIndex].toString());
    }
}