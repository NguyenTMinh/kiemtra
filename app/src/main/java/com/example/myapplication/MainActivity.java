package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.SanPhamAdapter;
import com.example.myapplication.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback{
    private RecyclerView mRecyclerView;
    private SanPhamAdapter sanPhamAdapter;
    private List<SanPham> mList;
    private Button mButton;
    private List<SanPham> mGioHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mGioHang = DataCache.sGioHang;

        caiDatData();

        mButton = findViewById(R.id.bt_giohang);
        mRecyclerView = findViewById(R.id.rv_sanpham);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        sanPhamAdapter = new SanPhamAdapter(mList, this, this);
        mRecyclerView.setAdapter(sanPhamAdapter);

        mButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, GioHangActivity.class);
            startActivity(intent);
        });
    }

    private void caiDatData() {
        mList.add(new SanPham(R.drawable.anh1, "ELIO Nàng thơ 32mmm", 790000L));
        mList.add(new SanPham(R.drawable.anh2, "Casio 33.2mm nữ", 1200000L));
        mList.add(new SanPham(R.drawable.anh3, "Q&Q 38mm nữ", 490000L));

        mList.add(new SanPham(R.drawable.anh1, "ELIO Nàng thơ 32mmm", 790000L));
        mList.add(new SanPham(R.drawable.anh2, "Casio 33.2mm nữ", 1200000L));
        mList.add(new SanPham(R.drawable.anh3, "Q&Q 38mm nữ", 490000L));
    }

    @Override
    public void add(int pos) {
        mGioHang.add(mList.get(pos));
        Toast.makeText(this, "Đã thêm giỏ hàng", Toast.LENGTH_SHORT).show();
    }
}