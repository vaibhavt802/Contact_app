package com.example.contact;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    int count = 0;
    List<String> stateList, contactList;
    private ViewHolder.OnStateListener onStateListener;

    public RecyclerAdapter(List<String> stateList, List<String> contactList, ViewHolder.OnStateListener onStateListener) {
        this.stateList = stateList;
        this.contactList = contactList;
        this.onStateListener = onStateListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Log.i (TAG, "onCreateViewHonder: " + count++);

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view, onStateListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.contactNumber.setText(contactList.get(i));
        viewHolder.stateName.setText(stateList.get(i));
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView call;
        TextView stateName, contactNumber;
        RelativeLayout expandable;
        OnStateListener onStateListener;
        private static final int REQUEST_CALL = 1;

        public ViewHolder(@NonNull final View itemView, OnStateListener onStateListener) {
            super(itemView);
            call = itemView.findViewById(R.id.call);
            stateName = itemView.findViewById(R.id.statename);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            expandable = itemView.findViewById(R.id.expandable);
            this.onStateListener = onStateListener;

//            expandable.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    makePhoneCall();
//                }
//            });

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onStateListener.onStateClick(getAdapterPosition());
        }

        public interface OnStateListener {
            void onStateClick (int position);
        }

        public void makePhoneCall(){
            String number = contactNumber.getText().toString();
            number.trim();
            String dial = "tel:" + number;
        }

    }

}
