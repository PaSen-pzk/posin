<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<h1>1.取值</h1>
<h2>1.1. 提供默认值</h2>
<#--报错-->
<#--${uname}    -->
<#--不报错，但是页面无内容-->
<#--${uname !}-->
<#--给值设置一个默认值-->
${uname! '无名'}

<h2>1.2. 对null值先进行判断</h2>
<p>1）exists用在逻辑判断；</p>
<#if uname?exists>
    ${uname}
</#if>
<br>
<p>2）??是判断对象是否为空</p>
<#if uname??>
    ${uname}
</#if>
<br>
<p>3）if_exists用来打印东西</p>
${uname?if_exists}
<br>

<h1>2.条件</h1>
<#if sex=='nv'>
    女
<#elseif sex='nan'>
    男
<#else>
    未知
</#if>
<br>

<h1>3.循环</h1>
<p>1）取出数组中的元素</p>
<#list arr as a>
    ${a}==
</#list>
<br>
<p>2）取出集合中的对象（注：访问的类要被public所修饰）</p>
<#list lst as item>
    ${item.id} : ${item.name}    <br>
</#list>

<h1>4 include</h1>
<#include "common.ftl" >

<h2>5 局部变量(assign)/全局变量(global)</h2>
${ctx}：${ctx2}
</body>
</html>
