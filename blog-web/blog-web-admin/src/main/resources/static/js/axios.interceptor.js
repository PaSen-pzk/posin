if (typeof (axios) != "undefined") {
    /**全局默认配置 */
    axios.defaults.headers.post["Content-Type"] = "application/json; charset=UTF-8";
    /**全局拦截器默认加上accesstoken */
    axios.interceptors.request.use(
        function (config) {
            var token = getLocalAccessToken();
            if (token != null) {
                config.headers["Authorization"] = token;
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
            alert("服务端异常，请重试");
            return Promise.reject(error);
        }
    );
}
