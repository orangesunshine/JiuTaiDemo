package com.jiutai.demo.recycylerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<T> mDatas;
    private int mLayoutRes;
    private Context mContext;

    public BaseRecyclerViewAdapter(Context context, int layoutRes) {
        mContext = context;
        mDatas = new ArrayList<>();
        mLayoutRes = layoutRes;
    }

    public void setDatas(List<T> datas) {
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<T> datas) {
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addData(T data) {
        if (null == mDatas) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(data);
        notifyItemChanged(mDatas.size() - 1);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(LayoutInflater.from(mContext).inflate(mLayoutRes, viewGroup, false));
    }

    protected abstract void onBind(@NonNull RecyclerViewHolder recyclerViewHolder, int i, T data);

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        if (mDatas.size() > i) {
            onBind(recyclerViewHolder, i, mDatas.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
