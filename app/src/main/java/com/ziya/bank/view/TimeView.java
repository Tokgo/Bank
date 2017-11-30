package com.ziya.bank.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ziya.bank.R;
import com.ziya.bank.utils.DensityUtil;

/**
 * Created by Oliver on 17/11/18.
 */

public class TimeView extends LinearLayout {

    private View root;
    private Button btn_description;
    private Button btn_time;
    private int res_description=R.color.blue;
    private int res_time=R.color.blue;
    private float size=DensityUtil.dip2px(15.0f);
    private int description_text=R.string.time;
    private int time_text=R.string.time;

    public TimeView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);

    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        root = View.inflate(context, R.layout.view_time, this);
        setOrientation(HORIZONTAL);
        initView();
        initAttrs(attrs,defStyleAttr);
    }

    private void initView() {
        btn_description=root.findViewById(R.id.description);
        btn_time=root.findViewById(R.id.time);
    }

    private void initAttrs(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.TimeView, defStyle, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int id = a.getIndex(i);
            switch (id) {
                case R.styleable.TimeView_color_description:
                    res_description = a.getResourceId(id,R.color.blue);
                    break;
                case R.styleable.TimeView_color_time:
                    res_time = a.getResourceId(id,R.color.blue);
                    break;
                case R.styleable.TimeView_size:
                    size = a.getDimension(id, DensityUtil.dip2px(15.0f));
                    break;
                case R.styleable.TimeView_description_text:
                    description_text=a.getResourceId(id,R.string.time);
                    break;
                case R.styleable.TimeView_time_text:
                    time_text=a.getResourceId(id,R.string.time);
                    break;
                default:
                    break;
            }
        }
        setDescriptionColor(res_description);
        setTimeColor(res_time);
        setDescriptionText(description_text);
        setTimeText(time_text);
        setTextSize(DensityUtil.px2dip(size));
    }

    public void setDescriptionText(int text){
        btn_description.setText(text);
    }

    public void setTimeText(int text){
        btn_time.setText(text);
    }

    @SuppressWarnings("deprecation")
    public void setDescriptionColor(int color){
        btn_description.setTextColor(getResources().getColor(color));
    }

    @SuppressWarnings("deprecation")
    public void setTimeColor(int color){
        btn_time.setTextColor(getResources().getColor(color));
    }

    public void setTextSize(float size){
        btn_description.setTextSize(size);
        btn_time.setTextSize(size);
    }
}
