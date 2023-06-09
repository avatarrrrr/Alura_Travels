package br.com.alura.aluratravels.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
}