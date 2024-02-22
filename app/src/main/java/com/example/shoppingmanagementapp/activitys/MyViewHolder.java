package com.example.shoppingmanagementapp.activitys;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanagementapp.R;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        ImageView imageView;
        Button plusButton;
        Button minusButton;
        Button addToBasketButton;
        Button removeButton;
        int count = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imageview);
            plusButton = itemView.findViewById(R.id.plus);
            minusButton = itemView.findViewById(R.id.minus);
            addToBasketButton = itemView.findViewById(R.id.addToBasketButton);
            removeButton = itemView.findViewById(R.id.removeButton);

            updateCount();

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    updateCount();
                }
            });

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count > 0) {
                        count--;
                        updateCount();
                    }
                }
            });

            addToBasketButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Add to basket logic here
                    Toast.makeText(itemView.getContext(), "The product has been added to the basket", Toast.LENGTH_SHORT).show();
                }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Remove from list logic here
                    Toast.makeText(itemView.getContext(), "The product has been removed from the list", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void updateCount() {
            nameView.setText(String.valueOf(count));
        }
    }