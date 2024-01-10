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

    @Excel(name = "元数据中文名称")
    private String zdzw="";

    @Excel(name = "元数据中文名称1")
    private String zdzw1="";

    @Excel(name = "元数据英文名称")
    private String zden="";

    @Excel(name = "字段名")
    private String zdm="";

    @Excel(name = "字段属性")
    private String zdsx="";

    @Excel(name = "约束性" , importFormat = "必选_0;可选_1;条件选_2")
    private String ysx="";

    @Excel(name = "元素类型")
    private String yslx="";

    @Excel(name = "数据类型")
    private String sjlx="";

    @Excel(name = "字段长度")
    private Integer zdcd;

    @Excel(name = "可重复性")
    private String kcfx="";

    @Excel(name = "值域")
    private String zy="";

    @Excel(name = "缺省值")
    private String defaultValue="";

    @Excel(name = "应用层级")
    private String yycj="";

    @Excel(name = "对应T46编号")
    private String t46="";
    @Excel(name = "对应T48编号")
    private String t48="";
    @Excel(name = "是否动态字段")
    private String isdt="";


}
