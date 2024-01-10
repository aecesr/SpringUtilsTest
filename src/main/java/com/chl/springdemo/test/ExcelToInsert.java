package com.chl.springdemo.test;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.chl.springdemo.model.ExcelModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/15 17:19
 * @注释
 */
public class ExcelToInsert {
    public static <T> List<T> importExcel(File file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
        if (file == null) {
            return null;
        }
        // 获取sheet
        Workbook workBook = getWorkBook(file);
        int sheets = workBook.getNumberOfSheets();

        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        params.setKeyIndex(null);
        List<T> list = new ArrayList<>();
        try {
            for (int i = 0; i < sheets; i++) {
                params.setStartSheetIndex(i);
                list.addAll(ExcelImportUtil.importExcel(file,pojoClass,params));
            }
//            list = ExcelImportUtil.importExcel(file, pojoClass, params);
        } catch (Exception e) {
             throw new RuntimeException("excel文件不能为空");
        }
        return list;
    }

    public static void main(String[] args) {
        int length = "offline_medium_storage_location".length();
//        System.out.println(length);
        File file = new File("D:\\desktop\\文书档案元数据表.xlsx");
        List<ExcelModel> excelModels = importExcel(file, 1, 1, ExcelModel.class);
        List<String> strings = new ArrayList<>();
//        System.out.println(excelModels);

//
        String sqlString ="";
        String pid = "0";
        String parentId = null;
        int parentSeq = 1;
        int childSeq = 1;
        for (ExcelModel excelModel : excelModels) {
            if (!"是，条目元数据".equals(excelModel.getIsdt())) {
               continue;
            }

            if (!excelModel.getZdm().equals(excelModel.getZden())) {
                System.out.println(excelModel.getZdm());
            }
            int orderSeq;
            String fieldName="";
            String fieldId = UUID.randomUUID().toString().replace("-","").toUpperCase();
            if (excelModel.getZdzw1() == null || "复合型".equals(excelModel.getYslx())) {
                parentId = fieldId;
            }
            if (excelModel.getZdzw() != null || "复合型".equals(excelModel.getYslx())) {
                pid = "0";
                orderSeq = parentSeq;
                parentSeq++;
                fieldName = excelModel.getZdzw();
            }else {
                orderSeq = childSeq;
                childSeq++;
                pid = parentId;
                fieldName = excelModel.getZdzw1();
            }



            String fieldDisplay = fieldName;
            String fieldDisplayEn = Objects.isNull(excelModel.getZden())?"":excelModel.getZden();
            int required = "必选".equals(excelModel.getYsx()) ? 0 : "可选".equals(excelModel.getYsx()) ? 1 : 2;
            int fieldContainer = "简单型".equals(excelModel.getYslx()) ? 0 : "容器型".equals(excelModel.getYslx()) ? 1 : 2;
            int dataType = "数值型".equals(excelModel.getSjlx()) ? 0 : "字符型".equals(excelModel.getSjlx()) ? 1 : "日期型".equals(excelModel.getSjlx()) ?2: "日期时间型".equals(excelModel.getSjlx())?3:1;
            int dataLength = (null == excelModel.getZdcd()) ? 30 : excelModel.getZdcd();
//            int listShowWidth = Objects.isNull(excelModel.getLbxs())?0:Integer.parseInt(excelModel.getLbxs());
//            int dataLength = 0;
            // 设置宽度
            assert fieldDisplay != null;
            int width = (fieldDisplay.length() / 2) * 50;
            int listShowWidth = Math.min(width,200);
            // 卡片显示宽度 0=25%，1=50%，2=75%，3=100%，4=文本行
            int formShowWidth = 0;
            if ("题名".equals(excelModel.getZdsx())) {
                formShowWidth = 3;
            }
//            if (!Objects.isNull(excelModel.getKpxs())){
//                String kpxs = excelModel.getKpxs();
//                switch (kpxs) {
//                    case "25%"->
//                            formShowWidth = 0;
//                    case "50%"->
//                            formShowWidth = 1;
//                    case "75%"->
//                            formShowWidth = 2;
//                    case "100%"->
//                            formShowWidth = 3;
//                    default ->
//                            formShowWidth = 4;
//                }
//            }
//            int formShowWidth =  Objects.isNull(excelModel.getKpxs())?0:"25%".equals(excelModel.getKpxs())?;
            String fieldAttr =  Objects.isNull(excelModel.getZdsx())?"":excelModel.getZdsx();
            String defaultValue = Objects.isNull(excelModel.getDefaultValue())?"":excelModel.getDefaultValue();
            int referenceType = 0;
            int referenceId = 0;
            String referenceDisplay = "";
            // 应用层次梳理
            String yycj = excelModel.getYycj();
            String[] split = yycj.split("/");
            List<String> strings1 = Arrays.asList(split);
            int forRecord = 0;
            int forFolder = 0;
            int forProject = 0;
            if (strings1.contains("件")) {
                forRecord = 1;
            }
            if (strings1.contains("卷")) {
                forFolder = 1;
            }
            if (strings1.contains("项目")){
                forProject = 1;
            }

//            int forRecord = "1".equals(excelModel.getWjml())? 1:0;
//            int forFolder = "1".equals(excelModel.getAjml())? 1:0;
//            int forProject = "1".equals(excelModel.getWjml())? 1:0;
            int  repeatable = "不可重复".equals(excelModel.getKcfx()) ? 0 : 1;
            String definition = "";
            String purpose = "";
            int state = 1;
//            sqlString += "INSERT INTO pdes_sys_base_field(field_id, class_id, field_name, field_display, field_display_en, required, field_container, data_type, data_length, list_show_width, form_show_width, field_attr, default_value, reference_type, reference_id, reference_display, for_record, for_folder, for_project, `repeatable`, definition, purpose, state)VALUES("+fieldId+","+"'','"+ fieldName.trim()+"','" +fieldDisplay.trim()+"','"+ fieldDisplayEn.trim()+"',"+ required+","+ fieldContainer+","+ dataType+","+ dataLength+","+ listShowWidth+","+formShowWidth +",'" +fieldAttr.trim()+"','"+ defaultValue+"',"+referenceType+",'"+ referenceId+"','"+ referenceDisplay +"'," + forRecord+","+ forFolder+","+ forProject+","+ repeatable+",'"+ definition+"','"+ purpose+"',"+ state+");\n";
            sqlString += "INSERT INTO pdes_sys_base_field(field_id,pid, order_seq,class_id, field_name, field_display, field_display_en, required, field_container, data_type, data_length, list_show_width, form_show_width, field_attr, default_value, reference_type, reference_id, reference_display, for_record, for_folder, for_project, `repeatable`, definition, purpose, state)VALUES('"+fieldId+"','"+ pid +"',"+ orderSeq +",'15','"+ fieldName.trim()+"','" +fieldDisplay.trim()+"','"+ fieldDisplayEn.trim()+"',"+ required+","+ fieldContainer+","+ dataType+","+ dataLength+","+ listShowWidth+","+formShowWidth +",'" +fieldAttr.trim()+"','"+ defaultValue+"',"+referenceType+",'"+ referenceId+"','"+ referenceDisplay +"'," + forRecord+","+ forFolder+","+ forProject+","+ repeatable+",'"+ definition+"','"+ purpose+"',"+ state+");\n";

//            fieldId++;
        }
        FileWriter writer;
        try {
            File file1 = new File("D:/desktop/insert.txt");
            if (!file1.exists()) {
               file1.createNewFile();
            }
            writer = new FileWriter("D:/desktop/insert.txt");
            writer.write("");//清空原文件内容
            writer.write(sqlString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(sqlString);
//        System.out.println(strings);
//        System.out.println(excelModels);
    }

    public static Workbook getWorkBook(File file){
        //这样写excel能兼容03和07
        Workbook hssfWorkbook = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            hssfWorkbook = new XSSFWorkbook(fileInputStream);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return hssfWorkbook;
    }
}
