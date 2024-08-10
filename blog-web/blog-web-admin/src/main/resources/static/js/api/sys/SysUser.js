/**
 * 查询登录用户信息
 * @param menuId
 * @returns {Promise<unknown>}
 */
function getLoginUser() {
    return Promise.resolve(
        axios.get(ADMIN_SERVER.MENU_CRUD.concat("/").concat(menuId))
    )
}
