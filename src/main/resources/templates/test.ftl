<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker模板引擎</title>
</head>
<body>
你是谁？<br>
<h3>${name}</h3>
<p>
    性别：
    <#if sex==0>
    女
    <#elseif sex==1>
    男
    <#else>
    保密
  </#if>
</p>


<h4>我的好友：</h4>
<#list list as item>
姓名：${item}
<br>
</#list>
</body>
</html>