/**
 * 查询菜单节点
 * @param menuId
 * @returns {Promise<unknown>}
 */
function getMenu(menuId) {
    return Promise.resolve(
        axios.get(ADMIN_SERVER.MENU_CRUD.concat("/").concat(menuId))
    )
}

/**
 * 新增菜单节点
 * @param form
 * @returns {Promise<unknown>}
 */
function addMenu(form) {
    return Promise.resolve(
        axios.post(ADMIN_SERVER.MENU_CRUD, form)
    )
}

/**
 * 删除菜单节点
 * @param menuId
 * @returns {Promise<unknown>}
 */
function delMenu(menuId) {
    return Promise.resolve(
        axios.delete(ADMIN_SERVER.MENU_CRUD.concat("/").concat(menuId))
    )
}
