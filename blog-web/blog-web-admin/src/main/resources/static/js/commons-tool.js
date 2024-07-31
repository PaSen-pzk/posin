function showSuccess(msg){
    Messenger().post({
        message: msg,
        type: 'success',
        showCloseButton: true
    });
}

function showErrorMessage(msg){
    Messenger().post({
        message: msg,
        type: 'error',
        showCloseButton: false
    });
}

/**
 * 获取一个雪花算法的id
 */
function getSnowId() {
    return getSnowIdByQueue();
}
/**
 * 获取主键
 */
var snowIdStore = new SnowIdStore();
function getSnowIdByQueue() {
    return snowIdStore.getSnowId();
}
/**
 * 雪花Id,依据队列实现，容器默认存储20个主键,如果没有了会从后台再次获取20个
 */
function SnowIdStore() {
    let snowIdStore = new Queue();
    let storeMaxSize = 20;
    this.getSnowId = function () {
        /**空的时候初始化 */
        if (snowIdStore.isEmpty()) {
            this.initSnowStore();
        }
        return snowIdStore.dequeue();
    }
    this.initSnowStore = function () {
        let url = applicationUrlPath.dataresUrlPath + 'data/common/snowidstr/batch/' + storeMaxSize;
        $.ajax({
            url: url,
            method: 'GET',
            beforeSend: function (XMLHttpRequest) {
                let accessToken = getLocalAccessToken();
                XMLHttpRequest.setRequestHeader("Authorization", accessToken);
            },
            async: false,
            contentType: 'application/json; charset=UTF-8',
            success: function (response) {
                for (let index = 0; index < response.model.length; index++) {
                    snowIdStore.enqueue(response.model[index]);
                }
            }
        });
    }
}
