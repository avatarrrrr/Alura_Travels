package br.com.alura.aluratravels.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.Utils;
import br.com.alura.aluratravels.ui.adapter.PackagesListAdapter;
import br.com.alura.aluraviagens.dao.PackagesDAO;
import br.com.alura.aluraviagens.model.PackageModel;

public class PackagesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_list);
        setTitle(getString(R.string.packages_list_activity_title));
        configListView();
    }

    private void configListView() {
        final ListView packagesListView = findViewById(R.id.packages_list_listview);
        final PackagesListAdapter adapter = new PackagesListAdapter(new PackagesDAO().generateList(), this);

        packagesListView.setAdapter(adapter);
        setOnItemClickBehavior(packagesListView);
    }

    private void setOnItemClickBehavior(ListView packagesListView) {
        packagesListView.setOnItemClickListener((parent, view, position, id) -> startActivity(
                        Utils.generateNewIntentWithPackage(
                                PackagesListActivity.this,
                                PackageOverviewActivity.class,
                                (PackageModel) parent.getItemAtPosition(position)
                        )
                )
        );
    }
}