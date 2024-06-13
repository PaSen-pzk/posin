var vm=new Vue({
    el: "#portal",
    data: {
        menus: [],
        isCollapse: true,
        isPauseTtsAudio: false,
        audioUrl: ""
    },
    created: function () {
        this.loadMenu();
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        //初始化数据
        loadMenu:function(){
            console.log("首页初始化菜单");
            let that = this;
            axios
                .get(ADMIN_API_SERVICE.concat(ADMIN_SERVER.MENU_TREE).format(role))
                .then(function (response) {
                    let res = response.data;
                    if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        that.menus = res.data;
                        that.menus.forEach((data, i) => {
                            if(typeof(data.role)=="undefined") {
                                data.role=0; /*默认值*/
                            }
                        })
                        console.log("菜单加载完成");
                        console.log(that.menus);
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        jsonWhere: function (data, action) {
            if (action == null) return;
            var reval = new Array();
            $(data).each(function (i, v) {
                if (action(v)) {
                    reval.push(v);
                }
            })
            return reval;
        },
        logout: function () {
            axios
                .get(ADMIN_API_SERVICE.concat(ADMIN_SERVER.SYS_LOGINOUT))
                .then(function (response) {
                    let res = response.data;
                    if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                        console.log("退出成功");
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
            sessionStorage.removeItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN);
            window.location.href = window.origin.concat(PAGE_DEFINE.SYS_LOGIN);
            history.pushState(null, null, window.location.href);
        }
    }
});
