package com.bigbadegg.amonthview;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by cy on 2017/11/15.
 */

public class CalendarAdapter extends BaseQuickAdapter<CalendarBean, BaseViewHolder> {
    public CalendarAdapter(List<CalendarBean> data) {
        super(R.layout.item_calendar, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CalendarBean item) {
        helper.setText(R.id.tv_day, item.getDay() + "");
        helper.setText(R.id.tv_text, item.getText());

        if (item.isSelect()){
            helper.setBackgroundColor(R.id.rl_item, Color.CYAN);
        }else{
            helper.setBackgroundColor(R.id.rl_item, Color.WHITE);
        }
    }
}
