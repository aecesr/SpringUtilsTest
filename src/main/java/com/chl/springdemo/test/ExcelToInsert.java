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

        File file = new File("D:\\desktop\\全局配置-元数据管理-初始化内元数据.xlsx");
        List<ExcelModel> excelModels = importExcel(file, 0, 1, ExcelModel.class);
        List<String> strings = new ArrayList<>();

        String sqlString ="";

        for (ExcelModel excelModel : excelModels) {
            String fieldId = UUID.randomUUID().toString().replace("-","").toUpperCase();
            String fieldName = excelModel.getZdm();
            String fieldDisplay = Objects.isNull(excelModel.getZdzw())?"":excelModel.getZdzw();
            String fieldDisplayEn = Objects.isNull(excelModel.getZden())?"":excelModel.getZden();
            int required = "必选".equals(excelModel.getYsx()) ? 0 : "可选".equals(excelModel.getYsx()) ? 1 : 2;
            int fieldContainer = "简单型".equals(excelModel.getYslx()) ? 0 : "容器型".equals(excelModel.getYslx()) ? 1 : 2;
            int dataType = "数值型".equals(excelModel.getYslx()) ? 0 : "字符型".equals(excelModel.getYslx()) ? 1 : "日期型".equals(excelModel.getYslx()) ?2:3;
            int dataLength =Objects.isNull(excelModel.getZdcd())?0:Integer.parseInt(excelModel.getZdcd());
            int listShowWidth = Objects.isNull(excelModel.getLbxs())?0:Integer.parseInt(excelModel.getLbxs());
            // 卡片显示宽度 0=25%，1=50%，2=75%，3=100%，4=文本行
            int formShowWidth = 4;
            if (!Objects.isNull(excelModel.getKpxs())){
                String kpxs = excelModel.getKpxs();
                switch (kpxs) {
                    case "25%"->
                            formShowWidth = 0;
                    case "50%"->
                            formShowWidth = 1;
                    case "75%"->
                            formShowWidth = 2;
                    case "100%"->
                            formShowWidth = 3;
                    default ->
                            formShowWidth = 4;
                }
            }
//            int formShowWidth =  Objects.isNull(excelModel.getKpxs())?0:"25%".equals(excelModel.getKpxs())?;
            String fieldAttr =  Objects.isNull(excelModel.getZdsx())?"":excelModel.getZdsx();
            String defaultValue = Objects.isNull(excelModel.getDefaultValue())?"":excelModel.getDefaultValue();
            int referenceType = 0;
            int referenceId = 0;
            String referenceDisplay = "";
            int forRecord = "1".equals(excelModel.getWjml())? 1:0;
            int forFolder = "1".equals(excelModel.getAjml())? 1:0;
            int forProject = "1".equals(excelModel.getWjml())? 1:0;
            int  repeatable = "不可重复".equals(excelModel.getKcfx()) ? 0 : 1;
            String definition = "";
            String purpose = "";
            int state = 1;
//            sqlString += "INSERT INTO pdes_sys_base_field(field_id, class_id, field_name, field_display, field_display_en, required, field_container, data_type, data_length, list_show_width, form_show_width, field_attr, default_value, reference_type, reference_id, reference_display, for_record, for_folder, for_project, `repeatable`, definition, purpose, state)VALUES("+fieldId+","+"'','"+ fieldName.trim()+"','" +fieldDisplay.trim()+"','"+ fieldDisplayEn.trim()+"',"+ required+","+ fieldContainer+","+ dataType+","+ dataLength+","+ listShowWidth+","+formShowWidth +",'" +fieldAttr.trim()+"','"+ defaultValue+"',"+referenceType+",'"+ referenceId+"','"+ referenceDisplay +"'," + forRecord+","+ forFolder+","+ forProject+","+ repeatable+",'"+ definition+"','"+ purpose+"',"+ state+");\n";
            sqlString += "INSERT INTO pdes_sys_base_field(field_id, class_id, field_name, field_display, field_display_en, required, field_container, data_type, data_length, list_show_width, form_show_width, field_attr, default_value, reference_type, reference_id, reference_display, for_record, for_folder, for_project, `repeatable`, definition, purpose, state,allowed_seq)VALUES('"+fieldId+"',"+"'','"+ fieldName.trim()+"','" +fieldDisplay.trim()+"','"+ fieldDisplayEn.trim()+"',"+ required+","+ fieldContainer+","+ dataType+","+ dataLength+","+ listShowWidth+","+formShowWidth +",'" +fieldAttr.trim()+"','"+ defaultValue+"',"+referenceType+",'"+ referenceId+"','"+ referenceDisplay +"'," + forRecord+","+ forFolder+","+ forProject+","+ repeatable+",'"+ definition+"','"+ purpose+"',"+ state+",1);\n";

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
