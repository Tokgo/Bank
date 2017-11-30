package com.ziya.bank.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ziya.bank.R;
import com.ziya.bank.base.BaseFragment;
import com.ziya.bank.fragment.iView.ITaskFragmentPresenter;
import com.ziya.bank.fragment.presenter.TaskFragmentPresenter;

/**
 * Created by Oliver on 17/11/19.
 */

public class TaskFragment extends BaseFragment<TaskFragmentPresenter> implements ITaskFragmentPresenter {

    private Button btn_task_unfinish;
    private Button btn_task_finished;
    private TextView tv_task_data;
    private TextView tv_task_line;
    private RecyclerView task_list;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        root=inflater.inflate(R.layout.fragment_task,null);
        initView();
        initData();
        return root;
    }

    private void initData() {
        initTitle();
        setTitle(R.string.task_list);
        presenter.initRecyclerView();
    }

    private void initView() {
        btn_task_unfinish=root.findViewById(R.id.fragment_task_unFinish);
        btn_task_finished=root.findViewById(R.id.fragment_task_finished);
        tv_task_data=root.findViewById(R.id.fragment_task_data);
        tv_task_line=root.findViewById(R.id.fragment_task_line);
        task_list=root.findViewById(R.id.fragment_task_list);
    }

    @Override
    public RecyclerView getRecycleView() {
        return task_list;
    }

    @Override
    public Class<TaskFragmentPresenter> getPresenterClass() {
        return TaskFragmentPresenter.class;
    }
}
