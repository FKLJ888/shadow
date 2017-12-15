package dqh.project.hour.mvp.P;

import dqh.project.hour.bean.FoundBean;
import dqh.project.hour.fragment.FoundFragment;
import dqh.project.hour.mvp.M.FoundModle;
import dqh.project.hour.mvp.V.FoundView;
import dqh.project.hour.mvp_base.Basepresenter;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Love_you on 2017/12/14 0014.
 */

public class FoundPresenter extends Basepresenter<FoundFragment,FoundModle> implements FoundView.presenterinter {
    @Override
    public void getPresenter() {
        mModle.getModle(new Observer<FoundBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull FoundBean foundBean) {
                mView.Succ(foundBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
