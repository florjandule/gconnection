package com.example.casper.githubconnection;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SARKI_LISTESI = 100;

    private final int   NR_OF_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int   NO_LOOP = 0;
    private final int   PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    private SoundPool mSoundPool;
    private int mDoSoundId;
    private int mReSoundId;
    private int mMiSoundId;
    private int mFaSoundId;
    private int mSolSoundId;
    private int mLaSoundId;
    private int mSiSoundId;


    String[] sarkiAdi, sarkiMelodisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SarkiListesiYukle();
        SarkiyiEkranaYukle(0);
        LoadSounds();
    }


    public void LoadSounds(){
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        mDoSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_do, 1);
        mReSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_re, 1);
        mMiSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_mi, 1);
        mFaSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_fa, 1);
        mSolSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_sol, 1);
        mLaSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_la, 1);
        mSiSoundId = mSoundPool.load(getApplicationContext(), R.raw.note_si, 1);
    }

    public void PlayDo(View v)
    {
        mSoundPool.play(mDoSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);

    }

    public void PlayRe(View v)
    {
        mSoundPool.play(mReSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayMi(View v)
    {
        mSoundPool.play(mMiSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayFa(View v)
    {
        mSoundPool.play(mFaSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlaySol(View v)
    {
        mSoundPool.play(mSolSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayLa(View v)
    {
        mSoundPool.play(mLaSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlaySi(View v)
    {
        mSoundPool.play(mSiSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void BtnListClicked(View v){
        Intent sarkiListesiIntent = new Intent(this, SarkiYukleme.class);
        startActivityForResult(sarkiListesiIntent, REQUEST_CODE_SARKI_LISTESI);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_SARKI_LISTESI){
            if(resultCode == RESULT_OK){
                int secilenSarkiIndeksi = data.getIntExtra("SecilenSarkiIndeksi", -1);
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