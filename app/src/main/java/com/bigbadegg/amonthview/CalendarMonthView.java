package com.bigbadegg.amonthview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by cy on 2017/11/16.
 */

public class CalendarMonthView extends LinearLayout {
    RecyclerView recyclerView;
    private TextView textView;
    CalendarAdapter adapter = new CalendarAdapter(new ArrayList<CalendarBean>());
    int positionRecord = 0;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);

    public CalendarMonthView(Context context) {
        this(context, null);
    }

    public CalendarMonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CalendarMonthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_month_view, this);
        textView = findViewById(R.id.tv_month);
        recyclerView = findViewById(R.id.rv_list);
        //fix 滑动冲突
        recyclerView.setLayoutManager(new GridLayoutManager(context, 7) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.setAdapter(adapter);
        updateData(year, month);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                List<CalendarBean> calendarBeans = adapter.getData();
                calendarBeans.get(positionRecord).setSelect(false);
                calendarBeans.get(position).setSelect(true);
                positionRecord = position;

                adapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * 获取当月日期集合
     *
     * @param year
     * @param month
     * @return
     */
    public void updateData(int year, int month) {
        List<CalendarBean> list = new ArrayList<>();
        //得到当月天数，以及1号位置
        int dayNum = DateUtils.getMonthDays(year, month);
        int dayFirstDay = DateUtils.getFirstDayWeek(year, month);

        for (int i = 1; i < dayFirstDay; i++) {
            list.add(new CalendarBean(0, "占位"));
        }

        for (int i1 = 1; i1 <= dayNum; i1++) {
            list.add(new CalendarBean(i1, "Text"));
        }

        for (int i2 = 0; i2 <= 42 - dayNum - dayFirstDay; i2++) {
            list.add(new CalendarBean(0, "占位"));
        }
        textView.setText(year + "年   " + (month + 1) + "月份");
        adapter.setNewData(list);
    }

}
