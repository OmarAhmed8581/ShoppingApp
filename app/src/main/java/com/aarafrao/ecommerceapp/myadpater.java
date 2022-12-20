package com.aarafrao.ecommerceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class myadpater extends RecyclerView.Adapter<myadpater.MyViewHolder> {
    Context context;
    ArrayList<productlist> list;

    public myadpater(Context context, ArrayList<productlist> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.productdata,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        productlist pd=list.get(position);
        holder.productname.setText(pd.getProduct_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView productname;
        public MyViewHolder(@NonNull View itemview){
            super(itemview);
            productname = itemview.findViewById(R.id.productname);

        }
    }
}
