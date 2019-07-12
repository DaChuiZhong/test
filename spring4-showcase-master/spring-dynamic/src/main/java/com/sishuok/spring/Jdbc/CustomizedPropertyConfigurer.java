package com.sishuok.spring.Jdbc;

import com.alibaba.fastjson.JSON;
import com.zuche.confcenter.bean.vo.ClientDataSource;
import com.zuche.confcenter.client.api.ConfCenterApi;
import com.zuche.confcenter.client.manager.DefaultConfigCenterManager;
import com.zuche.framework.common.GlobalMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description: 自定义配置文件加载类
 * @Author ZhangBei
 * @Date: 10:22 2017/8/19
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedPropertyConfigurer.class);

    private static Map<String,String> ctxPropMap=new HashMap();

    static {
        GlobalMessage.setProjectPath("/cspgen/");
    }
    private void initDySourceConfig(Properties props){
        DefaultConfigCenterManager instance = DefaultConfigCenterManager.getInstance();
        ConfCenterApi confCenterApi = instance.getConfCenterApi();
        Map<String, ClientDataSource> allDataSource = confCenterApi.getAllDataSource();
        ClientDataSource clientDataSource = allDataSource.get("sddladmin.cspgen.jndi.cspgen_jndi");
        String sourceValue = clientDataSource.getSourceValue();
        LOGGER.info("sourceValue=====>:" + sourceValue);
//        System.out.println("sourceValue========>"+sourceValue);
        Map<String, String> source = JSON.parseObject(sourceValue, Map.class);
        String url = source.get("url") + "&allowMultiQueries=true";
        source.put("url", url);
        String decryptPassword = DatabaseEncryption.decrypt(source.get("password"));
        source.put("password", decryptPassword);
        for (Object key : source.keySet()){
            props.put("jdbc." + key, source.get(key));
        }
    }
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        initDySourceConfig(props);
        super.processProperties(beanFactoryToProcess, props);
        for (Object key : props.keySet()){
            String keyStr = key.toString();
            String value = String.valueOf(props.get(keyStr));
            ctxPropMap.put(keyStr,value);
        }
    }

    public static String getCtxProp(String name) {
        return ctxPropMap.get(name);
    }

    public static Map<String, String> getCtxPropMap() {
        return ctxPropMap;
    }
}
