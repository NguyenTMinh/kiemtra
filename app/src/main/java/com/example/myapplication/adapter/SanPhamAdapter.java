package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Callback;
import com.example.myapplication.R;
import com.example.myapplication.model.SanPham;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.SanPhamViewHolder> {
    private List<SanPham> mList;
    private Context mContext;
    private Callback mCallback;

    public SanPhamAdapter(List<SanPham> list, Context context, Callback callback) {
        mList = list;
        mContext = context;
        mCallback = callback;
    }

    @NonNull
    @Override
    public SanPhamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_sanpham,parent, false);
        return new SanPhamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamViewHolder holder, int position) {
        SanPham sanPham = mList.get(position);

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');

        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setDecimalFormatSymbols(symbols);
        decimalFormat.applyPattern("#,###");

        String giaTien = decimalFormat.format(sanPham.getTien()) + " ₫";

        holder.imageView.setImageResource(sanPham.getAnh());
        holder.textViewTen.setText(sanPham.getTen());
        holder.textGiaTien.setText(giaTien);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class SanPhamViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTen;
        TextView textGiaTien;
        Button button;

        public SanPhamViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_anhsanpham);
            textViewTen = itemView.findViewById(R.id.tv_tensanpham);
            textGiaTien = itemView.findViewById(R.id.tv_giatien);
            button = itemView.findViewById(R.id.bt_addgiohang);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCallback.add(getAdapterPosition());
                }
            });
        }
    }
}
