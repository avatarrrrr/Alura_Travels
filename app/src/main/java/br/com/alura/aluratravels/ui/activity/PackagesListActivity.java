package br.com.alura.aluratravels.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.adapter.PackagesListAdapter;
import br.com.alura.aluraviagens.dao.PackagesDAO;

public class PackagesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_list);
        final ListView packagesListView = findViewById(R.id.packages_list_listview);
        packagesListView.setAdapter(new PackagesListAdapter(new PackagesDAO().generateList(), this));
    }
}