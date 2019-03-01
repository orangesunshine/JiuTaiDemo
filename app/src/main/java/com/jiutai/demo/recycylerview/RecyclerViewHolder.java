package com.jiutai.demo.recycylerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolder<T extends View> extends RecyclerView.ViewHolder {
    private SparseArray<View> views;
    private View mItemview;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        mItemview = itemView;
        views = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (null == view) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public void setText(int viewId, String text) {
        if (!TextUtils.isEmpty(text)) {
            ((TextView) getView(viewId)).setText(text);
        }
    }

    public void setTextColor(int viewId, int colorRes) {
        ((TextView) getView(viewId)).setTextColor(colorRes);
    }


    public void setImage(int viewId, int imgRes) {
        ((ImageView) getView(viewId)).setImageResource(imgRes);
    }

    public void setBackground(int viewId, int bgRes) {
        getView(viewId).setBackgroundResource(bgRes);
    }

    public void setImageResource(int viewId, int img) {
        ((ImageView)getView(viewId)).setImageResource(img);
    }
}
