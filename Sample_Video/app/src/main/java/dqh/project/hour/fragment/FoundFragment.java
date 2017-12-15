package dqh.project.hour.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import dqh.project.hour.R;
import dqh.project.hour.bean.FoundBean;
import dqh.project.hour.mvp.P.FoundPresenter;
import dqh.project.hour.mvp.V.FoundView;
import dqh.project.hour.mvp_base.BaseFragment;

/**
 * Created by Love_you on 2017/12/14 0014.
 */

public class FoundFragment extends BaseFragment<FoundPresenter> implements FoundView.Viewinter {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getPresenter();
    }

    @Override
    protected int addLauyout() {
        return R.layout.layout_found;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void Succ(FoundBean foundBean) {
        Log.i("xxx",foundBean.getCode());

    }
}
