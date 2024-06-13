<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章管理</title>
    <#include "../emglobal.ftl">
    <style>
        .container-top {
            margin-left: 2%;
            padding-top: 50px;
            height: auto;
        }
    </style>
</head>
<body>
<div id="articleManage" style="background-color: white;">
    <el-container class="container-top">
        <el-header style="padding-top:5px;height: auto;">
            <el-row style="margin-top: 5px;height: 50px;">
                <el-col :span="24">
                    <div style="display: flex;flex-direction: row;align-items: center;">
                        <el-input placeholder="按标题模糊查找"  v-model="fuzzyFiltrValue" style="width: 30%;margin-right: 20px;">
                            <el-button slot="append" icon="el-icon-search iconfont iconinquire" @click="fuzzyFiltrClick" style="background-color: #0379fb;color: white;"></el-button>
                        </el-input>
                        <el-button style="margin-right: 10px;" type="primary" plain><i class="el-icon-s-data"></i>  数据分析</el-button>
                        <el-button style="margin-right: 10px;" type="primary" plain><i class="el-icon-s-promotion"></i>  业务移交</el-button>
                        <el-button style="margin-right: 10px;" type="primary" plain><i class="el-icon-s-grid"></i>  导出Excel</el-button>
                        <el-button style="margin-right: 10px;" type="primary" plain> <i class="el-icon-download"></i>  下载文件</el-button>
                    </div>
                </el-col>
            </el-row>
            <el-card style="margin-top: 5px;width: 100%;">
                <span class="tag-group__title" style="color:#409EFF;font-size: 14px;"><i class="el-icon-s-flag"></i>当前筛选条件</span>
                <el-tag class="filter-tag-item" v-for="tag in filters" :key="tag.key" closable :type="tag.type" @close="removeFilter(tag)"> {{tag.name}} </el-tag>
            </el-card>
        </el-header>
        <el-main>
            <el-table
                    :data="articleList"
                    border
                    style="width: 100%">
                <el-table-column
                        fixed
                        prop="date"
                        label="日期"
                        width="150">
                </el-table-column>
                <el-table-column
                        prop="name"
                        label="姓名"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="province"
                        label="省份"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="city"
                        label="市区"
                        width="120">
                </el-table-column>
                <el-table-column
                        prop="address"
                        label="地址"
                        width="300">
                </el-table-column>
                <el-table-column
                        prop="zip"
                        label="邮编"
                        width="120">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label="操作"
                        width="100">
                    <template slot-scope="scope">
                        <el-button @click="viewArticle(scope.row)" type="text" size="small">查看</el-button>
                        <el-button type="text" size="small">编辑</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>
        <el-footer>
            <el-pagination :total="page.total"
                           @current-change="getPage"
                           :page-size="page.size"
                           :current-page="page.current"
                           background layout="total,prev,pager,next"  align="center" style="margin-top: 10px;">

            </el-pagination>
        </el-footer>
    </el-container>
</div>
</body>
<script src="${UI_WEB_SERVICE}js/article/manage.js"></script>
</html>
