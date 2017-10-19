package com.anlu.core.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
 
//import org.apache.commons.lang.StringEscapeUtils;
//import org.apache.commons.lang.StringUtils;
 
/**
 * @author xwchai
 *
 */
public class ScriptXssFilterWarp extends HttpServletRequestWrapper{

	public ScriptXssFilterWarp(HttpServletRequest request) {
        super(request);
    }
 public static void main(String[] args) {
	String a="opopo--";
	//System.out.println(StringEscapeUtils.escapeSql(a));
}
    /**对含有攻击字符进行替换
     * @author xwchai
     * @param name
     * @return
     */
    private String format(String value) {
//        return StringUtils.replaceEach(value,//
//                new String[]{"\"","'","<",">"},             //
//                new String[]{""","′","<",">"});
    	/*
    	 * 下面这些是英大信托的配置
    	
    	value=StringUtils.replace(value, "'","＇");//如果不写在escapeSql前面，则下面的escapeSql会把一个单引号变为两个，这种变法在sql里是可以的，但是页面的普通参数经过多次变换后，单引号越来越多
    	//value=StringEscapeUtils.escapeSql(value); //防止sql注入
    	//下面防止xss 没有用StringEscapeUtils.escapeHtml()和StringEscapeUtils.escapeJavaScript()是因为他们会把中文也给转了，这是不希望看到的。
    	value=StringUtils.replace(value, "--","——");
    	value=StringUtils.replace(value, "&","&amp;");
    	value=StringUtils.replace(value, "<","＜");
    	value=StringUtils.replace(value, "%3C","＜");//   
    	value=StringUtils.replace(value, "%3c","＜");//   
    	value=StringUtils.replace(value, ">","＞");
    	value=StringUtils.replace(value, "%3E","＞");// 
    	value=StringUtils.replace(value, "%3e","＞");//  
    	value=StringUtils.replace(value, "%3D","＝");// 
    	value=StringUtils.replace(value, "%3d","＝");// 
    	//value=StringUtils.replace(value, "/","／");//  /斜杠不能替换，否则有些参数是路径，就不能正确传递了
    	value=StringUtils.replace(value, "%27","＇");//  
    	value=StringUtils.replace(value, "%2F","／");//  /斜杠
    	value=StringUtils.replace(value, "%2f","／");//  /斜杠
    	value=StringUtils.replace(value, "%25","％");//百分号
    	value=StringUtils.replace(value, "%22","＂");//
    	//value=StringUtils.replace(value, "%","％");//通过？传中文的页面可能有%，这里就不应该过滤%了
    	value=StringUtils.replace(value, "#","＃");//u0023漏洞
    	value=StringUtils.replace(value, "\\u0023","＃");
    	value=StringUtils.replace(value, "\\U0023","＃");
    	//value=StringUtils.replace(value, "\"","＂");//双引号不能替换，否则放大镜会出错
    	//value=StringUtils.replace(value, "\\","＼");//转换反斜杠没有发现什么问题，但是不排除有些页面的参数带了转义，所以还是别转换了。
    	 */
    	 
 
        value=StringUtils.replace(value, "<","&lt;");
        value=StringUtils.replace(value, ">","&gt;");
        value=StringUtils.replace(value, "\\(","&#40;");// 英文左括号
        value=StringUtils.replace(value, "\\)","&#41;");//英文右括号
        value=StringUtils.replace(value, "'","&#x27");//单引号 有时候也用&#39;  不知道什么区别
        value=StringUtils.replace(value, "eval\\((.*)\\)","");//eval脚本
        value=StringUtils.replace(value, "[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",""); //js脚本
        value=StringUtils.replace(value, "\"","&quot");//双引号 
       // value = value.replaceAll("script", ""); 
    	
    	
        return  value;
    }
        /**
        *
        * @param name
        * @return
        */
       public Object getAttribute(String name) {
           Object value = super.getAttribute(name);
           if (value instanceof String) {
               value = format(String.valueOf(value));
           }
           return value;
       }
    
       /**
        * 重写getParameter方法
        *
        * @param name
        * @return
        */
       public String getParameter(String name) {
           String value = super.getParameter(name);
           if (value == null)
               return null;
           return format(value);
       }
       /**
       *
       * @param name
       * @return
       */
      public String[] getParameterValues(String name) {
          String[] values = super.getParameterValues(name);
          if (values != null) {
              for (int i = 0; i < values.length; i++) {
                  values[i] = format(values[i]);
              }
          }
          return values;
      }
      /**
       * @return
       */
      public Map<String,String[]> getParameterMap() {
   
          HashMap<String,String[]> paramMap = (HashMap<String,String[]>) super.getParameterMap();
          paramMap = (HashMap<String,String[]>) paramMap.clone();
   
          for (Iterator iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
              Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>) iterator.next();
              String [] values = entry.getValue();
              for (int i = 0; i < values.length; i++) {
                  if(values[i] instanceof String){
                      values[i] = format(values[i]);
                  }
              }
              entry.setValue(values);
          }
          return paramMap;
      }
      /** 
       * 覆盖getHeader方法，将参数名和参数值都做xss过滤。<br/> 
       * 如果需要获得原始的值，则通过super.getHeaders(name)来获取<br/> 
       * getHeaderNames 也可能需要覆盖 
       */  
       @Override  
       public String getHeader(String name) {  
     
           String value = super.getHeader(name);  
           if (value != null) {  
               value = format(value);  
           }  
           return value;  
       }  
     
 

}
