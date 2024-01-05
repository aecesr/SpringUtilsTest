package com.chl.springdemo.test;

import com.chl.springdemo.service.Translate;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/14 9:47
 * @注释
 */
public class TranslateTest {

    static  String a = "";

    static Boolean b = true;

    static String c ="";

    public static void print(String country, String[] content){
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                a = re(s);
            }
            public String re (String value) {
                if (content.length > 0) {
                    return Translate.zhTo(value,country);
                }
                    return "";
            }
        };
        for (String s : content) {
            String[] item = s.split("=");
            String title = "";
            if (item[0].endsWith(".")){
                String[] s1 = Objects.requireNonNull(Translate.zhToEn(item[1])).split(" ");
                String a1 = "";
                for (String s2 : s1) {
                    char c = s2.charAt(0);
                    String replace = s2.replace(String.valueOf(c), String.valueOf(c).toUpperCase());
                    a1 += replace;
                }
//                title = item[0] +  Objects.requireNonNull(Translate.zhToEn(item[1])).replaceAll(" ","");

                title = item[0] + removeCharacters(a1);
            }else {
                title = item[0];
            }
            String value = item[1];
            consumer.accept(value);
            String  s1 = a;
            System.out.println(title+" = "+s1);
            c += (title+" = "+s1+"\n");
        }

        System.out.println("\n ===========================");
    }
    public static String removeCharacters(String input) {
        // 匹配数字和特殊字符的正则表达式
        String regex = "[0-9\\p{Punct}]";

        // 使用空字符串替换匹配到的字符
        String result = input.replaceAll(regex, "");

        return result;
    }
    public static void main(String[] args) {

        String a ="offline.common.exception.message.Login.=存在同名用户\n" +
                "offline.common.exception.message.Login.=密码长度不得为0\n" +
                "offline.common.exception.message.Login.=用户名超出最大长度\n" +
                "offline.common.exception.message.Login.=密码不符合规则\n" +
                "offline.common.exception.message.Login.=两次密码不一致\n" +
                "offline.common.exception.message.Login.=注册成功\n" +
                "offline.common.exception.message.Login.=必填项为空\n" +
                "offline.common.exception.message.Login.=登录后才能修改密码！\n" +
                "offline.common.exception.message.Login.=原密码不正确!\n" +
                "offline.common.exception.message.Login.=密码不符合规则,只支持英文大小写和数字组合！\n" +
                "offline.common.exception.message.Login.=新密码与旧密码一致\n" +
                "offline.common.exception.message.Login.=修改成功\n" +
                "offline.common.exception.message.Login.=修改内容为空\n" +
                "offline.common.exception.message.Login.=用户名超出最大长度\n" +
                "offline.common.exception.message.Login.=通讯码为8位，需包含大写字母、小写字母和数字！\n" +
                "offline.common.exception.message.Login.=存在同名用户\n" +
                "offline.common.exception.message.Login.=部门名称超出最大长度\n" +
                "offline.common.exception.message.Login.=原密码不正确\n" +
                "offline.common.exception.message.Login.=修改内容为空\n" +
                "offline.common.exception.message.Login.=修改内容为空\n" +
                "offline.common.exception.message.SyncHistory.=新增成功!\n" +
                "offline.common.exception.message.SyncHistory.=更新成功!";

        System.out.println(a);

        String[] split = a.split("\n");

        System.out.println("=====  中文 -- zh =====\n");
        print("zh",split);

        String[] split1 = c.split("\n");

        split = split1;

        System.out.println("=====  转英文 -- En =====\n");
        print("en",split);

        System.out.println("=====  转繁体-- zh-TW =====\n");
        print("zh-TW",split);

        System.out.println("=====  转日文 =====\n");
        print("ja",split);

        System.out.println("=====  转韩文-- ko  =====\n");
        print("ko",split);

        System.out.println("=====  转法语-- fr =====\n");
        print("fr",split);

        System.out.println("=====  转俄语 -- ru =====\n");
        print("ru",split);

        System.out.println("=====  转葡萄牙--pt =====\n");
        print("pt",split);

        System.out.println("=====  转塞尔维亚--空 =====\n");
        print("",split);

        System.out.println("=====  转泰语--th =====\n");
        print("th",split);

        System.out.println("=====  转西班牙语--es =====\n");
        print("es",split);

//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToZhTw(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转日文 =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToJa(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转韩文-- ko  =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToKo(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转法语-- fr =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToFr(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转俄语 -- ru =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToRu(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转葡萄牙--pt =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToPt(content);
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转塞尔维亚--空 =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = "";
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转泰语--th =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToTh(content);;
//            System.out.println(title+"="+s1);
//        }
//        System.out.println("=====  转西班牙语--es =====");
//        for (String s : split) {
//            String[] split1 = s.split("=");
//            String title = split1[0];
//            String content = split1[1];
//            String s1 = Translate.zhToEs(content);;
//            System.out.println(title+"="+s1);
//        }


//        switch (country) {
//            case "En" -> {
//                s1 = Translate.zhToEn(value);
//                continue;
//            }
//            case "zhTW" -> {
//                s1 = Translate.zhToZhTw(value);
//                continue;
//            }
//            case "Ja" -> {
//                s1 = Translate.zhToJa(value);
//                continue;
//            }
//            case "Ko" -> {
//                s1 = Translate.zhToKo(value);
//                continue;
//            }
//            case "Fr" -> {
//                s1 = Translate.zhToFr(value);
//                continue;
//            }
//            case "Ru" -> {
//                s1 = Translate.zhToRu(value);
//                continue;
//            }
//            case "Pt" -> {
//                s1 = Translate.zhToPt(value);
//                continue;
//            }
//            case "Th" -> {
//                s1 = Translate.zhToTh(value);
//                continue;
//            }
//            case "Es" -> {
//                s1 = Translate.zhToEs(value);
//                continue;
//            }
//            default -> {
//                s1 = "";
//                continue;
//            }
//        }
    }
}
