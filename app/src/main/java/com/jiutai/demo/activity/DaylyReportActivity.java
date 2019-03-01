package com.jiutai.demo.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.jiutai.demo.R;
import com.jiutai.demo.bean.DaylyReportParentEntity;
import com.jiutai.demo.bean.ReportEntity;
import com.jiutai.demo.recycylerview.BaseRecyclerViewAdapter;
import com.jiutai.demo.recycylerview.RecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DaylyReportActivity extends FragmentActivity {
    //vars
    private List<DaylyReportParentEntity> mDatas;
    private DetailedAdapter mAdapter;

    //views
    private ExpandableListView expandDetailLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayly_report);
        expandDetailLv = findViewById(R.id.expandlv_detail);
        expandDetailLv = findViewById(R.id.expandlv_detail);
        mDatas = new ArrayList<>();
        List<DaylyReportParentEntity.DaylyReportSubEntity> subs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            subs.clear();
            subs.add(new DaylyReportParentEntity.DaylyReportSubEntity("CT彩票", 2000, 30, 50));
            subs.add(new DaylyReportParentEntity.DaylyReportSubEntity("CT彩票", 2000, 30, 50));
            subs.add(new DaylyReportParentEntity.DaylyReportSubEntity("CT彩票", 2000, 30, 50));
            subs.add(new DaylyReportParentEntity.DaylyReportSubEntity("CT彩票", 2000, 30, 50));
            mDatas.add(new DaylyReportParentEntity("11-04", 100, 500, 1000, subs));
        }
        mAdapter = new DetailedAdapter(mDatas, DaylyReportActivity.this);
        expandDetailLv.setAdapter(mAdapter);
    }

    public static class DetailedAdapter extends BaseExpandableListAdapter {
        private List<DaylyReportParentEntity> mDatas;
        private Context mContext;

        public DetailedAdapter(List<DaylyReportParentEntity> datas, Context context) {
            this.mDatas = datas;
            this.mContext = context;
        }

        @Override
        public int getGroupCount() {
            if (null == mDatas)
                return 0;
            return mDatas.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            if (null == mDatas || null == mDatas.get(groupPosition) || null == mDatas.get(groupPosition).getmSubs())
                return 0;
            return mDatas.get(groupPosition).getmSubs().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            if (null == mDatas)
                return null;
            return mDatas.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            if (null == mDatas || null == mDatas.get(groupPosition) || null == mDatas.get(groupPosition).getmSubs())
                return null;
            return mDatas.get(groupPosition).getmSubs().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            DaylyReportParentHolder holder = null;
            if (null == convertView) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_detail_parent, parent, false);
                holder = new DaylyReportParentHolder();
                holder.timeTv = convertView.findViewById(R.id.tv_time);
                holder.noteCountTv = convertView.findViewById(R.id.tv_note_count);
                holder.consumeTv = convertView.findViewById(R.id.tv_consume);
                holder.profitLossTv = convertView.findViewById(R.id.tv_profit_loss);
                convertView.setTag(holder);
            } else {
                holder = (DaylyReportParentHolder) convertView.getTag();
            }
            if (null != mDatas && mDatas.size() > groupPosition) {
                DaylyReportParentEntity entity = mDatas.get(groupPosition);
                if (null != entity) {
                    holder.timeTv.setText(entity.getDayTime());
                    holder.noteCountTv.setText(entity.getNoteCount() + "注");
                    holder.consumeTv.setText(entity.getConsumeRmb() + "元");
                    holder.profitLossTv.setText(String.valueOf(entity.getProfitLoss()));
                }
            }
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            DaylyReportSubHolder holder = null;
            if (null == convertView) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_detail_sub, parent, false);
                holder = new DaylyReportSubHolder();
                holder.lotteryNameTv = convertView.findViewById(R.id.tv_lottery_name);
                holder.noteCountTv = convertView.findViewById(R.id.win_note_count);
                holder.rebateTv = convertView.findViewById(R.id.tv_rebate);
                holder.profitLossTv = convertView.findViewById(R.id.tv_profit_loss);
                convertView.setTag(holder);
            } else {
                holder = (DaylyReportSubHolder) convertView.getTag();
            }
            if (null != mDatas && mDatas.size() > groupPosition && null != mDatas.get(groupPosition) && null != mDatas.get(groupPosition).getmSubs()) {
                DaylyReportParentEntity.DaylyReportSubEntity entity = mDatas.get(groupPosition).getmSubs().get(childPosition);
                if (null != entity) {
                    holder.lotteryNameTv.setText(entity.getLotteryName());
                    holder.noteCountTv.setText(entity.getWinNoteCount() + "注");
                    holder.rebateTv.setText(String.valueOf(entity.getRebate()));
                    holder.profitLossTv.setText(String.valueOf(entity.getProfitLoss()));
                }
            }
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    public static class DaylyReportParentHolder {
        public TextView timeTv, noteCountTv, consumeTv, profitLossTv;
    }

    public static class DaylyReportSubHolder {
        public TextView lotteryNameTv, noteCountTv, rebateTv, profitLossTv;
    }
}
