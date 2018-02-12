package com.example.casper.githubconnection;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CASPER on 12.02.2018.
 */

public class SarkiCal extends Application{

    private final int   SONG_INITIAL_DELAY = 2; // higher value is more late start
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

    private List<Integer> songNotes = new ArrayList<>();
    private String[] sarkiAdi, sarkiMelodisi;
    int secilenSarkiIndeksi;
    private Context context;

    CountDownTimer cdTimer;

    public SarkiCal(Context context){
        this.context = context;
        this.secilenSarkiIndeksi = 0;
        SarkiListesiYukle();
        LoadSounds();
    }

    public SarkiCal(Context context, int baslangicSarkiIndeksi){
        this.context = context;
        this.secilenSarkiIndeksi = baslangicSarkiIndeksi;
        SarkiListesiYukle();
        LoadSounds();
    }

    public void setSecilenSarkiIndeksi(int secilenSarkiIndeksi){
        this.secilenSarkiIndeksi = secilenSarkiIndeksi;
    }

    public int getSecilenSarkiIndeksi(){
        return secilenSarkiIndeksi;
    }

    public void LoadSounds(){
        mSoundPool = new SoundPool(NR_OF_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC, 0);

        mDoSoundId = mSoundPool.load(context, R.raw.note_do, 1);
        mReSoundId = mSoundPool.load(context, R.raw.note_re, 1);
        mMiSoundId = mSoundPool.load(context, R.raw.note_mi, 1);
        mFaSoundId = mSoundPool.load(context, R.raw.note_fa, 1);
        mSolSoundId = mSoundPool.load(context, R.raw.note_sol, 1);
        mLaSoundId = mSoundPool.load(context, R.raw.note_la, 1);
        mSiSoundId = mSoundPool.load(context, R.raw.note_si, 1);
    }

    public void SarkiListesiYukle(){
        SarkiListesi sl = (SarkiListesi) context;
        sarkiAdi = sl.getSarkiAdi();
        sarkiMelodisi = sl.getSarkiMelodisi();
    }

    public void PlayDo()
    {
        mSoundPool.play(mDoSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayRe()
    {
        mSoundPool.play(mReSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayMi()
    {
        mSoundPool.play(mMiSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayFa()
    {
        mSoundPool.play(mFaSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlaySol()
    {
        mSoundPool.play(mSolSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlayLa()
    {
        mSoundPool.play(mLaSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlaySi()
    {
        mSoundPool.play(mSiSoundId, LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
    }

    public void PlaySong(int songName, int songSpeed)
    {
        String  note    =   "";
        String  song    =   sarkiMelodisi[0];

        for (int i = 0; i < song.length(); i++)
        {
            if(song.charAt(i) != ' ' && song.charAt(i) != '.')
            {
                note = note + song.charAt(i);
            }
            else
            {
                switch (note)
                {
                    case "do":      songNotes.add(mDoSoundId);  break;
                    case "re":      songNotes.add(mReSoundId);  break;
                    case "mi":      songNotes.add(mMiSoundId);  break;
                    case "fa":      songNotes.add(mFaSoundId);  break;
                    case "sol":     songNotes.add(mSolSoundId); break;
                    case "la":      songNotes.add(mLaSoundId);  break;
                    case "si":      songNotes.add(mSiSoundId);  break;
                    case "wait":    songNotes.add(0);           break;
                    default:        songNotes.add(0);           break;
                }

                note = "";
            }
        }

            cdTimer = new CountDownTimer(songSpeed * (songNotes.size() + SONG_INITIAL_DELAY), songSpeed) {
            private int noteNo = -SONG_INITIAL_DELAY;

            @Override
            public void onTick(long l) {
                noteNo++;
                if(noteNo >= 0 && noteNo < songNotes.size())
                {
                    if(songNotes.get(noteNo) != 0)
                    {
                        mSoundPool.play(songNotes.get(noteNo), LEFT_VOLUME, RIGHT_VOLUME, NO_LOOP, PRIORITY, NORMAL_PLAY_RATE);
                    }
                }
            }

            @Override
            public void onFinish() {
                noteNo = 0;
            }
        };

        cdTimer.start();
    }

    public void StopSong(){
        cdTimer.cancel();
    }
}
