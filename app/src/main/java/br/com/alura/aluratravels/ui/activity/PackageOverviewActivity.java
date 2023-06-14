package br.com.alura.aluratravels.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.Utils;
import br.com.alura.aluraviagens.model.PackageModel;

public class PackageOverviewActivity extends AppCompatActivity {

    PackageModel packageModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_overview);
        setTitle(getString(R.string.activity_package_overview_title));
        packageModel = Utils.verifyIfHasPackageOnIntent(this);
        bindPackagesOnViews(packageModel);
    }

    private void bindPackagesOnViews(PackageModel packageModel) {
        bindImage(packageModel.getImage());
        bindTextOnTextView(packageModel.getLocation(), R.id.package_overview_location);
        bindTextOnTextView(getString(R.string.days, packageModel.getDays()), R.id.package_overview_days);
        bindTextOnTextView(Utils.getPriceFormatted(packageModel.getPrice()), R.id.package_overview_price);
        bindTextOnTextView(Utils.getDestinationPeriodFormatted(packageModel.getDays(), this), R.id.package_overview_time);
        setButtonPayClickBehavior(packageModel);
    }

    private void bindImage(String imageName) {
        final ImageView imageBannerView = findViewById(R.id.package_overview_imageview);
        imageBannerView.setImageDrawable(Utils.getDrawableFromString(imageName, this));
    }

    private void bindTextOnTextView(String text, int viewIdentifier) {
        final TextView view = findViewById(viewIdentifier);
        view.setText(text);
    }

    private void setButtonPayClickBehavior(PackageModel packageModel) {
        final Button payButtonView = findViewById(R.id.package_overview_button_pay);
        payButtonView.setOnClickListener(v ->
                startActivity(
                        Utils.generateNewIntentWithPackage(PackageOverviewActivity.this,
                                PaymentActivity.class,
                                packageModel
                        )
                )
        );
    }
}