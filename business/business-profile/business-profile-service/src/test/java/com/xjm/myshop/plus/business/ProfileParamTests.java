package com.xjm.myshop.plus.business;

import com.xjm.myshop.plus.business.dto.ProfileParam;
import com.xjm.myshop.plus.commons.utils.MapperUtils;
import org.junit.Test;

public class ProfileParamTests {

    @Test
    public void testProfileParam() throws Exception {
        System.out.println(MapperUtils.obj2json(new ProfileParam()));
    }
}
