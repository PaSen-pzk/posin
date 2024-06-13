<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章发布</title>
    <#include "../emglobal.ftl">
</head>
<style>
    #editor—wrapper {
        border: 1px solid #ccc;
        z-index: 100; /* 按需定义 */
    }
    #toolbar-container { border-bottom: 1px solid #ccc; }
    #editor-container { height: 500px; }
</style>
<body>
<link href="${UI_WEB_SERVICE}wangEditor/css/style.css" rel="stylesheet">

<script src="${UI_WEB_SERVICE}wangEditor/index.js"></script>

<div id="articleEditor" style="background-color: white;">
    <el-container>
        <el-header>
            <h2>文章发布</h2>
        </el-header>
        <el-main>
            <div style="padding: 20px;">
                <p>标题：</p>
                <el-input v-model="title" placeholder="请输入标题"></el-input>
                <p>正文：</p>
                <div id="editor—wrapper">
                    <div id="toolbar-container"><!-- 工具栏 --></div>
                    <div id="editor-container"><!-- 编辑器 --></div>
                    <el-input type="textarea" id="articleContent" style="display:none;"></el-input>
                </div>
                <p>标签（使用英文输入状态下的逗号进行分隔）：</p>
                <el-input v-model="label" placeholder="请输入标签"></el-input>
                <p>链接：</p>
                <el-input v-model="link" placeholder="请输入链接"></el-input>
            </div>
        </el-main>
        <el-footer>
            <el-button @click="saveDraft" type="primary">保存草稿</el-button>
            <el-button @click="publish" type="danger">发布</el-button>
        </el-footer>
    </el-container>
</div>
</body>
<script src="${UI_WEB_SERVICE}js/article/editor.js"></script>
<script>

    const { createEditor, createToolbar } = window.wangEditor;

    const editorConfig = {
        placeholder: 'Type here...',
        onChange(editor) {
            const html = editor.getHtml()
            console.log('editor content', html)
            // 也可以同步到 <textarea>
            document.getElementById("articleContent").value = html;
        }
    }

    const editor = createEditor({
        selector: '#editor-container',
        html: '<p><br></p>',
        config: editorConfig,
        mode: 'default', // or 'simple'
    })

    const toolbarConfig = {}

    const toolbar = createToolbar({
        editor,
        selector: '#toolbar-container',
        config: toolbarConfig,
        mode: 'default', // or 'simple'
    })
</script>
</html>
