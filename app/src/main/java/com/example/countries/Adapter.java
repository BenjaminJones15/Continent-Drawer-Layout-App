package com.example.countries;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private int rowLayout;
    private Context mContext;
    private List<String> countries;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Name;

        public ViewHolder(View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.Name);
        }
    }

    public Adapter(int rowLayout, Context context, List<String> Countries) {
        this.rowLayout = rowLayout;
        this.mContext = context;
        this.countries = Countries;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //this assumes it's not called with a null mCursor, since i means there is a data.
        String entry = countries.get(i);
        viewHolder.Name.setText(entry);

        viewHolder.Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView name = v.findViewById(R.id.Name);
                String Name = name.getText().toString();

                Toast.makeText(mContext, Name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount() {
        return countries == null ? 0 : countries.size();
    }


}
