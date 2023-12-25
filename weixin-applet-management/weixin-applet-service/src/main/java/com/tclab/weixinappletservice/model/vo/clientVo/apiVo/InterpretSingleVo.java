package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import java.util.List;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：InterpretVo
 * @Description： 单个患者报告解读显示
 * @Author：dcd
 * @Date：Created in 2019/9/12 3:02 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class InterpretSingleVo {

  private String interpretImg;
  private String interpretContent;
  private String participantImg;
  private String participantDiagnose;
  private String interpretDate;
  private String participantDescribe;
  private AppletOrderParticipant participant;
  private List<GoodQueryBaseVo> goodList;

}
