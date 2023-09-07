var vue = new Vue({

    el: '#app',
    data: {

        pagination: {},
        dataList: [],//总数据
        // showList: [],  //当前页要展示的列表数据
        formData: {},//表单数据
        dialogFormVisible: false,//控制表单是否可见
        dialogFormVisible4Edit: false,//编辑表单是否可见
        rules: {//校验规则
            type: [{required: true, message: '图书类别为必填项', trigger: 'blur'}],
            name: [{required: true, message: '图书名称为必填项', trigger: 'blur'}]
        },
        total: 0,//总条目数
        pagesize: 5,//每页显示条目个数
        currentPage: 1,//当前页数,
        // num: 1,     //选择购买书
        totalPrice: [],     //单价
        sum: 0,     //总价
        url : "/BookManagement_war/img/payment.png",
        show: false

    },

    //钩子函数，VUE对象初始化完成后自动执行
    created() {
        this.getAll();
    },

    methods: {
        //列表
        getAll() {
            //发送ajax请求
            var that = this;
            axios.get("/BookManagement_war/books").then((res) => {
                that.dataList = res.data.data;
            });

        },


        // name查询
        getByName() {
            // console.log(name);
            var that = this;
            axios.get("/BookManagement_war/books?name=" + this.pagination.queryString).then((res) => {
                if (res.data.code == 20041) {
                    this.dataList = res.data.data;
                    this.$message.success("查询成功");

                } else {
                    this.$message.error("查询失败");
                    console.log("测试查询失败");
                }
            });
        },

        //付款
        handlePayment() {
            this.$confirm("此操作将购买所有书籍，是否继续？", "提示", {
                type: 'info'
            }).then(() => {
                this.show = !this.show;

            });
        },

        //购买
        handlePrice() {

            // console.log(this.formData);
            // this.totalPrice = this.formData.price * this.num;
            if (true) {
                this.totalPrice.push(this.formData.price);
                this.dialogFormVisible4Edit = false;
                this.$message.success("添加成功");
            } else {
                this.$message.success("添加失败");
            }
            this.totalPrice.forEach(ele => {

                this.sum = this.sum + parseFloat(ele);

                //防止多次遍历同一数组值，每次进行清空
                this.totalPrice = [];
            });
            console.log(this.sum);
            console.log(this.totalPrice);
        },


        //弹出编辑窗口
        handleUpdate(row) {
            // console.log(row);   //row.id 查询条件
            //查询数据，根据id查询
            axios.get("/BookManagement_war/books/" + row.id).then((res) => {
                // console.log(res.data.data);
                if (res.data.code == 20041) {
                    //展示弹层，加载数据
                    this.formData = res.data.data;
                    this.dialogFormVisible4Edit = true;
                } else {
                    this.$message.error(res.data.msg);
                }
            });
        },



        // 删除
        handleDelete(row) {
            console.log(this.row)
            //1.弹出提示框
            this.$confirm("此操作永久删除当前数据，是否继续？", "提示", {
                type: 'info'
            }).then(() => {
                //2.做删除业务
                axios.delete("/BookManagement_war/books/" + row.id).then((res) => {
                    if (res.data.code == 20021) {
                        this.$message.success("删除成功");
                    } else {
                        this.$message.error("删除失败");
                    }
                }).finally(() => {
                    this.getAll();
                });
            }).catch(() => {
                //3.取消删除
                this.$message.info("取消删除操作");
            });
        },

        //    分页
        //—页显示多少条
        //监听 pagesize 改变的事件
        size_change(newSize) {
            this.pagesize = newSize
        },
        //监听 页码值 改变的事件
        current_change(newPage) {
            this.currentPage = newPage
        },

        closePayment(){
            this.show = !this.show;
        },
    }
})