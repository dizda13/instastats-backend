package ba.instastats.instastats.instaController.Model;

import java.io.Serializable;

public class ResponseInstagramBody<T> implements Serializable {

    private T data;
    private Meta meta;
    private Object pagination;


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    static public class Meta implements Serializable {
        int code;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}


