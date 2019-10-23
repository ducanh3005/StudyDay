/*
 * 版权所有 2009-2019山东新北洋信息技术股份有限公司保留所有权利
 */

/*
 * 版权所有 2009-2019山东新北洋信息技术股份有限公司保留所有权利
 */

/*
 * 版权所有 2009-2019山东新北洋信息技术股份有限公司保留所有权利
 */

package com.darly.chinese.parse;

/**
 * 商品详情核心业务数据库及中间层操作类
 *
 * @author liuyan3
 * @date 2019/6/26
 */
public class DetailUtilImpl {

    private static DetailUtilImpl impl;

    public synchronized static DetailUtilImpl get() {
        if (impl == null) {
            impl = new DetailUtilImpl();
        }
        return impl;
    }

    /**
     * 封装商品详情webview需要显示的html
     *
     * @param bodyHTML 商品详情
     */
    public String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>img{max-width: 100%; width:100%; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }


}
