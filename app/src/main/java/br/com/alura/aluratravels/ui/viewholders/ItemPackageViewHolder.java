package br.com.alura.aluratravels.ui.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.alura.aluratravels.R;

public class ItemPackageViewHolder {
    public final TextView locationFieldView;
    public final ImageView imageView;
    public final TextView daysFieldView;
    public final TextView priceFieldView;

    public ItemPackageViewHolder(View view) {
        this.locationFieldView = view.findViewById(R.id.item_menu_city);
        this.imageView = view.findViewById(R.id.item_package_image);
        this.daysFieldView = view.findViewById(R.id.item_menu_days);
        this.priceFieldView = view.findViewById(R.id.item_menu_price);
    }
}
