package com.example.casper.githubconnection;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ONE = 100;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void SarkiListesiAc(View v){
    }
}