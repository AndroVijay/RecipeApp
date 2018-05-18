package com.example.vijay.recipeapp.vijay.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vijay.recipeapp.R;
import com.example.vijay.recipeapp.vijay.Model.Recipe;
import com.example.vijay.recipeapp.vijay.activity.FoodListActivity;

import java.util.ArrayList;

/**
 * Created by vijay on 17-02-2018.
 */

 public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<Recipe> recipes;
    Context context;
    private OnItemClickListener mListener;



    public interface  OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }
    public CustomAdapter(ArrayList<Recipe> recipes, Context context) {

        this.recipes = recipes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_rows,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Recipe rec=recipes.get(position);
        holder.textView.setText(rec.getName());

        byte[] foodImage=rec.getImage();

        Bitmap bitmap= BitmapFactory.decodeByteArray(foodImage,0,foodImage.length);
        holder.imageView.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView  textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.foodName);
            imageView=itemView.findViewById(R.id.foodImage);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    if (mListener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION)
                        {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
