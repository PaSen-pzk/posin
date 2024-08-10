const SERVICE_RESPONSE = {
    /**
     * 成功
     */
    SUCCESS: {
        // CODE: "000000",
        CODE: "200",
        MESSAGE: "成功"
    },
    /**
     * 认证失败
     */
    AUTHORIZATION_ERROR: {
        CODE:"500205",
        MESSAGE:"认证失败"
    },
    /**
     * 无权限
     */
    NO_AUTHORITY: {
        CODE:"503",
        MESSAGE:"无权限"
    },
    /**
     * 业务异常
     */
    BUSSINESS_ERROR: {
        CODE:"500",
        MESSAGE:"操作失败"
    },
    /**
     * API异常
     */
    INVOKE_ERROR: {
        CODE:"404",
        MESSAGE:"服务不可用"
    }
}

/**
 * url 白名单
 * @type {*[]}
 */
const WHITE_LIST = [
    "/login",
    "/logout",
    "/register"
]

/**
 * ADMIN api 前缀
 * @type {{MENU_CURD: string}}
 */
const ADMIN_API_PREFIX = {
    //用户
    USER_CRUD: "sys/user",
    //菜单
    MENU_CURD: "sys/menu",
    //文章
    ARTICLE_CURD: "sys/article",
}

/**
 * API 后缀
 * @type {{SYS_LOGOUT: string, MENU_TREE: string, SYS_LOGIN: string, MENU_MANAGE_LIST: string, ARTICLE_DRAFT_SAVE: string, MENU_COMPLETE_TREE: string}}
 */
const ADMIN_SERVER = {
    //登录
    SYS_LOGIN: "/login",
    SYS_LOGOUT: "/loginOut",
    //用户
    LOGIN_USER: ADMIN_API_PREFIX.USER_CRUD.concat("/getUserInfo"),
    //菜单
    MENU_CRUD: ADMIN_API_PREFIX.MENU_CURD,
    MENU_MANAGE_LIST: ADMIN_API_PREFIX.MENU_CURD.concat("/list"),
    MENU_TREE: ADMIN_API_PREFIX.MENU_CURD.concat("/getRouters"),
    MENU_COMPLETE_TREE: ADMIN_API_PREFIX.MENU_CURD.concat("/treeselect"),
    //文章
    ARTICLE_SAVE: ADMIN_API_PREFIX.ARTICLE_CURD
}

const PAGE_DEFINE = {
    SYS_LOGIN: "/login",
    LOGIN_ACCOUNT: "/sys/user/account"
}

const KEY_CONSTANTS = {
    STORAGE_AUTH_USER: "X-AUTH-USER",
    STORAGE_AUTH_TOKEN: "X-AUTH-TOKEN",
    REQUEST_AUTH_HEADER: "Authorization"
}

const applicationUrlPath = {
    adminDataUrlPath: 'http://blog.posin.com:9000/blog-admin-service/',
    adminUiUrlPath: 'http://blog.posin.com:9000/ui-web-admin-view/',
}
