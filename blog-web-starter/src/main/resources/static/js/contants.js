const SERVICE_RESPONSE = {
    /**
     * 成功
     */
    SUCCESS: {
        CODE: "000000",
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
        CODE:"NO_AUTHORITY",
        MESSAGE:"无权限"
    },
    /**
     * 业务异常
     */
    BUSSINESS_ERROR: {
        CODE:"2000",
        MESSAGE:"操作失败"
    },
    /**
     * API异常
     */
    INVOKE_ERROR: {
        CODE:"2100",
        MESSAGE:"服务不可用"
    }
}
const ADMIN_SERVER = {
    SYS_LOGIN: "login",
    SYS_LOGINOUT: "loginOut",
    MENU_TREE: "sys/menu/list/{0}",
    MENU_COMPLETE_TREE: "sys/menu/list/all",
    MENU_NODE_DELETE: "sys/menu/delete",
    MENU_NODE_ADD: "sys/menu/save",
    ARTICLE_DRAFT_SAVE: "sys/article/save"
}

const PAGE_DEFINE = {
    SYS_LOGIN: "/view/login_"
}

const KEY_CONSTANTS = {
    STORAGE_AUTH_TOKEN: "X-AUTH-TOKEN",
    REQUEST_AUTH_HEADER: "Authorization"
}
