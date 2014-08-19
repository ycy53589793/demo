package com.template.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.internal.util.xml.MappingReader;
import org.hibernate.internal.util.xml.OriginImpl;
import org.hibernate.internal.util.xml.XmlDocument;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import com.template.DynamicStatementDTDEntityResolver;
import com.template.service.DynamicHibernateStatementBuilder;

public class DynamicHibernateStatementBuilderImpl implements DynamicHibernateStatementBuilder, ResourceLoaderAware {

	private static final String ROOT_ELEMENT = "dynamic-hibernate-statement";
	
    private Map<String, String> namedHQLQueries;
    private Map<String, String> namedSQLQueries;
    private List<String> fileNames;
    private ResourceLoader resourceLoader;
    
    private EntityResolver entityResolver = new DynamicStatementDTDEntityResolver();
  
    /**
     * Description :初始化
     * @param resources
     * @throws IOException
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    @Override  
    public void init() throws IOException {  
        namedHQLQueries = new HashMap<String, String>();  
        namedSQLQueries = new HashMap<String, String>();  
        boolean flag = resourceLoader instanceof ResourcePatternResolver;  
        for (String file : fileNames) {  
            if (flag) {  
                Resource[] resources = ((ResourcePatternResolver) resourceLoader).getResources(file);  
                buildMap(resources);  
            } else {  
                Resource resource = resourceLoader.getResource(file);  
                buildMap(resource);  
            }  
        }  
    }  
  
    /**
     * Description :构建缓存
     * @param resources
     * @throws IOException
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    private void buildMap(Resource[] resources) throws IOException {  
        if (resources == null) {  
            return;  
        }  
        for (Resource resource : resources) {  
            buildMap(resource);  
        }  
    }  
  
    /**
     * Description :构建缓存
     * @param resource
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    @SuppressWarnings({ "rawtypes" })  
    private void buildMap(Resource resource) {  
        InputSource inputSource = null;  
        try {  
            inputSource = new InputSource(resource.getInputStream());  
            XmlDocument metadataXml = MappingReader.INSTANCE.readMappingDocument(entityResolver, inputSource, new OriginImpl("file", resource.getFilename()));  
            if (isDynamicStatementXml(metadataXml)) {  
                final Document doc = metadataXml.getDocumentTree();  
                final Element dynamicHibernateStatement = doc.getRootElement();  
                Iterator rootChildren = dynamicHibernateStatement.elementIterator();  
                while (rootChildren.hasNext()) {  
                    final Element element = (Element) rootChildren.next();  
                    final String elementName = element.getName();  
                    if ("sql-query".equals(elementName)) {  
                        putStatementToCacheMap(resource, element, namedSQLQueries);  
                    } else if ("hql-query".equals(elementName)) {  
                        putStatementToCacheMap(resource, element, namedHQLQueries);  
                    }  
                }  
            }  
        } catch (Exception e) {  
        	e.printStackTrace();
        } finally {  
            if (inputSource != null && inputSource.getByteStream() != null) {  
                try {  
                    inputSource.getByteStream().close();  
                } catch (IOException e) {  
                	e.printStackTrace(); 
                }  
            }  
        }  
    }  
  
    /**
     * Description :把模板sql hql缓存
     * @param resource
     * @param element
     * @param statementMap
     * @throws Exception
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    private void putStatementToCacheMap(Resource resource, final Element element, Map<String, String> statementMap) throws Exception {
    	//获取sql
        String sqlQueryName = element.attribute("name").getText();
        Validate.notEmpty(sqlQueryName);
        if(statementMap.containsKey(sqlQueryName)) {  
            throw new Exception("重复的sql-query/hql-query语句定义在文件:" + resource.getURI() + "中，必须保证name的唯一.");  
        }
        String queryText = element.getText();  
        statementMap.put(sqlQueryName, queryText);  
    }  
    
    /**
     * Description :判断是否模板xml
     * @param xmlDocument
     * @return
     * @Author: 杨聪艺
     * @Create Date: 2014-8-19
     */
    private static boolean isDynamicStatementXml(XmlDocument xmlDocument) {  
        return ROOT_ELEMENT.equals(xmlDocument.getDocumentTree().getRootElement().getName());  
    }
    
    public void setResourceLoader(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    } 
    public void setFileNames(List<String> fileNames) {  
        this.fileNames = fileNames;  
    }  
    public Map<String, String> getNamedHQLQueries() {  
        return namedHQLQueries;  
    }  
    public Map<String, String> getNamedSQLQueries() {  
        return namedSQLQueries;  
    }  

}
