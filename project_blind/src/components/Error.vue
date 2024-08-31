<template>
    <div style="position: relative;">
        <div class="demo-image__lazy">
            <el-image :src='urls'></el-image>
            <div class="centered-text">
                <h2>404,页面错误。请前往</h2>
                <span @click="toPath" style="cursor: pointer"><a class="highlight-link">主页</a></span>
            </div>
        </div>
    </div>
</template>

<script>
import router from '@/router';

export default {
    name: 'Error',
    data() {
        return {
            urls: require('../assets/img/404搞怪.jpg')
        }
    },
    methods: {
        toPath() {
            this.$router.push('/')
        }
    }
}
</script>

<style lang="less" scoped>
.demo-image__lazy {
    position: relative;
    margin: auto;
}

.centered-text {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
}

.highlight-link {
    color: aqua; /* 设定高亮颜色 */
    text-decoration: underline; /* 添加下划线 */
    font-weight: bold; /* 可选：加粗字体 */
}
</style>
