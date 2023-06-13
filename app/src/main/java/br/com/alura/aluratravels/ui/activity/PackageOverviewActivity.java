package br.com.alura.aluratravels.ui.activity;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.Utils;
import br.com.alura.aluraviagens.model.PackageModel;

public class PackageOverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_overview);
        setTitle(getString(R.string.activity_package_overview_title));

        final PackageModel packageModel = new PackageModel("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal("421.50"));

        bindPackagesOnViews(packageModel);
    }

    private void bindPackagesOnViews(PackageModel packageModel) {
        bindImage(packageModel.getImage());
        bindTextOnTextView(packageModel.getLocation(), R.id.package_overview_location);
        bindTextOnTextView(getString(R.string.days, packageModel.getDays()), R.id.package_overview_days);
        bindTextOnTextView(Utils.getPriceFormatted(packageModel.getPrice()), R.id.package_overview_price);
        bindTextOnTextView(getDestinationPeriodFormatted(packageModel.getDays()), R.id.package_overview_time);
    }

    private void bindImage(String imageName) {
        final ImageView imageBannerView = findViewById(R.id.package_overview_imageview);
        imageBannerView.setImageDrawable(Utils.getDrawableFromString(imageName, this));
    }

    private void bindTextOnTextView(String text, int viewIdentifier) {
        final TextView view = findViewById(viewIdentifier);
        view.setText(text);
    }

    private String getDestinationPeriodFormatted(int daysToTravel) {
        final Calendar dateToStartTravel = Calendar.getInstance();
        final Calendar dateToFinishTravel = Calendar.getInstance();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM", Locale.getDefault());

        dateToFinishTravel.add(Calendar.DATE, daysToTravel);

        final String dateToStartTravelFormatted = dateFormat.format(dateToStartTravel.getTime());
        final String dateToFinishTravelFormatted = dateFormat.format(dateToFinishTravel.getTime());

        return getString(R.string.activity_package_overview_travel_time, dateToStartTravelFormatted, dateToFinishTravelFormatted, dateToFinishTravel.get(Calendar.YEAR));
    }
}