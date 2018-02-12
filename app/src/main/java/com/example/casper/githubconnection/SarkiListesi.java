package com.example.casper.githubconnection;

import android.app.Application;

/**
 * Created by CASPER on 10.02.2018.
 */

public class SarkiListesi extends Application {

    final String[] sarkiAdi = {
            "Jingle Bell"
            , "Küçük Kurbağa"
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

    final String sarkiMelodisi[] = {
            "mi mi mi wait mi mi mi wait mi sol do re mi wait wait fa fa fa wait mi mi mi wait re mi re sol wait wait mi mi mi wait " +
                    "mi mi mi wait mi sol do re mi wait wait fa fa fa wait mi mi mi wait sol sol fa re do."
            ,"sol mi mi mi sol mi mi mi sol la sol mi fa re wait wait fa re re re fa re re re fa sol fa re re do."
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

    public String[] getSarkiAdi(){
        return sarkiAdi;
    }

    public String[] getSarkiMelodisi(){
        return sarkiMelodisi;
    }
}
