package com.dinhnt.sqliteca3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.dinhnt.sqliteca3.adapter.SanPhamAdapter;
import com.dinhnt.sqliteca3.dao.SanphamDAO;
import com.dinhnt.sqliteca3.model.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvSanPham;
    private SanphamDAO sanphamDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ
        lvSanPham = findViewById(R.id.lvSanPham);
        EditText edtTenSP = findViewById(R.id.edtTenSP);
        EditText edtGiaSP = findViewById(R.id.edtGiaSP);
        EditText edtHinhSP = findViewById(R.id.edtHinhSP);
        Button btnThemSP = findViewById(R.id.btnThemSP);
        Button btnCapNhatSP = findViewById(R.id.btnCapNhatSP);

        sanphamDAO = new SanphamDAO(MainActivity.this);

        getAllData();

        btnThemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensp  = edtTenSP.getText().toString();
                int giasp = Integer.parseInt(edtGiaSP.getText().toString());
                String hinhsp = edtHinhSP.getText().toString();

                SanPham sanPham = new SanPham(tensp, giasp, hinhsp);
                if(sanphamDAO.insertProduct(sanPham)){
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    getAllData();
                }else {
                    Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getAllData(){
        //data
        ArrayList<SanPham> alSanPham = sanphamDAO.getAll();

        //adapter
        SanPhamAdapter adapter = new SanPhamAdapter(alSanPham, MainActivity.this);

        //set adapter
        lvSanPham.setAdapter(adapter);
    }
}