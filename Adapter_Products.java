package com.example.alik.anipco_co.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alik.anipco_co.Info.Info_Products;
import com.example.alik.anipco_co.Products.Products_Page;
import com.example.alik.anipco_co.R;

import java.util.List;

/**
 * Created by Ali.K on 5/1/2017.
 */

public class Adapter_Products extends RecyclerView.Adapter<Adapter_Products.ViewHolder> {
    private Context context;
    private List<Info_Products> data;
    private LayoutInflater layoutInflater;

    public Adapter_Products(Context context, List<Info_Products> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.products_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Info_Products cur = data.get(position);
        holder.textView.setText(cur.model);
        holder.imageView.setImageResource(cur.Image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.placeImage);
            textView = (TextView) itemView.findViewById(R.id.placeName);
            cardView = (CardView) itemView.findViewById(R.id.placeCard);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getPosition();
                    switch (position) {
                        case 0:

                            context.startActivity(new Intent(context, Products_Page.class));
                    }
                }
            });

        }
    }

}
