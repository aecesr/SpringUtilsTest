package com.chl.springdemo.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2024/1/3 13:46
 * @注释
 */
public class SqlTOJson {
    public static void main(String[] args) throws JsonProcessingException {
        String sqlStatement = "CREATE TABLE t_x_original_signature_certificate(\n" +
                "    `certificate_id` VARCHAR(32) NOT NULL   COMMENT '主键' ,\n" +
                "    `signature_id` VARCHAR(32)    COMMENT '签名ID' ,\n" +
                "    `certificate` VARCHAR(255)    COMMENT '证书' ,\n" +
                "    `certificate_reference` VARCHAR(255)    COMMENT '证书引证' ,\n" +
                "    PRIMARY KEY (certificate_id)\n" +
                ")  COMMENT = '证书?;';\n";

        List<Map<String,Object>> jsonOutput = convertSqlToJson(sqlStatement);
//        System.out.println(jsonOutput);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.valueToTree(jsonOutput);
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        System.out.println(s);
        JSONArray objects = new JSONArray(jsonOutput);
//        System.out.println(objects.toString(4));

    }

    public static  List<Map<String,Object>> convertSqlToJson(String sql) {
//        String pattern = "`(\\w+)`\\s+(\\w+)(?:\\((\\d+)\\))?[^']*'(.*?)'.*?(NOT\\s+NULL)?(?:\\s+DEFAULT\\s+'(.*?)')?";
        String pattern = "`(\\w+)`\\s+(\\w+)(?:\\((\\d+)\\))?[^']*'(.*?)'.*?(NOT\\s+NULL)?(?:\\s+DEFAULT\\s+'(.*?)')?";
//        String pattern = "`(\\w+)`\\s+(\\w+)(?:\\((\\d+)\\))?[^']*'(.*?)'.*?(NOT\\s+NULL)?(?:\\s+DEFAULT\\s+'(.*?)')?(?:\\s+COMMENT\\s+'(.*?)')?";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(sql);

//        Map<String, JSONObject> tableInfo = new HashMap<>();
        List<Map<String,Object>> maps = new LinkedList<>();
        while (matcher.find()) {
            Map<String,Object> fieldInfo = new LinkedHashMap<>();
            String fieldName = matcher.group(1);
            String fieldType = matcher.group(2);
            String fieldSize = matcher.group(3) != null ? matcher.group(3) : "";

            String fieldComment = matcher.group(4) != null ? matcher.group(4) : "";
            boolean isNotNull = matcher.group(5) != null;
            String defaultValue = matcher.group(6) != null ? matcher.group(6) : "";



            fieldInfo.put("name", fieldName);
            fieldInfo.put("type", fieldType);
            if (fieldSize.length() > 0) {
                fieldInfo.put("length", fieldSize);
            }
            fieldInfo.put("nullable", isNotNull);
                fieldInfo.put("defaultValue", "0");
            fieldInfo.put("memo", fieldComment);
            maps.add(fieldInfo);
        }

        return maps;
    }
}
