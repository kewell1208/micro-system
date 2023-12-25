package com.tclab.weixinappletcommon.constant;


import java.util.ArrayList;
import java.util.List;

public enum SampleTypeEnum {

    SAMPLE_TYPE_fenbian(0,"粪便",false),
    SAMPLE_TYPE_xueye(1,"血液",false),
    SAMPLE_TYPE_niaoye(2,"尿液",false),
    SAMPLE_TYPE_xiongshui(3,"胸水",false),
    SAMPLE_TYPE_naojiye(4,"脑脊液",false),
    SAMPLE_TYPE_yindaofenmiwu(5,"分泌物",false),
    SAMPLE_TYPE_tan(6,"痰",false),
    SAMPLE_TYPE_guisui(7,"骨髓",false),
    SAMPLE_TYPE_tanhuofeipaoguanxiye(8,"痰或者肺泡灌洗液",false),
    SAMPLE_TYPE_jingyefenmiwu(9,"精液",false),
    SAMPLE_TYPE_other(10,"其他",false);

    //样本类型（
    // 1血清 v
    // 2骨髓
    // 3尿液 v
    // 4痰
    // 5血浆 v
    // 7全血 v
    // 8乳汁
    // 9胸水
    // 10腹水 v
    // 11脑脊液
    // 12脐血
    // 13分泌物 v
    // 15粪便 v
    // 21外周血
    // 28咽拭子 v
    // 51阴道分泌物 v
    // 54生殖器分泌物
    // 55鼻拭子
    // 66肺泡灌洗液
    // 74精液 v
    // 115肝素抗凝血浆
    // 126多种标本类型
    // 165痰液或咽拭子 v
    // 167全血或骨髓
    // 171痰液或灌洗液 v）

    /*编号*/
    private Integer id;
    /*名称*/
    private String name;
    /*删除标识*/
    private Boolean delFlag;
    /*标本等级，一般的标本可以直接在诊所采样，特殊样本需要前往特殊采集点*/
    private Integer level;

    SampleTypeEnum(Integer id, String name, Boolean delFlag) {
        this.id = id;
        this.name = name;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public static SampleTypeEnum getByCode(Integer id) {
        if (id == null)
            return null;
        for (SampleTypeEnum sampleTypeEnum : values()) {
            if (sampleTypeEnum.getId() == id) {
                return sampleTypeEnum;
            }
        }
        return null;
    }

    public static List<Integer> getByDelFlag(boolean delFlag) {
        List<Integer> result = new ArrayList<>();
        for (SampleTypeEnum sampleTypeEnum : values()) {
            if (sampleTypeEnum.getDelFlag() == delFlag) {
                result.add(sampleTypeEnum.getId());
            }
        }
        return result;
    }

    public static List<SampleTypeListVo> getListVoByDelFlag(boolean delFlag) {
        List<SampleTypeListVo> result = new ArrayList<>();
        for (SampleTypeEnum sampleTypeEnum : values()) {
            if (sampleTypeEnum.getDelFlag() == delFlag) {
                SampleTypeListVo listVo = new SampleTypeListVo();
                listVo.setId(sampleTypeEnum.getId());
                listVo.setName(sampleTypeEnum.getName());
                result.add(listVo);
            }
        }
        return result;
    }

    public static String getNameById(Integer id) {
        List<SampleTypeListVo> result = new ArrayList<>();
        for (SampleTypeEnum sampleTypeEnum : values()) {
            if (sampleTypeEnum.getId().equals(id)) {
                SampleTypeListVo listVo = new SampleTypeListVo();
                listVo.setId(sampleTypeEnum.getId());
                listVo.setName(sampleTypeEnum.getName());
                result.add(listVo);
            }
        }
        if (result.size()!=0) {
            return result.get(0).getName();
        } else {
            return null;
        }
    }

}
