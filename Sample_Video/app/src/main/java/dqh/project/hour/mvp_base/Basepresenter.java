package dqh.project.hour.mvp_base;

import java.lang.ref.WeakReference;

import dqh.project.hour.utils.CreateObjUtil;

/**
 * Created by Love_you on 2017/12/6 0006.
 */

public abstract class Basepresenter<V extends IView,M extends IModle> implements IPresenter {
    //处理oom使用弱引用来进行调用
    private WeakReference<V> view;
    protected V mView;
    protected M mModle;
    {
        //使用初始化代码快
        //初始化V层与M层的对象
        mModle= CreateObjUtil.getT(this,1);
    }
    //与V层进行绑定
    public void attachView(V mView){
        this.mView=mView;
        view=new WeakReference(mView);
    }
    //与V层进行解绑
    public void destoryView(){
        if(view!=null){
            view.clear();
            view=null;
        }
    }
}
