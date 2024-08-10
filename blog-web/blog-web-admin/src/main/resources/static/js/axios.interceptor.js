if (typeof (axios) != "undefined") {
    /**全局默认配置 */
    axios.defaults.headers.post["Content-Type"] = "application/json; charset=UTF-8";
    /**全局拦截器默认加上accesstoken */
    axios.interceptors.request.use(
        function (config) {
            if(WHITE_LIST.includes(config.url)) {
                config.url = buildApiUrl(config.url);
                return config;
            }
            config.url = buildApiUrl(config.url);
            var token = getLocalAccessToken();
            if (token != null) {
                config.headers["Authorization"] = token;
            } else {
                console.log("认证失效");
                //清空session
                sessionStorage.removeItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN);
                //重定向到登录页
                window.location.replace(getPageBaseUrl().concat("login"));
            };
            if (/get/i.test(config.method)) {
                config.params = config.params || {};
                config.params.t = Date.parse(new Date()) / 1000;
            }
            return config;
        },
        function (error) {
            return Promise.error(error);
        }
    );
    axios.interceptors.response.use(
        function (response) {
            if (response.status === 200) {
                return Promise.resolve(response);
            } else if(response.status === 500205) {
                console.log("认证失效");
                //清空session
                sessionStorage.removeItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN);
                //重定向到登录页
                window.location.replace(getPageBaseUrl().concat("login"));
            } else {
                if (response.status.code === 403) {
                    alert("没有权限或者已下线！");
                } else if (response.status.code === 403) {
                    alert("未登录");
                }
                else {
                    alert(response.data.message || "服务端异常，请重试");
                }
                return Promise.reject(response);
            }
        },
        function (error) {
            let errorObj;
            console.log(error)
            return Promise.reject(error);
        }
    );
}
