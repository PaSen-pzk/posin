function getDataBaseUrl() {
    return applicationUrlPath.adminDataUrlPath;
}

function getPageBaseUrl() {
    return applicationUrlPath.adminUiUrlPath;
}

function buildApiUrl(router) {
    return getDataBaseUrl().concat(router);
}
