<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统菜单管理</title>
    <#include "../emglobal.ftl">
</head>
<body>
<div id="menuManage">
    <el-container style="border: 1px solid #eee">
        <el-aside width="20%" style="background-color: rgb(238, 241, 246)">
            <el-tree style="padding: 20px;"
                     :data="menuTree"
<#--                     show-checkbox-->
                     node-key="id"
                     default-expand-all
                     :check-on-click-node="false"
<#--                     @node-click="menuNodeClick"-->
                     :expand-on-click-node="false">
              <span class="custom-tree-node" slot-scope="{ node, data }">
                <span>{{ node.label }}</span>
                <span v-if="data.status=='1'">
                  <el-button
                          type="text"
                          size="mini"
                          @click="() => addMenu(data)">
                    <i class="el-icon-circle-plus-outline"></i>
                  </el-button>
                  <el-button
                          type="text"
                          size="mini"
                          @click="() => editMenu(node, data)">
                    <i class="el-icon-edit"></i>
                  </el-button>
                </span>
              </span>
            </el-tree>
        </el-aside>
        <el-container style="background: #FFF">
            <el-header>
                <h3>编辑菜单</h3>
            </el-header>
            <el-main style="padding-right: 200px;">
                <el-form ref="menuForm" :rules="rules" :model="menuForm" label-width="80px">
                    <el-row>
                        <el-col :span="12" style="padding-right: 20px;">
                            <el-form-item label="上级菜单" prop="parentId">
                                <el-input v-model="menuForm.parentId" :disabled="true"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="菜单名称" prop="fullName">
                                <el-input v-model="menuForm.fullName" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12" style="padding-right: 20px;">
                            <el-form-item label="英文名称" prop="enCode">
                                <el-input v-model="menuForm.enCode" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="图标" prop="icon">
                                <el-input v-model="menuForm.icon" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12" style="padding-right: 20px;">
                            <el-form-item label="跳转地址" prop="urlAddress">
                                <el-input v-model="menuForm.urlAddress" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="角色" prop="role">
                                <template slot="label" slot-scope="scope">
                                    角色
                                    <el-tooltip class="item" effect="dark" content="角色默认可填 6" placement="top-start">
                                        <i class="el-icon-warning-outline"></i>
                                    </el-tooltip>
                                </template>
                                <el-input v-model="menuForm.role" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="12" style="padding-right: 20px;">
                            <el-form-item label="排序号" prop="order">
                                <el-input v-model="menuForm.order" :disabled="!editable"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="12">
                            <el-form-item label="启用" prop="status">
                                <el-switch v-model="menuForm.status" :disabled="!editable"></el-switch>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row style="align-content: center;" v-if="editable">
                        <el-form-item>
                            <el-button type="primary" @click="saveModule">保存</el-button>
                            <el-button @click="cancelEdit">取消</el-button>
                            <el-button type="danger" v-if="menuForm.id && menuForm.id != null" @click="deleteModule">删除</el-button>
                        </el-form-item>
                    </el-row>
                </el-form>
            </el-main>
        </el-container>
    </el-container>
</div>
</body>
<script src="${UI_WEB_SERVICE}js/sys/menuManage.js"></script>
<style>
    .el-tree-node__content {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        height: 36px;
        cursor: pointer;
    }
</style>
</html>
