package com.trisnawati.netchace.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trisnawati.netchace.R;
import com.trisnawati.netchace.model.ResponseJson;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//todo 12
public class CostumAdapter extends RecyclerView.Adapter<CostumAdapter.MyView> {
    private Context context;
    private ArrayList<ResponseJson> list;

    public CostumAdapter(Context context, ArrayList<ResponseJson> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_layout, viewGroup, false);
        MyView myView = new MyView(view);
        return myView;
    }

    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {
        myView.titleItem.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyView extends RecyclerView.ViewHolder {

        @BindView(R.id.title_item)
        TextView titleItem;
        public MyView(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
