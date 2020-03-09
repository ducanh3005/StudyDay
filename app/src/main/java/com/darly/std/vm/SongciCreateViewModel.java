/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.BaseBean;
import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;

/**
 * Description TODO:
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/22 17:59
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class SongciCreateViewModel extends ViewModel {
    private MutableLiveData<SongCiAuthorModel> authorModel = new MutableLiveData<>();
    private MutableLiveData<SongCiModel> ciModel = new MutableLiveData<>();

    public SongciCreateViewModel() {
    }

    public void initModel(BaseBean bean) {
        if (bean instanceof SongCiAuthorModel) {
            authorModel.setValue((SongCiAuthorModel) bean);
        } else if (bean instanceof SongCiModel) {
            ciModel.setValue((SongCiModel) bean);
        } else {

        }
    }

    public MutableLiveData<SongCiAuthorModel> getAuthorModel() {
        return authorModel;
    }

    public MutableLiveData<SongCiModel> getCiModel() {
        return ciModel;
    }
}
