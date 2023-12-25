package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletGoodExceptionMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.ExceptionBaseVo;
import com.tclab.weixinappletservice.pojo.AppletGoodException;
import com.tclab.weixinappletservice.pojo.AppletGoodExceptionExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminExceptionService {

    @Autowired
    private AppletGoodExceptionMapper exceptionMapper;

    public List<ExceptionBaseVo> getExceptionByOrderNo(String orderNo){
        AppletGoodExceptionExample exceptionExample = new AppletGoodExceptionExample();
        AppletGoodExceptionExample.Criteria exceptionExampleCriteria = exceptionExample.createCriteria();
        exceptionExampleCriteria.andOrderNoEqualTo(orderNo);
        List<AppletGoodException> exceptionList = exceptionMapper.selectByExample(exceptionExample);
        if (exceptionList.size()!=0){
            List<ExceptionBaseVo> exceptionBaseVoList = new ArrayList<>();
            for (AppletGoodException exception:exceptionList) {
                ExceptionBaseVo exceptionBaseVo = new ExceptionBaseVo();
                BeanUtils.copyProperties(exception,exceptionBaseVo);
                exceptionBaseVo.setGoodApplyDate(DateUtils.convertToStandardDate(exception.getGoodApplyDate()));
                exceptionBaseVo.setGoodDelayApplyDate(DateUtils.convertToStandardDate(exception.getGoodDelayApplyDate()));
                exceptionBaseVoList.add(exceptionBaseVo);
            }
            return exceptionBaseVoList;
        } else {
            return null;
        }
    }

}
