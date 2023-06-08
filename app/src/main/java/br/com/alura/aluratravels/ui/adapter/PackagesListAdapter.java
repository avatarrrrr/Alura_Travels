package br.com.alura.aluratravels.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import java.util.List;
import java.util.Locale;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.viewholders.ItemPackageViewHolder;
import br.com.alura.aluraviagens.model.PackageModel;

public class PackagesListAdapter extends BaseAdapter {
    private final List<PackageModel> packages;
    private final Context context;

    public PackagesListAdapter(List<PackageModel> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Object getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = recuperateOrCreateNewView(convertView, parent);
        bindAPackageToView(position, view);

        return view;
    }

    private void bindAPackageToView(int position, View view) {
        final PackageModel packageItem = packages.get(position);

        final ItemPackageViewHolder holder = (ItemPackageViewHolder) view.getTag();

        holder.locationFieldView.setText(packageItem.getLocation());

        final Resources resources = context.getResources();
        @SuppressLint("DiscouragedApi") final int imageResourceID = resources.getIdentifier(packageItem.getImage(), "drawable", context.getPackageName());
        final Drawable imageDrawable = ResourcesCompat.getDrawable(resources, imageResourceID, context.getTheme());
        holder.imageView.setImageDrawable(imageDrawable);

        holder.daysFieldView.setText(context.getString(R.string.days, packageItem.getDays()));

        holder.priceFieldView.setText(String.format(Locale.getDefault(), "%f", packageItem.getPrice()));
    }

    @NonNull
    private View recuperateOrCreateNewView(View convertView, ViewGroup parent) {
        View view;
        ItemPackageViewHolder holder;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_package, parent, false);
            holder = new ItemPackageViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
        }

        return view;
    }
}
