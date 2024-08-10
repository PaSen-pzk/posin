var vm = new Vue({
    el: "#adminApp",
    data: {
        loginUser:{},
        menuTree: [],
        //导航信息
        navigation: {
            id: null,
            name: null,
            title: null,
            forwardPath: null
        }
    },
    created: function () {
        this.initMenu();
    },
    watch:{
    },
    methods: {
        //初始化数据
        initMenu: function () {
            let that = this;
            //加载菜单
            that.loadMenuTree();
            //获取登录用户信息
            that.obtainLoginUserInfo();
        },
        //获取登录用户信息
        obtainLoginUserInfo:function () {
            console.log("获取用户信息");
            let that = this;
            axios
                .get(ADMIN_SERVER.LOGIN_USER)
                .then(function (response) {
                    let res = response.data;
                    if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        that.loginUser = res.data.adminUser;
                        sessionStorage.setItem(KEY_CONSTANTS.STORAGE_AUTH_USER, JSON.stringify(res.data));
                    }
                })
                .catch(function (error) {
                    console.log("获取用户信息失败", error);
                });
        },
        //初始化数据
        loadMenuTree:function(){
            console.log("首页初始化菜单");
            let that = this;
            axios
                .get(ADMIN_SERVER.MENU_TREE)
                .then(function (response) {
                    let res = response.data;
                    if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        that.menuTree = res.data;
                        if(that.menuTree.length > 0) {
                            let menuEle = that.menuTree[0];
                            if(menuEle.menuType === 'C') {
                                that.loadNavigation(menuEle);
                            } else {
                                if(menuEle.childs && menuEle.childs.length > 0) {
                                    that.loadNavigation(menuEle.childs[0]);
                                }
                            }
                        }
                        console.log("菜单加载完成");
                        console.log(that.menus);
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        loadNavigation:function(menu) {
            let that = this;
            that.navigation.id = menu.menuId;
            that.navigation.name = menu.menuName;
            that.navigation.title = menu.navTitle;
            that.navigation.forwardPath = getPageBaseUrl().concat(menu.path);
            // let iframe = document.getElementById("sub-iframe");
            // iframe.src = that.navigation.forwardPath;
        },
        goMyAccount: function () {
            let that = this;
            that.navigation.forwardPath = getPageBaseUrl().concat(PAGE_DEFINE.LOGIN_ACCOUNT);
        },
        //退出登录
        logout:function () {
            //清空session
            sessionStorage.removeItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN);
            //重定向到登录页
            window.location.replace(getPageBaseUrl().concat("login"));
        }
    }
});
