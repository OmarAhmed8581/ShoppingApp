package com.aarafrao.ecommerceapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class myadapterlike  extends RecyclerView.Adapter<myadpater.MyViewHolder> {

    Context context;
    ArrayList<productlist> list;
    public myadapterlike(Context context, ArrayList<productlist> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public myadpater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardproduct,parent,false);
        return new myadpater.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadpater.MyViewHolder holder, int position) {
        productlist pd=list.get(position);
        holder.productname.setText(pd.getProduct_name());
        holder.productdes.setText(pd.getProduct_desc());
        holder.productprice.setText(String.valueOf(pd.getPrice()) );
        System.out.println(pd.quantity);

        if(holder.selectbox!=null){
            holder.selectbox.setText(String.valueOf(pd.getQuantity())+" | S" );
        }

        Picasso.get().load(pd.getUrl()).into(holder.productimg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView productname,productdes,productprice,selectbox,productquanty;
        ImageView productimg,addtocard;
        AutoCompleteTextView autoCompleteTextView;
        public MyViewHolder(@NonNull View itemview){
            super(itemview);
            productname = itemview.findViewById(R.id.productname);
            productimg = itemview.findViewById(R.id.productimg);
            productdes = itemview.findViewById(R.id.productdes);
            productprice = itemview.findViewById(R.id.productprice);
            selectbox = itemview.findViewById(R.id.productquanity);
        }
    }
}
