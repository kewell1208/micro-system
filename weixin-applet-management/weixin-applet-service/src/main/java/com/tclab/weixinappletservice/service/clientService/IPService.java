package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.IpUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class IPService {

    private static final Logger logger = LoggerFactory.getLogger(IPService.class);

    @Autowired
    private RedisUtils redisUtils;

    @Transactional
    public boolean checkIp(HttpServletRequest request){

        logger.info("判断IP是否可以操作");

        //判断IP是否恶意攻击
        String ip = IpUtils.getIpAddr(request);
        String blackIp = RedisConstants.BLACKIP+":"+ip;
        blackIp = redisUtils.get(blackIp);
        if (blackIp!=null&&blackIp.equals("1")){
            return false;
        }

        //如果不在黑名单中
        String ipKey = RedisConstants.IPCOUNT+":"+ip;
        String countStr = redisUtils.get(ipKey);
        if (countStr!=null){
            Integer count = Integer.parseInt(countStr);
            //如果超过20次请求则认为IP攻击
            if ((count+1)>20){
                redisUtils.set(blackIp,"1");
                return false;
            }
            countStr = String.valueOf(count+1);
            redisUtils.set(ipKey,countStr);
            return true;
        } else {
            redisUtils.set(ipKey,"1");
            return true;
        }

    }

}
