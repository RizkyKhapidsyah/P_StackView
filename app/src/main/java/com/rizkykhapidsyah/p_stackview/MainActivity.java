package com.rizkykhapidsyah.p_stackview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StackView IDJAVA_SV_StackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IDJAVA_SV_StackView = findViewById(R.id.IDJAVA_SV_StackView);
        IDJAVA_SV_StackView.setInAnimation(this, android.R.animator.fade_in);
        IDJAVA_SV_StackView.setOutAnimation(this, android.R.animator.fade_out);

        StackViewAdapter albumAdapter = new StackViewAdapter(dapatkanPenyimpanan(), R.layout.item, MainActivity.this);

        IDJAVA_SV_StackView.setAdapter(albumAdapter);
    }

    private List<String> dapatkanPenyimpanan() {
        List<String> Penyimpanan = new ArrayList<String>();
        Penyimpanan.add("gambar1");
        Penyimpanan.add("gambar2");
        Penyimpanan.add("gambar3");
        Penyimpanan.add("gambar4");
        return Penyimpanan;
    }
}

class StackViewAdapter extends ArrayAdapter {

    private List<String> listPenyimpanan;
    private Context Konteks;
    private int itemLayout;

    public StackViewAdapter(List<String> Penyimpanan, int Sumber, Context Kntks) {
        super(Kntks, Sumber, Penyimpanan);
        listPenyimpanan = Penyimpanan;
        Konteks = Kntks;
        itemLayout = Sumber;
    }

    @Override
    public int getCount() {
        return listPenyimpanan.size();
    }

    @Override
    public String getItem(int Posisi) {
        return listPenyimpanan.get(Posisi);
    }

    @Override
    public View getView(int Posisi, View Lihat, @NonNull ViewGroup Induk) {
        if (Lihat == null) {
            Lihat = LayoutInflater.from(Induk.getContext())
                    .inflate(itemLayout, Induk, false);
        }

        String Simpan = listPenyimpanan.get(Posisi);

        TextView namaSimpan = Lihat.findViewById(R.id.IDXML_TV_Text);
        ImageView imageSimpan = Lihat.findViewById(R.id.IDXML_IV_Image);

        namaSimpan.setText(Simpan);

        int IdSumber = Konteks.getResources().getIdentifier(Simpan, "drawable", Konteks.getPackageName());
        imageSimpan.setImageResource(IdSumber);

        return Lihat;
    }
}
