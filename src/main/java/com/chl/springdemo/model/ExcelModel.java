package com.chl.springdemo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/15 17:29
 * @注释
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelModel {


    @Excel(name = "编号")
    private String bh ="";

    @Excel(name = "字段中文名")
    private String zdzw="";

    @Excel(name = "字段英文名")
    private String zden="";

    @Excel(name = "字段名")
    private String zdm="";

    @Excel(name = "约束性" , importFormat = "必选_0;可选_1;条件选_2")
    private String ysx="";

    @Excel(name = "元素类型")
    private String yslx="";

    @Excel(name = "数据类型")
    private String sjlx="";


    @Excel(name = "字段长度")
    private String zdcd="0";

    @Excel(name = "列表显示宽度")
    private String lbxs="";

    @Excel(name = "卡片显示宽度")
    private String kpxs="";

    @Excel(name = "数据库字段长度")
    private String sjkzdcd="";

    @Excel(name = "属性")
    private String zdsx="";

    @Excel(name = "缺省值")
    private String defaultValue="";

    @Excel(name = "值域")
    private String zy="";
    @Excel(name = "可重复性")
    private String kcfx="";

    @Excel(name = "文件目录")
    private String wjml="";

    @Excel(name = "案卷目录")
    private String ajml="";

    @Excel(name = "卷内目录")
    private String jnml="";
    @Excel(name = "原文")
    private String yw="";

    @Excel(name = "立档单位必选")
    private String lddwbx="";

    @Excel(name = "档案馆必选")
    private String dagbx="";
    @Excel(name = "捕获方式")
    private String bhfs="";
    @Excel(name = "备注")
    private String bz="";


}
