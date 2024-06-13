//请求拦截器
// 添加请求拦截器
axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    console.log("args:", config.data);
    //补充请求token信息
    let token = sessionStorage.getItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN)
    if(token) {
        config.headers.set(KEY_CONSTANTS.REQUEST_AUTH_HEADER, sessionStorage.getItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN))
    } else {
        //token信息不存在，跳转登录页
        sessionStorage.removeItem(KEY_CONSTANTS.STORAGE_AUTH_TOKEN);
        window.location.href = window.origin.concat(PAGE_DEFINE.SYS_LOGIN);
        history.pushState(null, null, window.location.href);
        return Promise.reject(config);
    }
    return config;
}, function (error) {
    // 对请求错误做些什么
    console.log("[RequestInterceptor Error]", error)
    return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    console.log(response);
    // 对响应数据做点什么
    return response;
}, function (error) {
    // 对响应错误做点什么
    console.log(error);
    return Promise.reject(error);
});
