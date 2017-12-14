package dqh.project.hour.mvp_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dqh.project.hour.utils.CreateObjUtil;


/**
 * Created by Love_you on 2017/12/7 0007.
 */

public abstract class BaseFragment<P extends Basepresenter> extends Fragment implements IView {
    protected P mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //通过泛型获取P层对象,或者创建对象
        mPresenter= CreateObjUtil.getT(this,0);
        if (mPresenter!=null)
        {
            //P层与V层绑定
            mPresenter.attachView(this);
        }
        View view = inflater.inflate(addLauyout(),null,false);
        initView(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)
        {
            //观察者不继续消费事件
            mPresenter.destoryView();
        }
    }

    protected abstract int addLauyout();
    protected abstract void initView(View view);
}
