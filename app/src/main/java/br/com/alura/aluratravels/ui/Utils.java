package br.com.alura.aluratravels.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

import br.com.alura.aluratravels.R;
import br.com.alura.aluraviagens.model.PackageModel;

public class Utils {
    public static String getPriceFormatted(BigDecimal price) {
        final NumberFormat currencyInstance = DecimalFormat.getCurrencyInstance(Locale.getDefault());
        final String numberLocaleFormatted = currencyInstance.format(price);
        return numberLocaleFormatted.replace("$", "$ ");
    }

    @Nullable
    public static Drawable getDrawableFromString(String string, Context context) {
        final Resources resources = context.getResources();
        @SuppressLint("DiscouragedApi") final int imageResourceID = resources.getIdentifier(string, "drawable", context.getPackageName());
        return ResourcesCompat.getDrawable(resources, imageResourceID, context.getTheme());
    }

    public static PackageModel verifyIfHasPackageOnIntent(Activity context) {
        PackageModel result;
        final Intent intent = context.getIntent();
        if (intent.hasExtra(ActivitiesConstants.packageKey)) {
            result = intent.getParcelableExtra(ActivitiesConstants.packageKey);
        } else {
            result = new PackageModel("Belo Horizonte", "belo_horizonte_mg", 3, new BigDecimal("421.50"));
        }
        return result;
    }

    public static Intent generateNewIntentWithPackage(Context context, Class<?> activityClass, PackageModel packageModel) {
        final Intent intent = new Intent(context, activityClass);
        intent.putExtra(ActivitiesConstants.packageKey, packageModel);
        return intent;
    }

    public static String getDestinationPeriodFormatted(int daysToTravel, Activity context) {
        final Calendar dateToStartTravel = Calendar.getInstance();
        final Calendar dateToFinishTravel = Calendar.getInstance();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM", Locale.getDefault());

        dateToFinishTravel.add(Calendar.DATE, daysToTravel);

        final String dateToStartTravelFormatted = dateFormat.format(dateToStartTravel.getTime());
        final String dateToFinishTravelFormatted = dateFormat.format(dateToFinishTravel.getTime());

        return context.getString(R.string.activity_package_overview_travel_time, dateToStartTravelFormatted, dateToFinishTravelFormatted, dateToFinishTravel.get(Calendar.YEAR));
    }
}