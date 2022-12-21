package com.aarafrao.ecommerceapp.ui.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aarafrao.ecommerceapp.R;
import com.aarafrao.ecommerceapp.databinding.FragmentNotificationsBinding;
import com.aarafrao.ecommerceapp.myadaptercard;
import com.aarafrao.ecommerceapp.productlist;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    RecyclerView recyclerView;
    myadaptercard myadpater;
    ArrayList<productlist> list;
    SharedPreferences sharedPreferences;
    String MyPREFERENCES = "MyPrefs" ;
    TextView totalamount;
    TextView countitem;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        recyclerView = root.findViewById(R.id.productlistcard);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        totalamount = root.findViewById(R.id.totalamount);
        countitem = root.findViewById(R.id.itemtext);
        list = new ArrayList<>();
        myadpater = new myadaptercard(getContext(),list);
        recyclerView.setAdapter(myadpater);

        sharedPreferences =  getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Map<String,?> keys = sharedPreferences.getAll();
        int total=0;
        int count=0;
        for(Map.Entry<String,?> entry : keys.entrySet()){
            Log.d("map values",entry.getKey() + ": " +
                    entry.getValue().toString());

            Type type = new TypeToken<List<String>>() {
            }.getType();
            Gson gson = new Gson();
            List<String> arrPackageData = gson.fromJson(entry.getValue().toString(), type);
            productlist pd =new productlist();
            pd.setPrice(Integer.parseInt(arrPackageData.get(0)));
            pd.setProduct_desc(arrPackageData.get(1));
            pd.setProduct_name(arrPackageData.get(3));
            pd.setUrl(arrPackageData.get(2));
            pd.setQuantity(Integer.parseInt(arrPackageData.get(4)));
            list.add(pd);
            total+=Integer.parseInt(arrPackageData.get(0))*Integer.parseInt(arrPackageData.get(4));
            count+=1;
        }
        countitem.setText(String.valueOf(count)+" item");
        myadpater.notifyDataSetChanged();
        total +=3.95;
        totalamount.setText(String.valueOf(total));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}