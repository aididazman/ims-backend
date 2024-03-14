package com.my.ims.util.constants;

public enum DbStatusEnum {

    ACTIVE(1),INACTIVE(0),DELETED(9);

    private final Integer value;

    private DbStatusEnum(Integer value) {
        this.value = value;
    }

    public static DbStatusEnum parse(Integer value) {
        if (value!=null){
            for (DbStatusEnum status : values()) {
                if (status.value.equals(value)) {
                    return status;
                }
            }
        }
        return null;
    }

    public Integer getValue(){
        return value;
    }

}
