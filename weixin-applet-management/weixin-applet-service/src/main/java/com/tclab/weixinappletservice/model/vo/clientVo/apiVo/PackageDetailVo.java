package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageSub;

import java.util.ArrayList;
import java.util.List;

public class PackageDetailVo extends AppletPackage {

    List<AppletPackageSub> packageSubList = new ArrayList<>();

    private String sourcePic;

    public String getSourcePic() {
        return sourcePic;
    }

    public void setSourcePic(String sourcePic) {
        this.sourcePic = sourcePic;
    }

    public List<AppletPackageSub> getPackageSubList() {
        return packageSubList;
    }

    public void setPackageSubList(List<AppletPackageSub> packageSubList) {
        this.packageSubList = packageSubList;
    }
}
