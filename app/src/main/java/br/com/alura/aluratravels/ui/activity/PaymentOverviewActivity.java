package br.com.alura.aluratravels.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.Utils;
import br.com.alura.aluraviagens.model.PackageModel;

public class PaymentOverviewActivity extends AppCompatActivity {
    private PackageModel packageReceived;
    ImageView locationImageView;
    TextView locationCityView;
    TextView periodTimeView;
    TextView priceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_overview);
        setTitle(getString(R.string.activity_payment_overview_title));
        packageReceived = Utils.verifyIfHasPackageOnIntent(this);
        bindViews();
        bindPackageOnViews();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, PackagesListActivity.class));
    }

    private void bindPackageOnViews() {
        locationImageView.setImageDrawable(Utils.getDrawableFromString(packageReceived.getImage(), this));
        locationCityView.setText(packageReceived.getLocation());
        periodTimeView.setText(Utils.getDestinationPeriodFormatted(packageReceived.getDays(), this));
        priceView.setText(Utils.getPriceFormatted(packageReceived.getPrice()));
    }

    private void bindViews() {
        locationImageView = findViewById(R.id.payment_overview_imageview_location);
        locationCityView = findViewById(R.id.payment_overview_textView_location);
        periodTimeView = findViewById(R.id.payment_overview_textView_period_time);
        priceView = findViewById(R.id.payment_overview_textView_price);
    }
}