package com.ziya.bank.fragment.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ziya.bank.R;
import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.fragment.CarRecordTaskFragment;
import com.ziya.bank.fragment.iView.ICardRecordTaskView;
import com.ziya.bank.fragment.utils.DividerItemDecoration;
import com.ziya.bank.utils.DensityUtil;

/**
 * Created by Oliver on 17/11/20.
 */

public class CarRecordTaskPresenter extends BasePresenter<ICardRecordTaskView> {

    public void setDate() {
        // TODO: 17/11/20 设置当前记录表的时间
        iView.getDateText().setText("2017-11");
    }

    public void initRecycleView(int type) {
        LinearLayoutManager manager = new LinearLayoutManager(iView.getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        iView.getRecycleView().setLayoutManager(manager);
        iView.getRecycleView().addItemDecoration(new DividerItemDecoration(iView.getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dip2px(1), iView.getActivity().getResources().getColor(R.color.blue)));
        iView.getRecycleView().setAdapter(new CarRecordTaskAdapter(type));
    }

    public void init(int type) {
        if (type == CarRecordTaskFragment.OUT_IN_STORAGE) {
            iView.getListTitle().setText(R.string.out_in_mileage);
            iView.getFirstButton().setBackgroundResource(R.drawable.blue_gray);
        } else if (type == CarRecordTaskFragment.ADD_OIL) {
            iView.getListTitle().setText(R.string.add_oil_mileage);
            iView.getSecondButton().setBackgroundResource(R.drawable.blue_gray);
            setOutOfLayoutInVisible();
        } else if (type == CarRecordTaskFragment.REPAIR) {
            iView.getListTitle().setText(R.string.REPAIR_RECORD);
            iView.getThirdButton().setBackgroundResource(R.drawable.blue_gray);
            setOutOfLayoutInVisible();
        }
    }

    private void setOutOfLayoutInVisible() {
        iView.getOutOfTitle().setVisibility(View.GONE);
        iView.getOutOfLayout().setVisibility(View.GONE);
        iView.getRecycleTitle().setVisibility(View.GONE);
    }

    public class CarRecordTaskAdapter extends RecyclerView.Adapter {

        private int type;
        public CarRecordTaskAdapter(int type) {
            this.type = type;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car_record_task,parent,false);
            return new CarRecordTaskHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            // TODO: 17/11/20 数据更新
            CarRecordTaskHolder taskHolder= (CarRecordTaskHolder) holder;
            if (type == CarRecordTaskFragment.REPAIR){
                if(position!=0) {
                    taskHolder.root.getLayoutParams().height = DensityUtil.dip2px(60);
                    taskHolder.first.setText("2017-11-20");
                    taskHolder.second.setText("蹦蹦蹦三连撞");
                    taskHolder.third.setText("1000");
                }else{
                    taskHolder.first.setText(R.string.time);
                    taskHolder.second.setText(R.string.repair_reason);
                    taskHolder.third.setText(R.string.repair_money);
                }
            }else if(type==CarRecordTaskFragment.ADD_OIL){
                taskHolder.third_line.setVisibility(View.GONE);
                taskHolder.third.setVisibility(View.GONE);
                if(position==0) {
                    taskHolder.first.setText(R.string.time);
                    taskHolder.second.setText(R.string.mileage);
                }else{
                    taskHolder.first.setText("2017-11-20");
                    taskHolder.second.setText("8888");
                }
            }else if(type==CarRecordTaskFragment.OUT_IN_STORAGE&&position!=0){
                taskHolder.first.setText("2017-11-20");
                taskHolder.second.setText("6666");
                taskHolder.third.setText("8888");
            }
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class CarRecordTaskHolder extends RecyclerView.ViewHolder {
            private LinearLayout root;
            private TextView first;
            private TextView second;
            private TextView third;
            private View third_line;

            public CarRecordTaskHolder(View itemView) {
                super(itemView);
                root=itemView.findViewById(R.id.root);
                first = itemView.findViewById(R.id.first_form);
                second = itemView.findViewById(R.id.second_form);
                third = itemView.findViewById(R.id.third_form);
                third_line = itemView.findViewById(R.id.third_line);
            }
        }
    }
}
