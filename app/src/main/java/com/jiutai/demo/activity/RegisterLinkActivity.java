package com.jiutai.demo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiutai.demo.R;
import com.jiutai.demo.recycylerview.BaseRecyclerViewAdapter;
import com.jiutai.demo.recycylerview.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RegisterLinkActivity extends FragmentActivity {
    //views
    private RecyclerView mListRv;
    private ImageView ivRight;
    private TextView ivTitle;
    private LinearLayout llProfitLossAmount,llStatistics;

    //vars
    private BaseRecyclerViewAdapter<Integer> mAdapter;
    private List<Integer> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_report_team_profit_loss);
        ivRight = findViewById(R.id.iv_right);
        ivTitle = findViewById(R.id.tv_title);
        llProfitLossAmount = findViewById(R.id.ll_profit_loss_amount);
        llStatistics = findViewById(R.id.ll_statistics);
        llProfitLossAmount.setVisibility(View.GONE);
        llStatistics.setVisibility(View.GONE);
        ivTitle.setText("注册链接");
        ivRight.setVisibility(View.VISIBLE);
        mListRv = findViewById(R.id.rv_list);
        mListRv.setLayoutManager(new LinearLayoutManager(RegisterLinkActivity.this));
        mDatas = new ArrayList<>();
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mDatas.add(R.mipmap.ic_launcher);
        mAdapter = new BaseRecyclerViewAdapter<Integer>(this, R.layout.item_register_link) {
            @Override
            protected void onBind(@NonNull RecyclerViewHolder holder, int i, Integer data) {
                //holder.setImageResource(R.id.iv_qr_code, data);
            }
        };
        mListRv.setAdapter(mAdapter);
        mAdapter.setDatas(mDatas);
    }
}
