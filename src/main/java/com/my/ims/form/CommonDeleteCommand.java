package com.my.ims.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonDeleteCommand implements Serializable {

    private static final long serialVersionUID = 4382503430738836407L;

    private String[] ids;
}
