<template>
  <div>
    <el-container style="height: 500px;">
      <el-aside width="200px">
        <TheAside></TheAside> 
      </el-aside> 
      <el-container>
         <TheHeader></TheHeader>
      </el-container>
    </el-container>
    
  </div>
</template>

<script>
import TheAside from '@/pages/TheAside'
import TheHeader from '@/pages/TheHeader'
import bus from '../assets/js/bus'

export default {
  components: {
    TheHeader,
    TheAside
  },
  data () {
    return {
      tagsList: [],
      collapse: false
    }
  },
  created() {
    bus.$on('collapse', msg => {
      this.collapse = msg
    })

    // 只有在标签页列表里的页面才使用keep-alive，即关闭标签之后就不保存到内存中了。
    bus.$on('tags', msg => {
      let arr = []
      for (let i = 0, len = msg.length; i < len; i++) {
        msg[i].name && arr.push(msg[i].name)
      }
      this.tagsList = arr
    })
  }
}
</script>

<style lang="less" scoped>
</style>
