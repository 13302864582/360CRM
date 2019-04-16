package com.example.moudleb;

import java.util.List;

public class TestBean {

    /**
     * showapi_res_error :
     * showapi_res_id : 279b7fb0b10f4768877dc6634f8816b4
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"pagebean":{"contentlist":[{"id":"/art/renge/81219.html","img":"http://imagenlp.b0.upaiyun.com/20190219/034815ka8zhnunoo109f6c.jpg","title":"趣味测试：测测你内心的\u201d兽性\u201c"},{"id":"/art/renge/81214.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"你个性中的包袱是什么？"},{"id":"/art/renge/81213.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试：打瞌睡姿势看一个人的性格"},{"id":"/art/renge/81209.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"从吃蛋糕的小动作看出最真实的你！"},{"id":"/art/renge/81208.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"性格测试：测一测你的抗压能力有多强！"},{"id":"/art/liangxing/81201.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试｜魔镜告诉你灵魂深处的爱情本色"},{"id":"/art/renge/81197.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"测试你是欢乐颂里的谁？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"点菜测试 | 花30秒看你是个怎样的人？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"十张图测试出你的潜在性格，超级准！"},{"id":"/art/liangxing/81170.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"\u201c好老公\u201d测试：你们家老公合格了吗？"}],"allPages":"269","allNum":" 2685 "}}
     */

    private String showapi_res_error;
    private String showapi_res_id;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * pagebean : {"contentlist":[{"id":"/art/renge/81219.html","img":"http://imagenlp.b0.upaiyun.com/20190219/034815ka8zhnunoo109f6c.jpg","title":"趣味测试：测测你内心的\u201d兽性\u201c"},{"id":"/art/renge/81214.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"你个性中的包袱是什么？"},{"id":"/art/renge/81213.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试：打瞌睡姿势看一个人的性格"},{"id":"/art/renge/81209.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"从吃蛋糕的小动作看出最真实的你！"},{"id":"/art/renge/81208.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"性格测试：测一测你的抗压能力有多强！"},{"id":"/art/liangxing/81201.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试｜魔镜告诉你灵魂深处的爱情本色"},{"id":"/art/renge/81197.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"测试你是欢乐颂里的谁？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"点菜测试 | 花30秒看你是个怎样的人？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"十张图测试出你的潜在性格，超级准！"},{"id":"/art/liangxing/81170.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"\u201c好老公\u201d测试：你们家老公合格了吗？"}],"allPages":"269","allNum":" 2685 "}
         */

        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean {
            /**
             * contentlist : [{"id":"/art/renge/81219.html","img":"http://imagenlp.b0.upaiyun.com/20190219/034815ka8zhnunoo109f6c.jpg","title":"趣味测试：测测你内心的\u201d兽性\u201c"},{"id":"/art/renge/81214.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"你个性中的包袱是什么？"},{"id":"/art/renge/81213.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试：打瞌睡姿势看一个人的性格"},{"id":"/art/renge/81209.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"从吃蛋糕的小动作看出最真实的你！"},{"id":"/art/renge/81208.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"性格测试：测一测你的抗压能力有多强！"},{"id":"/art/liangxing/81201.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"趣味测试｜魔镜告诉你灵魂深处的爱情本色"},{"id":"/art/renge/81197.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"测试你是欢乐颂里的谁？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"点菜测试 | 花30秒看你是个怎样的人？"},{"img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"十张图测试出你的潜在性格，超级准！"},{"id":"/art/liangxing/81170.html","img":"http://pics.static.nlp.cn/quwei/nopic.gif","title":"\u201c好老公\u201d测试：你们家老公合格了吗？"}]
             * allPages : 269
             * allNum :  2685
             */

            private String allPages;
            private String allNum;
            private List<ContentlistBean> contentlist;

            public String getAllPages() {
                return allPages;
            }

            public void setAllPages(String allPages) {
                this.allPages = allPages;
            }

            public String getAllNum() {
                return allNum;
            }

            public void setAllNum(String allNum) {
                this.allNum = allNum;
            }

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean {
                /**
                 * id : /art/renge/81219.html
                 * img : http://imagenlp.b0.upaiyun.com/20190219/034815ka8zhnunoo109f6c.jpg
                 * title : 趣味测试：测测你内心的”兽性“
                 */

                private String id;
                private String img;
                private String title;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
