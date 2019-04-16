package com.example.mvp;

import java.util.List;

public class bean {
    /**
     * error : 0
     * message : success
     * data : {"total":0,"list":[],"page":1,"pagesize":10,"sql":"SELECT COUNT(*) AS tp_count FROM `x360p_course_prepare` WHERE (  `x360p_course_prepare`.`og_id` = 0  AND `x360p_course_prepare`.`bid` = 3  AND `teach_eid` = 1 ) AND `x360p_course_prepare`.`delete_time` IS NULL LIMIT 1"}
     * authed : true
     */

    private int error;
    private String message;
    private DataBean data;
    private boolean authed;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isAuthed() {
        return authed;
    }

    public void setAuthed(boolean authed) {
        this.authed = authed;
    }

    public class DataBean {
        /**
         * total : 0
         * list : []
         * page : 1
         * pagesize : 10
         * sql : SELECT COUNT(*) AS tp_count FROM `x360p_course_prepare` WHERE (  `x360p_course_prepare`.`og_id` = 0  AND `x360p_course_prepare`.`bid` = 3  AND `teach_eid` = 1 ) AND `x360p_course_prepare`.`delete_time` IS NULL LIMIT 1
         */
        private String sql;

        public String getSql() {
            return sql;
        }
    }
}
