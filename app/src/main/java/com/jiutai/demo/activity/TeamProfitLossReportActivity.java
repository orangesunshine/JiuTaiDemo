package com.jiutai.demo.activity;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jiutai.demo.R;
import com.jiutai.demo.bean.ReportEntity;
import com.jiutai.demo.recycylerview.BaseRecyclerViewAdapter;
import com.jiutai.demo.recycylerview.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TeamProfitLossReportActivity extends FragmentActivity {
    private RecyclerView mListRv;
    private BaseRecyclerViewAdapter<ReportEntity> mAdapter;
    private List<ReportEntity> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_report_team_profit_loss);
        mListRv = findViewById(R.id.rv_list);
        mListRv.setLayoutManager(new LinearLayoutManager(TeamProfitLossReportActivity.this));
        mDatas = new ArrayList<>();
        mDatas.add(new ReportEntity("代理", 100, -55.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("代理", 100, 66.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("会员", 100, 8888.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("代理", 100, -33333.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("会员", 100, 5554.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("代理", 100, 5434153.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("代理", 100, 554646.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("会员", 100, 4646474.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("会员", 100, -564643.0f, 98456.00f, 2300.56f, 125.2f));
        mDatas.add(new ReportEntity("会员", 100, -44131.0f, 98456.00f, 2300.56f, 125.2f));
        mAdapter = new BaseRecyclerViewAdapter<ReportEntity>(this, R.layout.item_team_profit_loss_report) {
            @Override
            protected void onBind(@NonNull RecyclerViewHolder holder, int i, ReportEntity data) {
                if (null != data) {
                    String role = data.getRole();
                    holder.setText(R.id.tv_role, role);
                    int bgRes = R.drawable.shape_role_orange;
                    if ("代理".equals(role)) {
                        bgRes = R.drawable.shape_role_blue;
                    }
                    holder.setBackground(R.id.tv_role, bgRes);

                    holder.setText(R.id.tv_note_count,String.valueOf(data.getNoteCount())+"注");

                    float profitOrLoss = data.getProfitOrLoss();
                    holder.setText(R.id.tv_sum,String.valueOf(profitOrLoss)+"元");
                    int sumColor=Color.parseColor("#0C6357");
                    if (profitOrLoss >= 0) {
                        sumColor=Color.parseColor("#FF7456");
                    }
                    holder.setTextColor(R.id.tv_sum,sumColor);
                }
            }
        };
        mListRv.setAdapter(mAdapter);
        mAdapter.setDatas(mDatas);
    }

}
