package com.dinhnt.sqliteca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.dinhnt.sqliteca3.adapter.SanPhamAdapter;
import com.dinhnt.sqliteca3.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        ListView lvSanPham = findViewById(R.id.lvSanPham);

        //data
        ArrayList<SanPham> alSanPham = new ArrayList<>();
        alSanPham.add(new SanPham(1, "Sản phẩm A", 1000, "1.jpg"));
        alSanPham.add(new SanPham(2, "Sản phẩm B", 7000, "1.jpg"));
        alSanPham.add(new SanPham(3, "Sản phẩm B", 6000, "1.jpg"));
        alSanPham.add(new SanPham(4, "Sản phẩm D", 5000, "1.jpg"));
        alSanPham.add(new SanPham(5, "Sản phẩm E", 3000, "1.jpg"));

        //adapter
        SanPhamAdapter adapter = new SanPhamAdapter(alSanPham, MainActivity.this);

        //set adapter
        lvSanPham.setAdapter(adapter);
    }
}