Vue.component('right-toolbar', {
    template: '#rightToolbar',
    props: ['showSearch','columns','search','showColumnsType','gutter'],
    data:function(){
        return {
            page: {
                currentPage: 1,
                pageSize: 10,
                total: 0
            },
            clauseListData: [],
            clauseCategoryData: [{
                label: '1级 1',
                children: [{
                    label: '2级 1-1',
                    children: [{
                        label: '3级 1-1-1',
                    }]
                }]
            }],
            defaultProps: {
                children: 'children',
                label: 'categoryName'
            },
            filterCategoryId: null,
        }
    },
    methods: {
        handleNodeClick: function(data){
            console.log(data);
            this.filterCategoryId = data.categoryId;
            this.getSelectClauseList();
        },
        afterOpen:function(){
            this.filterCategoryId=null;
            this.page.currentPage = 1;
            this.getClauseCategoryTree();
        },
        getClauseCategoryTree: function(){
            var that = this;
            var url =  "clauseCategory/tree/"+that.priorsysmoduleid
            AjaxInvk(url,null, "get", function (res) {
                if(res.code == "00"){
                    that.clauseCategoryData = res.data.data;
                }else{
                    notifyMsg(res.message,'error');
                }
            });
        },
        selectModeFilterClick:function(){
            this.page.currentPage = 1;
            this.getSelectClauseList();
        },
        //获取模块数据
        getSelectClauseList:function(){
            var that = this;
            var param = {
                categoryId:this.filterCategoryId,
                current:this.page.currentPage,
                size:this.page.pageSize
            };
            AjaxInvk("clauseManage/pagelist?",JSON.stringify(param), "post", function (res) {
                if(res.code == "00"){
                    that.clauseListData = res.data.page.records;
                    that.page = res.data.page;
                }else{
                    notifyMsg(res.message,'error');
                }
            })
        },
        getPageData:function (current) {
            this.page.currentPage = current;
            this.getSelectClauseList();
        },
        selectClauseOk:function (rows) {
            //var srows = this.$refs.selectClauseTable.selection;
            vm.selectClauseOk(rows);
        },
        selectClauseClose:function () {
            vm.selectClauseClose();
        },
        handleSelect:function (selection,row) {
            if(this.single) {
                this.$refs.selectClauseTable.clearSelection();
                this.$refs.selectClauseTable.toggleRowSelection(row);
            }
        },
        handleSelectAll:function (selection) {
            if(this.single) {
                this.$refs.selectClauseTable.clearSelection();
                this.$refs.selectClauseTable.toggleRowSelection(selection.shift());
            }
        }
    }
});
