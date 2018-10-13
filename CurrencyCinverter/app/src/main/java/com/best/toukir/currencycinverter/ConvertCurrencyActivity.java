package com.best.toukir.currencycinverter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class ConvertCurrencyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

//
//    String[] countryCurrencyNameTwo = {"US Dollar", "Australian Dollar", "Euro", "Bahamian Dollar", "Bahraini Dinar",
//            "Bangladeshi Taka", "Barbados Dollar", "Euro", "CFA Franc West", "Brazilian Real", "Bulgarian Lev", "CFA Franc West",
//            "CFA Franc Central", "Canadian Dollar", "CFA Franc Central", "CFA Franc Central", "CFA Franc Central", "Chilean Peso", "Chinese Renminbi", "Colombian Peso",
//            "Croatian Kuna", "Euro", "Czech Koruna", "Danish Krone", "Dominican Peso", "East Caribbean Dollar", "Egyptian Pound",
//            "CFA Franc Central", "Euro", "Fiji Dollar", "Euro", "Euro", "French Pacific Francs", "CFA Franc Central", "Euro",
//            "Ghanaian Cedi", "Euro", "Guatemalan Quetzal", "CFA Franc West", "Honduran Lempira", "Hong Kong Dollar", "Hungarian Forint",
//            "Icelandic Krona", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Euro", "Israeli Shekel", "Euro", "CFA Franc West",
//            "Jamaican Dollar", "Japanese Yen", "Jordanian Dinar", "Kenyan Shilling", "Korean Won", "Kuwaiti Dinar", "Euro",
//            "Euro", "Euro", "Malaysian Ringgit", "CFA Franc West", "Euro", "Mauritian Rupee", "Mexican Peso", "Moroccan Dirham",
//            "Myanmar Kyat", "Netherlands Antillian Guilder", "New Zealand Dollar", "CFA Franc West", "Nigerian Naira",
//            "Norwegian Krone", "Omani Rial", "Pakistani Rupee", "Panamanian Balboa", "Papua New Guinean Kina", "Peruvian Nuevo Sol",
//            "Philippine Peso", "Polish Zloty", "Euro", "Qatari Riyal", "CFA Franc Central", "Romanian Leu", "Russian Rouble", "Saudi Riyal",
//            "CFA Franc West", "Serbian Dinar", "Seychellois Rupee", "Singapore Dollar", "Euro", "Euro", "South African Rand", "Euro",
//            "Sri Lanka Rupee", "Swedish Krona", "Swiss Franc", "Taiwan New Dollar", "Taiwan Dollar", "Thai Baht", "Euro", "CFA Franc West",
//            "Trinidad And Tobago Dollar", "Tunisian Dinar", "Turkish Lira", "UAE Dirham", "Pound Sterling", "Argentine Peso", "Venezuelan Bolivar Fuerte",
//            "Vietnamese Dong", "Zambian Kwacha"};
    String[] countryCurrencyNameTwo = {"US Dollar", "Australian Dollar", "Austria(Euro)", "Bahamian Dollar", "Bahraini Dinar",
            "Bangladeshi Taka", "Barbados Dollar", "Belgium(Euro)", "CFA Franc West", "Brazilian Real", "Bulgarian Lev", "CFA Franc West",
            "CFA Franc Central", "Canadian Dollar", "CFA Franc Central", "CFA Franc Central", "CFA Franc Central", "Chilean Peso", "Chinese Renminbi", "Colombian Peso",
            "Croatian Kuna", "Czech Republic(Euro)", "Czech Koruna", "Danish Krone", "Dominican Peso", "East Caribbean Dollar", "Egyptian Pound",
            "CFA Franc Central", "Estonia(Euro)", "Fiji Dollar", "Finland(Euro)", "France(Euro)", "French Pacific Francs", "CFA Franc Central", "Germany(Euro)",
            "Ghanaian Cedi", "Greece(Euro)", "Guatemalan Quetzal", "CFA Franc West", "Honduran Lempira", "Hong Kong Dollar", "Hungarian Forint",
            "Icelandic Krona", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Ireland(Euro)", "Israeli Shekel", "Euro", "CFA Franc West",
            "Jamaican Dollar", "Japanese Yen", "Jordanian Dinar", "Kenyan Shilling", "Korean Won", "Kuwaiti Dinar", "Lativa(Euro)",
            "Lithuania(Euro)", "Luxembourg(Euro)", "Malaysian Ringgit", "CFA Franc West", "Malta(Euro)", "Mauritian Rupee", "Mexican Peso", "Moroccan Dirham",
            "Myanmar Kyat", "Netherlands Antillian Guilder", "New Zealand Dollar", "CFA Franc West", "Nigerian Naira",
            "Norwegian Krone", "Omani Rial", "Pakistani Rupee", "Panamanian Balboa", "Papua New Guinean Kina", "Peruvian Nuevo Sol",
            "Philippine Peso", "Polish Zloty", "Portugal(Euro)", "Qatari Riyal", "CFA Franc Central", "Romanian Leu", "Russian Rouble", "Saudi Riyal",
            "CFA Franc West", "Serbian Dinar", "Seychellois Rupee", "Singapore Dollar", "Slovakia(Euro)", "Slovenia(Euro)", "South African Rand", "Spain(Euro)",
            "Sri Lanka Rupee", "Swedish Krona", "Swiss Franc", "Taiwan New Dollar", "Taiwan Dollar", "Thai Baht", "The Netherlands(Euro)", "CFA Franc West",
            "Trinidad And Tobago Dollar", "Tunisian Dinar", "Turkish Lira", "UAE Dirham", "Pound Sterling", "Argentine Peso", "Venezuelan Bolivar Fuerte",
            "Vietnamese Dong", "Zambian Kwacha"};

    String[] countryName = {"Bangladesh", "Australia", "Austria", "Bahamas", "Bahrain", "Argentina", "Barbados", "Belgium", "Benin",
            "Brazil", "Bulgaria", "Burkina Faso", "Cameroon", "Canada", "Central African CFA", "Central African Republic", "Chad", "Chile", "China", "Colombia",
            "Croatian", "Cyprus", "Czech Republic", "Denmark", "Dominican Republic", "East Caribbean", "Egypt", "Equatorial Guinea", "Estonia", "Fiji", "Finland", "France", "French Pacific", "Gabon", "Germany",
            "Ghana", "Greece", "Guatemala", "Guinea-Bissau", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonessia", "Iran", "Ireland", "Israel", "Italy",
            "Ivory Cost", "Jamaica", "Japan", "Jordan", "Kenya", "Korea", "Kuwait", "Lativa", "Lithuania", "Luxembourg", "Malaysia", "Mali", "Malta", "Mauritius", "Maxico",
            "Morocco", "Myanmar", "Netherlands Antilles", "New Zealand", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama", "Papua New Guinea", "Peru",
            "Philippines", "Poland", "Portugal", "Qatar", "Republic of the Congo", "Romania", "Russian Federation", "Saudi Arabia", "Senegal", "Serbia", "Seychelles",
            "Singapore", "Slovakia", "Slovenia", "South Africa", "Spain", "Sri Lanka", "Sweden", "Switzerland", "Taiwan", "Taiwan", "Thailand", "The Netherlands", "Togo",
            "Trinidad and Tobago", "Trinidad and Tobago", "Turkey", "United Arab Emirates", "United Kingdom", "United States", "Venezuela", "Vietnam", "Zambia"};

    String[] countryCurrencyName = {"Bangladeshi Taka", "Australian Dollar", "Austria(Euro)", "Bahamian Dollar", "Bahraini Dinar",
            "Argentine Peso", "Barbados Dollar", "Belgium(Euro)", "CFA Franc West", "Brazilian Real", "Bulgarian Lev", "CFA Franc West",
            "CFA Franc Central", "Canadian Dollar", "CFA Franc Central", "CFA Franc Central", "CFA Franc Central", "Chilean Peso", "Chinese Renminbi", "Colombian Peso",
            "Croatian Kuna", "Czech Republic(Euro)", "Czech Koruna", "Danish Krone", "Dominican Peso", "East Caribbean Dollar", "Egyptian Pound",
            "CFA Franc Central", "Estonia(Euro)", "Fiji Dollar", "Finland(Euro)", "France(Euro)", "French Pacific Francs", "CFA Franc Central", "Germany(Euro)",
            "Ghanaian Cedi", "Greece(Euro)", "Guatemalan Quetzal", "CFA Franc West", "Honduran Lempira", "Hong Kong Dollar", "Hungarian Forint",
            "Icelandic Krona", "Indian Rupee", "Indonesian Rupiah", "Iranian Rial", "Ireland(Euro)", "Israeli Shekel", "Euro", "CFA Franc West",
            "Jamaican Dollar", "Japanese Yen", "Jordanian Dinar", "Kenyan Shilling", "Korean Won", "Kuwaiti Dinar", "Lativa(Euro)",
            "Lithuania(Euro)", "Luxembourg(Euro)", "Malaysian Ringgit", "CFA Franc West", "Malta(Euro)", "Mauritian Rupee", "Mexican Peso", "Moroccan Dirham",
            "Myanmar Kyat", "Netherlands Antillian Guilder", "New Zealand Dollar", "CFA Franc West", "Nigerian Naira",
            "Norwegian Krone", "Omani Rial", "Pakistani Rupee", "Panamanian Balboa", "Papua New Guinean Kina", "Peruvian Nuevo Sol",
            "Philippine Peso", "Polish Zloty", "Portugal(Euro)", "Qatari Riyal", "CFA Franc Central", "Romanian Leu", "Russian Rouble", "Saudi Riyal",
            "CFA Franc West", "Serbian Dinar", "Seychellois Rupee", "Singapore Dollar", "Slovakia(Euro)", "Slovenia(Euro)", "South African Rand", "Spain(Euro)",
            "Sri Lanka Rupee", "Swedish Krona", "Swiss Franc", "Taiwan New Dollar", "Taiwan Dollar", "Thai Baht", "The Netherlands(Euro)", "CFA Franc West",
            "Trinidad And Tobago Dollar", "Tunisian Dinar", "Turkish Lira", "UAE Dirham", "Pound Sterling", "US Dollar", "Venezuelan Bolivar Fuerte",
            "Vietnamese Dong", "Zambian Kwacha"};

    String[] currencyCode = {"BDT", "AUD", "EUR", "BSD", "BHD", "ARS", "BBD", "EUR", "XOF", "BRL", "BGN",
            "XOF", "XAF", "CAD", "XAF", "XAF", "XAF", "CLP", "CNY", "COP", "HRK", "EUR", "CZK", "DKK", "DOP", "XCD",
            "EGP", "XAF", "EUR", "FJD", "EUR", "EUR", "XPF", "XAF", "EUR", "GHS", "EUR", "GTQ", "XOF", "HNL", "HKD",
            "HUF", "ISK", "INR", "IDR", "IRR", "EUR", "ILS", "EUR", "XOF", "JMD", "JPY", "JOD", "KES", "KRW", "KWD",
            "EUR", "EUR", "EUR", "MYR", "XOF", "EUR", "MUR", "MXN", "MAD", "MMK", "ANG", "NZD", "XOF", "NGN", "NOK",
            "OMR", "PKR", "PAB", "PGK", "PEN", "PHP", "PLN", "EUR", "QAR", "XAF", "RON", "RUB", "SAR", "XOF", "RSD",
            "SCR", "SGD", "EUR", "EUR", "ZAR", "EUR", "LKR", "SEK", "CHF", "TWD", "TWD", "THB", "EUR", "XOF", "TTD",
            "TND", "TRY", "AED", "GBP", "USD", "VEF", "VND", "ZMW"};

    String[] currencyCodeTwo = {"USD", "AUD", "EUR", "BSD", "BHD", "BDT", "BBD", "EUR", "XOF", "BRL", "BGN",
            "XOF", "XAF", "CAD", "XAF", "XAF", "XAF", "CLP", "CNY", "COP", "HRK", "EUR", "CZK", "DKK", "DOP", "XCD",
            "EGP", "XAF", "EUR", "FJD", "EUR", "EUR", "XPF", "XAF", "EUR", "GHS", "EUR", "GTQ", "XOF", "HNL", "HKD",
            "HUF", "ISK", "INR", "IDR", "IRR", "EUR", "ILS", "EUR", "XOF", "JMD", "JPY", "JOD", "KES", "KRW", "KWD",
            "EUR", "EUR", "EUR", "MYR", "XOF", "EUR", "MUR", "MXN", "MAD", "MMK", "ANG", "NZD", "XOF", "NGN", "NOK",
            "OMR", "PKR", "PAB", "PGK", "PEN", "PHP", "PLN", "EUR", "QAR", "XAF", "RON", "RUB", "SAR", "XOF", "RSD",
            "SCR", "SGD", "EUR", "EUR", "ZAR", "EUR", "LKR", "SEK", "CHF", "TWD", "TWD", "THB", "EUR", "XOF", "TTD",
            "TND", "TRY", "AED", "GBP", "ARS", "VEF", "VND", "ZMW"};

    String resultCountryname, resultCurrencyName;
    String JSON_STRING;
    String convertedResult;
    ProgressBar progressBar;
    String cCodeFrom,cCodeTo;
    double amount;
    EditText getAmount;
    private InterstitialAd mInterstitialAd;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    TextView txtCustomFont, txtCustomFont2, txtFrom, txtTo;
    BackgroundTask backgroundTask = null;

    Spinner spinner, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_currency);




        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> currencyCodeAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countryCurrencyName);
        currencyCodeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(currencyCodeAdapter);

        ArrayAdapter<String> curreencyCodeAdapterTwo = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countryCurrencyNameTwo);
        curreencyCodeAdapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(curreencyCodeAdapterTwo);
        spinner2.setOnItemSelectedListener(this);

        init();
    }

    public void init(){

        getAmount = (EditText) findViewById(R.id.etgetAmount);
        txtCustomFont = (TextView) findViewById(R.id.txtApp);
        txtCustomFont2 = (TextView) findViewById(R.id.txtApp2);
        txtFrom = (TextView) findViewById(R.id.txtFrom);
        txtTo = (TextView) findViewById(R.id.txtTo);

        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");

        txtTo.setTypeface(customFont);
        txtFrom.setTypeface(customFont);
        txtCustomFont.setTypeface(customFont);
        txtCustomFont2.setTypeface(customFont);
    }

    public void btnConvert(View view) {

        if (isNetworkConnected()) {


            try {
                amount = Double.parseDouble(getAmount.getText().toString().trim());
                String amountFromUser = df2.format(amount);
                backgroundTask = new BackgroundTask();
                backgroundTask.execute(amountFromUser, cCodeFrom, cCodeTo);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Fill the field!",Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Please check your internet connection!", Toast.LENGTH_LONG).show();
           }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){

            case R.id.spinner:
                String codeOne = currencyCode[position];
                //Toast.makeText(this,codeOne,Toast.LENGTH_LONG).show();
                cCodeFrom = codeOne;
                break;
            case R.id.spinner2:
                String codeTwo = currencyCodeTwo[position];
                //Toast.makeText(this,codeTwo,Toast.LENGTH_LONG).show();
                cCodeTo = codeTwo;
                //cCodeTo = parent.getItemAtPosition(position).toString();
                resultCountryname = countryName[position];
                resultCurrencyName = countryCurrencyNameTwo[position];
                break;
            default:
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    class BackgroundTask extends AsyncTask<String, Integer, String> {

        String json_url;

        @Override
        protected void onPreExecute() {

            try {
                progressBar = (ProgressBar) findViewById(R.id.progressBar1);
                progressBar.setVisibility(View.VISIBLE);

                super.onPreExecute();
            }catch (Exception e){
                Toast.makeText(ConvertCurrencyActivity.this,"Poor internet connection, try again!",Toast.LENGTH_LONG).show();
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {

            String amount = params[0];
            String from = params[1];
            String to = params[2];

            json_url = "https://www.exchangerate-api.com/"+from+"/"+to+"/"+amount+"?k=db4ebdf0681c37aaaee4c282";
            try {
                URL url = new URL(json_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder builder = new StringBuilder();

                while ((JSON_STRING = reader.readLine()) != null) {

                    builder.append(JSON_STRING);
                }

                reader.close();
                inputStream.close();
                connection.disconnect();

                return builder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }



        @Override
        protected void onPostExecute(String aVoid) {



                progressBar.setVisibility(View.INVISIBLE);
                double result = (Double.parseDouble(aVoid));
                String rslt = df2.format(result);

                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ConvertCurrencyActivity.this);
                alertDialogBuilder.setTitle("Converted currency details");
                alertDialogBuilder.setMessage("Result:  " + rslt + " " + resultCurrencyName );

                alertDialogBuilder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        showInterstitial();


                    }
                });
            mInterstitialAd = newInterstitialAd();
            loadInterstitial();

                alertDialogBuilder.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        getAmount.setText("");
                        showInterstitial();

                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                //Toast.makeText(getApplicationContext(), rslt, Toast.LENGTH_LONG).show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (backgroundTask != null
                && backgroundTask.getStatus() != BackgroundTask.Status.FINISHED) {
            backgroundTask.cancel(true);
            backgroundTask = null;
        }
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

        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitial();
    }
}


