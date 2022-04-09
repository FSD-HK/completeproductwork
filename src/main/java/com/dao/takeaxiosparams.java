package com.dao;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class takeaxiosparams {
    public takeaxiosparams() {
    }
    public Map<String, Object> params(HttpServletRequest request, HttpServletResponse response) throws IOException { // 返回参数
        Map<String, Object> params = new HashMap<>();
        // 获取内容格式
        String contentType = request.getContentType();
        if (contentType != null && !contentType.equals("")) {
            contentType = contentType.split(";")[0];
        }
        if ("application/json".equalsIgnoreCase(contentType)) {
            // 使用 commons-io中 IOUtils 类快速获取输入流内容
            String paramJson = IOUtils.toString(request.getInputStream(), "UTF-8");
            Map parseObject = JSON.parseObject(paramJson, Map.class);
            params.putAll(parseObject);
        }
        return params;
    }
}
