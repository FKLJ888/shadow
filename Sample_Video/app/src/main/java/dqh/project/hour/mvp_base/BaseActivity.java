package dqh.project.hour.mvp_base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dqh.project.hour.utils.CreateObjUtil;

/**
 * Created by Love_you on 2017/12/6 0006.
 */

public abstract class BaseActivity<P extends Basepresenter> extends AppCompatActivity implements IView {
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ImmersionBar.with(this).barColor(R.color.colorPrimary).init();
        mPresenter= CreateObjUtil.getT(this,0);
        //进行绑定
        mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        if(mPresenter!=null){
            mPresenter.destoryView();
        }
//        ImmersionBar.with(this).destroy();
    }
}
