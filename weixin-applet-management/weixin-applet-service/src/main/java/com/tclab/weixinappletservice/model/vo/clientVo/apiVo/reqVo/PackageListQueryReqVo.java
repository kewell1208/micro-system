package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：PackageListReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 2:20 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class PackageListQueryReqVo {

  private String packageSourceId;
  private String packageName;
  private String packageNo;
  private Integer pageNo;
  private Integer pageSize;
}
