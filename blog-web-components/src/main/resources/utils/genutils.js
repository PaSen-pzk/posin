window.eventUtil = (function () {
    // var _eventSet = {};
    _createEvent = function (type, data) {
        var customEvent;
        try {
            customEvent = new CustomEvent(type, { detail: data });
        } catch (e) {
            var CustomEvent = function (name, params) {
                if (params) {
                    params.bubbles = params.bubbles || false;
                    params.cancelable = params.cancelable || false;
                    params.detail = params.detail || undefined
                }
                params = params || { bubbles: false, cancelable: false, detail: undefined };
                var evt = document.createEvent("CustomEvent");
                evt.initCustomEvent(name, params.bubbles, params.cancelable, params.detail);
                return evt;

            };
            CustomEvent.prototype = window.Event.prototype;
            window.CustomEvent = CustomEvent;
            customEvent = new CustomEvent(type, { detail: data });
        }

        // _eventSet[type] = customEvent;
        return customEvent;
    };
    _addEventListener = function (type, callback) {
        window.addEventListener(type, callback);
    };
    _dispatchEvent = function (evt) {
        if (window.dispatchEvent) {
            window.dispatchEvent(evt);
        }
        else {
            window.fireEvent(evt);
        }
    };
    return {
        createEvent: _createEvent,
        addEventListener: _addEventListener,
        dispatchEvent: _dispatchEvent
    }
})();




function createUUID() {
    /**
     * @return {string}
     */
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }

    return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}

function WhereSqlGroup(uid, sqlLogicOperator, conditions, groups) {
    this.uid = uid;
    this.sqlLogicOperator = sqlLogicOperator;
    this.conditions = conditions;
    this.groups = groups;
}


function WhereSqlCondition(fieldName, sqlOperator, value, valueType, valueKind) {
    this.fieldName = fieldName;
    this.sqlOperator = sqlOperator;
    this.value = value;
    this.valueType = valueType;
    this.valueKind = valueKind;
}

function addDataValueConditionToGroup(handleType, value, panelField, whereSqlGroup) {
    // 处理where条件json
    var valueType;
    switch (panelField.fieldType) {
        case 0:
            valueType = 'double';
            break;
        case 1:
            valueType = 'string';
            break;
        case 2:
            valueType = 'date';
            break;
        case 3:
            valueType = 'boolean';
            break;
        default:
            valueType = 'string';
    }
    var operator = 'eq';
    // 处理值
    if (handleType === 'inputValue') {
        switch (panelField.inputParsingType) {
            case 1:
                operator = 'eq';
                break;
            case 2:
                operator = 'like';
                break;
        }
        value = panelField.inputValue;
        if (panelField.inputParsingType === 0) {
            operator = 'between';
            value = {};
            var param = {
                'valueKind' : 'dataValue',
                'valueType' : valueType,
                'fieldName' : panelField.dbFieldName,
                'value' : '',
            };
            value.firstParam = JSON.parse(JSON.stringify(param));
            value.secondParam = JSON.parse(JSON.stringify(param));
            value.firstParam.value = panelField.inputMinValue;
            value.secondParam.value = panelField.inputMaxValue;
        }
    }
    var optionToCondition = new WhereSqlCondition(panelField.dbFieldName, operator, value,
        valueType, 'dataValue');
    // 添加条件
    whereSqlGroup.conditions.push(optionToCondition);
}

function handleConditionParse(handleType, panelField, value, whereSqlGroups) {
    // 新建组
    var fieldToSqlGroup = new WhereSqlGroup(panelField.whereSqlGroupUid, 'OR',
        [], []);
    var flag = true;
    // 遍历已有条件JSON
    if (whereSqlGroups.length > 0) {
        for (var i = 0; i < whereSqlGroups.length; i++) {
            if (whereSqlGroups[i].uid === panelField.whereSqlGroupUid) {
                fieldToSqlGroup = whereSqlGroups[i];
                flag = false;
                break;
            }
        }
    }
    // 新增条件或sql片段
    switch (handleType) {
        case 'optionValue':
        case 'inputValue':
            addDataValueConditionToGroup(handleType, value, panelField, fieldToSqlGroup);
            break;
        case 'sqlFragment':
            break;
    }
    // 添加组
    if (flag) {
        whereSqlGroups.push(fieldToSqlGroup);
    }
}
