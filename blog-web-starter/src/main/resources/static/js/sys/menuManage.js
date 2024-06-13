var vm=new Vue({
    el: "#menuManage",
    data: {
        editable: false,
        menuForm: {
            id: null,
            parentId: null,
            fullName: null,
            enCode: null,
            icon: null,
            urlAddress: null,
            role: null,
            order: null,
            status: null
        },
        rules: {
            fullName: [
                {required: true, message: '请输入菜单名称', trigger: 'blur'},
                {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
            ],
            enCode: [
                {required: true, message: '请输入英文名称', trigger: 'blur'},
            ],
            icon: [
                {required: true, message: '请选择图标', trigger: 'blur'},
            ],
            // urlAddress: [
            //     {required: true, message: '请输入跳转地址', trigger: 'blur'},
            // ],
            role: [
                {required: true, message: '请输入角色编号', trigger: 'blur'},
            ],
            order: [
                {required: true, message: '请输入排序号', trigger: 'blur'},
            ]
        },
        menuTree: [
            {
            id: 1,
            label: '一级 1',
            children: [{
                id: 4,
                label: '二级 1-1',
                children: [{
                    id: 9,
                    label: '三级 1-1-1'
                }, {
                    id: 10,
                    label: '三级 1-1-2'
                }]
            }]
        },
            {
            id: 2,
            label: '一级 2',
            children: [{
                id: 5,
                label: '二级 2-1'
            }, {
                id: 6,
                label: '二级 2-2'
            }]
        },
            {
            id: 3,
            label: '一级 3',
            children: [{
                id: 7,
                label: '二级 3-1'
            }, {
                id: 8,
                label: '二级 3-2'
            }]
        }
        ],
    },
    created: function () {
        this.loadMenuTree();
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        //初始化数据
        loadMenuTree:function(){
            let that = this;
            AjaxInvk(ADMIN_API_SERVICE + ADMIN_SERVER.MENU_COMPLETE_TREE + "/" + role,"","get",function (res) {
                if(res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                    console.log(res);
                    that.menuTree = res.data;
                }
            });
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
