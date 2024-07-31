var vm=new Vue({
    el: "#menuManage",
    data: {
        options: [{
            value: '0',
            label: '正常'
        }, {
            value: '1',
            label: '停用'
        }],
        // 遮罩层
        loading: true,
        // 显示搜索条件
        showSearch: true,
        // 菜单表格树数据
        menuList: [],
        // 菜单树选项
        menuOptions: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 是否展开，默认全部折叠
        isExpandAll: false,
        // 重新渲染表格状态
        refreshTable: true,
        // 查询参数
        queryParams: {
            menuName: undefined,
            status: '0'
        },
        // 表单参数
        form: {

        },
        // 表单校验
        rules: {
            menuName: [
                { required: true, message: "菜单名称不能为空", trigger: "blur" }
            ],
            orderNum: [
                { required: true, message: "菜单顺序不能为空", trigger: "blur" }
            ],
            path: [
                { required: true, message: "路由地址不能为空", trigger: "blur" }
            ]
        }
    },
    created: function () {
        this.loadMenuTree();
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        parseTime:function (time) {
          parseTime(time);
        },
        // 选择图标
        selected:function(name) {
            this.form.icon = name;
        },
        //初始化数据
        loadMenuTree:function(){
            let that = this;
            AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.MENU_MANAGE_LIST + "?" + objectToGetParams(that.queryParams),"","get",function (res) {
                if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                    if(res.data.length > 0) {
                        that.menuList = handleTree(res.data, "menuId");
                    }
                    // that.menuList = handleTree(that.mockMenu, "menuId");
                    that.loading = false;
                }
            });
        },
        /** 转换菜单数据结构 */
        normalizer:function(node) {
            if (node.children && !node.children.length) {
                delete node.children;
            }
            return {
                id: node.menuId,
                label: node.menuName,
                children: node.children
            };
        },
        /** 查询菜单下拉树结构 */
        getTreeselect:function() {
            // listMenu().then(response => {
            //     this.menuOptions = [];
            //     const menu = { menuId: 0, menuName: '主类目', children: [] };
            //     menu.children = this.handleTree(response.data, "menuId");
            //     this.menuOptions.push(menu);
            // });
        },
        // 取消按钮
        cancel:function() {
            this.open = false;
            this.reset();
        },
        // 表单重置
        reset:function() {
            this.form = {
                menuId: undefined,
                parentId: 0,
                menuName: undefined,
                icon: undefined,
                menuType: "M",
                orderNum: undefined,
                isFrame: "1",
                isCache: "0",
                visible: "0",
                status: "0"
            };
            this.resetForm("menuForm");
        },
         resetForm:function(refName) {
            if (this.$refs[refName]) {
                this.$refs[refName].resetFields();
            }
        },
        /** 搜索按钮操作 */
        handleQuery:function() {
            this.loadMenuTree();
        },
        /** 重置按钮操作 */
        resetQuery:function() {
            this.resetForm("queryForm");
            this.handleQuery();
        },
        /** 新增按钮操作 */
        handleAdd:function(row) {
            this.reset();
            this.getTreeselect();
            if (row != null && row.menuId) {
                this.form.parentId = row.menuId;
            } else {
                this.form.parentId = 0;
            }
            this.open = true;
            this.title = "添加菜单";
        },
        /** 展开/折叠操作 */
        toggleExpandAll:function() {
            this.refreshTable = false;
            this.isExpandAll = !this.isExpandAll;
            this.$nextTick(() => {
                this.refreshTable = true;
            });
        },
        /** 修改按钮操作 */
        handleUpdate:function(row) {
            this.reset();
            this.getTreeselect();
            // getMenu(row.menuId).then(response => {
            //     this.form = response.data;
            //     this.open = true;
            //     this.title = "修改菜单";
            // });
        },
        /** 提交按钮 */
        submitForm:function() {
            let that = this;
            that.$refs["menuForm"].validate(valid => {
                if (valid) {
                    if (that.form.menuId != undefined) {

                        // updateMenu(this.form).then(response => {
                        //     this.$modal.msgSuccess("修改成功");
                        //     this.open = false;
                        //     this.getList();
                        // });
                    } else {
                        AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.MENU_NODE_ADD,JSON.stringify(that.form),"post",function (res) {
                            console.log("保存菜單", JSON.stringify(res));
                            if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                                that.open = false;
                                that.loadMenuTree();
                            }
                        });
                        // addMenu(this.form).then(response => {
                        //     this.$modal.msgSuccess("新增成功");
                        //     this.open = false;
                        //     this.getList();
                        // });
                    }
                }
            });
        },
        /** 删除按钮操作 */
        handleDelete:function(row) {
            let that  = this;
            this.$confirm('是否确认删除名称为"' + row.menuName + '"的数据项？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(function() {
                return that.deleteModule(row.menuId);
            }).then(() => {
                that.loadMenuTree();
                that.$message({
                    type: 'success',
                    message: '删除成功!'
                });
            }).catch(() => {});
        },
        addMenu(node) {
            console.log("--添加菜单节点--");
            console.log(node);
            let that = this;
            that.initMenuForm();
            that.editable = true;
            that.menuForm.parentId = node.parentId;

        },
        editMenu(node, data) {
            console.log("--编辑菜单节点--");
            console.log(node.parent);
            console.log(data);
            let that = this;
            that.initMenuForm();
            that.editable = true;
            that.menuNodeClick(data);
            // const parent = node.parent;
            // const children = parent.data.children || parent.data;
            // const index = children.findIndex(d => d.id === data.id);
            // children.splice(index, 1);
        },
        saveModule() {
            console.log("--保存菜单节点--");
            let that = this;
            console.log(that.menuForm);
            that.$refs['menuForm'].validate((valid) => {
                if (valid) {
                    AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.MENU_NODE_ADD,that.menuForm,"post",function (res) {
                        if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                            console.log(res);
                            this.$message({
                                type: 'success',
                                message: '保存成功!'
                            });
                        }
                    });
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        cancelEdit() {
            let that = this;
            if(!that.menuForm.id) {
                that.initMenuForm();
            }
            that.editable = false;
        },
        initMenuForm() {
            let that = this;
            that.menuForm = {
                parentId: null,
                fullName: null,
                enCode: null,
                icon: null,
                urlAddress: null,
                role: null,
                order: null,
                status: null
            }
        },
        deleteModule(data) {
            let that = this;
            console.log(data);
            this.$confirm('此操作将永久删除该项, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.MENU_NODE_DELETE + "?id=" + data.id,"","get",function (res) {
                    if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        console.log(res);
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }
                });
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '删除失败，请稍后重试！'
                });
            });
        },
        menuNodeClick(data) {
            console.log(data);
            let that = this;
            that.menuForm.parentId = data.parentId;
            that.menuForm.fullName = data.label;
            that.menuForm.enCode = data.enCode;
            that.menuForm.icon = data.icon;
            that.menuForm.urlAddress = data.urlAddress;
            that.menuForm.role = data.role;
            that.menuForm.order = data.order;
            that.menuForm.status = data.status;
        }
    }
});
