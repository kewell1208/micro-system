package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletPackagePurpose;

import java.util.ArrayList;
import java.util.List;

public class PurposePackageVo {

    private AppletPackagePurpose packagePurpose;

    private List<PackageBaseVo> packageBaseVos = new ArrayList<>();

    public AppletPackagePurpose getPackagePurpose() {
        return packagePurpose;
    }

    public void setPackagePurpose(AppletPackagePurpose packagePurpose) {
        this.packagePurpose = packagePurpose;
    }

    public List<PackageBaseVo> getPackageBaseVos() {
        return packageBaseVos;
    }

    public void setPackageBaseVos(List<PackageBaseVo> packageBaseVos) {
        this.packageBaseVos = packageBaseVos;
    }
}
