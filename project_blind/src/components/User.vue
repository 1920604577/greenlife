<template>
    <div>
        <el-table :data="tableDatas" style="width: 100%">
            <el-table-column prop="id" label="ID" width="150"></el-table-column>
            <el-table-column prop="username" label="用户名" width="150"></el-table-column>
            <el-table-column prop="sex" label="性别" width="150"></el-table-column>
            <el-table-column prop="birthData" label="生日" width="150"></el-table-column>
            <el-table-column label="操作" width="150">
                <template v-slot="scope">
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
                    <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="400px">
            <el-form ref="form" :model="form" label-width="60px">
                <el-form-item label="用户名" size="mini">
                    <el-input v-model="form.username"></el-input>
                </el-form-item>
                <el-form-item label="性别" size="mini">
                    <el-radio-group v-model="form.sex">
                        <el-radio :label="0">男</el-radio>
                        <el-radio :label="1">女</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="生日" size="mini">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.birthData" style="width: 100%;"></el-date-picker>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button size="mini" @click="editVisible = false">取消</el-button>
                <el-button type="primary" size="mini" @click="saveEdit">确定</el-button>
            </span>
        </el-dialog>

        <!-- 分页 -->
        <div class="pagination">
            <el-pagination
                @current-change="handleCurrentChange"
                background
                layout="total, prev, pager, next"
                :current-page="currentPage"
                :page-size="pageSize"
                :total="totalItems">
            </el-pagination>
        </div>
    </div>
</template>

<script>
import { getCookie } from "/static/ZuiBlog/ZuiBlog"
import { synRequestPost } from "../../static/request";

export default {
    name: 'User',
    data() {
        return {
            token: '',
            user: JSON.parse(localStorage.getItem("user")),
            editVisible: false,
            tableDatas: [],
            DeleteUserByIdBo: {
                token: '',
                id: -1,
            },
            form: {
                id: '',
                username: '',
                sex: '',
                birthData: '',
            },
            UserUpdateBo: {
                token: '',
                id: '',
                username: '',
                sex: '',
                birthData: '',
            },
            pageSize: 5,
            currentPage: 1,
            totalItems: 0,
            idx: -1
        }
    },
    mounted() {
        this.token = getCookie('token');
        this.load();
    },
    methods: {
        // 获取当前页数据
        async load() {
            try {
                const response = await synRequestPost("/user/findAll", {
                    token: this.token,
                    start: this.currentPage,
                    size: this.pageSize
                });
                if (response && response.data) {
                    const data = response.data;
                    this.tableDatas = data.list;
                    this.totalItems = data.count; // 更新总条数
                } else {
                    console.error("Unexpected response format:", response);
                }
            } catch (error) {
                console.error("Failed to load data:", error);
            }
        },
        // 切换页码时加载数据
        async handleCurrentChange(val) {
            this.currentPage = val;
            await this.load();
        },
        async handleDelete(id) {
            this.DeleteUserByIdBo.id = id;
            this.DeleteUserByIdBo.token = this.token;
            const object = await synRequestPost("/user/deleteUserById", this.DeleteUserByIdBo);
            alert(object.message);
            this.load();
        },
        // 编辑
        handleEdit(row) {
            this.editVisible = true;
            let datetime = row.birthData;
            this.form = {
                id: row.id,
                username: row.username,
                sex: row.sex,
                birthData: datetime,
            };
        },
        // 保存编辑
        async saveEdit() {
            let d = new Date(this.form.birthData);
            let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
            this.UserUpdateBo.token = this.token;
            this.UserUpdateBo.id = this.form.id;
            this.UserUpdateBo.username = this.form.username;
            this.UserUpdateBo.sex = this.form.sex;
            this.UserUpdateBo.birthData = datetime;
            const object = await synRequestPost("/user/updateUserById", this.UserUpdateBo);
            alert(object.message);
            this.editVisible = false;
            this.load();
        },
    }
}
</script>

<style lang="less" scoped>
</style>
