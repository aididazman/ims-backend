package com.my.ims.form;

import java.io.Serializable;
import java.util.Arrays;

public class CommonCompositeDeleteCommand implements Serializable {

    private static final long serialVersionUID = 4382503430738836407L;

    private String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCompositeDeleteCommand that = (CommonCompositeDeleteCommand) o;
        return Arrays.equals(ids, that.ids);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ids);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CommonCompositeDeleteDO{");
        builder.append("ids=").append(Arrays.toString(ids));
        builder.append('}');
        return builder.toString();
    }
}
