package com.trisnawati.netchace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.trisnawati.netchace.adapter.CostumAdapter;
import com.trisnawati.netchace.model.ResponseJson;
import com.trisnawati.netchace.networl.RetroServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    //todo 6
    @BindView(R.id.list_data)
    RecyclerView listData;

//todo 9
    List<ResponseJson> list;
    ArrayList<ResponseJson> mList;

    CostumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //todo 7
        initData();

        //todo 10
        //list=new ArrayList<>();
    }

    //todo 8
    private void initData() {
        RetroServer.getInstancee().getData().enqueue(new Callback<List<ResponseJson>>() {
            @Override
            public void onResponse(Call<List<ResponseJson>> call, Response<List<ResponseJson>> response) {
                list = response.body();

                mList = new ArrayList<>();
                for (int i=0; i<list.size(); i++){
                    mList.add(new ResponseJson(
                            list.get(i).getId(),
                            list.get(i).getTitle(),
                            list.get(i).getBody(),
                            list.get(i).getUserId()));
                }

                initDataRecycler();
            }

            @Override
            public void onFailure(Call<List<ResponseJson>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDataRecycler() {
        Collections.sort(mList, new Comparator<ResponseJson>() {
            @Override
            public int compare(ResponseJson o1, ResponseJson o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        adapter = new CostumAdapter(MainActivity.this, mList);
        listData.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        listData.setAdapter(adapter);
    }
}
