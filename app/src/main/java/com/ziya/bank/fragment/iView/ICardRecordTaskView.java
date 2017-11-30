package com.ziya.bank.fragment.iView;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ziya.bank.base.BaseView;

/**
 * Created by Oliver on 17/11/20.
 */

public interface ICardRecordTaskView extends BaseView{
    TextView getDateText();

    RecyclerView getRecycleView();

    TextView getListTitle();

    Button getFirstButton();

    Button getSecondButton();

    Button getThirdButton();

    TextView getOutOfTitle();

    LinearLayout getOutOfLayout();

    TextView getRecycleTitle();
}
