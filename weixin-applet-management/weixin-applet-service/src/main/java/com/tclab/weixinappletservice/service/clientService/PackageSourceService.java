package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletservice.dao.AppletPackageSourceMapper;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletservice.pojo.AppletPackageSourceExample;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：PackageSourceService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/20 11:27 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class PackageSourceService {

  @Autowired
  private AppletPackageSourceMapper appletPackageSourceMapper;

  public List<AppletPackageSource> getList(){
    AppletPackageSourceExample example = new AppletPackageSourceExample();
    return appletPackageSourceMapper.selectByExample(example);
  }

}
