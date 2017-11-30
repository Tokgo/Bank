package com.ziya.bank.fragment.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ziya.bank.R;
import com.ziya.bank.base.BasePresenter;
import com.ziya.bank.fragment.iView.ITaskFragmentPresenter;
import com.ziya.bank.fragment.utils.DividerItemDecoration;
import com.ziya.bank.utils.DensityUtil;

/**
 * Created by Oliver on 17/11/19.
 */

public class TaskFragmentPresenter extends BasePresenter<ITaskFragmentPresenter> {


    public void initRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(iView.getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        iView.getRecycleView().setLayoutManager(manager);
        iView.getRecycleView().setAdapter(new TaskAdapter());
        iView.getRecycleView().addItemDecoration(new DividerItemDecoration(
                iView.getActivity(), LinearLayoutManager.HORIZONTAL, DensityUtil.dip2px(1),iView.getActivity().getResources().getColor(R.color.blue)));
    }
    public class TaskAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=View.inflate(iView.getActivity(), R.layout.item_task,null);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
        public  class  TaskHolder  extends RecyclerView.ViewHolder{

            private String taskId;
            private String taskTime;
            public TaskHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
