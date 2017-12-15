package dqh.project.hour.mvp.V;

import dqh.project.hour.bean.FoundBean;
import io.reactivex.Observer;

/**
 * Created by Love_you on 2017/12/14 0014.
 */

public class FoundView {
    public interface Viewinter{
        void Succ(FoundBean foundBean);
    }

    public interface modleinter{
        void getModle(Observer<FoundBean> observer);
    }

    public interface presenterinter{
        void getPresenter();
    }
}
