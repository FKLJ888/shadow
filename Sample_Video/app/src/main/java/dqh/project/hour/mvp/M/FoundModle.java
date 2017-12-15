package dqh.project.hour.mvp.M;

import dqh.project.hour.bean.FoundBean;
import dqh.project.hour.mvp.V.FoundView;
import dqh.project.hour.mvp_base.BaseModle;
import dqh.project.hour.retorfit.ApiService;
import dqh.project.hour.retorfit.RetorfitUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Love_you on 2017/12/14 0014.
 */

public class FoundModle extends BaseModle implements FoundView.modleinter {

    @Override
    public void getModle(Observer<FoundBean> observer) {
        ApiService apiService = RetorfitUtil.getApiService();
        apiService.getHomePage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
