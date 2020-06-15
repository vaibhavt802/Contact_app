package com.example.contact;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ViewHolder.OnStateListener {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    List<String> stateList;
    List<String> contactList;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateList = new ArrayList<>();
        contactList = new ArrayList<>();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(stateList, contactList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        stateList.add("Andaman and Nicobar Islands");
        stateList.add("Andhra Pradesh");
        stateList.add("Arunachal Pradesh");
        stateList.add("Assam");
        stateList.add("Bihar");
        stateList.add("Chandigarh");
        stateList.add("Chhttisgarh");
        stateList.add("Dadar Nagar Haveli");
        stateList.add("Delhi");
        stateList.add("Goa");
        stateList.add("Gujarat");
        stateList.add("Harnaya");
        stateList.add("Himachal Pradesh");
        stateList.add("Jammu and Kashmir");
        stateList.add("Jharkhand");
        stateList.add("Karnataka");
        stateList.add("Kerala");
        stateList.add("Ladakh");
        stateList.add("Lakshadweep");
        stateList.add("Madhya Pradesh");
        stateList.add("Maharashtra");
        stateList.add("Manipur");
        stateList.add("Meghalaya");
        stateList.add("Mizoram");
        stateList.add("Nagaland");
        stateList.add("Odisha");
        stateList.add("Puducherry");
        stateList.add("Punjab");
        stateList.add("Rajasthan");
        stateList.add("Sikkim");
        stateList.add("Tamil Nadu");
        stateList.add("Telengana");
        stateList.add("Tripura");
        stateList.add("uttar Pradesh");
        stateList.add("Uttarakhand");
        stateList.add("West Bengal");

        contactList.add("03192-232102");
        contactList.add("0866-2410978");
        contactList.add("9436055743");
        contactList.add("6913347770");
        contactList.add("104");
        contactList.add("9779558282");
        contactList.add("104");
        contactList.add("104");
        contactList.add("011-22307145");
        contactList.add("104");
        contactList.add("104");
        contactList.add("8558893911");
        contactList.add("104");
        contactList.add("01912520982");
        contactList.add("104");
        contactList.add("104");
        contactList.add("0471-2552056");
        contactList.add("01982256462");
        contactList.add("104");
        contactList.add("104");
        contactList.add("020-26127394");
        contactList.add("3852411668");
        contactList.add("108");
        contactList.add("102");
        contactList.add("7005539653");
        contactList.add("9439994859");
        contactList.add("104");
        contactList.add("104");
        contactList.add("0141-2225624");
        contactList.add("104");
        contactList.add("044-29510500");
        contactList.add("104");
        contactList.add("0381-2315879");
        contactList.add("104");
        contactList.add("18001805145");
        contactList.add("1800313444222");

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                Toast.makeText(this, "Permisiion denied ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onStateClick(int position) {
        final String number = contactList.get(position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Are you sure")
                .setMessage("Do you really want to call")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number.trim();
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:"+ number));
                        startActivity(i);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}
