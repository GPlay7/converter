package com.best.toukir.currencycinverter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class nternationalCurrencyActivity extends AppCompatActivity {


    String[] countryName = {"Argentina", "Australia", "Austria", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belgium", "Benin",
            "Brazil", "Bulgaria", "Burkina Faso", "Cameroon", "Canada", "Central African CFA", "Central African Republic", "Chad", "Chile", "China", "Colombia",
            "Croatian", "Cyprus", "Czech Republic", "Denmark", "Dominican Republic", "East Caribbean", "Egypt", "Equatorial Guinea", "Estonia", "Fiji", "Finland", "France", "French Pacific", "Gabon", "Germany",
            "Ghana", "Greece", "Guatemala", "Guinea-Bissau", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonessia", "Iran", "Ireland", "Israel", "Italy",
            "Ivory Cost", "Jamaica", "Japan", "Jordan", "Kenya", "Korea", "Kuwait", "Lativa", "Lithuania", "Luxembourg", "Malaysia", "Mali", "Malta", "Mauritius", "Maxico",
            "Morocco", "Myanmar", "Netherlands Antilles", "New Zealand", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama", "Papua New Guinea", "Peru",
            "Philippines", "Poland", "Portugal", "Qatar", "Republic of the Congo", "Romania", "Russian Federation", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
            "Singapore", "Slovakia", "Slovenia", "South Africa", "Spain", "Sri Lanka", "Sweden", "Switzerland", "Taiwan", "Taiwan", "Thailand", "The Netherlands", "Togo",
            "Trinidad and Tobago", "Trinidad and Tobago", "Turkey", "United Arab Emirates", "United Kingdom", "United States", "Venezuela", "Vietnam", "Zambia"};

    String[] countryCurrencyName = {"Argentine Peso", "Australian Dollar", "Euro", "Bahamian Dollar", "Bahraini Dinar",
            "Bangladeshi Taka", "Barbados Dollar", "Euro", "CFA Franc West", "Brazilian Real", "Bulgarian Lev", "CFA Franc West",
            "CFA Franc Central", "Canadian Dollar", "CFA Franc Central", "CFA Franc Central", "CFA Franc Central", "Chilean Peso", "Chinese Renminbi", "Colombian Peso",
            "Croatian Kuna", "Euro", "Czech Koruna", "Danish Krone", "Dominican Peso", "East Caribbean Dollar", "Egyptian Pound",
            "CFA Franc Central", "Euro", "Fiji Dollar", "Euro", "Euro", "French Pacific Francs", "CFA Franc Central", "Euro",
            "Ghanaian Cedi", "Euro", "Guatemalan Quetzal", "CFA Franc West", "Honduran Lempira", "Hong Kong Dollar", "Hungarian Forint",
            "Icelandic Krona", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Euro", "Israeli Shekel", "Euro", "CFA Franc West",
            "Jamaican Dollar", "Japanese Yen", "Jordanian Dinar", "Kenyan Shilling", "Korean Won", "Kuwaiti Dinar", "Euro",
            "Euro", "Euro", "Malaysian Ringgit", "CFA Franc West", "Euro", "Mauritian Rupee", "Mexican Peso", "Moroccan Dirham",
            "Myanmar Kyat", "Netherlands Antillian Guilder", "New Zealand Dollar", "CFA Franc West", "Nigerian Naira",
            "Norwegian Krone", "Omani Rial", "Pakistani Rupee", "Panamanian Balboa", "Papua New Guinean Kina", "Peruvian Nuevo Sol",
            "Philippine Peso", "Polish Zloty", "Euro", "Qatari Riyal", "CFA Franc Central", "Romanian Leu", "Russian Rouble", "Saudi Riyal",
            "CFA Franc West", "Serbian Dinar", "Seychellois Rupee", "Singapore Dollar", "Euro", "Euro", "South African Rand", "Euro",
            "Sri Lanka Rupee", "Swedish Krona", "Swiss Franc", "Taiwan New Dollar", "Taiwan Dollar", "Thai Baht", "Euro", "CFA Franc West",
            "Trinidad And Tobago Dollar", "Tunisian Dinar", "Turkish Lira", "UAE Dirham", "Pound Sterling", "US Dollar", "Venezuelan Bolivar Fuerte",
            "Vietnamese Dong", "Zambian Kwacha"};

    String[] currencyCode = {"ARS", "AUD", "EUR", "BSD", "BHD", "BDT", "BBD", "EUR", "XOF", "BRL", "BGN",
            "XOF", "XAF", "CAD", "XAF", "XAF", "XAF", "CLP", "CNY", "COP", "HRK", "EUR", "CZK", "DKK", "DOP", "XCD",
            "EGP", "XAF", "EUR", "FJD", "EUR", "EUR", "XPF", "XAF", "EUR", "GHS", "EUR", "GTQ", "XOF", "HNL", "HKD",
            "HUF", "ISK", "INR", "IDR", "IRR", "EUR", "ILS", "EUR", "XOF", "JMD", "JPY", "JOD", "KES", "KRW", "KWD",
            "EUR", "EUR", "EUR", "MYR", "XOF", "EUR", "MUR", "MXN", "MAD", "MMK", "ANG", "NZD", "XOF", "NGN", "NOK",
            "OMR", "PKR", "PAB", "PGK", "PEN", "PHP", "PLN", "EUR", "QAR", "XAF", "RON", "RUB", "SAR", "XOF", "RSD",
            "SCR", "SGD", "EUR", "EUR", "ZAR", "EUR", "LKR", "SEK", "CHF", "TWD", "TWD", "THB", "EUR", "XOF", "TTD",
            "TND", "TRY", "AED", "GBP", "USD", "VEF", "VND", "ZMW"};

    ListView listView;


    private InterstitialAd mInterstitialAd;
    CustomArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nternational_currency);



        mInterstitialAd = newInterstitialAd();
        loadInterstitial();

        TextView txt = (TextView) findViewById(R.id.txt);

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");

        txt.setTypeface(customFont);

        listView = (ListView) findViewById(R.id.listOfCurrencies);

        adapter = new CustomArrayAdapter(this,countryName,countryCurrencyName,currencyCode);
        listView.setAdapter(adapter);

    }

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

            }

            @Override
            public void onAdFailedToLoad(int errorCode) {

            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevel();
            }
        });
        return interstitialAd;
    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {

            goToNextLevel();
        }
    }

    private void loadInterstitial() {
        // Disable the next level button and load the ad.

        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void goToNextLevel() {
        // Show the next level and reload the ad to prepare for the level after.
        finish();
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitial();
    }
}
