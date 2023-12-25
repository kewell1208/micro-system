package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletservice.dao.AppletInterpretGoodMapper;
import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：InterpretGoodService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/11/4 2:57 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class InterpretGoodService {

  @Autowired
  private AppletInterpretGoodMapper appletInterpretGoodMapper;

  public int insertInterpretGood(AppletInterpretGood good) {
    return appletInterpretGoodMapper.insert(good);
  }
}
