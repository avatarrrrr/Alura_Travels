package br.com.alura.aluratravels.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.com.alura.aluratravels.R;
import br.com.alura.aluratravels.ui.Utils;
import br.com.alura.aluraviagens.model.PackageModel;

public class PaymentActivity extends AppCompatActivity {
    TextView priceView;
    TextInputEditText cardNumberView;
    TextInputEditText cardValidityMonthView;
    TextInputEditText cardValidityYearView;
    TextInputEditText cardCVCView;
    TextInputEditText cardNameView;
    Button finishView;

    PackageModel packageModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(getString(R.string.activity_payment_title));
        packageModel = Utils.verifyIfHasPackageOnIntent(this);
        bindViews();
        setPrice();
    }

    private void bindViews() {
        priceView = findViewById(R.id.payment_price);
        cardNumberView = findViewById(R.id.payment_card_number_edit_text);
        cardValidityMonthView = findViewById(R.id.payment_card_validity_month_edit_text);
        cardValidityYearView = findViewById(R.id.payment_card_validity_year_edit_text);
        cardCVCView = findViewById(R.id.payment_card_cvc_edit_text);
        cardNameView = findViewById(R.id.payment_card_name_edit_text);
        finishView = findViewById(R.id.payment_button_finish);
    }

    private void setPrice() {
        priceView.setText(Utils.getPriceFormatted(packageModel.getPrice()));
    }
}
