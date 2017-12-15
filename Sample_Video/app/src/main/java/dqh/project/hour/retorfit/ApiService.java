package dqh.project.hour.retorfit;

import dqh.project.hour.bean.FoundBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Love_you on 2017/12/15 0015.
 */

public interface ApiService {
    /**
     * 首页
     *
     * @return
     */
    @GET("homePageApi/homePage.do")
    Observable<FoundBean> getHomePage();
}
