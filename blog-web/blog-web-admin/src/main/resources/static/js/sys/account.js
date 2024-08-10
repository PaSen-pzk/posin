var vm=new Vue({
    el: "#profileInfo",
    data: {
        user: {

        }
    },
    created: function () {
        this.loadUser();
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        loadUser:function () {
            console.log("获取用户信息");
            let that = this;
            let storageInfo = sessionStorage.getItem(KEY_CONSTANTS.STORAGE_AUTH_USER);
            if(!storageInfo) {
                axios
                    .get(ADMIN_SERVER.LOGIN_USER)
                    .then(function (response) {
                        let res = response.data;
                        if(res.code && res.code == SERVICE_RESPONSE.SUCCESS.CODE){
                            that.user = res.data.adminUser;
                        }
                    })
                    .catch(function (error) {
                        console.log("获取用户信息失败", error);
                    });
            } else {
                let loginInfo = JSON.parse(storageInfo);
                that.user = loginInfo.adminUser;
                console.log(that.user)
            }
        }
    }
});
