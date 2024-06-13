function createUUID() {
    /**
     * @return {string}
     */
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }

    return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}


//AJAX 请求
//url:请求地址 data:请求数据 type:请求类型 默认get  bolasync:false同步,true 异步 CallbackFunction 回调函数
function AjaxInvk(url, data, type, CallbackFunction, bolasync, contentType) {
    var resData;
    var access_token = getLocalAccessToken();
    type = type ? type : "get";
    bolasync = bolasync == undefined ||  bolasync == null ? "true" :  bolasync;
    contentType = contentType ? contentType : "application/json; charset=UTF-8";
    if (typeof (CallbackFunction) == undefined || CallbackFunction == null) {
        var showdata;
        $.ajax({
            async: bolasync,
            dataType: "json",
            type: type,
            url: url,
            processData: false,
            data: data,
            contentType: contentType,
            beforeSend: function (request) {
                request.setRequestHeader("Authorization", getLocalAccessToken());
            },
            success: function (res) {
                resData = res;
            },
            error: function (err) {
                resData = err;
            }
        });
        return resData;
    }
    else {
        $.ajax({
            type: type,
            dataType: "json",
            async: bolasync,
            url: url,
            processData: false,
            data: data,
            contentType: contentType,
            beforeSend: function (request) {
                request.setRequestHeader("Authorization", access_token);
            },
            success: CallbackFunction
        });
    }
}

function getQueryString(name) {
    const reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    const r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
/**
 * 日期格式化
 * @param {}} fmt
 */
Date.prototype.format = function (fmt) {
    const o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (let k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};
function formatMoneyData(val) {
    if (val == null || val === '') {
        return "0";
    }

    val = (val).toString();
    let arr = [];

    if (val.indexOf('.') !== -1) {
        if (val[val.length - 1] === '.') {
            val = val.substring(0, val.length - 1);
        } else {
            arr = val.split(".");

            if (arr.length === 2) {
                val = arr[0];
            }
        }
    }

    for (let i = 0; i < Math.floor((val.length - (1 + i)) / 3); i++) {
        val = val.substring(0, val.length - (4 * i + 3)) + ',' + val.substring(val.length - (4 * i + 3));
    }

    if (arr.length === 2) {
        val = val + "." + arr[1];
    }

    return val;
}

function createUUID() { // 获取唯一值
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        var r = Math.random() * 16 | 0, v = c === 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

function numberToUpper(money) {
    if (money === null || money === '') {
        return "零";
    }

    var cnNums = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"]; //汉字的数字
    var cnIntRadice = ["", "拾", "佰", "仟"]; //基本单位
    var cnIntUnits = ["", "万", "亿", "兆"]; //对应整数部分扩展单位
    var cnDecUnits = ["角", "分", "毫", "厘"]; //对应小数部分单位
    var cnInteger = "整"; //整数金额时后面跟的字符
    var cnIntLast = "元"; //整型完以后的单位
    var maxNum = 999999999999999.9999; //最大处理的数字
    var IntegerNum; //金额整数部分
    var DecimalNum; //金额小数部分
    var ChineseStr = ""; //输出的中文金额字符串
    var parts; //分离金额后用的数组，预定义
    if (money === "") {
        return "";
    }
    money = parseFloat(money);
    if (money >= maxNum) {
        alert('超出最大处理数字');
        return "";
    }
    if (money === 0) {
        ChineseStr = cnNums[0] + cnIntLast + cnInteger;
        return ChineseStr;
    }
    money = money.toString(); //转换为字符串
    if (money.indexOf(".") === -1) {
        IntegerNum = money;
        DecimalNum = '';
    } else {
        parts = money.split(".");
        IntegerNum = parts[0];
        DecimalNum = parts[1].substr(0, 4);
    }
    if (parseInt(IntegerNum, 10) > 0) { //获取整型部分转换
        var zeroCount = 0;
        var IntLen = IntegerNum.length;
        for (var i = 0; i < IntLen; i++) {
            var n = IntegerNum.substr(i, 1);
            var p = IntLen - i - 1;
            var q = p / 4;
            var m = p % 4;
            if (n === "0") {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    ChineseStr += cnNums[0];
                }
                zeroCount = 0; //归零
                ChineseStr += cnNums[parseInt(n)] + cnIntRadice[m];
            }
            if (m === 0 && zeroCount < 4) {
                ChineseStr += cnIntUnits[q];
            }
        }
        ChineseStr += cnIntLast;
        //整型部分处理完毕
    }
    if (DecimalNum !== '') { //小数部分
        var decLen = DecimalNum.length;
        for (var i = 0; i < decLen; i++) {
            var n = DecimalNum.substr(i, 1);
            if (n !== '0') {
                ChineseStr += cnNums[Number(n)] + cnDecUnits[i];
            }
        }
    }
    if (ChineseStr === '') {
        ChineseStr += cnNums[0] + cnIntLast + cnInteger;
    } else if (DecimalNum === '') {
        ChineseStr += cnInteger;
    }
    return ChineseStr;
}

//获取当前页面url参数值  name:参数名称
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    var context = "";
    if (r != null) context = r[2];
    return context;
}
String.prototype.trimEnd = function (char) {
    return this.replace(/(^\s*)|(\s*$)/g, char);
}

/**
 * 字符串-占位符替换
 * 使用方法：
 *  "js修改原生String实现用自符串替换占位符{0} {1} {2}格式化数据".format("hello", "world", "welcome")
 */
String.prototype.format = function () {
    // 数据长度为空，则直接返回
    if (arguments.length == 0){
        return this;
    }

    // 使用正则表达式，循环替换占位符数据
    for (var result = this, i = 0; i < arguments.length; i++){
        result = result.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
    }
    return result;
};

Array.prototype.findItem = function (filter) {
    let res = null;
    if (this) {
        for (let index = 0; index < this.length; index++) {
            const element = this[index];
            if (filter(element)) {
                res = element;
                break;
            }
        }
    }
    return res;
}
//千分位
function number_format(number, decimals, dec_point, thousands_sep) {
    /*
     * 参数说明：
     * number：要格式化的数字
     * decimals：保留几位小数
     * dec_point：小数点符号
     * thousands_sep：千分位符号
     * */
    number = (number + '').replace(/[^0-9+-Ee.]/g, '');
    let n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 2 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            let k = Math.pow(10, prec);
            return '' + Math.ceil(n * k) / k;
        };

    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    let re = /(-?\d+)(\d{3})/;
    while (re.test(s[0])) {
        s[0] = s[0].replace(re, "$1" + sep + "$2");
    }

    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
}
Date.prototype.format = function (fmt) {
    const o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (let k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};
//element弹出窗封装 zgq add 20200912
function notifyMsg(message, type, dura, app) {
    type = type ? type : 'info';
    var duration;
    if (dura) {
        duration = dura;
    } else {
        duration = type == 'info' || type == 'success' ? 1500 : 3000;
    }
    let vueApp = app || vm;
    vueApp.$notify({ title: "提醒", message: message, type: type, duration: duration, offset: 100 })
}
/**
 * 获取AccessToken，存储在sessionStorage
 */
function getLocalAccessToken() {
    return window.sessionStorage.getItem("X-AUTH-TOKEN");
}
/**
 * 数据增加foreach
 */
if (!Array.prototype.forEach) {
    Array.prototype.forEach = function forEach(callback, thisArg) {
        var T, k;
        if (this == null) {
            throw new TypeError("this is null or not defined");
        }
        var O = Object(this);
        var len = O.length >>> 0;
        if (typeof callback !== "function") {
            throw new TypeError(callback + " is not a function");
        }
        if (arguments.length > 1) {
            T = thisArg;
        }
        k = 0;
        while (k < len) {
            var kValue;
            if (k in O) {
                kValue = O[k];
                callback.call(T, kValue, k, O);
            }
            k++;
        }
    }
};
/**
 * （废弃，后续请使用isInArray）
 * @param {*} attrName
 * @param {*} attrVal
 */
Array.prototype.isInarray = function (attrName, attrVal) {
    var res = false;
    for (var i = 0; i < this.length; i++) {
        if (this[i][attrName] == attrVal) {
            res = true;
            break;
        }
    }
    return res;
}
Array.prototype.isInArray = function (val, attrName) {
    var res = false;
    for (var i = 0; i < this.length; i++) {
        if (attrName) {
            if (this[i][attrName] == val) {
                res = true;
                break;
            }
        }
        else {
            if (this[i] == val) {
                res = true;
                break;
            }
        }
    }
    return res;
}
/**
 * 队列实现
 * @author zz
 */
function Queue() {
    let items = [];
    /**
     * 入队
     * @param {} ele
     *
     */
    this.enqueue = function (ele) {
        items.push(ele);
    }
    /**
     * 出队
     */
    this.dequeue = function () {
        return items.shift();
    }
    /**
     * 首队
     */
    this.front = function () {
        return items[0];
    }
    /**
     * 队列长度
     */
    this.size = function () {
        return items.length;
    }
    /**
     * 是否空队列
     */
    this.isEmpty = function () {
        return items.length === 0;
    }
}

//xgjadd 20210124
function showloading() {
    var cover = document.getElementById('cover');
    cover.style.display = 'block';
}
function unloading() {
    var cover = document.getElementById('cover');
    cover.style.display = 'none';
}
/**
 * 获取文件后缀名
 * @param {String} fileName 文件名
 */
function getFileExtension(fileName) {
    return fileName.substring(fileName.lastIndexOf('.'), fileName.length);
}
/**
 * 获取文件名（不包含后缀名）
 * @param {String} fileName
 */
function getFileNameWithNoExtension(fileName) {
    return fileName.substring(0, fileName.lastIndexOf('.'));
}
/**
 * 获取cookie
 * @param {String} name
 */
function getCookie(name) {
    let cname = name + "=";
    let ca = document.cookie.split(";");
    for (let index = 0; index < ca.length; index++) {
        const element = ca[index].trim();
        if (element.indexOf(name) == 0) {
            return c.substring(cname.length, element.length);
        }
    }
    return null;
}
/**
 * 删除cookie
 * @param {String} name
 */
function delCookie(name) {
    let exp = new Date();
    exp.setTime(exp.getTime() - 1);
    let cval = getCookie(name);
    if (cval != null) {
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }
}
