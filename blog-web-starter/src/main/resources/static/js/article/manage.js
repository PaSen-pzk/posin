var vm=new Vue({
    el: "#articleManage",
    data: {
        articleList:[{
            date: '2016-05-02',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1518 弄',
            zip: 200333
        }, {
            date: '2016-05-04',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1517 弄',
            zip: 200333
        }, {
            date: '2016-05-01',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1519 弄',
            zip: 200333
        }, {
            date: '2016-05-03',
            name: '王小虎',
            province: '上海',
            city: '普陀区',
            address: '上海市普陀区金沙江路 1516 弄',
            zip: 200333
        }],
        page:{
            total: 1,
            size: 10,
            current: 1
        },
    },
    created: function () {
    },
    watch: {

    },
    mounted: function () {

    },
    methods:{
        viewArticle:function(row) {
            console.log(row);
        },
        //分页处理
        getPage:function (current) {
            this.page.current = current;
            this.getData();
        },
    }
});
