package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<SanPham> mGioHang;
    private List<String> mTenSanPham;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giohang_activity);

        mGioHang = DataCache.sGioHang;
        mTenSanPham = new ArrayList<>();
        for (SanPham sanPham: mGioHang) {
            mTenSanPham.add(sanPham.getTen());
        }

        mListView = findViewById(R.id.rv_giohang);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mTenSanPham);
        mListView.setAdapter(mAdapter);
    }
}
