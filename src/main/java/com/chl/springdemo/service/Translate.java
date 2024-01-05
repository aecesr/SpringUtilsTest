package com.chl.springdemo.service;

import com.chl.springdemo.model.TencentSecret;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateResponse;


/**
 * @version 1.0
 * @Author caohl
 * @Date 2023/12/13 17:53
 * @注释
 */
public class Translate {
    public static String enToZh(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("en");
            req.setTarget("zh");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }
    public static String zhTo(String content,String country) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget(country);
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }

    public static String zhToEn(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("en");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }

    public static String zhToZhTw(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("zh-TW");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }


    public static String zhToJa(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("ja");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }


    public static String zhToKo(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("ko");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }


    public static String zhToFr(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("fr");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }



    public static String zhToEs(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("es");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }


    public static String zhToRu(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("ru");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }


    public static String zhToPt(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("pt");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }

    public static String zhToTh(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("th");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }

    public static String zhTo(String content) {
        try {
            String secretId = TencentSecret.SECRET_ID.getValue();
            String secretKey = TencentSecret.SECRET_KEY.getValue();
            Credential cred = new Credential(secretId, secretKey);
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("tmt.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            TmtClient client = new TmtClient(cred, "ap-shanghai", clientProfile);
            TextTranslateRequest req = new TextTranslateRequest();
            req.setSourceText(content);
            req.setSource("zh");
            req.setTarget("en");
            req.setProjectId(0L);
            TextTranslateResponse resp = client.TextTranslate(req);
            return resp.getTargetText();
        } catch (TencentCloudSDKException e) {
            return null;
        }
    }



}
